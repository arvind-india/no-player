package com.novoda.noplayer.exoplayer;

import android.content.Context;
import android.net.Uri;

import com.novoda.noplayer.ContentType;
import com.novoda.noplayer.Forwarder;
import com.novoda.noplayer.Heart;
import com.novoda.noplayer.Player;
import com.novoda.noplayer.PlayerAudioTrack;
import com.novoda.noplayer.PlayerListenersHolder;
import com.novoda.noplayer.PlayerView;
import com.novoda.noplayer.Timeout;
import com.novoda.noplayer.VideoContainer;
import com.novoda.noplayer.VideoDuration;
import com.novoda.noplayer.VideoPosition;
import com.novoda.noplayer.player.PlayerInformation;

import java.util.Collections;
import java.util.List;

public class ExoPlayerTwoImpl extends PlayerListenersHolder implements Player {

    private final ExoPlayerTwoFacade facade;
    private final Heart heart;
    private VideoContainer videoContainer = VideoContainer.empty();

    public static ExoPlayerTwoImpl newInstance(Context context) {
        Forwarder forwarder = new Forwarder();
        ExoPlayerTwoFacade facade = ExoPlayerTwoFacade.newInstance(context);
        ExoPlayerBinder exoPlayerBinder = new ExoPlayerBinder(facade);

        ExoPlayerTwoImpl exoPlayerTwo = new ExoPlayerTwoImpl(facade);
        forwarder.bind(exoPlayerBinder, exoPlayerTwo, exoPlayerTwo);
        return exoPlayerTwo;
    }

    private ExoPlayerTwoImpl(ExoPlayerTwoFacade facade) {
        this.facade = facade;
        Heart.Heartbeat<Player> onHeartbeat = new Heart.Heartbeat<>(getHeartbeatCallbacks(), this);
        heart = Heart.newInstance(onHeartbeat);
    }

    @Override
    public boolean isPlaying() {
        return facade.getPlayWhenReady();
    }

    @Override
    public int getVideoWidth() {
        return facade.getVideoWidth();
    }

    @Override
    public int getVideoHeight() {
        return facade.getVideoHeight();
    }

    @Override
    public VideoPosition getPlayheadPosition() {
        return VideoPosition.fromMillis(facade.getPlayheadPosition());
    }

    @Override
    public VideoDuration getMediaDuration() {
        return VideoDuration.fromMillis(facade.getMediaDuration());
    }

    @Override
    public int getBufferPercentage() {
        return facade.getBufferedPercentage();
    }

    @Override
    public void play() {
        showContainer();
        heart.startBeatingHeart();
        facade.play();
        getStateChangedListeners().onVideoPlaying();
    }

    @Override
    public void play(VideoPosition position) {
        seekTo(position);
        play();
    }

    @Override
    public void pause() {
        facade.pause();
        getStateChangedListeners().onVideoPaused();
        if (heart.isBeating()) {
            heart.stopBeatingHeart();
            heart.forceBeat();
        }
    }

    @Override
    public void seekTo(VideoPosition position) {
        facade.seekTo(position.inMillis());
    }

    @Override
    public void reset() {
        // TODO: Reset the player, so that it can be used by another video source.
    }

    @Override
    public void stop() {
        facade.stop();
    }

    @Override
    public void release() {
        getPlayerReleaseListener().onPlayerPreRelease(this);
        getStateChangedListeners().onVideoReleased();
        heart.stopBeatingHeart();
        facade.release();
        videoContainer.hide();
    }

    @Override
    public void loadVideo(Uri uri, ContentType contentType) {
        getPreparedListeners().reset();
        showContainer();
        facade.prepare(uri, contentType);
    }

    @Override
    public void loadVideoWithTimeout(Uri uri, ContentType contentType, Timeout timeout, LoadTimeoutCallback loadTimeoutCallback) {
        loadVideo(uri, contentType);
    }

    @Override
    public PlayerInformation getPlayerInformation() {
        return new ExoPlayerInformation();
    }

    @Override
    public void attach(PlayerView playerView) {
        videoContainer = VideoContainer.with(playerView.getContainerView());
        facade.setPlayer(playerView.simplePlayerView());
        // TODO : Set SubtitleView on the facade.
    }

    @Override
    public void selectAudioTrack(int audioTrackIndex) {
        //TODO: Select the audio track on the facade.
    }

    @Override
    public List<PlayerAudioTrack> getAudioTracks() {
        //TODO : Get a list of audio tracks from the facade.
        return Collections.emptyList();
    }

    private void showContainer() {
        videoContainer.show();
    }

}
