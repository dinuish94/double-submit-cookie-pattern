package com.sliit.ssd.csrfapp.controllers;

import com.sliit.ssd.csrfapp.exceptions.UnauthorizedException;
import com.sliit.ssd.csrfapp.models.Credentials;
import com.sliit.ssd.csrfapp.models.FundTransfer;
import com.sliit.ssd.csrfapp.services.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller for handling login requests
 *
 * Created by dinukshakandasamanage on 9/5/18.
 */

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    AuthenticationService authenticationService;

    @GetMapping("/")
    public String showLoginPage(Model model, HttpServletRequest request) throws UnauthorizedException {

        if (!authenticationService.isAuthenticated(request.getCookies())){
            model.addAttribute("login", new Credentials());
            return "login";
        } else {
            model.addAttribute("home", new FundTransfer());
            return "redirect:/home";
        }

    }

    @GetMapping("/home")
    public String showHomePage(Model model, HttpServletRequest request) throws UnauthorizedException {
        if(authenticationService.isAuthenticated(request.getCookies())){
            model.addAttribute("home", new FundTransfer());
            return "home";
        } else {
            model.addAttribute("login", new Credentials());
            return "redirect:/";
        }

    }

    @PostMapping("/login")
    public void login(@ModelAttribute Credentials credentials, HttpServletResponse response) throws UnauthorizedException, IOException {
        String username = credentials.getUsername();

        if(authenticationService.isUserAuthenticated(username, credentials.getPassword())){

            logger.debug("Successfully authenticated user...");
            Cookie sessionCookie = new Cookie("sessionID", authenticationService.generateSessionId(username));
            Cookie userCookie = new Cookie("username", username);
            Cookie csrfToken = new Cookie("Csrf-token", authenticationService.generateToken());
            response.addCookie(sessionCookie);
            response.addCookie(userCookie);
            response.addCookie(csrfToken);
            response.sendRedirect("/home");
            return;
        }
        throw new UnauthorizedException();
    }
}
