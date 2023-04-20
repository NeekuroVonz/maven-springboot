package retrain.maven.neko.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import retrain.maven.neko.entity.UsersPaymentsEntity;

public interface UsersPaymentsDao extends JpaRepository<UsersPaymentsEntity, String> {

}
