package com.poly.controler;

import com.poly.jpa.model.GooglePojo;
import com.poly.untils.GoogleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class D6 {

    @Autowired
    private GoogleUtils googleUtils;

    @RequestMapping("/home/index")
    public String index(Principal principal){

        return "home/index";
    }

    @RequestMapping("/home/about")
    public String about(){

        return "home/about";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping("/home/admin")
    public String admin(){

        return "home/admin";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @RequestMapping("/home/user")
    public String user(){

        return "home/user";
    }

    // dang nhap moi duoc vao
    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/home/auth")
    public String auth(){

        return "home/auth";
    }

    @RequestMapping("/home/thymeleaf1")
    public String thy1(){

        return "home/thymeleaf1";
    }

    @RequestMapping("/home/thymeleaf2")
    public String thy2(){

        return "home/thymeleaf2";
    }


}
