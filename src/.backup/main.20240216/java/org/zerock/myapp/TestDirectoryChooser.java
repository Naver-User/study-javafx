package org.zerock.myapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.util.Arrays;


@Log4j2
@NoArgsConstructor
public class TestDirectoryChooser extends Application {


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


        // --------
        // DirectoryChooser to select a directory.
        // --------
        // Until closing DirectoryChooser, thread is suspended.
        // Thread re-runs when closing DirectoryChooser.         <--- ***

        // --------
        DirectoryChooser chooser = new DirectoryChooser();
        log.info("\t+ chooser: {}", chooser);

        // --------
        chooser.setTitle("디렉토리를 선택하세요!!!");

        File selectedDir = chooser.showDialog(primaryStage);
        log.info("\t+ selectedDir: {}", selectedDir);

        // --------------
        Platform.runLater(Platform::exit);
    } // start


    public static void main(String... args) {
        log.trace("main({}) invoked.", Arrays.toString(args));
        Application.launch(args);
    } // main

} // end class


