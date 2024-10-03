package org.zerock.myapp.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
@Accessors(fluent = true, chain = true)
@Data
public class RootController26 implements Initializable {
    @FXML private TextArea textArea;
    @FXML private ComboBox<String> comboBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

        // -----------------
        log.info("\t+ textArea: {}", this.textArea);
        log.info("\t+ comboBox: {}", this.comboBox);

        // -----------------
        // changed
        this.comboBox.valueProperty().addListener((observable, oldValue, newValue) -> {
            log.trace("ChangeListener::changed({}, {}, {}) invoked.", observable, oldValue, newValue);
            textArea().appendText(newValue+"\n");
        }); // .addListener
    } // initialize

    public void handleNew(ActionEvent e) {
        log.trace("handleNew({}) invoked.", e);
        this.textArea().appendText("New\n");
    } // handleNew

    public void handleOpen(ActionEvent e) {
        log.trace("handleOpen({}) invoked.", e);
        this.textArea().appendText("Open\n");
    } // handleOpen

    public void handleSave(ActionEvent e) {
        log.trace("handleSave({}) invoked.", e);
        this.textArea().appendText("Save\n");
    } // handleSave

    public void handleExit(ActionEvent e) {
        log.trace("handleExit({}) invoked.", e);
        Platform.exit();
    } // handleExit

} // end class
