package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    User findUserById(String id);

    User findByUserNameOrAddress(String userName,String addredd);

    List<User> findByLevelBetween(int start,int end);

    @Transactional
    String deleteUserById(String id);
}
