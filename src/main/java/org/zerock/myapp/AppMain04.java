package org.zerock.myapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;


@Log4j2
@NoArgsConstructor
public class AppMain04 extends Application {


    @Override
    public void start(Stage primaryStage) {
        log.trace("start({}) invoked.", primaryStage);

        // --------------------
        TextField textField = new TextField();
        textField.setPrefWidth(200.);
        textField.setFont(Font.font("D2Coding", 16.));

        textField.setOnKeyTyped(e -> {
            log.trace("setOnKeyTyped({}) invoked.", e);

            String character = e.getCharacter();
            log.info("\t+ character: {}", character);

//            CharSequence charSequence = textField.getCharacters();
//            log.info("\t+ charSequence: {}", charSequence);
        }); // .setOnKeyTyped

        // --------------------
        Button button = new Button();
        button.setText("Confirm");
        button.setFont(Font.font("Lucida Sans Unicode", 13.));

        button.setOnAction(e -> {
            log.trace("setOnAction({}) invoked.", e);

            CharSequence charSequence = textField.getCharacters();
            log.info("\t+ charSequence: {}", charSequence);

            Platform.exit();
        }); // .setOnAction

        // --------------------
        HBox root = new HBox();
//        root.setPadding(new Insets(10., 10., 10., 10.));      // OK
        root.setPadding(new Insets(10.));                     // OK
        root.setSpacing(10.);

        // --------------------
        ObservableList<Node> children  = root.getChildren();

//        children.add(textField);
//        children.add(button);

        children.addAll(textField, button);

        children.forEach(log::info);

        // --------------------
        Scene scene = new Scene(root);

        // --------------------
        primaryStage.setTitle("AppMain04");

        /*
         * Specifies the style for this stage.
         * This must be done prior to making the stage visible. (***)
         */
//        primaryStage.initStyle(StageStyle.DECORATED);         // Ordinary window
//        primaryStage.initStyle(StageStyle.UNDECORATED);       // *NO* caption bar on window
//        primaryStage.initStyle(StageStyle.TRANSPARENT);       // *NOT* supported on windows platform.
        primaryStage.initStyle(StageStyle.UTILITY);           // Like Dialog Window.
//        primaryStage.initStyle(StageStyle.UNIFIED);           // *NOT* supported on windows platform.

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);

        primaryStage.show();
    } // start

    @Override
    public void init() {
        log.trace("init() invoked.");
    } // init

    @Override
    public void stop() {
        log.trace("stop() invoked.");
    } // stop


    public static void main(String ... args) {
        log.trace("main({}) invoked.", Arrays.toString(args));

//        Application.launch();
        Application.launch(args);
    } // main
} // end class
