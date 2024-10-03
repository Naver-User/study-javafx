package org.zerock.myapp.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.log4j.Log4j2;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


@Log4j2

@Accessors(fluent = true, chain = true)
@Data
public class RootController23 implements Initializable {
    @FXML private ImageView imageView;
    @FXML private MediaView mediaView;
    @FXML private Button playBtn;
    @FXML private Button pauseBtn;
    @FXML private Button stopBtn;
    @FXML private Button closeBtn;

    private boolean endOfMedia;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);
        log.info("\t+ this: {}", this);

        // ----------------
        boolean isVideo = true;

        String url = "/media/video.mp4";              // Video

//        String url = "/media/audio.wav";              // Audio
//        isVideo = !isVideo;

        // ----------------
        // Step1. Create a Media Object
        Media media = new Media(Objects.requireNonNull(this.getClass().getResource(url)).toString());

        // ----------------
        // Step2. Create a MediaPlayer Object
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        mediaPlayer.currentTimeProperty()
            .addListener((observableValue, oldValue, newValue) -> {
            log.trace("currentTime::changed(_, {}, {}) invoked.", oldValue, newValue);
        }); // .addListener

        // ----------------
        // Step3. Set the created MediaPlayer to the MediaView
        if(isVideo) this.mediaView().setMediaPlayer(mediaPlayer);

        // ----------------
        // Step4. Configure auto-play runnable object on each state

        // 4-1. When READY state,
        mediaPlayer.setOnReady(new Runnable() {

            @Override
            public void run() {
                log.trace("READY::run() invoked.");

                // ----------------
                playBtn().setDisable(false);
                pauseBtn().setDisable(true);
                stopBtn().setDisable(true);

                // ----------------
                if(mediaPlayer.isAutoPlay()) {
                    mediaView().setVisible(false);
                } // if
            } // run

        }); // .setOnReady

        // 4-2. When PLAYING state,
        mediaPlayer.setOnPlaying(() -> {
            log.trace("PLAYING::run() invoked.");

            // ----------------
            this.playBtn().setDisable(true);
            this.pauseBtn().setDisable(false);
            this.stopBtn().setDisable(false);
        }); // .setOnPlaying

        // 4-3. When PAUSE state,
        mediaPlayer.setOnPaused(() -> {
            log.trace("PAUSE::run() invoked.");

            // ----------------
            this.playBtn().setDisable(false);
            this.pauseBtn().setDisable(true);
            this.stopBtn().setDisable(false);
        }); // .setOnPaused

        // 4-4. When EndOfMedia State,
        mediaPlayer.setOnEndOfMedia(() -> {
            log.trace("EndOfMedia::run() invoked.");

            // ----------------
            // Automatically, mediaPlayer is seek to the start time.                <--- ***
            mediaPlayer.stop();

            // ----------------
            this.playBtn().setDisable(false);
            this.pauseBtn().setDisable(true);
            this.stopBtn().setDisable(true);
        }); // .setOnEndOfMedia

        // 4-5. When STOPPED state,
        mediaPlayer.setOnStopped(() -> {
            log.trace("STOPPED::run() invoked.");

            // ----------------
            this.endOfMedia(false);

            // ----------------
            this.playBtn().setDisable(false);
            this.pauseBtn().setDisable(true);
            this.stopBtn().setDisable(true);
        }); // .setOnStopped

        // 4-6. When STALLED state,
        mediaPlayer.setOnStalled(() -> {
            log.trace("STALLED::run() invoked.");

            // ----------------
            this.playBtn().setDisable(true);
            this.pauseBtn().setDisable(true);
            this.stopBtn().setDisable(false);
        }); // .setOnStalled

        // ----------------
        this.playBtn().setOnAction(e -> {
            log.trace("EventHandler<ActionEvent>::handle({}) invoked.", e);

            if(this.endOfMedia()) {
                // Automatically, mediaPlayer is seek to the start time.                <--- ***
                mediaPlayer.stop();
            } // if

            mediaPlayer.play();
            this.endOfMedia(false);
        }); // .setOnAction

        this.pauseBtn().setOnAction(e -> {
            log.trace("EventHandler<ActionEvent>::handle({}) invoked.", e);

            mediaPlayer.pause();
        }); // .setOnAction

        this.stopBtn().setOnAction(e -> {
            log.trace("EventHandler<ActionEvent>::handle({}) invoked.", e);

            // Automatically, mediaPlayer is seek to the start time.                <--- ***
            mediaPlayer.stop();
        }); // .setOnAction

        this.closeBtn().setOnAction(e -> Platform.exit());

    } // initialize

} // end class
