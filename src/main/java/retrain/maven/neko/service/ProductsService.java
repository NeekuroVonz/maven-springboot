package retrain.maven.neko.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import retrain.maven.neko.dao.CategoryDao;
import retrain.maven.neko.dao.ProductsDao;
import retrain.maven.neko.entity.ProductsEntity;
import retrain.maven.neko.exceptions.BadRequestException;
import retrain.maven.neko.exceptions.ResourceNotFoundException;

@Service
public class ProductsService {
    @Autowired
    private ProductsDao productsDao;

    @Autowired
    private CategoryDao categoryDao;

    public List<ProductsEntity> findAll() {
        return productsDao.findAll();
    }

    public ProductsEntity findById(String id) {
        return productsDao.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Product with id: " + id + " not found!"));
    }

    public ProductsEntity create(ProductsEntity productsEntity) {
        productsEntity.setId(UUID.randomUUID().toString());
        
        if (productsEntity.getAmount() < 0) {
            throw new BadRequestException("Amount cannot be negative!");
        }
        if (!StringUtils.hasText(productsEntity.getName())) {
            throw new BadRequestException("Name cannot be blank!");
        }
        if (productsEntity.getPrice() == null) {
            throw new BadRequestException("Price cannot be blank!");
        }
        if (productsEntity.getPrice().compareTo(BigDecimal.ZERO) == -1 ) {
            throw new BadRequestException("Price cannot be smaller than 0!");
        }

        if (productsEntity.getCategoryId() == null) {
            throw new BadRequestException("Category cannot be blank!");
        }
        if (!StringUtils.hasText(productsEntity.getCategoryId().getId())) {
            throw new BadRequestException("Category ID cannot be blank!");
        }


        categoryDao.findById(productsEntity.getCategoryId().getId())
            .orElseThrow(() -> new BadRequestException("This category with id: " + productsEntity.getCategoryId().toString() + " doesn't exist!"));

        productsEntity.setTimestamps(LocalDateTime.now());

        return productsDao.save(productsEntity);
    }

    public ProductsEntity update(ProductsEntity productsEntity) {
        if (productsEntity.getAmount() < 0) {
            throw new BadRequestException("Amount cannot be negative!");
        }
        if (productsEntity.getPrice().compareTo(BigDecimal.ZERO) == -1 ) {
            throw new BadRequestException("Price cannot be smaller than 0!");
        }

        productsDao.findById(productsEntity.getId())
            .orElseThrow(() -> new BadRequestException("Product with id: " + productsEntity.getId() + " not found!"));

        categoryDao.findById(productsEntity.getCategoryId().getId())
            .orElseThrow(() -> new BadRequestException("This category with id: " + productsEntity.getCategoryId().toString() + " doesn't exist!"));
        
        productsEntity.setTimestamps(LocalDateTime.now());

        return productsDao.save(productsEntity);
    }

    public void deleteById(String id) {
        productsDao.deleteById(id);
    }
}
