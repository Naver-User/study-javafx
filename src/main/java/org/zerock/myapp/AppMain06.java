package org.zerock.myapp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;


@Log4j2
@NoArgsConstructor
public class AppMain06 extends Application {


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

        // ------------------------
        // 1. Configure Padding
        // ------------------------
        HBox root = new HBox();
        root.setSpacing(10.);
//        root.setSpacing(0.);

        // (top, right, bottom, left) = (10., 10., 10., 10.)
        root.setPadding(new Insets(10.));                         // 1st. method

        // (top, right, bottom, left) = (10., 0., 0., 50.)
//        root.setPadding(new Insets(10., 0., 0., 50.));              // 2nd. method

        // ------------------------
        Button button1 = new Button();
        button1.setPrefSize(100., 50.);
        button1.setText("Button1");
        button1.setFont(new Font("Lucida Sans Unicode", 13.));

        // ------------------------
        Button button2 = new Button();
        button2.setPrefSize(100., 50.);
        button2.setText("Button2");
        button2.setFont(new Font("Lucida Sans Unicode", 13.));

        // ------------------------
        // 2. Configure Margin
        // ------------------------
//        HBox root = new HBox();
//        root.setSpacing(0.);
//
//        // ------------------------
//        Button button1 = new Button();
//        button1.setPrefSize(100., 50.);
//        button1.setText("Button1");
//        button1.setFont(new Font("Lucida Sans Unicode", 13.));
//
//        // (top, right, bottom, left) = (10., 10., 10., 10.)
//        HBox.setMargin(button1, new Insets(10.));                 // 1st. method
//
//        // (top, right) = (10., 0.), (bottom, left) = (0., 50.)
////        HBox.setMargin(button1, new Insets(10., 0., 0., 50.));        // 2nd. method
//
//        // ------------------------
//        Button button2 = new Button();
//        button2.setPrefSize(100., 50.);
//        button2.setText("Button2");
//        button2.setFont(new Font("Lucida Sans Unicode", 13.));
//
//        // (top, right, bottom, left) = (50., 50., 50., 50.)
////        HBox.setMargin(button2, new Insets(50.));                 // 1st. method
//
//        // (top, right) = (10., 0.), (bottom, left) = (0., 50.)
//        HBox.setMargin(button2, new Insets(10., 0., 0., 50.));        // 2nd. method

        // ------------------------
        root.getChildren().addAll(button1, button2);
        root.getChildren().forEach(log::info);

        // ------------------------
        primaryStage.setTitle("AppMain06");

        /*
         * Specifies the style for this stage.
         * This must be done prior to making the stage visible. (***)
         */
//        primaryStage.initStyle(StageStyle.DECORATED);         // Ordinary window
//        primaryStage.initStyle(StageStyle.UNDECORATED);       // *NO* caption bar on window
//        primaryStage.initStyle(StageStyle.TRANSPARENT);       // *NOT* supported on windows platform.
        primaryStage.initStyle(StageStyle.UTILITY);           // Like Dialog Window.
//        primaryStage.initStyle(StageStyle.UNIFIED);           // *NOT* supported on windows platform.

//        primaryStage.setWidth(400);
//        primaryStage.setHeight(300);

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
