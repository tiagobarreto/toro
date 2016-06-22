/*
 * Copyright 2016 eneim@Eneim Labs, nam@ene.im
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.ene.lab.toro.ext.layeredvideo;

import android.net.Uri;
import com.google.android.exoplayer.util.Util;
import im.ene.lab.toro.media.Media;

/**
 * Represents a video that can be played by ExoPlayer.
 */
public class Video extends Media {

  /**
   * A list of available video formats which ExoPlayer can play.
   */
  public enum Type {
    /**
     * See {@link Util#TYPE_DASH}
     */
    DASH,
    /**
     * See {@link Util#TYPE_SS}
     */
    SS,
    /**
     * See {@link Util#TYPE_HLS}
     */
    HLS,
    /**
     * See {@link Util#TYPE_OTHER}
     */
    OTHER
  }

  /**
   * The video format of the video.
   */
  private final Type videoType;

  /**
   * ID of content (for DASH).
   */
  private final String contentId;

  /**
   * Provider (for DASH).
   */
  private final String provider;

  public Video(Uri mediaUri) {
    this(mediaUri, PlayerUtil.inferVideoType(mediaUri), null, null);
  }

  /**
   * @param uri The URL pointing to the video.
   * @param videoType The video format of the video.
   */
  public Video(Uri uri, Type videoType) {
    this(uri, videoType, null);
  }

  /**
   * @param uri The URL pointing to the video.
   * @param videoType The video format of the video.
   * @param contentId ID of content (for DASH).
   */
  public Video(Uri uri, Type videoType, String contentId) {
    this(uri, videoType, contentId, null);
  }

  public Video(Uri uri, Type videoType, String contentId, String provider) {
    super(uri);
    this.videoType = videoType;
    this.contentId = contentId;
    this.provider = provider;
  }

  /**
   * Returns ID of content (for DASH).
   */
  public String getContentId() {
    return contentId;
  }

  /**
   * Returns the video format of the video.
   */
  public Type getVideoType() {
    return videoType;
  }

  public String getProvider() {
    return provider;
  }
}
