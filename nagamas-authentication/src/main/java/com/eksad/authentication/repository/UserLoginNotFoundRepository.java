package com.eksad.authentication.repository;

import com.eksad.authentication.domain.UserLoginNotFound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginNotFoundRepository extends JpaRepository<UserLoginNotFound, String> {
}
