package org.zerock.myapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.zerock.myapp.controller.RootController19;

import java.util.Arrays;


@Log4j2
@NoArgsConstructor
public class AppMain19 extends Application {
    // XX : UI control CANNOT be injected in main class.
//    @FXML private Circle circle;


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

        // ----------------
//        Parent root = FXMLLoader.<AnchorPane>load(this.getClass().getResource("AppMain19.fxml"));
//        log.info("\t+ root: {}", root);
//
//        root.getChildrenUnmodifiable().forEach(log::info);

        // ----------------
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("AppMain19.fxml"));
        Parent root = loader.<AnchorPane>load();
        log.info("\t+ root: {}", root);

        root.getChildrenUnmodifiable().forEach(log::info);

        // ----------------
        //  How to get UI controls defined in the FXML file ?
        // ----------------
        RootController19 controller = loader.getController();
        AnchorPane anchorPane = controller.root();
        Circle circle = controller.circle();

        // controller: org.zerock.myapp.controller.RootController19@6ce1f6bb
        log.info("\t+ controller: {}", controller);
        log.info("\t+ anchorPane: {}", anchorPane);
        log.info("\t+ circle: {}", circle);

        // ----------------
        primaryStage.setTitle("AppMain19");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(true);
        primaryStage.setAlwaysOnTop(true);

//        primaryStage.show();
        primaryStage.close();
    } // start


    public static void main(String ... args) {
        log.trace("main({}) invoked.", Arrays.toString(args));
        Application.launch(args);
    } // main

} // end class
