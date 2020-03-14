/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.controller;

import com.test.Repository.adminLoginRepository;
import com.test.Repository.examlistRepository;
import com.test.entity.AdminLogin;
import com.test.entity.Examlists;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author HP
 */
@Controller
public class AdminController {

    @Autowired
    private examlistRepository exmRepo;
   

    @RequestMapping(value = "/")
    public String test(Model model) {
        //model.addAttribute("name", name);

        return "demo";
    }

    @RequestMapping(value = "/adminLogin")
    public String admins() {

        return "adminLogin";
    }

    @RequestMapping(value = "/already")
    public String tests(Model model) {
        //model.addAttribute("name", name);
        return "adminLogin";
    }

    @RequestMapping(value = "/register")
    public String register(Model model) {
        //model.addAttribute("name", name);
        return "adminRegister";
    }

    @RequestMapping(value = "/forgot")
    public String testing(Model model) {
        //model.addAttribute("name", name);
        return "adminforgot";
    }

    @RequestMapping(value = "/examList")
    public String examLst(HttpServletRequest request, Model model) {

        return "admin/examList";
    }

    @RequestMapping(value = "/examListInsert", method = RequestMethod.POST)
    public String insert(HttpServletRequest request, Model m) {

        String exam_name = request.getParameter("exam_name");
        String date = request.getParameter("date");
        String coment = request.getParameter("coment");
        Examlists exm = new Examlists();
        exm.setExam_name(exam_name);
        exm.setDate(date);
        exm.setComent(coment);
        exmRepo.save(exm);

//            List<Examlists> exmlst = (List<Examlists>) exmRepo.findAll();
//             m.addAttribute("exmlst",exmlst);
        return "admin/examList";

    }

    @RequestMapping(value = "/showExamlists")
    public String show(Model m) {
        List<Examlists> exmlst = (List<Examlists>) exmRepo.findAll();
        m.addAttribute("exmlst", exmlst);
//        System.out.println("..........."+exmlst.get(1).getExam_name());
//        System.out.println("...........test...."+exmlst.get(1).getDate());
//        public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//                        model.addAttribute("name", name);
        return "admin/examList";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteExamList(@PathVariable(name = "id") int id) {

//        exmRepo.deleteById(id);j#
        exmRepo.deleteById(id);
        System.out.print("................+ " + id);
        System.out.print("..........test......");
        return "redirect:/showExamlists";
    }

    @RequestMapping("/edit/{id}")
    public String showE(@PathVariable(name = "id") int id, Model m) {
        Examlists exmlst = exmRepo.findById(id);
        m.addAttribute("exmlst", exmlst);
        System.out.println("..........." + id);
//        exmRepo.save(exmlst);
        return "admin/editExamList";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)

    public String updateUser(@PathVariable("id") int id, @Valid Examlists exmlst,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            exmlst.setId(id);
            return "update-user";
        }

        exmRepo.save(exmlst);
        model.addAttribute("exmlst", exmRepo.findAll());
        return "redirect:/showExamlists";
    }

 
}
