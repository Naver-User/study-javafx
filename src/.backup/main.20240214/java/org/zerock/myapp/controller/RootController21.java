package org.zerock.myapp.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
@Accessors(fluent = true, chain = true)
@Data
public class RootController21 implements Initializable {
    @FXML private TextField txtTitle;
    @FXML private PasswordField txtPassword;
    @FXML private ComboBox<String> comboPublic;
    @FXML private DatePicker dateExit;
    @FXML private TextArea txtContent;
    @FXML private Button btnReg;
    @FXML private Button btnCancel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

        // ---------------
        log.info("\t1. txtTitle({})", this.txtTitle());
        log.info("\t2. txtPassword({})", this.txtPassword());
        log.info("\t3. comboPublic({})", this.comboPublic());
        log.info("\t4. dateExit({})", this.dateExit());
        log.info("\t5. txtContent({})", this.txtContent());
        log.info("\t6. btnReg({})", this.btnReg());
        log.info("\t7. btnCancel({})", this.btnCancel());

    } // initialize

    public void handleBtnReg(ActionEvent e) {
        log.trace("handleBtnReg({}) invoked.", e);

        log.info("\t1. title: {}", this.txtTitle().getText());
        log.info("\t2. password: {}", this.txtPassword().getText());
        log.info("\t3. strPublic: {}", this.comboPublic().getValue());
        log.info("\t4. localDate: {}", this.dateExit().getValue());
        log.info("\t5. content: {}", this.txtContent().getText());
    } // handleBtnReg

    public void handleBtnCancel(ActionEvent e) {
        log.trace("handleBtnCancel({}) invoked.", e);

        Platform.exit();
    } // handleBtnCancel

} // end class
