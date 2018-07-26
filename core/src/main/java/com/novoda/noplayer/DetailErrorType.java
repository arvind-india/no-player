package com.novoda.noplayer;

/**
 * Assume all errors are thrown by Exo Player, MEDIA_PLAYER prefix will
 * indicate that the error is thrown by Meda Player.
 */
public enum DetailErrorType {

    // SOURCE,
    SOURCE_LIVE_STALE_MANIFEST_AND_NEW_MANIFEST_COULD_NOT_LOAD_ERROR,
    SOURCE_PARSING_MEDIA_DATA_OR_METADATA_ERROR,

    SOURCE_AD_LOAD_ERROR_THEN_WILL_SKIP,
    SOURCE_AD_GROUP_LOAD_ERROR_THEN_WILL_SKIP,
    SOURCE_ALL_ADS_LOAD_ERROR_THEN_WILL_SKIP,
    SOURCE_ADS_LOAD_UNEXPECTED_ERROR_THEN_WILL_SKIP,

    SOURCE_CLIPPING_MEDIA_SOURCE_CANNOT_CLIP_WRAPPED_SOURCE_INVALID_PERIOD_COUNT,
    SOURCE_CLIPPING_MEDIA_SOURCE_CANNOT_CLIP_WRAPPED_SOURCE_NOT_SEEKABLE_TO_START,
    SOURCE_CLIPPING_MEDIA_SOURCE_CANNOT_CLIP_WRAPPED_SOURCE_START_EXCEEDS_END,
    SOURCE_CLIPPING_MEDIA_SOURCE_CANNOT_CLIP_WRAPPED_SOURCE_UNKNOWN_ERROR,
    SOURCE_DATA_POSITION_OUT_OF_RANGE_ERROR,

    SOURCE_SAMPLE_QUEUE_MAPPING_ERROR,
    SOURCE_READING_LOCAL_FILE_ERROR,
    SOURCE_UNEXPECTED_LOADING_ERROR,
    SOURCE_DOWNLOAD_ERROR,
    SOURCE_MERGING_MEDIA_SOURCE_CANNOT_MERGE_ITS_SOURCES,
    SOURCE_TASK_CANNOT_PROCEED_PRIORITY_TOO_LOW,
    SOURCE_CACHE_WRITING_DATA_ERROR,
    SOURCE_READ_LOCAL_ASSET_ERROR,

    SOURCE_MEDIA_PLAYER_IO,
    MEDIA_PLAYER_MALFORMED,
    MEDIA_PLAYER_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK,
    MEDIA_PLAYER_INFO_NOT_SEEKABLE,
    MEDIA_PLAYER_SUBTITLE_TIMED_OUT,
    MEDIA_PLAYER_UNSUPPORTED_SUBTITLE,

    // CONNECTIVITY
    SOURCE_HTTP_CANNOT_OPEN_ERROR,
    SOURCE_HTTP_CANNOT_READ_ERROR,
    SOURCE_HTTP_CANNOT_CLOSE_ERROR,
    SOURCE_READ_CONTENT_URI_ERROR,
    SOURCE_READ_FROM_UDP_ERROR,
    SOURCE_HLS_PLAYLIST_STUCK_SERVER_SIDE_ERROR,
    SOURCE_HLS_PLAYLIST_SERVER_HAS_RESET,
    MEDIA_PLAYER_TIMED_OUT,

    // DRM
    RENDERER_UNSUPPORTED_DRM_SCHEME_ERROR,
    RENDERER_DRM_INSTANTIATION_ERROR,
    RENDERER_DRM_UNKNOWN_ERROR,
    RENDERER_CANNOT_ACQUIRE_DRM_SESSION_MISSING_SCHEME_FOR_REQUIRED_UUID_ERROR,
    RENDERER_DRM_SESSION_ERROR,
    RENDERER_DRM_KEYS_EXPIRED_ERROR,
    RENDERER_MEDIA_REQUIRES_DRM_SESSION_MANAGER_ERROR,
    MEDIA_PLAYER_SERVER_DIED,
    MEDIA_PLAYER_PREPARE_DRM_STATUS_PREPARATION_ERROR,
    MEDIA_PLAYER_PREPARE_DRM_STATUS_PROVISIONING_NETWORK_ERROR,
    MEDIA_PLAYER_PREPARE_DRM_STATUS_PROVISIONING_SERVER_ERROR,

    // CONTENT_DECRYPTION
    RENDERER_FAIL_DECRYPT_DATA_DUE_NON_PLATFORM_COMPONENT_ERROR,
    RENDERER_CRYPTO_INSUFFICIENT_OUTPUT_PROTECTION_ERROR,
    RENDERER_CRYPTO_KEY_EXPIRED_ERROR,
    RENDERER_CRYPTO_KEY_NOT_FOUND_WHEN_DECRYPTION_ERROR,
    RENDERER_CRYPTO_RESOURCE_BUSY_ERROR_THEN_SHOULD_RETRY,
    RENDERER_CRYPTO_DECRYPTION_ATTEMPTED_ON_CLOSED_SEDDION_ERROR,
    RENDERER_CRYPTO_LICENSE_POLICY_REQUIRED_NOT_SUPPORTED_BY_DEVICE_ERROR,

    // RENDERER_DECODER
    RENDERER_AUDIO_SINK_CONFIGURATION_ERROR,
    RENDERER_AUDIO_SINK_INITIALISATION_ERROR,
    RENDERER_AUDIO_SINK_WRITE_ERROR,
    RENDERER_AUDIO_UNHANDLED_FORMAT_ERROR,
    RENDERER_AUDIO_DECODER_ERROR,
    RENDERER_DECODER_INITIALISATION_ERROR,
    RENDERER_DECODING_METADATA_ERROR,
    RENDERER_DECODING_SUBTITLE_ERROR,
    MEDIA_PLAYER_INFO_AUDIO_NOT_PLAYING,
    MEDIA_PLAYER_BAD_INTERLEAVING,
    MEDIA_PLAYER_INFO_VIDEO_NOT_PLAYING,
    MEDIA_PLAYER_INFO_VIDEO_TRACK_LAGGING,

    // UNEXPECTED
    UNEXPECTED_EGL_OPERATION_ERROR,
    UNEXPECTED_SPURIOUS_AUDIO_TRACK_TIMESTAMP_ERROR,
    UNEXPECTED_MULTIPLE_RENDERER_MEDIA_CLOCK_ENABLED_ERROR,

    UNKNOWN,
    MEDIA_PLAYER_UNKNOWN
}
