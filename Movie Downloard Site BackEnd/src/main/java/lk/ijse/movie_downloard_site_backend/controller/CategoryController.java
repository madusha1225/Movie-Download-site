package lk.ijse.movie_downloard_site_backend.controller;

import lk.ijse.movie_downloard_site_backend.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping("/getCategories")
    @PreAuthorize("hasAuthority('USER')")
    public List<String> getCategory(){
      return  categoryService.getCategory();
    }
}
