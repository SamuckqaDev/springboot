package br.com.matsutech.contoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.matsutech.model.User;
import br.com.matsutech.repository.UserRepository;

@RestController
@RequestMapping("api/v1/users")
public class UserController {


    @Autowired
    private UserRepository repository;

    @GetMapping("/{id}")
    public User listUsers(@PathVariable("id") Long id) {
        Optional<User> userFind = this.repository.findById(id);

        if (userFind.isPresent()) {
            return userFind.get();
        }
        return null;
    }

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        return this.repository.save(user);
    }

    @GetMapping("/list")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/list/{id}")
    public List<User> listMoreThan(@PathVariable("id") Long id) {
        return repository.findByIdGreaterThan(id);
    }

    @GetMapping("/findByName/{name}")
    public List<User> listForName(@PathVariable("name") String name) {
        return repository.findByNameIgnoreCase(name);
    }
}
