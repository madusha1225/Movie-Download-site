package lk.ijse.movie_downloard_site_backend.service.impl;

import lk.ijse.movie_downloard_site_backend.entity.Category;
import lk.ijse.movie_downloard_site_backend.repo.CategoryRepository;
import lk.ijse.movie_downloard_site_backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    public CategoryRepository categoryRepository;

    @Override
    public List<String> getCategory(){
        List<Category> all = categoryRepository.findAll();
        List<String> categoryNames = new ArrayList<>();

        for (Category category : all){
            categoryNames.add(category.getName());
        }
        return categoryNames;
    }
}
