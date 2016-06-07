/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.util.List;
import javafx.event.EventHandler;
import model.*;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.TilePane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;

/**
 *
 * @author L3000n100
 */
public class TilePaneItemDisplay extends TilePane {
    // The Button Array 
    private Button[] buttons = null;
    
    // Custom TilePane constructor
    public TilePaneItemDisplay(ScrollPane sp){
        this.setPadding(new Insets(10,0,10,0));
        this.setVgap(10);
        this.setHgap(10);
        this.setOrientation(Orientation.HORIZONTAL);
        this.setPrefHeight(sp.getPrefHeight());
        this.setPrefWidth(sp.getPrefWidth());
        
        this.setTileAlignment(Pos.CENTER);
        this.setNodeOrientation(NodeOrientation.INHERIT);
        this.setAlignment(Pos.TOP_CENTER);
        
        this.setStyle("-fx-background-color:  linear-gradient(#333, #666, #555)");
        
        System.out.println("TilePane initialized");
    }
    
    // The Method to create the Button_Tiles on each TilePane instance and return the built button array
    public Button[] createTiles(List<?> list){
        // array initialization
        buttons = new Button[list.size()];
        int i = 0; // array index counter
        
        // checks if the List passed is a list of Burger
        if(list.get(0).getClass() == Burger.class){
            // creates and initialize each button with images, texts, and Id. Then add to the tilePane instance
            for(Burger b : (List<Burger>) list){
                buttons[i] = new Button(b.getName()+"\n \u20B1"+b.getPrice());
                setButton("/imgs/burgers/", buttons[i], i, b.getName());
                i++;
            }
            System.out.println("Burger Tiles Created");      
        }
        // checks if the List passed is a list of Sides and Drinks
        else if(list.get(0).getClass() == Side_Drink.class){
            // creates and initialize each button with images, texts, and Id. Then add to the tilePane instance
            for(Side_Drink sd : (List<Side_Drink>) list){
                buttons[i] = new Button(sd.getName());
                setButton("/imgs/sides_drinks/", buttons[i], i, sd.getName());
                i++;
            }
            System.out.println("Side and Drink Tiles Created");
        }
        // checks if the List passed is a list of Desserts
        else if(list.get(0).getClass() == Dessert.class){
            // creates and initialize each button with images, texts, and Id. Then add to the tilePane instance
            for(Dessert d : (List<Dessert>) list){
                buttons[i] = new Button(d.getName());
                setButton("/imgs/desserts/", buttons[i], i, d.getName());
                i++;
            }
            System.out.println("Dessert Tiles Created");
        }
        return buttons;
    }
    
    // initialize button
    public void setButton(String imgPath, Button b, int index, String objectName){
        Image img = null;
        DropShadow shadow = new DropShadow();
        
        /* 
            some conditions to set Onion rings and Fries to have the same image, 
            because they only differ in meal size
        */
        if(objectName.contains("Onion Rings"))
            img = new Image(imgPath+"0.png");
        else if(objectName.contains("Fries"))
            img = new Image(imgPath+"1.png");
        else
            img = new Image(imgPath+index+".png");
        
        ImageView iv = new ImageView(img);
        iv.setFitHeight(100);
        iv.setFitWidth(100);
        b.setGraphic(iv);
        b.setTooltip(new Tooltip(objectName));
        b.setGraphicTextGap(4);
        b.setContentDisplay(ContentDisplay.TOP);

        b.setMinWidth(100);
        b.setMinHeight(110);
        b.setId(objectName);
        b.setEffect(shadow);
        this.getChildren().add(b);
    }
    
    // method to be called by the controller to set the events on each buttons
    public void addButtonListener(Button btn, EventHandler e){
        btn.setOnAction(e);
    }
}
