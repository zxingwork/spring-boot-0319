package org.zx.springboot0319.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zx.springboot0319.model.User;


public interface UserDao extends JpaRepository<User, String> {
}
