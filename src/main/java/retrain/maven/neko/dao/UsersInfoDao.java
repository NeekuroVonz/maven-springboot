package retrain.maven.neko.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import retrain.maven.neko.entity.UsersInfoEntity;

public interface UsersInfoDao extends JpaRepository<UsersInfoEntity, String> {
    
}
