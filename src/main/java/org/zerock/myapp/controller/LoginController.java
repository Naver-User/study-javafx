package org.zerock.myapp.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;
import org.zerock.myapp.util.CommonUtil;

import java.net.URL;
import java.util.ResourceBundle;


@Log4j2
@Accessors(fluent = true)
@Data
public class LoginController implements Initializable {
    @FXML private BorderPane login;
    @FXML private Button btnMain;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);
        log.info("\t+ login: {}, btnMain: {}", login, btnMain);

    } // initialize

    public void handleBtnClose(ActionEvent event) {
        log.trace("handleBtnClose({}) invoked.", event);

        Platform.exit();
    } // handleBtnClose

    public void handleBtnMain(ActionEvent event) {
        log.trace("handleBtnMain({}) invoked.", event);

        // --------------
        // 1. How to get *Primary Stage* from a UI control ?
        // --------------
        // Returns javafx.stage.Stage by .getWindow() method.
        // Window mainWindow = this.btnMain().getScene().getWindow();

        Stage primaryStage = (Stage) this.btnMain().getScene().getWindow();
        log.info("\t+ primaryStage: {}", primaryStage);

        // ----------------
        // 2. How to get *Root Container* from a UI control ?
        // --------------
        Parent root = this.login().getParent();             // 1st. method
//        Parent root = this.login().getScene().getRoot();    // 2nd. method
//        Parent root = this.btnMain().getScene().getRoot();  // 3rd. method

        log.info("\t+ root: {}", root);

        // --------------
        // 3. How to traverse all child nodes from the root node by the hierarchy ?
        // --------------
        CommonUtil.doTraverseByHierarchy(root, 0);

        // --------------
        // 4. How to apply animation to the scene change ?
        // --------------

        // 4-1. Not To move the login container.
        login.setTranslateY(0.);

        // 4-2. To create the KeyValue, KeyFrame.
        KeyValue keyValue = new KeyValue(login.translateYProperty(), 500.);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(100.), keyValue);

        // 4-3. To create a TimeLine and play this time line to apply animation.
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);

        timeline.play();

        // 5. To wait for animation duration time.
        timeline.setOnFinished(e -> {
            // ----------------
            // 5-1. How to change the current scene ?
            // --------------
            ((StackPane) root).getChildren().remove(login); // Login -> Main
        }); // .setOnFinished

    } // handleBtnMain


    /**
     * ------------------------------------------------------------
     * How to apply Animation to the container/control in JavaFX ?
     * ------------------------------------------------------------
     * (1) KeyValue keyValue = new KeyValue(Container/Control.translateXProperty(), endValue);
     *
     * (2) KeyFrame keyFrame = new KeyFrame(Duration.millis(durationTime), keyValue);
     *
     * (3) Timeline timeline = new TimeLine();
     * (4) timeline.getKeyFrames().add(keyFrame);
     * (5) timeline.play();
     * ------------------------------------------------------------
     */

} // end class


