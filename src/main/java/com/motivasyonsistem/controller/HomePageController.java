package com.motivasyonsistem.controller;

import com.motivasyonsistem.domain.User;
import com.motivasyonsistem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by burcu on 22.02.2018.
 */

@Controller
public class HomePageController {

    private UserService userService;

    @RequestMapping("/")
    public String homePage() {
        return "index";
    }

    @RequestMapping("/giris")
    public String loginPage() {
        return "login";
    }

    @RequestMapping("/kayit")
    public String signupPage() {
        return "signup";
    }

    @RequestMapping(value = "/kayit/user",  method= RequestMethod.POST)
    public String kaydet(@RequestParam String username, @RequestParam String mail, @RequestParam String password, ModelMap modelMap, HttpSession session ) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(mail);
        user.setPassword(password);
        user.setHeight(0);
        user.setWidth(0);

        if (userService.findByMail(mail) != null) {
            modelMap.put("error", "Bu mail ile daha önce kayıt olunmuş.");
            modelMap.put("username", username);
            return "/kayit/user";
        }
        else if (userService.findByUsername(username) != null) {
            modelMap.put("error","Bu kullanıcı adına sahip motimasyon üyesi var.");
            modelMap.put("mail", mail);
            return "/kayit/user";
        }
        else {
            System.out.println(user.getUsername());
            userService.save(user);
        }

        return "redirect:/";
    }
}
