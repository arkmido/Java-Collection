package srcclasses;

import javax.persistence.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author L3000n100
 */
@Table(name="tasks")
public class Tasks {
    @Column(name="id")
    private int id;
    
    @Column(name="user_id")
    private int userID;
    
    @Column(name="title")
    private String title;
    
    @Column(name="description")
    private String description;
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public int getUserID(){
        return userID;
    }
    public void setUserID(int userID){
        this.userID = userID;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
}
