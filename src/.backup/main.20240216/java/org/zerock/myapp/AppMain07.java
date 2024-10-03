package org.zerock.myapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.Arrays;
import java.util.Objects;


@Log4j2
@NoArgsConstructor
public class AppMain07 extends Application {


    @Override
    public void init() {
        log.trace("init() invoked.");
    } // init

    @Override
    public void stop() {
        log.trace("stop() invoked.");
    } // stop

    @Override
    public void start(Stage primaryStage) throws Exception {
        log.trace("start({}) invoked.", primaryStage);

        // ------------------------
//        URL fxml = this.getClass().getResource("AppMain07.fxml");                       // 1st. method
        URL fxml = this.getClass().getResource("/org/zerock/myapp/AppMain07.fxml");     // 2nd. method

        Objects.requireNonNull(fxml);
        log.trace("\t1. fxml: {}", fxml);

        // ------------------------
//        Parent root = FXMLLoader.<AnchorPane>load(fxml);                                // 1st. method
//        log.trace("\t2. root: {}", root);

        // ------------------------
        FXMLLoader loader = new FXMLLoader(fxml);
        Parent root = loader.<AnchorPane>load();                          // 2nd. method
        log.trace("\t2. root: {}", root);

        // ------------------------
        root.getChildrenUnmodifiable().forEach(log::info);

        // ------------------------
        primaryStage.setTitle("AppMain07");

        /*
         * Specifies the style for this stage.
         * This must be done prior to making the stage visible. (***)
         */
//        primaryStage.initStyle(StageStyle.DECORATED);         // Ordinary window
//        primaryStage.initStyle(StageStyle.UNDECORATED);       // *NO* caption bar on window
//        primaryStage.initStyle(StageStyle.TRANSPARENT);       // *NOT* supported on windows platform.
        primaryStage.initStyle(StageStyle.UTILITY);           // Like Dialog Window.
//        primaryStage.initStyle(StageStyle.UNIFIED);           // *NOT* supported on windows platform.

        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);

        primaryStage.show();
    } // start


    public static void main(String... args) {
        log.trace("main({}) invoked.", Arrays.toString(args));
        Application.launch(args);
    } // main

} // end class
