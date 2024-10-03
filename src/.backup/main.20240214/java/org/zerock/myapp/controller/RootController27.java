package org.zerock.myapp.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.*;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;


@Log4j2
@Accessors(fluent = true, chain = true)
@Data
public class RootController27 implements Initializable {
    private Stage primaryStage;

    @FXML private HBox containerHBox;
    @FXML private Button btnOpenFileChooser;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

        // --------------
        // Here, We cannot get the reference of main window (primaryStage)   <--- ***
        log.info("\t1. containerHBox: {}", this.containerHBox());
        log.info("\t2. btnOpenFileChooser: {}", this.btnOpenFileChooser());

        // --------------
        // 1st. location to get owner window (primaryStage)     XX
        // --------------
        // Error: because the return value of "javafx.scene.layout.HBox.getScene()" is null
//        Stage ownerStage1 = (Stage) this.containerHBox().getScene().getWindow();
//        log.info("\t3. ownerStage1: {}", ownerStage1);
    } // initialize

    public void handleOpenFileChooser(ActionEvent e) {
        log.trace("handleOpenFileChooser({}) invoked.", e);

        // --------------
        // 2nd. location to get owner window (primaryStage)     OK
        // --------------
        Stage ownerStage1 = (Stage) this.containerHBox().getScene().getWindow();
        log.info("\t3. ownerStage1: {}", ownerStage1);
        Stage ownerStage2 = (Stage) this.btnOpenFileChooser().getScene().getWindow();
        log.info("\t4. ownerStage2: {}", ownerStage2);

        // --------------
        FileChooser chooser = new FileChooser();

        chooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Text Files", "*.txt"),
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
            new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
            new FileChooser.ExtensionFilter("All Files", "*.*")
        );  // .addAll

        // --------------
//        chooser.setTitle("한 개의 파일만 선택하세요.");
//
//        File selectedFile = chooser.showOpenDialog(this.primaryStage());
//        Objects.requireNonNull(selectedFile, "No selected.");
//        log.info("\t+ selectedFile: {}", selectedFile);

        // --------------
        chooser.setTitle("한 개이상의 파일을 선택하실 수 있습니다.");

        List<File> selectedFiles = chooser.showOpenMultipleDialog(this.primaryStage());
        Objects.requireNonNull(selectedFiles, "No selected.");
        selectedFiles.forEach(log::info);
    } // handleOpenFileChooser

    public void handleSaveFileChooser(ActionEvent e) {
        log.trace("handleSaveFileChooser({}) invoked.", e);

        // --------------
        FileChooser chooser = new FileChooser();

        chooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("All Files", "*.*")
        );  // .addAll

        // --------------
        chooser.setTitle("저장할 파일을 선택하거나 새로이 입력하세요");

        File selectedFile = chooser.showSaveDialog(this.primaryStage());
        Objects.requireNonNull(selectedFile, "No selected.");
        log.info("\t+ selectedFile: {}", selectedFile);
    } // handleSaveFileChooser

    public void handleDirectoryChooser(ActionEvent e) {
        log.trace("handleDirectoryChooser({}) invoked.", e);

        // --------------
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("한 개의 디렉토리를 선택하세요.");

        // --------------
        File selectedDir = chooser.showDialog(this.primaryStage());

        Objects.requireNonNull(selectedDir, "No selected.");
        log.info("\t+ selectedDir: {}", selectedDir);
    } // handleDirectoryChooser

    public void handlePopup(ActionEvent e) throws IOException {
        log.trace("handlePopup({}) invoked.", e);

        // --------------
        Popup popup = new Popup();

        // --------------
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(
                this.getClass().getResource("/org/zerock/myapp/Popup.fxml"),
                "No Popup.fxml found."
            )
        );  // .load

        ImageView imageView = (ImageView) root.lookup("#imgMessage");
        Label label = (Label) root.lookup("#lblMessage");

        // --------------
        imageView.setImage(
            new Image(
                Objects.requireNonNull(
                    this.getClass().getResource("/images/dialog-info.png"),
                    "No dialog-info.png found"
                ).toString()
            )
        );  // .setImage

//        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {        // 1st. method
//            @Override
//            public void handle(MouseEvent event) {
//                log.trace("EventHandler<MouseEvent>::handle({}) invoked.", event);
//                popup.hide();
//            } // handle
//        }); // .setOnMouseClicked

        imageView.setOnMouseClicked(event -> popup.hide());                     // 2nd. method

        label.setText("A new message received.");

        // --------------
//        ObservableList<Node> list = popup.getContent();                       // 1st. method
//        list.add(root);

        popup.getContent().add(root);                                           // 2nd.method

        popup.setAutoHide(true);
        popup.show(this.primaryStage());
    } // handlePopup

    public void handleCustomDialog(ActionEvent e) throws IOException {
        log.trace("handleCustomDialog({}) invoked.", e);

        // --------------
        Stage dialog = new Stage(StageStyle.UTILITY);       // Dialog Window

        dialog.initModality(Modality.WINDOW_MODAL);         // Set Modal Window
        dialog.initOwner(this.primaryStage());              // Set Owner Window
        dialog.setTitle("Confirm");

        // --------------
        Parent root = FXMLLoader.<AnchorPane>load(
            Objects.requireNonNull(
                this.getClass().getResource("/org/zerock/myapp/CustomDialog.fxml"),
                "No CustomDialog.fxml found."
            )
        );  // .load

        // --------------
        ImageView imageView = (ImageView) root.lookup("#imageView");
        Label lblTitle = (Label) root.lookup("#lblTitle");
        Button btnOK = (Button) root.lookup("#btnOK");

        // --------------
        imageView.setImage(
            new Image(
                Objects.requireNonNull(
                    this.getClass().getResource("/images/dialog-warning.png"),
                    "No dialog-warning.png found."
                ).toString()
            )
        );  // .setImage

        lblTitle.setText("Do you confirm ?");

        btnOK.setOnAction(new EventHandler<>() {         // 1st. method
            @Override
            public void handle(ActionEvent event) {
                log.trace("EventHandler<ActionEvent>::handle({}) invoked.", event);
                dialog.close();
            } // handle
        }); // .setOnAction

//        btnOK.setOnAction(event -> dialog.close());                 // 2nd. method

        // --------------
        dialog.setScene(new Scene(root));
        dialog.setResizable(false);

        dialog.show();
        dialog.centerOnScreen();
    } // handleCustomDialog

} // end class



