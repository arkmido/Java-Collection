/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahibernate2;
import javax.persistence.*;

/**
 *
 * @author L3000n100
 */
@Table(name="UserTable")
public class UserClass {
    @Column(name="id")
    private int id;
    
    @Column(name="name")
    private String name;
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
