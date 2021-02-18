package expensesTracker.controllers;

import expensesTracker.models.PhotoFile;
import expensesTracker.models.User;
import expensesTracker.services.PhotoFileService;
import expensesTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

@Controller
public class AuthentificationController {

    @Autowired
    private PhotoFileService photoFileService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/registerNew")
    public String registerUser(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("photo") MultipartFile multipartFile,
                                Model model) throws IOException {
        User user = new User(username, passwordEncoder.encode(password));
        PhotoFile photoFile = photoFileService.saveOrUpdatePhoto(multipartFile);
        user.setPhotoFile(photoFile);
        userService.saveUser(user);
        model.addAttribute("user", user);

        String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/files/")
                    .path(String.valueOf(photoFile.getId()))
                    .toUriString();
        model.addAttribute("fileDownloadUri", fileDownloadUri);

        return "redirect:/dashboard";
    }

    @RequestMapping(value = {"/dashboard"})
    public String getDashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        User user = userService.loadUserByUsername(username);
        model.addAttribute("user", user);
        String fileDownloadUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/files/")
                .path(String.valueOf(user.getPhotoFile().getId()))
                .toUriString();
        model.addAttribute("fileDownloadUri", fileDownloadUri);
        return "dashboard";
    }

//    @RequestMapping("/authorize")
//    public String loginUser(@RequestParam("username") String username,
//                                @RequestParam("password") String password,
//                                Model model){
//        User user = userService.loadUserByUsername(username);
//        if(user.getPassword().equals(password)){
//            model.addAttribute("user", user);
//            return "dashboard";
//        }else{
//            model.addAttribute("message", "Username and password do not match, try again!");
//            return "";
//        }
//    }

//    @GetMapping("/files")
//    public ResponseEntity<List<ResponseFile>> getListFiles() {
//        List<ResponseFile> files = photoFileService.getAllFiles().map(dbFile -> {
//            String fileDownloadUri = ServletUriComponentsBuilder
//                    .fromCurrentContextPath()
//                    .path("/files/")
//                    .path(dbFile.getId())
//                    .toUriString();
//
//            return new ResponseFile(
//                    dbFile.getName(),
//                    fileDownloadUri,
//                    dbFile.getType(),
//                    dbFile.getData().length);
//        }).collect(Collectors.toList());
//
//        return ResponseEntity.status(HttpStatus.OK).body(files);
//    }


    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        PhotoFile fileDB = photoFileService.getFileById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }



}
