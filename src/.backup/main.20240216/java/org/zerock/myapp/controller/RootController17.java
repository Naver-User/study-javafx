package org.zerock.myapp.controller;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.text.Font;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
@NoArgsConstructor
public class RootController17 implements Initializable {
    @FXML private Slider slider;
    @FXML private Label label;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

        log.info("slider({}), label({})", this.slider, this.label);

        // --------------
        DoubleProperty valueProperty = this.slider.valueProperty();

        // 1st. method - with anonymous implementation object
//        valueProperty.addListener(new ChangeListener<Number>() {
//            @Override
//            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//                log.trace("ChangeListener::changed({}, {}, {}) invoked.", observable, oldValue, newValue);
//                label.setFont(new Font(newValue.doubleValue()));
//            } // changed
//        }); // .addListener

        // 2nd. method - with lambda expression
        // void changed(ObservableValue<? extends T> observable, T oldValue, T newValue);
        valueProperty.addListener((observable, oldValue, newValue) -> {
            log.trace("ChangeListener::changed({}, {}, {}) invoked.", observable, oldValue, newValue);
            label.setFont(new Font(newValue.doubleValue()));
        }); // .addListener
    } // initialize

} // end class

