package com.example.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.mdl.User;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByUserName(String userName);

  User findByUserNameOrEmail(String username, String email);

  Page<User> findAll(Pageable pageable);

  @Transactional(timeout = 10)
  @Modifying
  @Query("update User u set u.userName = ?1 where c.id = ?2")
  int modifyByIdAndUserId(String userName, Long id);
}
