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
import org.zerock.myapp.controller.RootController36;

import java.util.Arrays;


@Log4j2
@NoArgsConstructor
public class AppMain36 extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        log.trace("start({}) invoked.", primaryStage);

        // -----------------
//        Parent root = FXMLLoader.load(
//            Objects.requireNonNull(
//                this.getClass().getResource("AppMain36.fxml"),
//                "No AppMain36.fxml found."
//            )
//        );  // .load

        // -----------------
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("AppMain36.fxml"));
        Parent root = loader.<AnchorPane>load();

        // -----------------
        primaryStage.setOnCloseRequest(e -> {
            log.trace("Stage::setOnCloseRequest({}) invoked.", e);
            loader.<RootController36>getController().stop(true);
        }); // .setOnCloseRequest

        // -----------------
        primaryStage.setTitle("AppMain36");

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


