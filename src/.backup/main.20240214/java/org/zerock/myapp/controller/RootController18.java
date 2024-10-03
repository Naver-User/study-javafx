package org.zerock.myapp.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
@NoArgsConstructor
public class RootController18 implements Initializable {
    @FXML private TextArea textArea1;
    @FXML private TextArea textArea2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

        log.info("\t+ textArea1({}), textArea2({})", this.textArea1, this.textArea2);

        // ---------------------
        // 1. Uni-directional property binding between two controls.
        // ---------------------
        // textArea2: Binding Target -> Un-modifiable
        // textArea1: Modifiable
//        textArea2.textProperty().bind(textArea1.textProperty());

        // ---------------------
        // 2. Bi-directional property binding between two controls.
        // ---------------------
        // All textArea1, 2 -> Modifiable and each become binding targets.

        // 1st. method
        textArea1.textProperty().bindBidirectional(textArea2.textProperty());

        // 2nd. method
//        Bindings.<String>bindBidirectional(textArea1.textProperty(), textArea2.textProperty());

    } // initialize

} // end class
