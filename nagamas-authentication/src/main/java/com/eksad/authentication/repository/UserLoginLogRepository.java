package com.eksad.authentication.repository;

import com.eksad.authentication.domain.UserLoginLog;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserLoginLogRepository extends JpaRepository<UserLoginLog, String> {

    @Query(value = "SELECT * FROM user_login_log WHERE id_user = :userId AND is_active = :isActive", nativeQuery = true)
    List<UserLoginLog> findByUserIdIAndIsActive(@Param("userId") Long userId, @Param("isActive") Long isActive);

    @Modifying
    @Transactional
    @Query(value = "UPDATE user_login_log " +
            "SET is_active = :isActive, " +
            "logout_latitude = :logoutLatitude, " +
            "logout_longitude = :logoutLongitude, " +
            "logout_time = :logoutTime, " +
            "modified_by = :modifiedBy, " +
            "modified_dt = :modifiedDt, " +
            "status_log = :statusLog " +
            "WHERE id_user = :userId AND is_active = 1", nativeQuery = true)
    void updateUserLogs(
            @Param("isActive") Long isActive,
            @Param("logoutLatitude") Double logoutLatitude,
            @Param("logoutLongitude") Double logoutLongitude,
            @Param("logoutTime") Date logoutTime,
            @Param("modifiedBy") String modifiedBy,
            @Param("modifiedDt") Date modifiedDt,
            @Param("statusLog") String statusLog,
            @Param("userId") Long userId);
}