package com.email.EmailAPI.repository;

import com.email.EmailAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends JpaRepository<User, Long> {

}
