package PROJECT_STUBE.STUBE;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity(name="users")
public class User {

    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String email;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Video> videoList = new ArrayList<>();

    public User(){

    }

    public User(String name, String email, String password) throws Exception{
        checkPass(password);
        checkEmail(email);
        checkName(name);
        this.password = password;
        this.email = email;
        this.name = name;
    }

    private void checkName(String name) throws Exception {
        if (!name.trim().matches("^[A-Za-z0-9]{5,20}$"))throw new Exception("The user name must have between 5 & 20 characters & must be made up of alphanumeric characters. ");
    }

    private void checkEmail(String email) throws Exception {
        Matcher match = validEmailRegex().matcher(email);
        if (!match.find()) throw new Exception("The email doesn't match with the parameters of email. ");
    }

    private Pattern validEmailRegex() {
        return Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
    }

    private void checkPass(String password) throws Exception {
        if (checkPattern(password)) throw new Exception("The pattern of the password must be a number and be a length of 7 or more");

    }

    private boolean checkPattern(String password) {
        return (password.length() < 7 || !password.matches(".*\\d.*"));
    }

   public String getName(){
        return name;
   }

   public String getPassword(String password){
        return this.password;
   }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Video> getVideoList(){
        return videoList;
   }

    public Video addVideo(Video video) {
        video.setUser(this);
        this.videoList.add(video);
        return video;
    }

    public void deleteVideoList() {
        this.videoList.clear();
    }

    public Video searchVideo(String videoId) throws Exception {
        for (Video currentVideo : videoList) {
            if (currentVideo.getId().equals(videoId)){
                return currentVideo;
            }
        }
        throw new Exception("Video not found. ");
    }

    public void setName(String name) throws Exception {
        checkName(name);
        this.name = name;
    }

    public void setPassword(String password) throws Exception {
        checkPass(password);
        this.password = password;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    public String getPassword() {
        return password;
    }


}
