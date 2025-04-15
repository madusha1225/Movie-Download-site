package lk.ijse.movie_downloard_site_backend.repo;

import lk.ijse.movie_downloard_site_backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query("SELECT c FROM Category c WHERE c.name = :name")
    Category getByName(@Param("name") String name);

}
