package org.zerock.myapp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
//@NoArgsConstructor
public class Root15Controller implements Initializable {
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;


    // Default Constructor Required                                                 <--- ***: (1)
    public Root15Controller() {                                                     // OK
        log.trace("Default constructor invoked.");

        // All fields with @FXML are *NOT* initialized, with null                   <--- ***: (2)
        log.info("\t+ btn1({}), btn2({}), btn3({})",
                this.btn1, this.btn2, this.btn3);
    } // Default constructor

    // The constructor with parameters *NOT* required in the FXML Root Controller   <--- ***: (3)
    // As a result, this constructor with parameters *CANNOT* be invoked.
    public Root15Controller(Button btn1, Button btn2, Button btn3) {                // XX
        log.trace("AppMain15Controller({}, {}, {}) invoked.", btn1, btn2, btn3);

        this.btn1 = btn1;
        this.btn2 = btn2;
        this.btn3 = btn3;
    } // constructor

    // Before calling back the following initialize() method,
    // All fields with @FXML are initialized.                                       <--- ***: (4)
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

        log.info("\t+ btn1: {}", this.btn1);
        log.info("\t+ btn2: {}", this.btn2);
        log.info("\t+ btn3: {}", this.btn3);

        // -------------------
        btn1.setOnAction(new EventHandler<>() {
            @Override
            public void handle(ActionEvent event) {
                log.trace("btn1::handle({}) invoked.", event);
            } // handle
        }); // .setOnAction

        btn2.setOnAction(e -> log.trace("btn2::handle({}) invoked.", e)); // .setOnAction
        btn3.setOnAction(e -> log.trace("btn3::handle({}) invoked.", e)); // .setOnAction
    } // initialize


} // end class

