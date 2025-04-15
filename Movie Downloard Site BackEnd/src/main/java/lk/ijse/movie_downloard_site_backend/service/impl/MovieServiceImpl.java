package lk.ijse.movie_downloard_site_backend.service.impl;

import lk.ijse.movie_downloard_site_backend.entity.Category;
import lk.ijse.movie_downloard_site_backend.entity.Film;
import lk.ijse.movie_downloard_site_backend.repo.CategoryRepository;
import lk.ijse.movie_downloard_site_backend.repo.MovieRepository;
import lk.ijse.movie_downloard_site_backend.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Film> getMovies(){
        return movieRepository.findAll();
    }

    @Override
    public void saveMovie(Film movie, String category) {
        System.out.println(category);
        Category byId = categoryRepository.getByName(category.trim());
        System.out.println(byId.getId());
        movie.setCategory(byId);
        movieRepository.save(movie);
    }

    @Override
    public Film getMovieById(int id){
        Optional<Film> optional = movieRepository.findById(id);
        Film movie = null;
        if (optional.isPresent()){
            movie = optional.get();
        }else{
            throw new RuntimeException("Movie not found for id ::" + id);
        }
        return movie;
    }

    @Override
    public void deleteMovie(Film film){
        movieRepository.delete(film);
    }

    @Override
    public List<Film> findByKeyword(String keyword){
        return movieRepository.findByKeyword(keyword);
    }

}
