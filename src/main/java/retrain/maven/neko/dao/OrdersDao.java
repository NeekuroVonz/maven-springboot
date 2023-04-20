package retrain.maven.neko.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import retrain.maven.neko.entity.OrdersEntity;

public interface OrdersDao extends JpaRepository<OrdersEntity, String> {
    
}
