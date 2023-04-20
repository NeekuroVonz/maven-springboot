package retrain.maven.neko.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import retrain.maven.neko.entity.ProductsEntity;

public interface ProductsDao extends JpaRepository<ProductsEntity, String> {

}
