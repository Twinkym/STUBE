package PROJECT_STUBE.STUBE;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class User {

    private long uuid = UUID.randomUUID().getMostSignificantBits();
    private String userName;
    private String email;
    private String password;
    private List<Video> videos = new ArrayList<>();

    public User(){

    }

    public User(String userName, String email, String password) throws Exception{
        checkPass(password);
        checkEmail(email);
        this.password = password;
        this.email = email;
        this.userName = userName;
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

   public String getUserName(){
        return userName;
   }

   public String getPassword(String password){
        return this.password;
   }

    public long getUuid() {
        return uuid;
    }

    public List<Video> getVideos(Video newVideo){
        return videos;
   }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public String getPassword() {
        return password;
    }
}
