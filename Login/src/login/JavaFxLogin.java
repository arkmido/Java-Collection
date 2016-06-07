package login;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author L3000n100
 */
public class JavaFxLogin extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        setUserAgentStylesheet(STYLESHEET_MODENA);
        primaryStage.setTitle("JavaFX Welcome");
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        primaryStage.setResizable(false);
        
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        //grid.setGridLinesVisible(true);
        
        Text sceneTitle = new Text("Welcome");
        grid.add(sceneTitle, 0, 0, 2, 1);
        sceneTitle.setId("welcome-text");
        
        Label userName = new Label("Username:");
        grid.add(userName, 0, 1);
        
        TextField userTxtField = new TextField();
        grid.add(userTxtField, 1, 1);
        
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);
        
        PasswordField pwbox = new PasswordField();
        grid.add(pwbox, 1, 2);
        
        final Text actionTarget = new Text();
        grid.add(actionTarget, 1, 6);
        actionTarget.setId("actiontarget");
        
        Button btn = new Button("Sign In");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(userTxtField.getText().equals("") || 
                        pwbox.getText().equals("")) 
                            actionTarget.setText("Incomplete fields");
                else 
                    actionTarget.setText("");
            }
        });
        
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        //scene.getStylesheets().add(
        //        JavaFxLogin.class.getResource("style1.css").toExternalForm());
        primaryStage.show();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } 
}
