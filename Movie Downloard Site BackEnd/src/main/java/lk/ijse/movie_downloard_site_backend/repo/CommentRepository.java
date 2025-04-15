package lk.ijse.movie_downloard_site_backend.repo;

import lk.ijse.movie_downloard_site_backend.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Integer> {
}
