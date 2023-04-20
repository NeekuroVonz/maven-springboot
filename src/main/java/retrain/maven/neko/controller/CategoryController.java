package retrain.maven.neko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import retrain.maven.neko.entity.CategoryEntity;
import retrain.maven.neko.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category/{id}")
    public CategoryEntity findById(@PathVariable("id") String id) {
        return categoryService.findById(id);
    }

    @PostMapping("/category")
    public CategoryEntity create(@RequestBody CategoryEntity entity) {
        return categoryService.create(entity);
    }

    @PatchMapping("/category/{id}")
    public CategoryEntity update(@PathVariable("id") String id, @RequestBody CategoryEntity categoryEntity) {
        return categoryService.update(id, categoryEntity);
    }

    @GetMapping("/category")
    public List<CategoryEntity> findAll() {
        return categoryService.findAll();
    }

    @DeleteMapping("/category/{id}")
    public void deleteById(@PathVariable("id") String id) {
        categoryService.delete(id);
    }
}
