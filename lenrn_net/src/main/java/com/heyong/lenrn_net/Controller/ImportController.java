package com.heyong.lenrn_net.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create By Yong
 */

@Controller
@RequestMapping("/import")
public class ImportController {


    @CrossOrigin(origins = "*")
    @RequestMapping("/homepage")
    public String ToHome(){
        return "HomePage.html";
    }

    @RequestMapping("/details")
    public String ToDetails(){
        return "details.html";
    }

    @RequestMapping("/maincontent")
    public String ToMain(){
        return "MainContent.html";
    }

    @RequestMapping("/upload")
    public String Toupload(){
        return "upload.html";
    }

    @RequestMapping("/login")
    public String ToLogin(){
        return "Login.html";
    }
}
