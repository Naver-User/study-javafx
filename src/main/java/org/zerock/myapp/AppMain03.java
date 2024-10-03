package org.zerock.myapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;


@Log4j2
@NoArgsConstructor
public class AppMain03 extends Application {


    @Override
    public void start(Stage primaryStage) {
        log.trace("start({}) invoked.", primaryStage);

        Label label = new Label();
        label.setText("Yoseph");

//        label.setFont(new Font(50));                            // 1st. method
//        label.setFont(new Font("D2Coding", 50.));               // 2nd. method
        label.setFont(Font.font("D2Coding", 50.));              // 3rd. method

        // -----------------
        Button button = new Button();
        button.setText("Close");

        button.setFont(Font.getDefault());                      // 4th. method
//        button.setFont(
//            Font.font("D2Coding", Font.getDefault().getSize())  // 5th. method
//        );  // .setFont

//        button.setOnAction(new EventHandler<ActionEvent> () { // 1st. method
//            @Override
//            public void handle(ActionEvent event) {
//                log.trace("handle({}) invoked.", event);
//                Platform.exit();
//            } // handle
//        }); // .setOnAction

        button.setOnAction(e -> {                             // 2nd. method
            log.trace("setOnAction({}) invoked.", e);
            Platform.exit();
        }); // .setOnAction

        // -----------------
        VBox root = new VBox();

        root.setPrefHeight(150);
        root.setPrefWidth(350);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20.);

        // -----------------
        ObservableList<Node> children = root.getChildren();

//        children.add(label);
//        children.add(button);

        children.addAll(label, button);

        children.forEach(log::info);

        // -----------------
        primaryStage.setTitle("AppMain03");

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

    @Override
    public void init() throws Exception {
        log.trace("init() invoked.");
    } // init

    @Override
    public void stop() throws Exception {
        log.trace("stop() invoked.");
    } // stop


    public static void main(String... args) {
        log.trace("main({}) invoked.", Arrays.toString(args));

//        Application.launch();
        Application.launch(args);
    } // main

} // end class
