package com.model.admin;

import com.model.entitymodel.admin.entity.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository
public interface AdminRoleRepository extends JpaRepository<AdminRole , Integer> {
}
