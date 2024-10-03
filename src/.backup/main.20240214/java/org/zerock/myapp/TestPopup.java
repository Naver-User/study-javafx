package org.zerock.myapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;


@Log4j2
@NoArgsConstructor
public class TestPopup extends Application {


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

        // --------------
        Popup popup = new Popup();
        popup.setWidth(300);
        popup.setHeight(35);

        /**
         * The ObservableList of Nodes to be rendered on this Popup.
         * The content forms the complete visual representation of the Popup.
         * Popups have no intrinsic visuals.
         */
        ObservableList<Node> content = popup.getContent();
        Parent popupRoot = FXMLLoader.<HBox>load(this.getClass().getResource("popup.fxml"));
        /** Appends the specified element to the end of this list (optional operation). */
        content.add(popupRoot);

        // --------------

        /**
         * Shows this stage and waits for it to be hidden (closed) before returning to the caller.
         */
//        popup.show(primaryStage, 500, 500);
        popup.show(primaryStage);

        // --------------
        primaryStage.hide();
//        Platform.exit();
    } // start


    public static void main(String[] args) {
        log.trace("main({}) invoked.", Arrays.toString(args));
        Application.launch(args);
    } // main

} // end class


