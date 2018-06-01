package com.novoda.noplayer;

import android.support.annotation.Nullable;
import android.view.SurfaceView;
import android.view.TextureView;

public class PlayerSurfaceHolder {

    @Nullable
    private final SurfaceView surfaceView;
    @Nullable
    private final TextureView textureView;
    private final PlayerViewSurfaceHolder surfaceHolder;

    public static PlayerSurfaceHolder create(SurfaceView surfaceView) {
        PlayerViewSurfaceHolder surfaceHolder = new PlayerViewSurfaceHolder();
        surfaceView.getHolder().addCallback(surfaceHolder);
        return new PlayerSurfaceHolder(surfaceView, null, surfaceHolder);
    }

    public static PlayerSurfaceHolder create(TextureView textureView) {
        PlayerViewSurfaceHolder surfaceHolder = new PlayerViewSurfaceHolder();
        textureView.setSurfaceTextureListener(surfaceHolder);
        return new PlayerSurfaceHolder(null, textureView, new PlayerViewSurfaceHolder());
    }

    PlayerSurfaceHolder(@Nullable SurfaceView surfaceView, @Nullable TextureView textureView, PlayerViewSurfaceHolder surfaceHolder) {
        this.surfaceView = surfaceView;
        this.textureView = textureView;
        this.surfaceHolder = surfaceHolder;
    }

    public boolean containsSurfaceView() {
        return surfaceView != null;
    }

    public SurfaceView getSurfaceView() {
        if (surfaceView == null) {
            throw new IllegalStateException("No SurfaceView available");
        }
        return surfaceView;
    }

    public boolean containsTextureView() {
        return textureView != null;
    }

    public TextureView getTextureView() {
        if (textureView == null) {
            throw new IllegalStateException("No TextureView available");
        }
        return textureView;
    }

    public SurfaceRequester getSurfaceRequester() {
        return surfaceHolder;
    }
}
