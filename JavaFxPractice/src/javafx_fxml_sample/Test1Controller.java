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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Popup;


public class Test1Controller implements Initializable{

    @FXML
    public void btnSelectClicked() throws InterruptedException{
        ih.stop();
        setDisableItems(true);
        int x = ih.getUserChoice();
        int y = ih.getOpponentChoice();
        
        if(x == y){
            title.setText("DRAW BITCH!!");
        }else if((x == 0 && y == 2) || (x == 1 && y == 0) || (x == 2 && y == 1)){
            title.setText("YOU WIN!! Lucky Bastard!");
        }else{
            title.setText("YOU LOSE!! AHAAAAH!");
        }
    }
    @FXML
    public void btnRestartClicked(){
        setDisableItems(false);
        ih = new ImageHandler();
        title.setText("ROCK PAPER SCISSORS");
        ih.start();
    }
    public void loadImages(){
        for(int i = 1; i <= 6; i++){
            if(i <= 3)
                imgs1.add(new Image(getClass().
                    getResource(i+".png").toExternalForm()));
            else if(i > 3)
                imgs2.add(new Image(getClass().
                    getResource(i+".png").toExternalForm()));
        }
        //System.out.println("Images loaded");
    }
    public void setDisableItems(boolean x){
        btnSelect.setDisable(x);
        rb1.setDisable(x);
        rb2.setDisable(x);
        rb3.setDisable(x);
        btnRestart.setDisable(!x);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ih = new ImageHandler();
        setDisableItems(false);
        ih.start();
    }
    
    private List<Image> imgs1 = new ArrayList();
    private List<Image> imgs2 = new ArrayList();
    private Random r = new Random();
    private ImageHandler ih;
    
    @FXML
    private ImageView imguser, imgcmp;
    @FXML
    private Button btnSelect, btnRestart;
    @FXML
    private RadioButton rb1,rb2,rb3;
    @FXML
    private Label title;

    /*
    * Handles the animation of ImageViewer and opponent's random choice
    */
    private class ImageHandler implements Runnable{
        public boolean flag;
        Thread t;
        ImageHandler(){
            loadImages();
            flag = true;
        }
        @Override
        public void run() {
            try{
                while(flag){
                    //System.out.println("Changing image..");
                    imguser.setImage(imgs1.get(r.nextInt(3)));
                    imgcmp.setImage(imgs2.get(r.nextInt(3)));
                    Thread.sleep(99);
                }
            }catch(InterruptedException e){
                Alert alertError = new Alert(AlertType.ERROR);
                alertError.setTitle("Ooops!");
                alertError.setHeaderText("An error has occured");
                alertError.setContentText(e.toString());
                alertError.showAndWait();
            }
            //System.out.println("Thread done");
        }
        public void start(){
            //System.out.println("Starting Thread..");
            if(t == null){
                t = new Thread(this);
                t.start();
            }
        }
        public void stop(){
            //System.out.println("Stoping thread");
            flag = false;
        }
        public int getUserChoice(){
            if(rb1.isSelected()){
                imguser.setImage(imgs1.get(0));
                return 0; //rock
            } 
            else if(rb2.isSelected()){ 
                imguser.setImage(imgs1.get(1)); 
                return 1; //paper
            }
            else if(rb3.isSelected()){
                imguser.setImage(imgs1.get(2));
                return 2; //scissors
            }
            return 1;
        }
        public int getOpponentChoice(){
            int x = r.nextInt(3);
            imgcmp.setImage(imgs2.get(x));
            //System.out.println(x);
            return x;
        }
    }
}

