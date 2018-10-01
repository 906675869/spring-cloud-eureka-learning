package com.qianxp.eurekaclientdao.repository;

import com.qianxp.eurekaclientdao.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role,Long> {
}
