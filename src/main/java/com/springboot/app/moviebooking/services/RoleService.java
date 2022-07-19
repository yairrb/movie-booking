package com.springboot.app.moviebooking.services;

import com.springboot.app.moviebooking.model.Role;

public interface RoleService {


    Role createRole(Role role);

    Role updateRole(Role role);

    void deleteRole(Long id);

    Role getRole(Long id);
}
