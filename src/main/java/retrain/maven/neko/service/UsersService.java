package retrain.maven.neko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retrain.maven.neko.dao.UsersDao;
import retrain.maven.neko.entity.UsersEntity;
import retrain.maven.neko.exceptions.ResourceNotFoundException;

@Service
public class UsersService {
    @Autowired
    private UsersDao usersDao;

    public UsersEntity findById(String id) {
        return usersDao.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found!"));
    }

    public List<UsersEntity> findAll() {
        return usersDao.findAll();
    }

    

    public void delete(String id) {
        usersDao.deleteById(id);
    }
}
