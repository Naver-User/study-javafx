package org.zerock.myapp.controller;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
@NoArgsConstructor
public class RootController20 implements Initializable {
    @FXML private CheckBox check1;
    @FXML private CheckBox check2;

    @FXML private ImageView checkImageView;
    @FXML private ImageView radioImageView;

    @FXML private RadioButton radio1;
    @FXML private RadioButton radio2;
    @FXML private RadioButton radio3;

    @FXML private Button exitButton;
    @FXML private ToggleGroup group;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

        // ------------------
        log.info("\t+ check1: {}, check2: {}", this.check1, this.check2);
        log.info("\t+ checkImageView: {}", this.checkImageView);
        log.info("\t+ radioImageView: {}", this.radioImageView);
        log.info("\t+ radio1: {}, radio2: {}, radio3: {}", this.radio1, this.radio2, this.radio3);
        log.info("\t+ exitButton: {}", this.exitButton);
        log.info("\t+ group: {}", this.group);

        // ------------------
        this.group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {  // Anonymous Implementation Object

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                log.trace("ChangeListener::changed({}, {}, {}) invoked.", observable, oldValue, newValue);
                log.info("\t1. this: {}", this); // Anonymous Implementation Object

                // ------------------
                String newUserData = newValue.getUserData().toString();
                log.info("\t2. newUserData: {}", newUserData);

                String url = "/images/"+newUserData+".png";
                Image image = new Image(this.getClass().getResource(url).toString()); // OK
//                Image image = new Image(url);   // XX

                log.info("\t3. image: {}", image);

                radioImageView.setImage(image);
            } // changed

        }); // .addListener

        // ------------------
        this.check1.selectedProperty().addListener(new ChangeListener<Boolean>() {  // Anonymous Implementation Object

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                log.trace("changed({}, {}, {}) invoked.", observable, oldValue, newValue);

                if(newValue) {
                    String imageUrl = "/images/geek-glasses.gif";
                    log.info("\t+ imageUrl: {}", imageUrl);

                    checkImageView.setImage(new Image(this.getClass().getResource(imageUrl).toString()));
                }
            } // changed

        }); // .addListener

        // ------------------
        this.check2.selectedProperty().addListener(new ChangeListener<Boolean>() {  // Anonymous Implementation Object

            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                log.trace("changed({}, {}, {}) invoked.", observable, oldValue, newValue);

                if(newValue) {
                    String imageUrl = "/images/geek-hair.gif";
                    log.info("\t+ imageUrl: {}", imageUrl);

                    checkImageView.setImage(new Image(this.getClass().getResource(imageUrl).toString()));
                } // if
            } // changed

        }); // .addListener
    } // initialize

    public void handleCheckBox(Event e) {
        log.trace("handleCheckBox({}) invoked.", e);

        // ------------------
        log.info("\t1. check1: {}", this.check1.isSelected());
        log.info("\t2. check2: {}", this.check2.isSelected());

        // ------------------
        String imageUrl = "";

        if(this.check1.isSelected() && this.check2.isSelected()) {
            imageUrl = "/images/geek-glasses-hair.gif";
            log.info("\t3.imageUrl: {}", imageUrl);
            this.checkImageView.setImage(new Image(this.getClass().getResource(imageUrl).toString()));
        } else if(!this.check1.isSelected() && !this.check2.isSelected()) {
            imageUrl = "/images/geek.gif";
            log.info("\t3.imageUrl: {}", imageUrl);
            this.checkImageView.setImage(new Image(this.getClass().getResource(imageUrl).toString()));
        } // if-else
    } // handleCheckBox

    public void handleExit(ActionEvent e) {
        log.trace("handleExit({}) invoked.", e);

        Platform.exit();
    } // handleExit

} // end class
