package org.zerock.myapp.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


@Log4j2
@Accessors(fluent = true)
@Data
public class RootController38 implements Initializable {
    @FXML private StackPane root;
    @FXML private BorderPane main;
    @FXML private Button btnLogin;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);
        log.info("\t+ root: {}, main: {}, btnLogin: {}", root, main, btnLogin);

    } // initialize

    public void handleBtnClose(ActionEvent event) {
        log.trace("handleBtnClose({}) invoked.", event);

        Platform.exit();
    } // handleBtnClose

    public void handleBtnLogin(ActionEvent event) throws IOException {
        log.trace("handleBtnLogin({}) invoked.", event);

        // --------------
        // 1. How to get *Primary Stage* from a UI control ?
        // --------------
        // Returns javafx.stage.Stage by .getWindow() method.
        // Window mainWindow = this.btnLogin().getScene().getWindow();

        Stage primaryStage = (Stage) this.btnLogin().getScene().getWindow();
        log.info("\t+ primaryStage: {}", primaryStage);

        // --------------
        // 2. How to get *Root Container* from a UI control ?
        // --------------
        Parent root = this.btnLogin().getScene().getRoot();
        log.info("\t+ root: {}", root);

        // --------------
        // 3. How to traverse all child nodes from the root node by the hierarchy ?
        // --------------
//        this.doTraverseByHierarchy(root, 0);

        CommonUtil.doTraverseByHierarchy(root, 0);

        // --------------
        // 4. How to change the current scene ?
        // --------------
        Parent login = FXMLLoader.load(
            Objects.requireNonNull(
                this.getClass().getResource("/org/zerock/myapp/login.fxml"),
                "No login.fxml found."
            )
        ); // .load

        // Main -> Login
//        ((StackPane) root).getChildren().add(login);  // 1st. method
        this.root().getChildren().add(login);   // 2nd. method

        // --------------
        // 5. How to apply animation to the scene change ?
        // --------------

        // 5-1. To move the login container to the right through X axis to be hidden.
        login.setTranslateX(300.);

        // 5-2. To create the KeyValue, KeyFrame.
        KeyValue keyValue = new KeyValue(login.translateXProperty(), 0.);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(100.), keyValue);

        // 5-3. To create a TimeLine and play this time line to apply animation.
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);

        timeline.play();
    } // handleBtnLogin

    /**
     * ------------------------------------------------------------
     * How to traverse all child nodes from the root node by the hierarchy ?
     * ------------------------------------------------------------
        this.doTraverseByHierarchy(root, 0);

        private void doTraverseByHierarchy(Node node, int depth) {
            // log.trace("{}[{}]. doTraverseByHierarchy({}) invoked.", "\t".repeat(depth), depth, node);
            log.trace("{}[{}]. {}", "\t".repeat(depth), depth, node);

            Objects.requireNonNull(node, "Depth(%s) node is NULL.".formatted(depth));

            if(node instanceof Parent parent) {
                parent.getChildrenUnmodifiable().
                    forEach(n -> this.doTraverseByHierarchy(n, depth + 1));
            } // if
        } // doTraverseByHierarchy
     * ------------------------------------------------------------
     */

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


