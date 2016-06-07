/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

/**
 *
 * How to properly close a stage or window
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelloJavaFx_ClosingButton extends Application{
    private Stage window;
    private Button btn1;
    private Scene scene1;
    private StackPane layout1;
    
    public static void main(String args[]){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        window.setTitle("CLOSING APP");
        // take the event instead from the system "e.consume"
        // so we can handle the app doing something else before close
        window.setOnCloseRequest(e -> {
            e.consume();
            closeStage();
        });
        
        btn1 = new Button("Close");
        btn1.setOnAction(e -> closeStage());
        
        layout1 = new StackPane();
        layout1.getChildren().add(btn1);
        
        scene1 = new Scene(layout1, 200,200);
        window.setScene(scene1);
        window.show();
    }

    private void closeStage() {
//        System.out.println("File saved!");
        Boolean answer = ConfirmBox.display("CLOSE APP", "Are you sure you want to exit?");
        if(answer) Platform.exit();
    } 
}
