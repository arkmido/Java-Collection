/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

/**
 *
 * @author L3000n100
 * Demonstrates the use of second stage
 */

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class HelloJavaFx_SwitchingScenes2_alertBox {
    public static void display(String title, String message){
        Stage window = new Stage();
        window.setTitle(title);
        window.setMinWidth(250);
        
        // block any user interaction with other windows
        window.initModality(Modality.APPLICATION_MODAL);
        
        Label lbl1 = new Label(message);
        Button btn1 = new Button("Close");
        btn1.setOnAction(e -> window.close());
        
        VBox layout1 = new VBox(10);
        layout1.getChildren().addAll(lbl1,btn1);
        layout1.setAlignment(Pos.CENTER);
        
        Scene scene1 = new Scene(layout1);
        window.setScene(scene1);
        
        // make the parent window to freeze until this stage is closed
        window.showAndWait();
        
    }
}
