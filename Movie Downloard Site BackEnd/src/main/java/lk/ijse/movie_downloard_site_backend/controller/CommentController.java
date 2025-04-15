package lk.ijse.movie_downloard_site_backend.controller;

import lk.ijse.movie_downloard_site_backend.entity.Comment;
import lk.ijse.movie_downloard_site_backend.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comment")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping("/getComments")
    public List<Comment> getComments() {
        return commentService.getComments();
    }

    @PostMapping("/saveComment")
    public void saveComment(@RequestBody Comment comment) {
        commentService.saveComment(comment);
    }
}
