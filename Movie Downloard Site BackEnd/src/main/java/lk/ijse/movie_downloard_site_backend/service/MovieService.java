package lk.ijse.movie_downloard_site_backend.service;

import lk.ijse.movie_downloard_site_backend.entity.Film;

import java.util.List;

public interface MovieService {
    List<Film> getMovies();

    void saveMovie(Film movie, String category);

    Film getMovieById(int id);

    void deleteMovie(Film film);

    List<Film> findByKeyword(String keyword);
}
