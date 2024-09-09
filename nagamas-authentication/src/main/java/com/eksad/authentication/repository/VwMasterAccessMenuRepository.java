package com.eksad.authentication.repository;

import com.eksad.authentication.domain.ViewMasterAccessMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VwMasterAccessMenuRepository extends JpaRepository<ViewMasterAccessMenu, String> {

    @Query(value = "SELECT * FROM vw_mst_access_menu WHERE user_id = :userId", nativeQuery = true)
    List<ViewMasterAccessMenu> findAllByUserId(@Param("userId") String userId);
}
