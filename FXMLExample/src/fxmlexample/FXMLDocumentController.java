/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxmlexample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 *
 * @author L3000n100
 */
public class FXMLDocumentController{
    @FXML
    private Text actionTarget;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField passwordField;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        if(userName.getText().equals("") || passwordField.getText().equals(""))
            actionTarget.setText("Incomplete Fields!");
        else actionTarget.setText("");
    }   
}
