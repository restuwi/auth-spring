package com.eksad.authentication.repository;

import com.eksad.authentication.domain.ViewMasterRoleAccess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VwMasterAccessRoleRepository extends JpaRepository<ViewMasterRoleAccess, String> {

}
