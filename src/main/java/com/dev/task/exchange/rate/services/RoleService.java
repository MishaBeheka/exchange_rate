package com.dev.task.exchange.rate.services;

import com.dev.task.exchange.rate.model.Role;

public interface RoleService {
    Role create(Role role);

    Role findRoleByRoleName(String roleName);
}
