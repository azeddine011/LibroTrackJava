package com.librotrackapp.librotrack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.librotrackapp.librotrack.model.User;
import com.librotrackapp.librotrack.repository.UserRepository;

@Controller
public class HomeController {
    
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String index(Model model) {
        // For now, we'll create a user and save it to database
        User user = new User();
        user.setFirstName("Azeddine");
        user.setLastName("El Hamzaoui");
        user.setUsername("azeddine");
        user.setEmail("azeddine@example.com");
        user.setCreatedAt(new java.util.Date());
        user.setUpdatedAt(new java.util.Date());
        userRepository.save(user);
        
        model.addAttribute("pageTitle", "Home Page");
        model.addAttribute("user", user);
        model.addAttribute("isAdmin", true);
        return "index";
    }
}
