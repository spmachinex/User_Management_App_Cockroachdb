package com.becoder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.becoder.model.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, String> {

    boolean existsByEmail(String email);

    UserDtls findByEmail(String email);
}
