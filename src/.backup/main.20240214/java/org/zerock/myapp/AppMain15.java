package org.zerock.myapp;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;
import java.util.Objects;


@Log4j2
@NoArgsConstructor
public class AppMain15 extends Application {


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

        // ---------------
        // (1) Root Controller.<init> invoked.                                          <--- ***
        //      -> Create a Root Controller with default constructor.
        // (2) Inject the corresponding UI controls declared from FXML
        //     into fields with @FXML defined in the Root Controller.                   <--- ***
        // (3) Root Controller.initialize() invoked.                                    <--- ***
        //      -> Initialize UI controls, register event handler, and so on.
        Parent root = FXMLLoader.<HBox>load(
            Objects.requireNonNull(
                this.getClass().getResource("AppMain15.fxml"),
                "No AppMain15.fxml found."
            )
        );  // .load
        log.info("\t+ root: {}", root);

        // ---------------
        ObservableList<Node> children = root.getChildrenUnmodifiable();
        children.forEach(log::info);

        // ---------------
        primaryStage.setTitle("AppMain15");

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
