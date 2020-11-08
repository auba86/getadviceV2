package lt.auba.getadvice.service;

import lt.auba.getadvice.model.Post;
import lt.auba.getadvice.model.User;
import lt.auba.getadvice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void saveNewPost(Post post){
        postRepository.save(post);
    }

    public List<Post> getAllPosts() {
        return (List<Post>) postRepository.findAll();
    }
}
