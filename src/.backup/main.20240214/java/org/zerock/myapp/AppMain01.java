package org.zerock.myapp;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;


@Log4j2
public class AppMain01 extends Application {


    public AppMain01() {
        log.trace("Default constructor invoked.");
    } // Default Constructor

    @Override
    public void init() {
        log.trace("init() invoked.");
    } // init

    @Override
    public void stop() {
        log.trace("stop() invoked.");
    } // stop

    @Override
    public void start(Stage primaryStage) {
        log.trace("start({}) invoked.", primaryStage);

        // --------------------
        primaryStage.setTitle("AppMain01");

        /*
         * Specifies the style for this stage.
         * This must be done prior to making the stage visible. (***)
         */
//        primaryStage.initStyle(StageStyle.DECORATED);         // Ordinary window
//        primaryStage.initStyle(StageStyle.UNDECORATED);       // *NO* caption bar on window
//        primaryStage.initStyle(StageStyle.TRANSPARENT);       // *NOT* supported on windows platform.
        primaryStage.initStyle(StageStyle.UTILITY);           // Like Dialog Window.
//        primaryStage.initStyle(StageStyle.UNIFIED);           // *NOT* supported on windows platform.

        primaryStage.setWidth(300.);
        primaryStage.setHeight(250.);
        primaryStage.setResizable(true);
        primaryStage.setAlwaysOnTop(true);

        primaryStage.show();
    } // start


    public static void main(String... args) {
        log.trace("main({}) invoked.", Arrays.toString(args));
//        Application.launch();         // OK
        Application.launch(args);     // OK
    } // main
} // end class

