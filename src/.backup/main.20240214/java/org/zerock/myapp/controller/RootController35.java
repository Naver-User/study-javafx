package org.zerock.myapp.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
@Accessors(fluent = true)
@Data
public class RootController35 implements Initializable {


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);
    } // initialize

    public void handleBtnCancel(ActionEvent e) {
        log.trace("handleBtnCancel({}) invoked.", e);
        Platform.runLater(Platform::exit); // .runLater
    } // handleBtnCancel

} // end class

