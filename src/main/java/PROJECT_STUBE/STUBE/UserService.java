package PROJECT_STUBE.STUBE;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public void createUser(User newUser) {
        users.add(newUser);
    }

    public List<User> showAllUser(){
        return users;
    }

    public void deleteAll(){
        users.clear();
    }

    public User getUser(long uuid) throws Exception{
        for (User currentUser: users) {
            if (currentUser.getUuid() == uuid){
                users.remove(currentUser);
            }
        }
        throw new Exception("We don't have a user with that uuid. ");
    }

    public void deleteUser(long uuid) throws Exception {
        for (User currentUser : users) {
            if (currentUser.getUuid() == uuid){
                users.remove(currentUser);
            }
        }
        throw new Exception("We don't have a user with that uuid. ");
    }
    public User setUser(long uuid, User userMod) throws Exception {
        for (User currentUser: users) {
            if (currentUser.getUuid() == uuid) {
                currentUser.setUserName(userMod.getUserName());
                currentUser.getPassword(userMod.getPassword(userMod.getPassword()));
            }
        }
        throw new Exception("We don't have a user with that uuid. ");
    }

    public void addVideo(long uuid, Video newVideo) throws Exception {
        User currentUser = getUser(uuid);
         currentUser.getVideos(newVideo);
    }

    public List<Video> getVideos(long uuid, Video newVideo) throws Exception {
        User currentUser = getUser(uuid);
        return currentUser.getVideos(newVideo);
    }

    public void addRating(String uuid, String id, Ratings rating) {


    }
}


