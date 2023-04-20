package retrain.maven.neko.service;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;
import retrain.maven.neko.dao.CategoryDao;
import retrain.maven.neko.entity.CategoryEntity;
import retrain.maven.neko.exceptions.BadRequestException;
import retrain.maven.neko.exceptions.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public CategoryEntity findById(String id) {
        return categoryDao.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + id + " not found!"));
    }

    public CategoryEntity create(@NotNull CategoryEntity categoryEntity) {
        categoryEntity.setId(UUID.randomUUID().toString());
        if (!StringUtils.hasText(categoryEntity.getName())) {
            throw new BadRequestException("Category name can not be blank!");
        }
        categoryEntity.setTimestamps(LocalDateTime.now());

        return categoryDao.save(categoryEntity);
    }

    public CategoryEntity update(String id, CategoryEntity categoryEntity) {
        categoryDao.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Category with id: " + id + " not found!"));
        
        if (!StringUtils.hasText(categoryEntity.getName())) {
            throw new BadRequestException("Category name can not be blank!");
        }

        categoryEntity.setTimestamps(LocalDateTime.now());

        return categoryDao.save(categoryEntity);
    }

    public List<CategoryEntity> findAll() {
        return categoryDao.findAll();
    }

    public void delete(String id) {
        categoryDao.deleteById(id);
    }
}
