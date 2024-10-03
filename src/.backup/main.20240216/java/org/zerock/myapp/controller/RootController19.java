package org.zerock.myapp.controller;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2

@Accessors(fluent = true)
@Getter
@NoArgsConstructor
public class RootController19 implements Initializable {
    // NOTE: The field to be injected must be an "instance" field, *NOT* static.
    @FXML private AnchorPane root;
    @FXML private Circle circle;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);
        log.info("\t+ root: {}, circle: {}", this.root, this.circle);

        // ----------------
        root.widthProperty().addListener(e -> {
            log.info("root::width -> {}", root.getWidth());
        }); // .addListener

        root.heightProperty().addListener(e -> {
            log.info("root::height -> {}", root.getHeight());
        }); // .addListener

        // ----------------
        circle.centerXProperty().bind( Bindings.divide(root.widthProperty(), 2) );
        circle.centerYProperty().bind( Bindings.divide(root.heightProperty(), 2) );
    } // initialize

} // end class
