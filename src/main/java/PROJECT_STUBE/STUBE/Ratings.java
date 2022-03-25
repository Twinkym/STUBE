package PROJECT_STUBE.STUBE;

import java.util.UUID;

public class Ratings {
    private int rating;
    private String comment;
    private String id = UUID.randomUUID().toString();

    public Ratings(int rating, String comment) throws Exception{
        checkRate(rating);
        checkComment(comment);
        this.rating = rating;
        this.comment = comment;
    }

    private void checkRate(int rating) throws Exception {
        if (rating < 1 || rating > 5) throw new Exception("The raiting must be between 1 & 5. ");
    }

    private void checkComment(String comment) throws Exception {
        if (comment.trim().equals("")) throw new Exception("The comment area couldn't be empty. ");
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String getId() {
        return id;
    }
}
