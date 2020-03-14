/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP
 */
@Controller
public class EmployeeController {

        @RequestMapping(value = "/employeeLogin")
	public String empLogin(Model model) {
		//model.addAttribute("name", name);
		return "employeeLogin";
	}
//        @RequestMapping(value = "/employeeLogin")
//	public String emptests(Model model) {
//		//model.addAttribute("name", name);
//		return "employeeLogin";
//	}
         @RequestMapping(value = "/employeeRegister")
	public String empregister(Model model) {
		//model.addAttribute("name", name);
		return "employeeRegister";
	}
        
            @RequestMapping(value = "/employeeforgot")
	public String emptesting(Model model) {
		//model.addAttribute("name", name);
		return "employeeforgot";
	}
    
}
