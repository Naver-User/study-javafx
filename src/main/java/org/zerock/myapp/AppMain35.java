package org.zerock.myapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Objects;


@Log4j2
@NoArgsConstructor
public class AppMain35 extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        log.trace("start({}) invoked.", primaryStage);

        // ------------
        Parent root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("AppMain35.fxml")));
        log.info("\t+ root: {}", root);

        // ------------
        Scene scene = new Scene(root);
        log.info("\t+ scene: {}", scene);
        log.info("\t\t- stylesheets: {}", scene.getStylesheets());

        // Apply the specified CSS file to the whole scene in the current window.
//        scene.getStylesheets().add(Objects.requireNonNull(this.getClass().getResource("/css/AppMain35.css")).toString());
        scene.getStylesheets().forEach(log::info);

        // ------------
        primaryStage.setTitle("AppMain35");

        /*
         * Specifies the style for this stage.
         * This must be done prior to making the stage visible. (***)
         */
//        primaryStage.initStyle(StageStyle.DECORATED);         // Ordinary window
        primaryStage.initStyle(StageStyle.UNDECORATED);       // *NO* caption bar on window
//        primaryStage.initStyle(StageStyle.TRANSPARENT);       // *NOT* supported on windows platform.
//        primaryStage.initStyle(StageStyle.UTILITY);           // Like Dialog Window.
//        primaryStage.initStyle(StageStyle.UNIFIED);           // *NOT* supported on windows platform.

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);

        primaryStage.show();
    } // start


    public static void main(String ... args) {
        log.trace("main({}) invoked.", Arrays.toString(args));
        Application.launch(args);
    } // main

} // end class

