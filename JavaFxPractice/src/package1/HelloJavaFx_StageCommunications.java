/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

/**
 *
 * Demonstrates how stages or windows can communicate with other windows
 */
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;

public class HelloJavaFx_StageCommunications extends Application{
    private Stage window;
    private Button btn1;
    private Scene scene1;
    private StackPane layout1;
    
    public static void main(String args[]){
        launch(args);
    }
    public void start(Stage stage){
        window = stage;
        window.setTitle("Stage1");
        
        btn1 = new Button("See Stage2");
        btn1.setOnAction(e -> {
            boolean result = ConfirmBox.display("Stage2","Send naked pics?");
            System.out.println(result ? "Nice" : "Boring!");
        });
        
        layout1 = new StackPane();
        layout1.getChildren().add(btn1);
        
        scene1 = new Scene(layout1, 200, 200);
        window.setScene(scene1);
        window.show();
    }
}

class ConfirmBox{
    private static Button btnYes, btnNo;
    private static Stage window;
    private static Label lbl1;
    private static VBox layout1;
    private static Scene scene1;
    
    static boolean answer;
    
    public static boolean display(String title, String msg){
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        
        lbl1 = new Label(msg);
        btnYes = new Button("Yes");
        btnNo = new Button("No");
        
        btnYes.setOnAction(e -> {
            answer = true;
            window.close();
        });
        
        btnNo.setOnAction(e -> {
            answer = false;
            window.close();
        });
        
        layout1 = new VBox(10);
        layout1.setAlignment(Pos.CENTER);
        layout1.getChildren().addAll(lbl1, btnYes, btnNo);
        
        scene1 = new Scene(layout1);
        window.setScene(scene1);
        window.showAndWait();
        
        return answer;
    }
}
