/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
/**
 *
 * @author L3000n100
 */
public class HelloJavaFx extends Application{
    
    /*
    *   Entire window or frame in swing is called Stage
    *   and inside the stage is called the scene which gonna
    *   hold the buttons, widgets, etc.
    */
    
    private Button btn;
    
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Hello JavaFx");
        
        // creating a button
        btn = new Button();
        btn.setText("Click Me!");
        
        /*
            we use Layout the same way we use layout in
            swing panel to control how objects appear 
            and arrange inside the scene
            We call it the StackPane
        */
        StackPane sp = new StackPane();
        sp.getChildren().add(btn);
        
        /*
            we also use the scene to hold the layout
            passing in the layout as arguments
        */
        Scene scene = new Scene(sp, 300, 250);
        
        // then pass in the scene to the main stage
        stage.setScene(scene);
        // finally to make the stage actually apear
        stage.show();
        
    }
}
