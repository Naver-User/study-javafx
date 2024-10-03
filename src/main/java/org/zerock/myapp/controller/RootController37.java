package org.zerock.myapp.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.Border;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
@Accessors(fluent = true)
@Data
public class RootController37 implements Initializable {
    @FXML private ProgressBar progressBar;
    @FXML private Label lblWorkDone;
    @FXML private Label lblResult;
    @FXML private Button btnStart;
    @FXML private Button btnStop;

    private Thread t;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

        // -------------
//        log.info("\t+ progress: {}", this.progressBar().getProgress());       // -1.0

//        this.progressBar().setBlendMode(BlendMode.RED);
//        this.progressBar().setBlendMode(BlendMode.COLOR_BURN);
//        this.progressBar().setBlendMode(BlendMode.COLOR_DODGE);
//        this.progressBar().setBlendMode(BlendMode.BLUE);
//        this.progressBar().setBlendMode(BlendMode.ADD);
//        this.progressBar().setBlendMode(BlendMode.DARKEN);
//        this.progressBar().setBlendMode(BlendMode.DIFFERENCE);
        this.progressBar().setBlendMode(BlendMode.EXCLUSION);
//        this.progressBar().setBlendMode(BlendMode.GREEN);
//        this.progressBar().setBlendMode(BlendMode.HARD_LIGHT);
//        this.progressBar().setBlendMode(BlendMode.LIGHTEN);
//        this.progressBar().setBlendMode(BlendMode.MULTIPLY);
//        this.progressBar().setBlendMode(BlendMode.OVERLAY);
    } // initialize

    public void handleBtnStart(ActionEvent event) {
        log.trace("handleBtnStart({}) invoked.", event);

        // --------------
        this.progressBar().setProgress(0.0);
        this.lblWorkDone().setText(String.valueOf(0));
        this.lblResult().setText(String.valueOf(0));

        // --------------
        this.t = new Thread(() -> {
            int result = 0;

            for(int counter=1; counter<=100; counter++) {
                result += counter;
                double progress = counter / 100.;

                // ----------
                // *Caution*: local variables referenced from a lambda expression must be final or effectively final
                int finalResult = result;
                int finalCounter = counter;

                Platform.runLater(() -> {
                    this.progressBar().setProgress(progress);
                    this.lblWorkDone().setText(String.valueOf(finalCounter));
                    this.lblResult().setText(String.valueOf(finalResult));
                }); // .runLater

                // ----------
                try { Thread.sleep(30); }
                catch(InterruptedException e) { break; } // try-catch
            } // for
        }); // Runnable

        t.setName("WorkerThread");
        t.setDaemon(true);

        t.start();
    } // handleBtnStart

    public void handleBtnStop(ActionEvent event) {
        log.trace("handleBtnStop({}) invoked.", event);

        if(this.t() != null) {
            this.t.interrupt();
            this.progressBar().setProgress(-1.);
        } // if
    } // handleBtnStop

} // end class
