package retrain.maven.neko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import retrain.maven.neko.entity.ProductsEntity;
import retrain.maven.neko.service.ProductsService;

@RestController
@RequestMapping("/api")
public class ProductsController {
    @Autowired
    private ProductsService productsService;

    @GetMapping("/products")
    public List<ProductsEntity> getAll() {
        return productsService.findAll();
    }

    @GetMapping("/products/{id}")
    public ProductsEntity getById(@PathVariable("id") String id) {
        return productsService.findById(id);
    }

    @PostMapping("/products")
    public ProductsEntity create(@RequestBody ProductsEntity productsEntity) {
        return productsService.create(productsEntity);
    }

    @PatchMapping("/products/{id}")
    public ProductsEntity update(@RequestBody ProductsEntity productsEntity) {
        return productsService.update(productsEntity);
    }

    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable("id") String id) {
        productsService.deleteById(id);
    }
}
