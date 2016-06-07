/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx_fxml_sample;

/**
 *
 * @author L3000n100
 */
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.StageStyle;

public class Test1 extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Test1FXML.fxml"));
        
        primaryStage.setTitle("R.P.S. -Gilagid");
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        
        Scene scene = new Scene(root, 586, 322);
        scene.getStylesheets().add(Test1.class.getResource("style1.css").toExternalForm());
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String args[]){
        launch(args);    
    }
}
