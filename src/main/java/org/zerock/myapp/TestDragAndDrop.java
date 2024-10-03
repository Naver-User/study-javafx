package org.zerock.myapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Arrays;


@Log4j2
@NoArgsConstructor
public class TestDragAndDrop extends Application {
    private double xOffset;
    private double yOffset;


    @Override
    public void start(Stage primaryStage) throws Exception {
        log.trace("start({}) invoked.", primaryStage);

        // ----------
        Label lbl = new Label("Drag Me !!!");

        lbl.setStyle("-fx-background-color: #000055;-fx-text-fill: white;");
        lbl.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, 16.));
        lbl.setPadding(new Insets(10.));
        lbl.setAlignment(Pos.CENTER);
        lbl.setPrefSize(200., 200.);


        // ******************************************************************************
        // To set required event handlers on drag & drop events for moving primary stage.
        // ******************************************************************************

        // ---------------------
        // 1. When pressing any button on the <MOUSE>
        // ---------------------

        lbl.setOnMousePressed(e -> {    // MouseEvent
            log.trace("0. setOnMousePressed({}) invoked.", e);

            log.info("\t+ (screenX, screenY) = ({}, {}), (sceneX, sceneY) = ({}, {})",
                    e.getScreenX(), e.getScreenY(), e.getSceneX(), e.getSceneY());

            // ---------------

            /*
             * -----------------------------------------------------------------
             * 1. javafx.scene.input.MouseEvent.getSceneX()
             * -----------------------------------------------------------------
             *  Returns horizontal position of the event relative to the origin of the Scene
             *  that contains the MouseEvent's source.
             *
             *  If the node is not in a Scene, then the value is relative to the boundsInParent of
             *  the root-most parent of the MouseEvent's node.
             *
             *  Note that in 3D scene, this represents the flat coordinates
             *  after applying the projection transformations.
             *
             * -----------------------------------------------------------------
             * 2. javafx.scene.input.MouseEvent.getSceneY()
             * -----------------------------------------------------------------
             *  Returns vertical position of the event relative to the origin of the Scene
             *  that contains the MouseEvent's source.
             *
             *  If the node is not in a Scene, then the value is relative to the boundsInParent of
             *  the root-most parent of the MouseEvent's node.
             *
             *  Note that in 3D scene, this represents the flat coordinates
             *  after applying the projection transformations.
             *
             */

            this.xOffset = e.getSceneX();
            this.yOffset = e.getSceneY();
        }); // .setOnMousePressed

/*
        lbl.setOnMouseReleased(e -> {   // MouseEvent
            log.trace("setOnMouseReleased({}) invoked.", e);
        }); // .setOnMouseReleased

        lbl.setOnMouseClicked(e -> {    // MouseEvent
            log.trace("setOnMouseClicked({}) invoked.", e);
        }); // .setOnMouDrag Me !!!seClicked

        lbl.setOnMouseMoved(e -> {    // MouseEvent
            log.trace("setOnMouseMoved({}) invoked.", e);
        }); // .setOnMouseMoved
*/

        // ---------------------
        // 2. When pressing any button and moving cursor on the <MOUSE> (Drag & Drop)
        // ---------------------
