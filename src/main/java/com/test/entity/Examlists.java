/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author HP
 */
@Data
@Entity
@NotNull
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "examlist")
public class Examlists {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     private Integer id;
    @Column(name = "exam_name")
     private String exam_name;
    @Column(name = "date")
     private String date;
    @Column(name = "coment")
     private String coment;
    
}
