package org.zerock.myapp;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Log4j2
@NoArgsConstructor
public class AppMain02 extends Application {


    @Override
    public void init() {
        log.trace("init() invoked.");

        Parameters params = this.getParameters();
        log.trace("\t1. params: {}", params);

        Map<String, String> named = params.getNamed();
        log.trace("\t2. named: {}", named);

        List<String> unnamed = params.getUnnamed();
        log.trace("\t3. unnamed: {}", unnamed);

        List<String> raw = params.getRaw();
        log.trace("\t4. raw: {}", raw);
    } // init

    @Override
    public void stop() {
        log.trace("stop() invoked.");
    } // stop

    @Override
    public void start(Stage primaryStage) {
        log.trace("start({}) invoked.", primaryStage);

        primaryStage.setTitle("AppMain02");

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
        primaryStage.setHeight(300.);
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);

        primaryStage.show();
    } // start


    public static void main(String... args) {
        log.trace("main({}) invoked.", Arrays.toString(args));
        Application.launch(args);
//        Application.launch();
    } // main

} // end class


