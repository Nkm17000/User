package com.nitin.user.Controller;
import com.nitin.user.Entity.User;
import com.nitin.user.Error.UserNotFoundException;
import com.nitin.user.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

     @Autowired
    UserRepository userRepository;
    @GetMapping("/")
    List< User > getAllUsers(){
        return userRepository.findAll();


    }


    @GetMapping("/user/{id}")
     User  getAllUsers(@PathVariable int id){
       return userRepository
               .findById(id)
               .orElseThrow(()->new UserNotFoundException("User not found"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping ("/user")
    User  createUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }
}
