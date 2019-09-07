package com.olehpodolin.spring5mvcrest.controllers.v1;

import com.olehpodolin.spring5mvcrest.api.v1.model.CategoryDTO;
import com.olehpodolin.spring5mvcrest.api.v1.model.CategoryListDTO;
import com.olehpodolin.spring5mvcrest.services.CategoryService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {

    public static final String BASE_URL = "/api/v1/categories/";

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CategoryListDTO getAllCategories() {
        return new CategoryListDTO(categoryService.getAllCategories());
    }

    @GetMapping("{name}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDTO getCategoryByName(@PathVariable String name) {
        return categoryService.getCategoryByName(name);
    }
}
