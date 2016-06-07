/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;

/**
 *
 * @author L3000n100
 */
@Entity
@Table(name="SIDES_DRINKS")
public class Side_Drink {
    @Id
    @GeneratedValue
    @Column(name="ID")
    private int id;
    
    @Column(name="PRICE")
    private double price;
    
    @Column(name="NAME")
    private String name;
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
