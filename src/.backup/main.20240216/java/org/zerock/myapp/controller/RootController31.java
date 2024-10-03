package org.zerock.myapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
@Accessors(fluent = true)
@Data
public class RootController31 implements Initializable {
    @FXML private VBox vbox1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

        log.info("\t+ vbox1: {}", vbox1);

        // Until here, the scene wasn't set to the primary stage yet.   (***)
        // Thus, we cannot get scene object.                            (***)
        Scene scene = this.vbox1().getScene();
        log.info("\t+ scene: {}", scene);           // scene is null.
    } // initialize

    public void handleMouseClicked(MouseEvent event) {
        log.trace("handleMouseClicked({}) invoked.", event);
        log.info("\t+ target: {}", event.getTarget());

        // Apply CSS style to the specified container.                  (***)
        VBox target = (VBox) event.getTarget();
        target.setStyle("-fx-background-color: red;");
    } // handleMouseClicked


} // end class



