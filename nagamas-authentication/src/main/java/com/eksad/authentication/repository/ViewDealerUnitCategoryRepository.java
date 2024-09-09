package com.eksad.authentication.repository;

import com.eksad.authentication.domain.ViewDealerUnitCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ViewDealerUnitCategoryRepository extends JpaRepository<ViewDealerUnitCategory, Integer> {
    @Query(value = "SELECT * FROM vw_dealer_unit_category WHERE dealer_id = :dealerId", nativeQuery = true)
    List<ViewDealerUnitCategory> finByDealerId(@Param("dealerId") String dealerId);
}
