package retrain.maven.neko.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import retrain.maven.neko.entity.CategoryEntity;

public interface CategoryDao extends JpaRepository<CategoryEntity, String> {

}