/*
        lbl.setOnMouseDragEntered(e -> {    // MouseEvent
            log.trace("setOnMouseDragEntered({}) invoked.", e);
        }); // .setOnMouseDragEntered

        lbl.setOnMouseDragOver(e -> {       // MouseEvent
            log.trace("setOnMouseDragOver({}) invoked.", e);
        }); // .setOnMouseDragOver

        lbl.setOnMouseDragExited(e -> {     // MouseEvent
            log.trace("setOnMouseDragExited({}) invoked.", e);
        }); // .setOnMouseDragExited

        lbl.setOnMouseDragReleased(e -> {   // MouseEvent
            log.trace("setOnMouseDragReleased({}) invoked.", e);
        }); // .setOnMouseDragReleased
*/

        lbl.setOnMouseDragged(e -> {        // MouseEvent
            log.trace("1. setOnMouseDragged({}) invoked.", e);

            /*
             * -----------------------------------------------------------------
             * 1. javafx.scene.input.MouseEvent.getScreenX()
             * -----------------------------------------------------------------
             *  Returns absolute horizontal position of the event.
             *
             * -----------------------------------------------------------------
             * 2. javafx.scene.input.MouseEvent.getScreenY()
             * -----------------------------------------------------------------
             *  Returns absolute vertical position of the event.
             *
             * -----------------------------------------------------------------
             * 3. javafx.scene.input.MouseEvent.getSceneX()
             * -----------------------------------------------------------------
             *  Returns horizontal position of the event relative to the origin of the Scene
             *  that contains the MouseEvent's source.
             *
             *  If the node is not in a Scene, then the value is relative to the boundsInParent of
             *  the root-most parent of the MouseEvent's node.
             *
             *  Note that in 3D scene, this represents the flat coordinates
             *  after applying the projection transformations.
             *
             * -----------------------------------------------------------------
             * 4. javafx.scene.input.MouseEvent.getSceneY()
             * -----------------------------------------------------------------
             *  Returns vertical position of the event relative to the origin of the Scene
             *  that contains the MouseEvent's source.
             *
             *  If the node is not in a Scene, then the value is relative to the boundsInParent of
             *  the root-most parent of the MouseEvent's node.
             *
             *  Note that in 3D scene, this represents the flat coordinates
             *  after applying the projection transformations.
             *
             */

            log.info("\t+ (screenX, screenY) = ({}, {}), (sceneX, sceneY) = ({}, {})",
                    e.getScreenX(), e.getScreenY(), e.getSceneX(), e.getSceneY());

            // ---------------
            primaryStage.setX(e.getScreenX() - this.xOffset);
            primaryStage.setY(e.getScreenY() - this.yOffset);

            // ---------------

            /*
             * -----------------------------------------------------------------
             * javafx.event.Event.consume()
             * -----------------------------------------------------------------
             *  Marks this Event as consumed.
             *  This stops its further propagation.
             *
             */

            e.consume();
        }); // .setOnMouseDragged


        // ---------------------
        // 3. When drag & drop with mouse
        // ---------------------

        lbl.setOnDragDetected(e -> {    // MouseEvent
            log.trace("2. setOnDragDetected({}) invoked.", e);

            /*
             * -----------------------------------------------------------------
             * 1. javafx.scene.input.MouseEvent.getScreenX()
             * -----------------------------------------------------------------
             *  Returns absolute horizontal position of the event.
             *
             * -----------------------------------------------------------------
             * 2. javafx.scene.input.MouseEvent.getScreenY()
             * -----------------------------------------------------------------
             *  Returns absolute vertical position of the event.
             *
             * -----------------------------------------------------------------
             * 3. javafx.scene.input.MouseEvent.getSceneX()
             * -----------------------------------------------------------------
             *  Returns horizontal position of the event relative to the origin of the Scene
             *  that contains the MouseEvent's source.
             *
             *  If the node is not in a Scene, then the value is relative to the boundsInParent of
             *  the root-most parent of the MouseEvent's node.
             *
             *  Note that in 3D scene, this represents the flat coordinates
             *  after applying the projection transformations.
             *
             * -----------------------------------------------------------------
             * 4. javafx.scene.input.MouseEvent.getSceneY()
             * -----------------------------------------------------------------
             *  Returns vertical position of the event relative to the origin of the Scene
             *  that contains the MouseEvent's source.
             *
             *  If the node is not in a Scene, then the value is relative to the boundsInParent of
             *  the root-most parent of the MouseEvent's node.
             *
             *  Note that in 3D scene, this represents the flat coordinates
             *  after applying the projection transformations.
             *
             */

            log.info("\t+ (screenX, screenY) = ({}, {}), (sceneX, sceneY) = ({}, {})",
                    e.getScreenX(), e.getScreenY(), e.getSceneX(), e.getSceneY());

            // ---------------

            /*
             * -----------------------------------------------------------------
             * 1. Dragboard Node.startDragAndDrop(TransferMode... transferModes)
             * -----------------------------------------------------------------
             *  Confirms a potential drag and drop gesture that is recognized over this Node.
             *  Can be called only from a DRAG_DETECTED event handler.
             *
             *  The returned Dragboard is used to transfer data during the drag and drop gesture.
             *
             *  Placing this Node's data on the Dragboard also identifies this Node
             *  as the source of the drag and drop gesture.
             *
             * -----------------------------------------------------------------
             * 2. javafx.scene.input.TransferMode
             * -----------------------------------------------------------------
             *  Describes the mode of data transfer with respect to a drag and drop gesture.
             *
             *      TransferMode.COPY - Indicates copying of data is supported or intended.
             *      TransferMode.MOVE - Indicates moving of data is supported or intended.
             *      TransferMode.LINK - Indicates linking of data is supported or intended.
             *
             * -----------------------------------------------------------------
             * 3. javafx.scene.input.Dragboard
             * -----------------------------------------------------------------
             *  A drag and drop specific Clipboard.
             *
             * -----------------------------------------------------------------
             * 4. javafx.scene.input.Dragboard.setContent(Map<DataFormat, Object> content)
             * -----------------------------------------------------------------
             *  Puts content onto the clipboard.
             *  This call will always result in clearing all previous content from the clipboard,
             *  and replacing it with whatever content is specified in the supplied ClipboardContent map.
             *
             *  Params:
             *      content – The content to put on the clipboard.
             *                If null, the clipboard is simply cleared and no new content added.
             *  Returns:
             *      True if successful, false if the content fails to be added.
             *
             * -----------------------------------------------------------------
             * 5. javafx.scene.input.ClipboardContent
             * -----------------------------------------------------------------
             *  Data container for Clipboard data.
             *  It can hold multiple data in several data formats.
             *
             * -----------------------------------------------------------------
             * 6. javafx.scene.input.ClipboardContent.putString(String s)
             * -----------------------------------------------------------------
             *  Puts a plain text String into the ClipboardContent.
             *  This is equivalent to invoking put(DataFormat.PLAIN_TEXT, s).
             *  Setting this value to null effectively clears it from the ClipboardContent.
             *
             *  Params:
             *      s – The string to place. This may be null.
             *  Returns:
             *      always true (the string is always successfully put)
             *
             */

            Dragboard db = lbl.startDragAndDrop(TransferMode.MOVE);

            ClipboardContent content = new ClipboardContent();
            content.putString(lbl.getText());

            db.setContent(content);

            // ---------------

            /*
             * -----------------------------------------------------------------
             * javafx.event.Event.consume()
             * -----------------------------------------------------------------
             *  Marks this Event as consumed.
             *  This stops its further propagation.
             *
             */

            e.consume();
        }); // .setOnDragDetected

        lbl.setOnDragEntered(e -> {     // DragEvent
            log.trace("3. setOnDragEntered({}) invoked.", e);

            log.info("\t+ (screenX, screenY) = ({}, {}), (sceneX, sceneY) = ({}, {})",
                    e.getScreenX(), e.getScreenY(), e.getSceneX(), e.getSceneY());
        }); // .setOnDragEntered

        lbl.setOnDragOver(e -> {        // DragEvent
            log.trace("4. setOnDragOver({}) invoked.", e);

            log.info("\t+ (screenX, screenY) = ({}, {}), (sceneX, sceneY) = ({}, {})",
                    e.getScreenX(), e.getScreenY(), e.getSceneX(), e.getSceneY());

            // ---------------
            primaryStage.setX(e.getScreenX() - this.xOffset);
            primaryStage.setY(e.getScreenY() - this.yOffset);

            // ---------------

            /*
             * -----------------------------------------------------------------
             * 1. javafx.scene.input.DragEvent.getDragboard()
             * -----------------------------------------------------------------
             *  A dragboard that is available to transfer data.
             *  Data can be placed onto this dragboard in handler of the DRAG_DETECTED mouse event.
             *  Data can be copied from this dragboard in handler of the DRAG_DROPPED event.
             *
             *  Returns: a dragboard that is available to transfer data
             *
             * -----------------------------------------------------------------
             * 2. javafx.scene.input.Dragboard
             * -----------------------------------------------------------------
             *  A drag and drop specific Clipboard.
             *
             * -----------------------------------------------------------------
             * 3. javafx.scene.input.Dragboard.hasString()
             * -----------------------------------------------------------------
             *  Gets whether a plain text String (DataFormat.PLAIN_TEXT) has been registered on this Clipboard.
             *
             *  Returns:
             *      true if hasContent(DataFormat.PLAIN_TEXT) returns true, false otherwise
             *
             * -----------------------------------------------------------------
             * 4. javafx.scene.input.DragEvent.getGestureSource()
             * -----------------------------------------------------------------
             *  The source object of the drag and drop gesture.
             *  Gesture source is the object that started drag and drop operation.
             *  The value null is valid in the case that the gesture comes from another application.
             *
             *  Returns:
             *      the source object of the drag and drop gesture
             *
             * -----------------------------------------------------------------
             * 5. javafx.scene.input.DragEvent.acceptTransferModes(TransferMode... transferModes)
             * -----------------------------------------------------------------
             *  Accepts this DragEvent, choosing the transfer mode for the drop operation.
             *  Used to indicate that the potential drop target that receives this event is a drop target
             *  from DRAG_OVER event handler.
             *
             *  It accepts one of the transfer modes that are both passed into this method and supported by the gesture source.
             *  It accepts the default transfer mode if possible, otherwise the most common one of the acceptable modes.
             *
             *  Params:
             *      transferModes – the transfer mode for the drop operation.
             *
             * -----------------------------------------------------------------
             * 6. javafx.scene.input.TransferMode
             * -----------------------------------------------------------------
             *  Describes the mode of data transfer with respect to a drag and drop gesture.
             *
             *      TransferMode.COPY - Indicates copying of data is supported or intended.
             *      TransferMode.MOVE - Indicates moving of data is supported or intended.
             *      TransferMode.LINK - Indicates linking of data is supported or intended.
             *
             * -----------------------------------------------------------------
             * 7. javafx.scene.input.Clipboard.hasString()
             * -----------------------------------------------------------------
             *  Gets whether a plain text String (DataFormat.PLAIN_TEXT) has been registered on this Clipboard.
             *
             *  Returns:
             *      true if hasContent(DataFormat.PLAIN_TEXT) returns true, false otherwise
             *
             */

            if (e.getGestureSource() != lbl && e.getDragboard().hasString()) {
                e.acceptTransferModes(TransferMode.MOVE);
            } // if

            /*
             * -----------------------------------------------------------------
             * javafx.event.Event.consume()
             * -----------------------------------------------------------------
             *  Marks this Event as consumed.
             *  This stops its further propagation.
             *
             */

            e.consume();
        }); // .setOnDragOver

        lbl.setOnDragExited(e -> {      // DragEvent
            log.trace("5. setOnDragExited({}) invoked.", e);

            log.info("\t+ (screenX, screenY) = ({}, {}), (sceneX, sceneY) = ({}, {})",
                    e.getScreenX(), e.getScreenY(), e.getSceneX(), e.getSceneY());
        }); // .setOnDragExited

        lbl.setOnDragDone(e -> {        // DragEvent
            log.trace("6. setOnDragDone({}) invoked.", e);

            log.info("\t+ (screenX, screenY) = ({}, {}), (sceneX, sceneY) = ({}, {})",
                    e.getScreenX(), e.getScreenY(), e.getSceneX(), e.getSceneY());
        }); // .setOnDragDone

        lbl.setOnDragDropped(e -> {     // DragEvent
            log.trace("7. setOnDragDropped({}) invoked.", e);

            log.info("\t+ (screenX, screenY) = ({}, {}), (sceneX, sceneY) = ({}, {})",
                    e.getScreenX(), e.getScreenY(), e.getSceneX(), e.getSceneY());

            // ---------------

            /*
             * -----------------------------------------------------------------
             * 1. javafx.scene.input.DragEvent.getDragboard()
             * -----------------------------------------------------------------
             *  A dragboard that is available to transfer data.
             *  Data can be placed onto this dragboard in handler of the DRAG_DETECTED mouse event.
             *  Data can be copied from this dragboard in handler of the DRAG_DROPPED event.
             *
             *  Returns: a dragboard that is available to transfer data
             *
             * -----------------------------------------------------------------
             * 2. javafx.scene.input.Dragboard
             * -----------------------------------------------------------------
             *  A drag and drop specific Clipboard.
             *
             * -----------------------------------------------------------------
             * 3. javafx.scene.input.Dragboard.hasString()
             * -----------------------------------------------------------------
             *  Gets whether a plain text String (DataFormat.PLAIN_TEXT) has been registered on this Clipboard.
             *
             *  Returns:
             *      true if hasContent(DataFormat.PLAIN_TEXT) returns true, false otherwise
             *
             * -----------------------------------------------------------------
             * 4. javafx.scene.input.Clipboard.hasString()
             * -----------------------------------------------------------------
             *  Gets whether a plain text String (DataFormat.PLAIN_TEXT) has been registered on this Clipboard.
             *
             *  Returns:
             *      true if hasContent(DataFormat.PLAIN_TEXT) returns true, false otherwise
             *
             * -----------------------------------------------------------------
             * 5. javafx.scene.input.Clipboard.getString()
             * -----------------------------------------------------------------
             *  Gets the plain text String from the clipboard which had previously been registered.
             *  his is equivalent to invoking getContent(DataFormat.PLAIN_TEXT).
             *  If no such entry exists, null is returned.
             *
             * -----------------------------------------------------------------
             * 6. javafx.scene.input.DragEvent.setDropCompleted(boolean isTransferDone)
             * -----------------------------------------------------------------
             *  Indicates that transfer handling of this DragEvent was completed successfully
             *  during a DRAG_DROPPED event handler.
             *
             *  No dragboard access can happen after this call.
             *
             *  Params:
             *      isTransferDone – true indicates that the transfer was successful.
             *
             */

            boolean success = false;

            Dragboard db = e.getDragboard();
            if (db.hasString()) {
                lbl.setText(db.getString());
                success = true;
            } // if

            // ---------------
            e.setDropCompleted(success);

            /*
             * -----------------------------------------------------------------
             * javafx.event.Event.consume()
             * -----------------------------------------------------------------
             *  Marks this Event as consumed.
             *  This stops its further propagation.
             *
             */

            e.consume();
        }); // .setOnDragDropped


        // --------------------------------
        Button btnClose = new Button("Close");
        btnClose.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, 13.));
        btnClose.setPrefSize(100., 20.);
        VBox.setMargin(btnClose, new Insets(5.));

        btnClose.setOnAction(this::handleBtnClose); // .setOnAction

        // --------------------------------
        VBox vBox = new VBox(lbl, btnClose);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(10.));

        Scene scene = new Scene(vBox);

        // --------------------------------
        primaryStage.setTitle("Drag & Drop Window");

        /*
         * Specifies the style for this stage.
         * This must be done prior to making the stage visible. (***)
         */
//        primaryStage.initStyle(StageStyle.DECORATED);         // Ordinary window
        primaryStage.initStyle(StageStyle.UNDECORATED);       // *NO* caption bar on window
//        primaryStage.initStyle(StageStyle.TRANSPARENT);       // *NOT* supported on windows platform.
//        primaryStage.initStyle(StageStyle.UTILITY);           // Like Dialog Window.
//        primaryStage.initStyle(StageStyle.UNIFIED);           // *NOT* supported on windows platform.

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setAlwaysOnTop(true);

        primaryStage.setX(100.);
        primaryStage.setY(800.);

        primaryStage.show();
    }// start

    public void handleBtnClose(ActionEvent event) {
        log.trace("handleBtnClose({}) invoked.", event);
        Platform.exit();
    } // handleBtnClose


    public static void main(String... args) {
        log.trace("main({}) invoked.", Arrays.toString(args));
        Application.launch(args);
    } // main

} // end class
