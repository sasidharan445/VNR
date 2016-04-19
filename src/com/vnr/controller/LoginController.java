package com.vnr.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vnr.model.UserAccount;
import com.vnr.service.LoginService;

@Controller
public class LoginController {
	
	private static final Log log = LogFactory.getLog(LoginController.class);
	
	@Autowired	
	LoginService loginService;
	
	@ModelAttribute("loginForm")
    public UserAccount loginForm() {
        return new UserAccount();
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String displayLogin(Model model) {		
      
        return "login";
    }
	
	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String displayAccessDenied(Model model) {		
      
        return "redirect:/403";
    }
	
	@RequestMapping(value = "/login" , method=RequestMethod.POST)
    public String submitLogin(@ModelAttribute("loginForm") UserAccount userAccount, Model model,
    		BindingResult bindingResult) {
        model.addAttribute("message", "Login Successful"+userAccount.getLoginName());
        log.info(userAccount.getLoginName());
        log.info(userAccount.getPassword());
        UserAccount response = loginService.selectUserAccount(userAccount);
        if(response == null) {
        	 model.addAttribute("message", "Please Enter valid Username and Password");        	
        	 return "login";
        }
        log.info(response.getLoginName());
        log.info(response.getPassword());
        log.info(response.getUserAccountId());
        log.info(userAccount.getLoginName());
        
        return "redirect:/home";
    }
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
    public String displayHome(Model model) {		
      
        return "home";
    }
	
    @RequestMapping(value="/error", method = RequestMethod.GET)
    public String loginerror(ModelMap model)  {
    	model.addAttribute("message", "Please Enter valid Username and Password");      
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
   
}
