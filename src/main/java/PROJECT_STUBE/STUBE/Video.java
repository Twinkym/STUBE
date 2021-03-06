package PROJECT_STUBE.STUBE;

import java.util.ArrayList;
import java.util.List;

public class Video {
    private String urlVideo;
    private String title;
    private String description;
    private List<Ratings> rating = new ArrayList<>();

    public Video() {
    }

    public Video(String urlVideo, String title, String description, List<Ratings> rating) throws Exception {
        checkUrlVideo(urlVideo);
        checkTitle(title);
        this.urlVideo = urlVideo;
        this.title = title;
        this.description = description;
        this.rating = rating;


    }

    private void checkTitle(String title) throws Exception {
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

    public void addRating(Ratings rating){
        this.rating.add(rating);

    }
    public String getUrlVideo() {
        return urlVideo;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<Ratings> getRating() {
        return rating;
    }
}
