/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

/**
 *
 * Using Check Boxes
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.*;

public class HelloJavaFx_CheckBoxes extends Application{
    private Scene scene1;
    private VBox layout1;
    private Button btn1;
    private CheckBox cb1,cb2;
    
    public static void main(String args[]){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("CheckBoxes");
        stage.setOnCloseRequest(eh -> System.exit(0));
        
        cb1 = new CheckBox("Bacon");
        cb2 = new CheckBox("Tuna");
        cb2.setSelected(true);
        
        btn1 = new Button("Click Me!");
        btn1.setOnAction(eh -> {
            if(cb1.isSelected()) System.out.println("Bacon");
            if(cb2.isSelected()) System.out.println("Tuna");
        });
        
        layout1 = new VBox();
        layout1.setPadding(new Insets(10,0,0,10));
        layout1.getChildren().addAll(cb1,cb2,btn1);
        
        scene1 = new Scene(layout1, 150, 150);
        stage.setScene(scene1);
        stage.show();
    }
    
}
