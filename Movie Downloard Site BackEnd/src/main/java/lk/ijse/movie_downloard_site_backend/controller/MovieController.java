package lk.ijse.movie_downloard_site_backend.controller;


import lk.ijse.movie_downloard_site_backend.dto.FilmDTO;
import lk.ijse.movie_downloard_site_backend.entity.Category;
import lk.ijse.movie_downloard_site_backend.entity.Film;
import lk.ijse.movie_downloard_site_backend.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@RequestMapping("api/v1/movie")
public class MovieController {
    @Autowired
    private MovieServiceImpl movieService;


//    @GetMapping("/show")
//    public String showMovieList(Model model,String keyword){
//        if (keyword != null){
//            model.addAttribute("movies",movieService.findByKeyword(keyword));
//        }
//        else{
//            model.addAttribute("movies",movieService.getMovies());
//        }
//        return "menu";
//    }

    @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FilmDTO> getAllMovie() {
        List<Film> filmList = movieService.getMovies();
        List<FilmDTO> filmDTOS = new ArrayList<>();
        for (Film film : filmList){
            if (film.getCategory() == null) {
                film.setCategory(new Category("Test"));
            }
            filmDTOS.add(new FilmDTO(film.getId(),film.getName(), film.getYear(), film.getDescription(),film.getFilmLink(),film.getMovieImage(),film.getLanguages(),film.getCategory().getName()));
        }
        return filmDTOS;
    }

    @GetMapping("/addNewMovie")
    public String addNewMovie(Model model){
        Film movie = new Film();
        model.addAttribute("movie",movie);
        model.addAttribute("actors");
        return "new_movie";
    }

    @PostMapping("/saveMovie")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String saveMovie(@RequestBody FilmDTO filmDTO){
        Film film = new Film(filmDTO.getName(), filmDTO.getYear(),filmDTO.getDescription(), filmDTO.getFilmLink(),filmDTO.getMovieImage(),filmDTO.getLanguages());
        System.out.println("------------------------1----------------------------");
        movieService.saveMovie(film,filmDTO.getCategory());
        return "Okay";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model){
        Film movie = movieService.getMovieById(id);
        model.addAttribute("movie",movie);
        return "update_movie";
    }

    @PostMapping("/deleteMovie")
    public void deleteMovie(@RequestBody FilmDTO filmDTO){
        Film film = new Film(filmDTO.getId(), filmDTO.getName(), filmDTO.getYear(),filmDTO.getDescription(), filmDTO.getFilmLink(),filmDTO.getMovieImage(),filmDTO.getLanguages());
        movieService.deleteMovie(film);
    }

    @GetMapping("/getMovie/{id}")
    public FilmDTO getMovie(@PathVariable(value = "id") int id){
        Film film = movieService.getMovieById(id);
        if (film.getCategory() == null) {
            film.setCategory(new Category("Test"));
        }
        return new FilmDTO(film.getId(),film.getName(), film.getYear(), film.getDescription(),film.getFilmLink(),film.getMovieImage(),film.getLanguages(),film.getCategory().getName());
    }

    @GetMapping("movies")
    public List<Film> getMovies() {
        return movieService.getMovies();
    }

    @PutMapping("updateMovie")
    public void updateMovie(@RequestBody FilmDTO filmDTO) {
        Film film = new Film(filmDTO.getId(), filmDTO.getName(), filmDTO.getYear(),filmDTO.getDescription(), filmDTO.getFilmLink(),filmDTO.getMovieImage(),filmDTO.getLanguages());
        movieService.saveMovie(film,filmDTO.getCategory());
    }
}
