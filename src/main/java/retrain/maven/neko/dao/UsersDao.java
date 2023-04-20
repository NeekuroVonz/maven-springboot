package retrain.maven.neko.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import retrain.maven.neko.entity.UsersEntity;

public interface UsersDao extends JpaRepository<UsersEntity, String> {

}
