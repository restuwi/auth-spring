package com.eksad.authentication.repository;

import com.eksad.authentication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query(value = "SELECT * FROM public.user WHERE username = :username AND is_active = :is_active",
            nativeQuery = true)
    Optional<User> findByUserIsActive(
            @Param("username") String username,
            @Param("is_active") Long isActive
    );

    @Query(value = "SELECT * FROM public.user " +
            "WHERE lower(username) = :username " +
            "AND lower(dealer_group_id) = :dealerGroupId",
            nativeQuery = true)
    Optional<User> findByUsernameAndDg(
            @Param("username") String username,
            @Param("dealerGroupId") String dealerGroupId
    );
}
