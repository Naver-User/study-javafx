package org.zerock.myapp.controller;

import javafx.fxml.Initializable;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
public class TempController implements Initializable {


    public TempController() {
        log.trace("Default constructor invoked.");
    } // Default Constructor


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

    } // initialize

} // end class
