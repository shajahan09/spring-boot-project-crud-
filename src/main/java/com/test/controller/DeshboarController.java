/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controller;

import com.test.Repository.adminLoginRepository;
import com.test.entity.AdminLogin;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author HP
 */
@Controller
public class DeshboarController {

    @Autowired
    private adminLoginRepository adminRepo;

    @RequestMapping(value = "/deshboard", method = RequestMethod.POST)
    public String adminLogin(HttpServletRequest request, Model model) {
//                model.addAttribute("name", name);
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (!email.isEmpty() && !password.isEmpty()) {
            AdminLogin admin = adminRepo.findByEmailAndPassword(email, password);
            if (!admin.equals(null)) {
                return "deshboard";
            }

        }

        return "adminLogin";
    }

}
