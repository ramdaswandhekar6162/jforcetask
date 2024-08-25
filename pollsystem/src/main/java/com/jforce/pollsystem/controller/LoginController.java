package com.jforce.pollsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jforce.pollsystem.entity.User;
import com.jforce.pollsystem.playload.LoginDto;
import com.jforce.pollsystem.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/leaf")
public class LoginController {
	
	@Autowired
	UserService userSer;
	
	
	@GetMapping("/register")
	public String registrorUser(Model model) {
		
		model.addAttribute("user", new User());
		
		return "register";
	}
	
	@PostMapping("/register")
    public String registerUser(User user) {
        userSer.save(user);
        return "redirect:/leaf/login";
    }
	
	@GetMapping("/login")
	public String showLoginForm(Model model) {
	    model.addAttribute("loginDto", new LoginDto());
	    return "login";
	}

	@PostMapping("/login")
	public String loginMethod(@ModelAttribute("loginDto") LoginDto loginDto, HttpSession session) {
	    User user = userSer.findByUserName(loginDto.getUsername());
	    
	    if (user != null && user.getPassword().equals(loginDto.getPassword())) {
	        session.setAttribute("validUser", user);
	        return "redirect:/leaf/home";
	    }
	    
	    return "redirect:/login?error"; // Redirect to login with an error parameter
	}
	
	
	
}
