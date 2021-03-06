package uk.jumpingmouse.spotify.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A parcelable artist.
 * @author Edmund Johnson
 */
public class AppTrack implements Parcelable {

    private final String id;
    private final String trackName;
    private final String albumName;
    private final String imageUrlSmall;
    private final String imageUrlLarge;
    private final String previewUrl;
    private final long previewDuration;
    private final long duration;
    private final String artistName;

    /**
     * Public constructor which initialises the artist.
     * @param id the Spotify id for the track
     * @param trackName the name of the track
     * @param albumName the name of the album from which the track was taken
     * @param imageUrlSmall the URL of a small image for the track
     * @param imageUrlLarge the URL of a large image for the track
     * @param previewUrl the preview URL for streaming the track
     * @param duration the track duration in milliseconds
     * @param artistName the name of the artist
     */
    public AppTrack(String id, String trackName, String albumName,
                    String imageUrlSmall, String imageUrlLarge, String previewUrl,
                    long duration, long previewDuration, String artistName) {
        this.id = id;
        this.trackName = trackName;
        this.albumName = albumName;
        this.imageUrlSmall = imageUrlSmall;
        this.imageUrlLarge = imageUrlLarge;
        this.previewUrl = previewUrl;
        this.duration = duration;
        this.previewDuration = previewDuration;
        this.artistName = artistName;
    }

    /**
     * Constructor which creates the artist from a parcel.
     * @param parcel the parcel
     */
    private AppTrack(Parcel parcel) {
        this.id = parcel.readString();
        this.trackName = parcel.readString();
        this.albumName = parcel.readString();
        this.imageUrlSmall = parcel.readString();
        this.imageUrlLarge = parcel.readString();
        this.previewUrl = parcel.readString();
        this.duration = parcel.readLong();
        this.previewDuration = parcel.readLong();
        this.artistName = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(getId());
        parcel.writeString(getTrackName());
        parcel.writeString(getAlbumName());
        parcel.writeString(getImageUrlSmall());
        parcel.writeString(getImageUrlLarge());
        parcel.writeString(getPreviewUrl());
        parcel.writeLong(getDuration());
        parcel.writeLong(getPreviewDuration());
        parcel.writeString(getArtistName());
    }

    public static final Creator<AppTrack> CREATOR
            = new Creator<AppTrack>() {
        public AppTrack createFromParcel(Parcel in) {
            return new AppTrack(in);
        }

        public AppTrack[] newArray(int size) {
            return new AppTrack[size];
        }
    };

    // Getters and setters

    private String getId() {
        return id;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getImageUrlSmall() {
        return imageUrlSmall;
    }

    public String getImageUrlLarge() {
        return imageUrlLarge;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    private long getDuration() {
        return duration;
    }

    public long getPreviewDuration() {
        return previewDuration;
    }

    public String getArtistName() {
        return artistName;
    }
}
