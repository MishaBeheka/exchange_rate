package com.dev.task.exchange_rate.services.implementation;

import com.dev.task.exchange_rate.model.Role;
import com.dev.task.exchange_rate.repository.RoleRepository;
import com.dev.task.exchange_rate.services.RoleService;
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
}
