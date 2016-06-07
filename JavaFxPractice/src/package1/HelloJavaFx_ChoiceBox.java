/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

/**
 *
 * Using Choice Boxes or Dropdown menu
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.*;

public class HelloJavaFx_ChoiceBox extends Application{
    private Scene scene1;
    private VBox layout1;
    private Button btn1;
    
    public static void main(String args[]){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("CheckBoxes");
        stage.setOnCloseRequest(eh -> System.exit(0));
        
        ChoiceBox<String> choicebox = new ChoiceBox<>();
        choicebox.getItems().addAll("Apples", "Bananas");
        choicebox.getItems().addAll("MeatBalls", "Bacon");
        choicebox.setValue("Apples");
        
        btn1 = new Button("Click Me!");
        btn1.setOnAction(eh -> {
            System.out.println(choicebox.getValue());
        });
        
        layout1 = new VBox();
        layout1.setPadding(new Insets(10,10,10,10));
        layout1.getChildren().addAll(choicebox,btn1);
        
        scene1 = new Scene(layout1, 150, 150);
        stage.setScene(scene1);
        stage.show();
    }
    
}

