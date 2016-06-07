/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author L3000n100
 */
public class Arnel_Burger_FXML_Hibernate extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("View_FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("view/style1.css");
        
        stage.setOnCloseRequest(e -> System.exit(0));
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        
        stage.setMaxWidth(1040);
        stage.setMaxHeight(780);
        
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
