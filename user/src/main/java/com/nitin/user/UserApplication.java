package com.nitin.user;

import com.nitin.user.Entity.PostData;
import com.nitin.user.Entity.User;
import com.nitin.user.Repository.PostRepository;
import com.nitin.user.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class UserApplication implements CommandLineRunner {
     @Autowired
	UserRepository userRepository;

     @Autowired
	PostRepository postRepository;
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<User> userList=new ArrayList<>();
		User user1=new User();
		user1.setName("nitin");
		user1.setBirthDate(new Date());


		User user2=new User();
		user2.setName("rahul");
		user2.setBirthDate(new Date());
		userList.add(user1);
		userList.add(user2);
		userRepository.saveAll(userList);

		PostData postData=new PostData();
		postData.setTitle("first data");
		postData.setUser(user1);
		postRepository.save(postData);
	}
}
