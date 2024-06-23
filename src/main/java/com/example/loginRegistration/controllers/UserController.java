package com.example.loginRegistration.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.loginRegistration.models.LoginUser;
import com.example.loginRegistration.models.User;
import com.example.loginRegistration.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {

//	
//	@Autowired
//	UserService userService;
//	
//	@GetMapping("/")
//	public String newUser(Model model) {
//		model.addAttribute("user", new User());
//		model.addAttribute("loginUser", new LoginUser());
//		return "registration.jsp";
//	}
//	
//	@PostMapping("/register")
//	public String createUser(@Valid @ModelAttribute("user") User user, BindingResult results,Model model, HttpSession session) {
//		
//		userService.register(user, results);
//		
//		if(results.hasErrors()) {
//			//model.addAttribute("loginUser", new LoginUser());
//			return "registration.jsp";
//		}
//		session.setAttribute("user_id",user.getId());
//		return "redirect:/dashboard";
//	}
//	
//	@PostMapping("/login")
//	public String login(@Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {
//		
//		User user = userService.login(loginUser, result);
//		if(result.hasErrors()) {
//			model.addAttribute("user", new User());
//			return "registration.jsp";
//		}
//		session.setAttribute("user_id", user.getId());
//		return "redirect:/dashboard";
//	}
//	
//	@GetMapping("/logout")
//	public String logout(HttpSession s) {
//		 s.invalidate();
//		 return "redirect:/";
//	}
	
	  @Autowired
	  private UserService userServ;
	 
	 @GetMapping("/")
	 public String index(Model model) {
	 
	     model.addAttribute("newUser", new User());
	     model.addAttribute("newLogin", new LoginUser());
	     return "index.jsp";
	 }
	 
	 @PostMapping("/register")
	 public String register(@Valid @ModelAttribute("newUser") User newUser, 
	         BindingResult result, Model model, HttpSession session) {
	     
	     userServ.register(newUser, result);
	     
	     if(result.hasErrors()) {
	         // Be sure to send in the empty LoginUser before 
	         // re-rendering the page.
	         model.addAttribute("newLogin", new LoginUser());
	         return "index.jsp";
	     }
	     
	     session.setAttribute("userId", newUser.getId());
	 
	     return "redirect:/welcome";
	 }
	 
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	         BindingResult result, Model model, HttpSession session) {
	     
	     // Add once service is implemented:
	     User user = userServ.login(newLogin, result);
	 
	     if(result.hasErrors()) {
	         model.addAttribute("newUser", new User());
	         return "index.jsp";
	     }
	 
	     session.setAttribute("userId", user.getId());
	 
	     return "redirect:/welcome";
	 }
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
//		 session.setAttribute("userId", null);
		 session.invalidate();
		 return "redirect:/";
	 }
	 
	 @GetMapping("/welcome")
	 public String welcome(Model model, HttpSession session) {
		 Long userId = (Long) session.getAttribute("userId");
		 if(userId==null) {
			 return "redirect:/";
		 }
		 User user = userServ.findUserById(userId);
		 model.addAttribute("user",user);
		 return "dashboard.jsp";
	 }
}