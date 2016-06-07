/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.KeyEvent;
import java.util.Optional;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author L3000n100
 */
public class ConfirmBox{
  
    public static boolean display(String title, String foodName, Double foodPrice){
        window  = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(230);
        
        Reflection rf = new Reflection();
        
        label = new Label("Order "+foodName+"?\n \u20B1"+foodPrice);
        btnOk = new Button("OK");
        btnCancel = new Button("CANCEL");
        btnOk.setEffect(rf);
        btnCancel.setEffect(rf);
        
        btnOk.setId("btnOk");
        btnCancel.setId("btnCancel");
        
        btnOk.setOnAction(e -> {
            controller.View_FXMLDocumentController.orderCount = getQuantity();
            answer = true;
            window.close();
        });
        btnCancel.setOnAction(e -> {
            answer = false;
            window.close();
        });
        
        tfCount = new TextField();
        tfCount.textProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue.length() > 5) tfCount.setText(oldValue);
        });
        tfCount.setMaxWidth(150);
        tfCount.setPromptText("Enter Food Quantity");
        tfCount.setFocusTraversable(false);
        
        layout2 = new HBox(8);
        layout2.setAlignment(Pos.BOTTOM_CENTER);
        layout2.getChildren().addAll(btnOk, btnCancel);
        
        layout1 = new VBox(10);
        layout1.setAlignment(Pos.CENTER);
        layout1.getChildren().addAll(label, tfCount, layout2);
        
        scene = new Scene(layout1);
        scene.getStylesheets().add("view/style2.css");
        window.setScene(scene);
        window.setResizable(false);
        window.showAndWait();
        
        return answer;
    }
  
    public static int getQuantity(){
        int x = 0;
        try{
            if(tfCount.getText().equals(""))
                return 0;
            x = Integer.parseInt(tfCount.getText());
        }catch(NumberFormatException e){
            Alert a = new Alert(AlertType.ERROR);
            a.setTitle("Arnel's Burger");
            a.setHeaderText("Invalid Input");
            a.setContentText("Please enter numeric whole number only");
            System.out.println("Error: "+e.toString());
            a.showAndWait(); 
        }
        return x;
    }

    private static boolean answer = false;
    private static Stage window;
    private static TextField tfCount;
    
    private static Button btnOk, btnCancel;
    private static Label label;
    private static VBox layout1;
    private static HBox layout2;
    private static Scene scene;    
}

