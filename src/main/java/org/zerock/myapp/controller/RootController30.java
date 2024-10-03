package org.zerock.myapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
@Accessors(fluent = true)
@Data
public class RootController30 implements Initializable {
    @FXML private Button btnConfirm;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);
        log.info("\t+ btnConfirm: {}", this.btnConfirm());

        this.btnConfirm().setOnAction(e -> {
            log.trace("EventHandler<ActionEvent>::handle({}) invoked.", e);
        }); // .setOnAction
    } // initialize

} // end class
