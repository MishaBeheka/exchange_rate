package com.dev.task.exchange.rate.services.implementation;

import com.dev.task.exchange.rate.model.Role;
import com.dev.task.exchange.rate.repository.RoleRepository;
import com.dev.task.exchange.rate.services.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findRoleByRoleName(roleName);
    }
}
