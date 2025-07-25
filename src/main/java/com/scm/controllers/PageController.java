package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;
import com.scm.services.Impl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {

    @Autowired
    UserService userService;

    @RequestMapping("/Home")
    public String Home(){
        System.out.println("Hey");
        return "Home";
    }

    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

      // registration page
      @GetMapping("/register")
      public String register(Model model) {
  
         UserForm userForm = new UserForm();
          //default data bhi daal sakte hai
        //   userForm.setName("Nikhil");
        //   userForm.setAbout("This is about : Write something about yourself");
          model.addAttribute("userForm", userForm);
  
          return "register";
      }

      @RequestMapping(value = "/do-register", method=RequestMethod.POST)
      public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,
            HttpSession session) {

        if(rBindingResult.hasErrors()){
            return "register";
        }        

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
       // user.setEnabled(false);
        user.setProfilePic(
                "");
                User savedUser = userService.saveUser(user);
                
                Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
                
                session.setAttribute("message", message);

          return "redirect:/register";
      }
      

}
