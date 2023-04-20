package retrain.maven.neko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import retrain.maven.neko.entity.UsersEntity;
import retrain.maven.neko.service.UsersService;

@RestController
@RequestMapping("/api")
public class UsersController {
    @Autowired
    private UsersService usersService;
    
    @GetMapping("/users")
    public List<UsersEntity> findAll() {
        return usersService.findAll();
    }

    @GetMapping("/users/{id}")
    public UsersEntity findById(@PathVariable String id) {
        return usersService.findById(id);
    }

    

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id) {
        usersService.delete(id);
    }
}
