package lk.ijse.movie_downloard_site_backend.service.impl;

import lk.ijse.movie_downloard_site_backend.entity.Comment;
import lk.ijse.movie_downloard_site_backend.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl {

    @Autowired
    private CommentRepository commentRepository;

    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    public List<Comment> getComments() {
        List<Comment> all = commentRepository.findAll();
        return all;
    }
}
