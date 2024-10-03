package org.zerock.myapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
@Accessors(fluent = true)
@Data
public class RootController29 implements Initializable {
    @FXML private Parent root;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);
        log.info("\t+ root: {}", this.root());

        root.getChildrenUnmodifiable().forEach(log::info); // .forEach
    } // initialize

} // end class
