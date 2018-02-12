package com.jwt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class TestController {

    @RequestMapping("/oauth")
    public OAuth2Authentication getoauth(OAuth2Authentication oAuth2Authentication)
    {
        return oAuth2Authentication;
    }

    @PreAuthorize("#oauth2.hasScope('read') and hasRole('ADMIN')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello()
    {
        return  "hello";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String testadm()
    {
        return "admin";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String testuser()
    {
        return "user";
    }


    @PreAuthorize("#oauth2.hasScope('test') and hasRole('USER')")
    @RequestMapping(value = "/testscope", method = RequestMethod.GET)
    public String testscope()
    {
        return "testscope";
    }


}
