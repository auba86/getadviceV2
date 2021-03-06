package lt.auba.getadvice.service;

import lt.auba.getadvice.model.Comment;
import lt.auba.getadvice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public void saveNewComment(Comment comment) {
        commentRepository.save(comment);
    }
}
