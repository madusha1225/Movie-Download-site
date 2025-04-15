package lk.ijse.movie_downloard_site_backend.repo;

import lk.ijse.movie_downloard_site_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByEmail(String userName);

    boolean existsByEmail(String userName);

    int deleteByEmail(String userName);

}
