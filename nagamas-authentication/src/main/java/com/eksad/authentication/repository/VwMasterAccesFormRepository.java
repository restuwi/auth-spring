package com.eksad.authentication.repository;

import com.eksad.authentication.domain.ViewMasterAccessForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface VwMasterAccesFormRepository extends JpaRepository<ViewMasterAccessForm, String> {

    @Query(value = "SELECT * FROM vw_mst_access_form " +
            "WHERE user_id = :userId " +
            "AND menu_id = :menuId",
            nativeQuery = true
    )
    List<ViewMasterAccessForm> findAllByUserIdAndMenuId(
            @Param("userId") Long userId,
            @Param("menuId") List<String> menuId
    );

    @Query(value = "SELECT * FROM vw_mst_access_form WHERE user_id = :userId", nativeQuery = true)
    List<ViewMasterAccessForm> findAllByUserId(@Param("userId") String userId);

    @Query(value = "SELECT * FROM vw_mst_access_form WHERE user_id = :userId AND form_id = :formId", nativeQuery = true)
    Optional<ViewMasterAccessForm> findByUserIdAndFormId(@Param("userId") String userId, @Param("formId") String formId);
}
