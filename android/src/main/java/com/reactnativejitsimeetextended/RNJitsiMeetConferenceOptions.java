package com.reactnativejitsimeetextended;

/*
 * Copyright @ 2019-present 8x8, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;


import java.net.URL;


/**
 * This class represents the options when joining a Jitsi Meet conference. The user can create an
 * instance by using {@link RNJitsiMeetConferenceOptions.Builder} and setting the desired options
 * there.
 *
 * The resulting {@link RNJitsiMeetConferenceOptions} object is immutable and represents how the
 * conference will be joined.
 */
public class RNJitsiMeetConferenceOptions implements Parcelable {
  /**
   * Server where the conference should take place.
   */
  private URL serverURL;
  /**
   * Room name.
   */
  private String room;
  /**
   * Conference subject.
   */
  private String subject;
  /**
   * JWT token used for authentication.
   */
  private String token;

  /**
   * Feature flags. See: https://github.com/jitsi/jitsi-meet/blob/master/react/features/base/flags/constants.js
   */
  private Bundle featureFlags;

  /**
   * Set to {@code true} to join the conference with audio / video muted or to start in audio
   * only mode respectively.
   */
  private Boolean audioMuted;
  private Boolean audioOnly;
  private Boolean videoMuted;

  /**
   * USer information, to be used when no token is specified.
   */
  private RNJitsiMeetUserInfo userInfo;

  public URL getServerURL() {
    return serverURL;
  }

  public String getRoom() {
    return room;
  }

  public String getSubject() {
    return subject;
  }

  public String getToken() {
    return token;
  }

  public Bundle getFeatureFlags() {
    return featureFlags;
  }

  public boolean getAudioMuted() {
    return audioMuted;
  }

  public boolean getAudioOnly() {
    return audioOnly;
  }

  public boolean getVideoMuted() {
    return videoMuted;
  }

  public RNJitsiMeetUserInfo getUserInfo() {
    return userInfo;
  }

  /**
   * Class used to build the immutable {@link RNJitsiMeetConferenceOptions} object.
   */
  public static class Builder {
    private URL serverURL;
    private String room;
    private String subject;
    private String token;

    private Bundle featureFlags;

    private Boolean audioMuted;
    private Boolean audioOnly;
    private Boolean videoMuted;

    private RNJitsiMeetUserInfo userInfo;

    public Builder() {
      featureFlags = new Bundle();
    }

    /**\
     * Sets the server URL.
     * @param url - {@link URL} of the server where the conference should take place.
     * @return - The {@link Builder} object itself so the method calls can be chained.
     */
    public Builder setServerURL(URL url) {
      this.serverURL = url;

      return this;
    }

    /**
     * Sets the room where the conference will take place.
     * @param room - Name of the room.
     * @return - The {@link Builder} object itself so the method calls can be chained.
     */
    public Builder setRoom(String room) {
      this.room = room;

      return this;
    }

    /**
     * Sets the conference subject.
     * @param subject - Subject for the conference.
     * @return - The {@link Builder} object itself so the method calls can be chained.
     */
    public Builder setSubject(String subject) {
      this.subject = subject;

      return this;
    }

    /**
     * Sets the JWT token to be used for authentication when joining a conference.
     * @param token - The JWT token to be used for authentication.
     * @return - The {@link Builder} object itself so the method calls can be chained.
     */
    public Builder setToken(String token) {
      this.token = token;

      return this;
    }

    /**
     * Indicates the conference will be joined with the microphone muted.
     * @param muted - Muted indication.
     * @return - The {@link Builder} object itself so the method calls can be chained.
     */
    public Builder setAudioMuted(boolean muted) {
      this.audioMuted = muted;

      return this;
    }

    /**
     * Indicates the conference will be joined in audio-only mode. In this mode no video is
     * sent or received.
     * @param audioOnly - Audio-mode indicator.
     * @return - The {@link Builder} object itself so the method calls can be chained.
     */
    public Builder setAudioOnly(boolean audioOnly) {
      this.audioOnly = audioOnly;

      return this;
    }
    /**
     * Indicates the conference will be joined with the camera muted.
     * @param videoMuted - Muted indication.
     * @return - The {@link Builder} object itself so the method calls can be chained.
     */
    public Builder setVideoMuted(boolean videoMuted) {
      this.videoMuted = videoMuted;

      return this;
    }

    public Builder setFeatureFlag(String flag, boolean value) {
      this.featureFlags.putBoolean(flag, value);

      return this;
    }

