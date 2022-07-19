package com.springboot.app.moviebooking.services.imp;

import com.springboot.app.moviebooking.model.Role;
import com.springboot.app.moviebooking.repositories.RoleRepository;
import com.springboot.app.moviebooking.services.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {

    private final RoleRepository repository;

    public RoleServiceImp(RoleRepository repository) {
        this.repository = repository;
    }


    @Override
    public Role createRole(Role role) {
        return this.repository.save(role);
    }

    @Override
    public Role updateRole(Role role) {
        return this.repository.saveAndFlush(role);
    }

    @Override
    public void deleteRole(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    public Role getRole(Long id) {
        return this.repository.findById(id).orElseThrow();
    }
}
