package lk.ijse.movie_downloard_site_backend.repo;


import lk.ijse.movie_downloard_site_backend.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Film,Integer> {

    @Query(value="SELECT * FROM movie.movies WHERE name like %:keyword%  or genre like %:keyword%",nativeQuery = true)
    List<Film> findByKeyword(@Param("keyword") String keyword);


}
