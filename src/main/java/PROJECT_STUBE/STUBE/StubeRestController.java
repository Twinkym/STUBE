package PROJECT_STUBE.STUBE;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StubeRestController {

    private StubeService stubeService;
    @Autowired
    public StubeRestController(StubeService stubeService) {
        this.stubeService = stubeService;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return stubeService.createUser(user);
    }

    @GetMapping("/users")
    public List<User> showUsers(){
        return stubeService.showAllUser();
    }

    @DeleteMapping("/users")
    public void deleteAll(){
        stubeService.deleteAll();
    }

    @PutMapping("/users/{id}")
    public User setUserById(@PathVariable String id, @RequestBody User userMod) throws Exception {
        return stubeService.setUser(id, userMod);
    }
    @PostMapping("/users/{id}/videos")
    public void createVideo(@PathVariable String id, @RequestBody Video newVideo) throws Exception {
        stubeService.addVideo(id, newVideo);
    }
    @GetMapping("/users/{id}/videos")
    public void createVideo(@PathVariable String id) throws Exception {
        stubeService.getUserVideos(id);
    }

    @PostMapping("/users/{id}/videos/{videoId}")
    public void addRating(@PathVariable String videoId, @PathVariable String id, @RequestBody Ratings rating) throws Exception {
        stubeService.addRating(id, videoId, rating);
    }
}