    public Builder setFeatureFlag(String flag, String value) {
      this.featureFlags.putString(flag, value);

      return this;
    }

    public Builder setFeatureFlag(String flag, int value) {
      this.featureFlags.putInt(flag, value);

      return this;
    }

    public Builder setUserInfo(RNJitsiMeetUserInfo userInfo) {
      this.userInfo = userInfo;

      return this;
    }

    /**
     * Builds the immutable {@link RNJitsiMeetConferenceOptions} object with the configuration
     * that this {@link Builder} instance specified.
     * @return - The built {@link RNJitsiMeetConferenceOptions} object.
     */
    public RNJitsiMeetConferenceOptions build() {
      RNJitsiMeetConferenceOptions options = new RNJitsiMeetConferenceOptions();

      options.serverURL = this.serverURL;
      options.room = this.room;
      options.subject = this.subject;
      options.token = this.token;
      options.featureFlags = this.featureFlags;
      options.audioMuted = this.audioMuted;
      options.audioOnly = this.audioOnly;
      options.videoMuted = this.videoMuted;
      options.userInfo = this.userInfo;

      return options;
    }
  }

  private RNJitsiMeetConferenceOptions() {
  }

  private RNJitsiMeetConferenceOptions(Parcel in) {
    serverURL = (URL) in.readSerializable();
    room = in.readString();
    subject = in.readString();
    token = in.readString();
    featureFlags = in.readBundle();
    userInfo = new RNJitsiMeetUserInfo(in.readBundle());
    byte tmpAudioMuted = in.readByte();
    audioMuted = tmpAudioMuted == 0 ? null : tmpAudioMuted == 1;
    byte tmpAudioOnly = in.readByte();
    audioOnly = tmpAudioOnly == 0 ? null : tmpAudioOnly == 1;
    byte tmpVideoMuted = in.readByte();
    videoMuted = tmpVideoMuted == 0 ? null : tmpVideoMuted == 1;
  }

  Bundle asProps() {
    Bundle props = new Bundle();

    // Android always has the PiP flag set by default.
    if (!featureFlags.containsKey("pip.enabled")) {
      featureFlags.putBoolean("pip.enabled", true);
    }

    props.putBundle("flags", featureFlags);

    Bundle config = new Bundle();

    if (audioMuted != null) {
      config.putBoolean("startWithAudioMuted", audioMuted);
    }
    if (audioOnly != null) {
      config.putBoolean("startAudioOnly", audioOnly);
    }
    if (videoMuted != null) {
      config.putBoolean("startWithVideoMuted", videoMuted);
    }
    if (subject != null) {
      config.putString("subject", subject);
    }

    Bundle urlProps = new Bundle();

    // The room is fully qualified
    if (room != null && room.contains("://")) {
      urlProps.putString("url", room);
    } else {
      if (serverURL != null) {
        urlProps.putString("serverURL", serverURL.toString());
      }
      if (room != null) {
        urlProps.putString("room", room);
      }
    }

    if (token != null) {
      urlProps.putString("jwt", token);
    }

    if (userInfo != null) {
      props.putBundle("userInfo", userInfo.asBundle());
    }

    urlProps.putBundle("config", config);
    props.putBundle("url", urlProps);

    return props;
  }

  // Parcelable interface
  //

  public static final Creator<RNJitsiMeetConferenceOptions> CREATOR = new Creator<RNJitsiMeetConferenceOptions>() {
    @Override
    public RNJitsiMeetConferenceOptions createFromParcel(Parcel in) {
      return new RNJitsiMeetConferenceOptions(in);
    }

    @Override
    public RNJitsiMeetConferenceOptions[] newArray(int size) {
      return new RNJitsiMeetConferenceOptions[size];
    }
  };

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeSerializable(serverURL);
    dest.writeString(room);
    dest.writeString(subject);
    dest.writeString(token);
    dest.writeBundle(featureFlags);
    dest.writeBundle(userInfo != null ? userInfo.asBundle() : new Bundle());
    dest.writeByte((byte) (audioMuted == null ? 0 : audioMuted ? 1 : 2));
    dest.writeByte((byte) (audioOnly == null ? 0 : audioOnly ? 1 : 2));
    dest.writeByte((byte) (videoMuted == null ? 0 : videoMuted ? 1 : 2));
  }

  @Override
  public int describeContents() {
    return 0;
  }
}
