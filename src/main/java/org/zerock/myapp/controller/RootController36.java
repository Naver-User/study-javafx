package org.zerock.myapp.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import static java.lang.Thread.sleep;


@Log4j2
@Accessors(fluent = true)
@Data
public class RootController36 implements Initializable {
    @FXML private Label lblTime;
    @FXML private Button btnStart;
    @FXML private Button btnStop;

    private boolean stop;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

        this.btnStart().setOnAction(this::handleBtnStart);
        this.btnStop().setOnAction(this::handleBtnStop);
    } // initialize

    public void handleBtnStart(ActionEvent e) {
        log.trace("handleBtnStart({}) invoked.", e);

        this.stop(false);

        // -----------------
        Thread t = new Thread(() -> {
            log.trace("run() invoked.");

            DateFormat formatter = new SimpleDateFormat("HH:mm:ss");

            while(!stop) {
                String currentTime = formatter.format(new Date());
                Platform.runLater(() -> lblTime().setText(currentTime));

                try { sleep(1000); }
                catch (InterruptedException ignored) {}
            } // while

            log.info("\t+ Done.");
        });

        t.setName("TimerWorkerThread");
//        t.setDaemon(true);

        t.start();
    } // handleBtnStart

    public void handleBtnStop(ActionEvent e) {
        log.trace("handleBtnStop({}) invoked.", e);

        this.stop(true);
    } // handleBtnStop

} // end class
