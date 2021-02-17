package expensesTracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AuthentificationController {

    @RequestMapping("/authorize")
    public String authorizeUser(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("photo") MultipartFile multipartFile){
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        //FileDB FileDB = new FileDB(fileName, file.getContentType(), file.getBytes());

        return "index";
    }

    @RequestMapping(value = {"/register"})
    public String registerNewUser(Model model) {

        return "redirect:/dashboard";
    }
}
