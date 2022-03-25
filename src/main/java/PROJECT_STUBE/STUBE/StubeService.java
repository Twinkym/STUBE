package PROJECT_STUBE.STUBE;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StubeService {
    private UserRepository userRepository;
    private VideoRepository videoRepository;
    private RateRepository rateRepository;

    public StubeService(UserRepository userRepository, VideoRepository videoRepository, RateRepository rateRepository) {
        this.userRepository = userRepository;
        this.videoRepository = videoRepository;
        this.rateRepository = rateRepository;
    }
    private List<User> userList = new ArrayList<>();

    public User createUser(User user) {
        this.userRepository.save(user);
        return user;
    }

    public Video addVideo(String id, Video video) throws Exception {
        User user = searchUser(id);
        video = user.addVideo(video);
        videoRepository.save(video);
        return video;
    }

    public List<Video> getUserVideos(String id) throws Exception {
        User user = searchUser(id);
        return user.getVideoList();
    }

    public Video getVideo(String id, String videoId) throws Exception{
        return  videoRepository.findById(videoId).get();
    }

    public void deleteUserVideos(String id) throws Exception {
        User user = searchUser(id);
        videoRepository.deleteAllByUser(user);
    }

    public User updateUser(String id, User data) throws Exception{
        User user = searchUser(id);
        user.setName(data.getName());
        user.setEmail(data.getEmail());
        user.setPassword(data.getPassword());
        userRepository.save(user);
        return user;
    }

    public void addRating(String id, String videoId, Ratings rating) throws Exception {
        Video video = getVideo(id, videoId);
        video.addRating(rating);
        rateRepository.save(rating);

    }

    public List<User> showAllUser(){
        return userList;
    }

    public void deleteAll(){
        userList.clear();
    }

    public User searchUser(String id) throws Exception{
       return userRepository.findById(id).get();
    }

    public void deleteUser(String id) throws Exception {
        for (User currentUser : userList) {
            if (currentUser.getId() == id){
                userList.remove(currentUser);
            }
        }
        throw new Exception("We don't have a user with that id. ");
    }
    public User setUser(String id, User userMod) throws Exception {
        for (User currentUser: userList) {
            if (currentUser.getId() == id) {
                currentUser.setName(userMod.getName());
                currentUser.getPassword(userMod.getPassword(userMod.getPassword()));
            }
        }
        throw new Exception("We don't have a user with that id. ");
    }

}


