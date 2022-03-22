package com.springboot.videoservicenew.app.repository;

import com.springboot.videoservicenew.app.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    RoleModel findByRoleName(String name);
}
