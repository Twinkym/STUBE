package PROJECT_STUBE.STUBE;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends CrudRepository<Video, String>{
    @Transactional
    List<Video>deleteAllByUser(User user);
}
