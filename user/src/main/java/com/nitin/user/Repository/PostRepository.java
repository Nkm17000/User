package com.nitin.user.Repository;

import com.nitin.user.Entity.PostData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository  extends JpaRepository< PostData, Integer > {


}
