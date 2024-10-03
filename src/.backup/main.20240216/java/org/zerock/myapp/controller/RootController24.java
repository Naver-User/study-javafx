package org.zerock.myapp.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
public class RootController24 implements Initializable {
    @FXML private ImageView imageView;
    @FXML private MediaView mediaView;
    @FXML private Button playBtn;
    @FXML private Button pauseBtn;
    @FXML private Button stopBtn;
    @FXML private Button closeBtn;

    @FXML private ProgressBar progressBar;
    @FXML private ProgressIndicator progressIndicator;

    @FXML private Label labelTime;
    @FXML private Slider sliderVolume;

    private boolean endOfMedia;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        log.trace("initialize({}, {}) invoked.", location, resources);

        // ----------------
        this.sliderVolume().setValue(0.);   // set initial volume

        // ----------------
        boolean isVideo = true;

        String url = "/media/video.mp4";              // Video

//        String url = "/media/audio.wav";              // Audio
//        isVideo = !isVideo;

        // ----------------
        Media media = new Media(Objects.requireNonNull(this.getClass().getResource(url)).toString());

        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(this.sliderVolume().getValue() / 100.);      // set initial volume

        if(isVideo) this.mediaView().setMediaPlayer(mediaPlayer);

        // ----------------

        // 1. When READY state, configure an auto-runnable object.
        mediaPlayer.setOnReady(new Runnable() {

            @Override
            public void run() {
                log.trace("READY::run() invoked.");

                // ----------------
                sliderVolume().setValue(50.);   // Set initial volume when ready
                mediaPlayer.setVolume(sliderVolume().getValue() / 100.);

                // ----------------
                mediaPlayer.currentTimeProperty()
                    .addListener((observableValue, oldValue, newValue) -> {
//                        log.trace("currentTime::changed(_, {}, {}) invoked.", oldValue, newValue);

//                        double currentTime = mediaPlayer.getCurrentTime().toSeconds();    // (1) : OK
                        double currentTime = newValue.toSeconds();                        // (2) : OK
                        double totalTime = mediaPlayer.getTotalDuration().toSeconds();
                        double progress = currentTime / totalTime;

                        progressBar().setProgress(progress);
                        progressIndicator().setProgress(progress);

                        labelTime().setText((int) currentTime + " / " + (int) totalTime + " sec");
                    }); // .addListener

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

        // 2. When PLAYING state, configure an auto-runnable object.
        mediaPlayer.setOnPlaying(() -> {
            log.trace("PLAYING::run() invoked.");

            // ----------------
            this.playBtn().setDisable(true);
            this.pauseBtn().setDisable(false);
            this.stopBtn().setDisable(false);
        }); // .setOnPlaying

        // 3. When PAUSE state, configure an auto-runnable object.
        mediaPlayer.setOnPaused(() -> {
            log.trace("PAUSE::run() invoked.");

            // ----------------
            this.playBtn().setDisable(false);
            this.pauseBtn().setDisable(true);
            this.stopBtn().setDisable(false);
        }); // .setOnPaused

        // 4. When EndOfMedia State, configure an auto-runnable object.
        mediaPlayer.setOnEndOfMedia(() -> {
            log.trace("EndOfMedia::run() invoked.");

            // ----------------
            this.progressBar().setProgress(1.0);
            this.progressIndicator().setProgress(1.0);

            this.endOfMedia(true);

            // ----------------
            this.playBtn().setDisable(false);
            this.pauseBtn().setDisable(true);
            this.stopBtn().setDisable(true);
        }); // .setOnEndOfMedia

        // 5. When STOPPED state, configure an auto-runnable object.
        mediaPlayer.setOnStopped(() -> {
            log.trace("STOPPED::run() invoked.");

            // ----------------
            this.playBtn().setDisable(false);
            this.pauseBtn().setDisable(true);
            this.stopBtn().setDisable(true);
        }); // .setOnStopped

        // 6. When STALLED state, configure an auto-runnable object.
        mediaPlayer.setOnStalled(() -> {
            log.trace("STALLED::run() invoked.");

            // ----------------
            this.playBtn().setDisable(true);
            this.pauseBtn().setDisable(true);
            this.stopBtn().setDisable(false);
        }); // .setOnStalled

        // ----------------
        this.sliderVolume().valueProperty()
            .addListener((observable, oldValue, newValue) -> {
                log.trace("value::changed(_, {}, {}) invoked.", oldValue, newValue);

                mediaPlayer.setVolume(newValue.doubleValue() / 100. );            // (1) : OK
//                mediaPlayer.setVolume(this.sliderVolume().getValue() / 100.);     // (2) : OK
            }); // .addListener

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


