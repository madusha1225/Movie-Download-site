package lk.ijse.movie_downloard_site_backend.service;

import lk.ijse.movie_downloard_site_backend.entity.Comment;

import java.util.List;

public interface CommentService {

    void saveComment(Comment comment);

    List<Comment> getComments();
}
