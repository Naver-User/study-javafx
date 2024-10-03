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

import java.util.Arrays;
import java.util.Objects;


@Log4j2
@NoArgsConstructor
public class AppMain24 extends Application {


    @Override
    public void init() throws Exception {
        log.trace("init() invoked.");
    } // init

    @Override
    public void stop() throws Exception {
        log.trace("stop() invoked.");
    } // stop

    @Override
    public void start(Stage primaryStage) throws Exception {
        log.trace("start({}) invoked.", primaryStage);

        // ------------
        Parent root = FXMLLoader.<AnchorPane>load(
            Objects.requireNonNull(
                this.getClass().getResource("AppMain24.fxml"),
                "No AppMain24.fxml found."
            )
        );  // .load
        log.info("1. root: {}", root);

        root.getChildrenUnmodifiable().forEach(log::info);

        // ------------
//        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("AppMain24.fxml"));
//        log.info("1. loader: {}", loader);
//
//        Parent root = loader.<AnchorPane>load();
//        log.info("2. root: {}", root);
//
//        RootController24 controller = loader.<RootController24>getController();
//        log.info("3. controller: {}", controller);
//
//        root.getChildrenUnmodifiable().forEach(log::info);

        // ------------
        primaryStage.setTitle("AppMain24");

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


    public static void main(String[] args) {
        log.trace("main({}) invoked.", Arrays.toString(args));
        Application.launch(args);
    } // main

} // end class
