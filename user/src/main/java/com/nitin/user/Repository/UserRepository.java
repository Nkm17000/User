package com.nitin.user.Repository;

import com.nitin.user.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository< User, Integer > {


}
