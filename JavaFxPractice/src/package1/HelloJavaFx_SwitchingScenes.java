/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

/**
 *
 * @author L3000n100
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloJavaFx_SwitchingScenes extends Application{
    
    private Stage window;
    private Scene scene1, scene2;
    private Label lbl1 = new Label("Welcome to First Scene");
    private Button btn1, btn2;
    
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("Title here");
        
        // Button 1
        btn1 = new Button("Go to scene2");
        btn1.setOnAction(e -> window.setScene(scene2));
        
        // layout 1 - children are laid out in vertical column
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(lbl1,btn1);
        scene1 = new Scene(layout1,200, 200); // add the layout to the scene
        
        // Button 2
        btn2 = new Button("This scene sucks, go back!");
        btn2.setOnAction(e -> window.setScene(scene1));
        
        // layout 2
        StackPane layout2 = new StackPane();
        layout2.getChildren().add(btn2);
        scene2 = new Scene(layout2, 600, 300);
        
        // create the scene and layout objects first before setting the scene
        window.setScene(scene1); 
        window.show();
        
    }
    
}
