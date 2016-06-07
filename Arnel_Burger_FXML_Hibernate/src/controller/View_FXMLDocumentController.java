/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.*;
import view.ConfirmBox;
import view.TilePaneItemDisplay;
import java.util.List;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;



/**
 *
 * @author L3000n100
 */
public class View_FXMLDocumentController implements Initializable {
    // FXML Objects and Events
    @FXML
    private ScrollPane ScrollPaneCenter;
    
    @FXML
    private ToggleButton tgBurgers, tgSidesDrinks, tgDesserts;
    
    @FXML
    private TextField tfTotal;
            
    @FXML
    private RadioButton rdbDine, rdbOut;
    
    @FXML
    private ListView list1;
   
    @FXML
    public void orderClicked(ActionEvent event){
        Alert a = new Alert(AlertType.ERROR);
        if(total > 0){
            a.setTitle("TROLOLOLOL");
            a.setHeaderText("HAHAHA PUMILA KA DUN!, KALA MO MAS MADALI DITO?!");
            a.setContentText("U MAD BRO? :3");
            a.showAndWait();
            a.setTitle("TROLOLOLOL");
            a.setHeaderText("TROLOLOLOLTROLOLOLOLTROLOLOLOL");
            a.setContentText("TROLOLOLOLTROLOLOLOL");
            a.showAndWait();
            System.exit(0);
        }
    }
    
    @FXML
    public void btnRemoveClicked(ActionEvent event){
//        System.out.println("EditStart");
//        int index = list1.getSelectionModel().getSelectedIndex();
//        String item = null;
//        if(index != -1)
//             item = (String) list1.getSelectionModel().getSelectedItem();
//      
        Alert a = new Alert(AlertType.CONFIRMATION);
        Optional <ButtonType> opt;
        if(!tfTotal.getText().equals("")){
            a.setHeaderText("This will reset your order list");
            a.setContentText("Continue?");
            opt = a.showAndWait();
            if(opt.isPresent() && opt.get() == ButtonType.OK){
                list1.getItems().clear();
                tfTotal.clear();
                total = 0;
            }
        }
    }
    
    //-------------------------------------------------------
    // Sets the toggle buttons event for changing ScrollPanes' tilepanes
    
    @FXML
    public void tgBurgersClicked(ActionEvent event) {  
        ScrollPaneCenter.setContent(tilePaneB);
        list1.getEditingIndex();
    }
    @FXML
    public void tgSidesDrinksClicked(ActionEvent event){
        ScrollPaneCenter.setContent(tilePaneSD);
    }
    @FXML
    public void tgDessertsClicked(ActionEvent event){
        ScrollPaneCenter.setContent(tilePaneD);
    }
    //-----------------------------------------------------
    
    // INITIALIZATIONS
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Model part:  the hibernate data handler
        dh = new Data_Handler();
        dh.connect();
        dh.createTables();
        dh.insertDataToTables();
        burgers = dh.getBurgers();
        desserts = dh.getDesserts();
        sides_drinks = dh.getSides_Drinks();
        dh.disconnect();
        
        setToggleGroup();
        initTilePanes();
        
        // gets the button_tiles as button array in each custom tilepane
        btnB = tilePaneB.createTiles(burgers);
        btnSD = tilePaneSD.createTiles(sides_drinks);
        btnD = tilePaneD.createTiles(desserts);
        
        // create the button_tiles events
        createEvents(btnB, btnSD, btnD);
        
        // the ScrollPane that holds the tilepanes
        ScrollPaneCenter.setContent(tilePaneB);
        
    }
    
    // CREATE EVENTS FOR THE BUTTONS ON EACH TILEPANE
    private void createEvents(Button[] bB, Button[] bSD, Button[] bD){
        // Buger buttons_tiles
        for(Button b : bB){
            tilePaneB.addButtonListener(b, new EventHandler <ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    for(Burger burg : burgers){
                        if(burg.getName() == b.getId())
                            if(ConfirmBox.display(burg.getType(),burg.getName(), burg.getPrice()) && orderCount > 0){
                                String str = "("+orderCount+") "+burg.getName()+": "+burg.getPrice();
                                list1.getItems().add(str);
                                total += burg.getPrice() * orderCount;
                                tfTotal.setText("\u20B1 "+new Double(total).toString());
                                orderCount = 0;
                            }
                    }           
                }
            });
        }
        // Sides and Drinks buttons_tiles
        for(Button b : bSD){
            tilePaneSD.addButtonListener(b, new EventHandler <ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    for(Side_Drink sd : sides_drinks){
                        if(sd.getName() == b.getId())
                             if(ConfirmBox.display("Sides and Drinks", sd.getName(), sd.getPrice()) && orderCount > 0){
                                String str = "("+orderCount+") "+sd.getName()+": "+sd.getPrice();
                                list1.getItems().add(str);
                                total += sd.getPrice() * orderCount;
                                tfTotal.setText("\u20B1 "+new Double(total).toString());
                                orderCount = 0;
                            }
                    }  
                }
            });
        }
        // Desserts buttons_tiles
        for(Button b : bD){
            tilePaneD.addButtonListener(b, new EventHandler <ActionEvent>(){
                @Override
                public void handle(ActionEvent event) {
                    for(Dessert d : desserts){
                        if(d.getName() == b.getId())
                           if(ConfirmBox.display("Desserts", d.getName(), d.getPrice()) && orderCount > 0){
                                String str = "("+orderCount+") "+d.getName()+": "+d.getPrice();
                                list1.getItems().add(str);
                                total += d.getPrice() * orderCount;
                                tfTotal.setText("\u20B1 "+new Double(total).toString());
                                orderCount = 0;
                            }
                    }  
                }
            });
        }
    }
    
    // initialize tilepanes from the customized TilePane class in the view
    private void initTilePanes(){
        tilePaneB = new TilePaneItemDisplay(ScrollPaneCenter);
        tilePaneSD = new TilePaneItemDisplay(ScrollPaneCenter);
        tilePaneD = new TilePaneItemDisplay(ScrollPaneCenter);
    }
    
    // just a toggle group for the toggle buttons
    private void setToggleGroup(){
        tg = new ToggleGroup();
        tgBurgers.setToggleGroup(tg);
        tgSidesDrinks.setToggleGroup(tg);
        tgDesserts.setToggleGroup(tg);
        
        tgrdb = new ToggleGroup();
        rdbDine.setToggleGroup(tgrdb);
        rdbOut.setToggleGroup(tgrdb);
        rdbDine.setSelected(true);
    }
        
    // Objects not initially in the view
    public static int orderCount = 0;
    private double total = 0;
    private ToggleGroup tg, tgrdb;
    private TilePaneItemDisplay tilePaneB, tilePaneSD, tilePaneD;
    private Data_Handler dh;
    private List<model.Burger> burgers;
    private List<model.Dessert> desserts;
    private List<model.Side_Drink> sides_drinks;
    private Button[] btnB, btnSD, btnD;
}
