/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Repository;

import com.test.entity.AdminLogin;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author HP
 */
public interface adminLoginRepository extends CrudRepository<AdminLogin, Integer>{
    
   public AdminLogin findByEmailAndPassword(String email,String password);

//    public AdminLogin findByPassword(String username);
}
