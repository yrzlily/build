package com.model.admin;

import com.model.entitymodel.admin.entity.AdminCate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yrz
 */
@Repository
public interface AdminCateRepository extends JpaRepository<AdminCate , Integer> {

}
