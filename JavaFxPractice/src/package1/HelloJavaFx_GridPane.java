/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

/**
 *
 * Using a grid pane layout
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class HelloJavaFx_GridPane extends Application{
    private Stage window;
    private Scene scene1;
    private Button btnlogin;
    private Label lblname, lblpass;
    private TextField tfname, tfpass;
    private GridPane grid1;
    
    public static void main(String args[]){
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
       window = stage;
       window.setTitle("Grid Panes");
       window.setResizable(false);
       
       grid1 = new GridPane();
       // sets the padding of the layout to the scene
       // 10,10,10,10 -> top, right, bottom, left paddings
       grid1.setPadding(new Insets(10,10,10,10));
       // sets rows and columns spacing
       grid1.setHgap(8);
       grid1.setVgap(8);
       grid1.setGridLinesVisible(true);
       
       lblname = new Label("Username:");
       lblpass = new Label("Password:");
       tfname = new TextField();
       tfpass = new TextField();
       tfpass.setPromptText("password");
       btnlogin = new Button("Login");
       
       grid1.add(lblname, 0, 0);
       grid1.add(lblpass, 0, 1);
       grid1.add(tfname, 1, 0);
       grid1.add(tfpass, 1, 1);
       grid1.add(btnlogin, 1, 2);
       /*
       GridPane.setConstraints(lblname, 0, 0);
       GridPane.setConstraints(lblpass, 0, 1);
       GridPane.setConstraints(tfname, 1, 0);
       GridPane.setConstraints(tfpass, 1, 1);
       GridPane.setConstraints(btnlogin, 1, 2);
       
       grid1.getChildren().addAll(lblname,lblpass,tfname,tfpass,btnlogin);
       */
       scene1 = new Scene(grid1, 235, 150);
       window.setScene(scene1);
       window.show();
    }
    
}
