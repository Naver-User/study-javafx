package org.zerock.myapp;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
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
public class AppMain14 extends Application {


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
        HBox root = new HBox();
        root.setPrefSize(300., 50.);
        root.setSpacing(20.);
        root.setAlignment(Pos.CENTER);

        // ------------------------
        Button btn1 = new Button("Button1");
        btn1.setPrefWidth(100.);
        btn1.setPrefHeight(30.);
        btn1.setFont(Font.font("Lucida Sans Unicode", 13.));

        // 1st. method with anonymous implementation object.
//        btn1.setOnAction(new EventHandler<>() {
//            @Override
//            public void handle(ActionEvent event) {
//                log.trace("btn1::handle({}) invoked.", event);
//            } // handle
//        }); // .setOnAction

        // 2nd. method with Lambda expression.
        btn1.setOnAction(e -> log.trace("btn1::handle({}) invoked.", e)); // .setOnAction

        // ------------------------
        Button btn2 = new Button("Button2");
        btn2.setPrefWidth(100.);
        btn2.setPrefHeight(30.);
        btn2.setFont(Font.font("Lucida Sans Unicode", 13.));
        btn2.setOnAction(e -> log.trace("btn2::handle({}) invoked.", e)); // .setOnAction

        // ------------------------
        ObservableList<Node> children = root.getChildren();
        children.addAll(btn1, btn2);
        children.forEach(log::info);

        // ------------------------
        primaryStage.setTitle("AppMain14");

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

/*      // 1st. method with anonymous implementation object.
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                log.trace("primaryStage::handle({}) invoked.", event);
                // Platform.exit();      // XX : *NOT* required.
            } // handle
        }); // .setOnCloseRequest
*/

        // 2nd. method with Lambda expression.
        primaryStage.setOnCloseRequest(e -> log.trace("primaryStage::handle({}) invoked.", e));

        primaryStage.show();
    } // start


    public static void main(String[] args) {
        log.trace("main({}) invoked.", Arrays.toString(args));
        Application.launch(args);
    } // main

} // end class
