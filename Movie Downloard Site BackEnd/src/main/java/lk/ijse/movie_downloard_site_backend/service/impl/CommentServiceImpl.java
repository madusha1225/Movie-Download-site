package lk.ijse.movie_downloard_site_backend.service.impl;

import lk.ijse.movie_downloard_site_backend.entity.Comment;
import lk.ijse.movie_downloard_site_backend.repo.CommentRepository;
import lk.ijse.movie_downloard_site_backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public void saveComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getComments() {
        List<Comment> all = commentRepository.findAll();
        return all;
    }
}
