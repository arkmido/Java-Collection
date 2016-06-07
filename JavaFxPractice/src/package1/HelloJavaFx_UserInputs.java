/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

/**
 *
 * Getting User Inputs using a text field and a button
 */

import javafx.application.Application;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class HelloJavaFx_UserInputs extends Application{
    private Scene scene1;
    private Button btn1;
    private TextField tf1;
    
    public static void main(String args[]){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage = new Stage();
        stage.setTitle("User Inputs");
        stage.setOnCloseRequest(eh -> System.exit(0));
        
        tf1 = new TextField("");
        tf1.setPromptText("enter age");
        
        btn1 = new Button("Click Me!");
        btn1.setOnAction(e -> isValid(tf1, tf1.getText()));
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,0,0,10));
        grid.setHgap(8);
        grid.setVgap(8);
        GridPane.setConstraints(tf1, 0, 0);
        GridPane.setConstraints(btn1, 0, 1);
        grid.getChildren().addAll(tf1,btn1);
        
        scene1 = new Scene(grid, 300, 200);
        stage.setScene(scene1);
        stage.show();
    }
    private boolean isValid(TextField tf, String text){
        try{
            int age = Integer.parseInt(text);
            System.out.println(age+" is valid");
            return true;
        }catch(NumberFormatException e){
            System.out.println(text+" is invalid");
            return false; 
        }  
    }
}
