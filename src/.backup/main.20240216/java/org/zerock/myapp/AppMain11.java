package org.zerock.myapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;


@Log4j2
@NoArgsConstructor
public class AppMain11 extends Application {


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
//        Parent root = FXMLLoader.load(this.getClass().getResource("AppMain11.fxml"));         // OK
//        log.trace("\t+ root: {}", root);

        // ------------------------
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("AppMain11.fxml"));      // OK
        Parent root = loader.<TilePane>load();
        log.trace("\t+ root: {}", root);

        // ------------------------
        root.getChildrenUnmodifiable().forEach(log::info);

        // ------------------------
        primaryStage.setTitle("AppMain11");

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
        primaryStage.setResizable(true);
        primaryStage.setAlwaysOnTop(true);

        primaryStage.show();
    } // start


    public static void main(String ... args) {
        log.trace("main({}) invoked.", Arrays.toString(args));
        Application.launch(args);
    } // main
} // end class
