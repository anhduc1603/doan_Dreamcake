package com.anhduc.managecake.reponsitory;

import com.anhduc.managecake.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleReponsitory extends JpaRepository<Role, Integer> {
}
