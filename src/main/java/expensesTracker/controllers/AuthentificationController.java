package expensesTracker.controllers;

import expensesTracker.models.PhotoFile;
import expensesTracker.models.User;
import expensesTracker.services.PhotoFileService;
import expensesTracker.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class AuthentificationController {

    @Autowired
    private PhotoFileService photoFileService;

    @Autowired
    private UserService userService;

    @RequestMapping("/authorize")
    public String authorizeUser(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("photo") MultipartFile multipartFile,
                                Model model) throws IOException {
        User user = new User(username, password);
        PhotoFile photoFile = photoFileService.saveOrUpdatePhoto(multipartFile);
        user.setPhotoFile(photoFile);
        userService.saveUser(user);
        model.addAttribute("user", user);
        model.addAttribute("photo", photoFile.getName());
        return "index";
    }

    @RequestMapping(value = {"/register"})
    public String registerNewUser(Model model) {

        return "redirect:/dashboard";
    }
}
