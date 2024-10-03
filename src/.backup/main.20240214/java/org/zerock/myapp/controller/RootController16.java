package org.zerock.myapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
@NoArgsConstructor
public class RootController16 implements Initializable {
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private Button btn3;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);
        log.info("\t+ btn1({}), btn2({}), btn3({})", this.btn1, this.btn2, this.btn3);

    } // initialize

    public                                       // OK
    //private                                      // XX
    //default                                      // XX
    //protected                                    // XX
    //static                                       // XX
    void handleBtn1(ActionEvent e) {
        log.trace("handleBtn1({}) invoked.", e);
    } // handleBtn1

    public                                       // OK
    //private                                      // XX
    //default                                      // XX
    //protected                                    // XX
    //static                                       // XX
    void handleBtn2(ActionEvent e) {
        log.trace("handleBtn2({}) invoked.", e);
    } // handleBtn2

    public                                       // OK
//    private                                      // XX
//    default                                      // XX
    //protected                                    // XX
    //static                                       // XX
    void handleBtn3(ActionEvent e) {
        log.trace("handleBtn3({}) invoked.", e);
    } // handleBtn3

} // end class
