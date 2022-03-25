package PROJECT_STUBE.STUBE;

import org.hibernate.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity(name = "videos")
public class Video {

    @Id
    private String id = UUID.randomUUID().toString();
    private String urlVideo;
    private String title;
    private String description;

    @OneToMany(mappedBy = "video")
    private List<Ratings> ratingsList = new ArrayList<>();
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CACADE)
    @JoinColumn(name = "user_id")
    private User user;

    public Video() {
    }

    public Video(String urlVideo, String title, String description, User user) throws Exception {
        checkUrlVideo(urlVideo);
        checkTitle(title);
        checkDescription(description);
        this.urlVideo = urlVideo;
        this.title = title;
        this.description = description;
        this.user = user;


    }

    private void checkTitle(String title) throws Exception {
        if (title.trim().equals("")) throw new Exception("The title can't be empty. ");
        if (title.length() < 10){
            throw new Exception("The title must be a length of 10 or more. ");
        }
    }

    private void checkUrlVideo(String urlVideo) throws Exception {
        String initUrl = urlVideo.substring(0, 3);
        if (!checkPattern(initUrl)){
            throw new Exception("The pattern of url doesn't match must initialize by (www.) ");
        }
    }

    private boolean checkPattern(String initUrl) {
        return initUrl.equals("www.");
    }

    private void checkDescription(String description) throws Exception {
        if (description.trim().equals("")) throw new Exception("The description can't be empty. ");
    }

    public void addRating(Ratings rating){
        rating.setVideo(this);
        this.ratingsList.add(rating);

    }
    public String getUrlVideo() {
        return urlVideo;
    }

    public String getTitle() {
        return title;
    }

    public void setUrlVideo(String urlVideo) throws Exception {
        checkUrlVideo(urlVideo);
        this.urlVideo = urlVideo;
    }

    public void setTitle(String title) throws Exception {
        checkTitle(title);
        this.title = title;
    }

    public void setDescription(String description) throws Exception {
        checkDescription(description);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setUser(User user) {
        this.user=user;
    }

    public Object getId() {
        return id;
    }
}
