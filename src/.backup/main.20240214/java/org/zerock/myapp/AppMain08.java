package org.zerock.myapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;


@Log4j2
@NoArgsConstructor
public class AppMain08 extends Application {


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
//        Parent root = FXMLLoader.<VBox>load(
//            Objects.requireNonNull(
//                this.getClass().getResource("AppMain08.fxml"),
//                "No AppMain08.fxml found."
//            )
//        );  // .load

        // ------------------------
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("AppMain08.fxml"));
        Parent root = loader.<VBox>load();

        // ------------------------
        ObservableList<Node> children = root.getChildrenUnmodifiable();
        children.forEach(log::info);

        if(children.get(1) instanceof HBox hbox) {
            if(hbox.getChildren().get(1) instanceof Button closeButton) {
                closeButton.setOnAction(e -> {
                    log.trace("Button::setOnAction({}) invoked.", e);
                    Platform.exit();
                }); // .setOnAction
            } // if
        } // if

        // ------------------------
        primaryStage.setTitle("AppMain08");

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
