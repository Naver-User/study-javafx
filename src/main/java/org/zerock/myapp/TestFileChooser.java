package org.zerock.myapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.util.Arrays;
import java.util.List;


@Log4j2
@NoArgsConstructor
public class TestFileChooser extends Application {


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
        // FileChooser to select files.
        // --------
        // Until closing FileChooser, thread is suspended.
        // Thread re-runs when closing FileChooser.         <--- ***

        FileChooser chooser = new FileChooser();
        log.info("\t+ chooser: {}", chooser);

        // --------
        chooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
            new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
            new FileChooser.ExtensionFilter("All Files", "*.*")
        );  // .addAll

        // --------
        chooser.setTitle("1. 하나의 파일만 선택하세요!!!");
        File selectedFile = chooser.showOpenDialog(primaryStage);                   // Blocking I/O
        log.info("\t+ selectedFile: {}", selectedFile);

        // --------
        chooser.setTitle("2. 여러파일을 선택하세요!!!");
        List<File> selectedFiles = chooser.showOpenMultipleDialog(primaryStage);    // Blocking I/O
        log.info("\t+ selectedFiles: {}", selectedFiles);

        // --------
        chooser.setTitle("3. 파일을 저장하세요!!!");
        File savedFile = chooser.showSaveDialog(primaryStage);                      // Blocking I/O
        log.info("\t+ savedFile: {}", savedFile);

        // --------
        Platform.exit();
    } // start


    public static void main(String... args) {
        log.trace("main({}) invoked.", Arrays.toString(args));
        Application.launch(args);
    } // main

} // end class
