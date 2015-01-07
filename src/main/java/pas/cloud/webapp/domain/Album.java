package pas.cloud.webapp.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Album
{
    @Id
    @Column(length=40)
    @GeneratedValue(generator="randomId")
    @GenericGenerator(name="randomId", strategy="pas.cloud.webapp.domain.RandomIdGenerator")
    private String id;

    private String title;
    private String artist;
    private String releaseYear;

    public Album() {
    }

    public Album(String title, String artist, String releaseYear) {
        this.title = title;
        this.artist = artist;
        this.releaseYear = releaseYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                '}';
    }
}
