package com.librotrackapp.librotrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.librotrackapp.librotrack.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
