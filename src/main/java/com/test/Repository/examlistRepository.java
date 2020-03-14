/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.Repository;

import com.test.entity.Examlists;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author HP
 */
@Repository
public interface examlistRepository extends CrudRepository<Examlists, Integer> {

    public Examlists findById(int id);

    
//public Examlists findById();

}
