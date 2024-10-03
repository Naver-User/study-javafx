package org.zerock.myapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
@Accessors(fluent = true)
@Data
public class RootController37 implements Initializable {
    @FXML private ProgressBar progressBar;
    @FXML private Label lblWorkDone;
    @FXML private Label lblResult;
    @FXML private Button btnStart;
    @FXML private Button btnStop;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

        log.info("progressBar: {}, lblWorkDone: {}, lblResult: {}, btnStart: {}, btnStop: {}",
                this.progressBar(), this.lblWorkDone(), this.lblResult(), this.btnStart(), this.btnStop());

        // -------------

    } // initialize

    public void handleBtnStart(ActionEvent e) {
        log.trace("");
    } // handleBtnStart

    public void handleBtnStop(ActionEvent e) {

    } // handleBtnStop

} // end class
