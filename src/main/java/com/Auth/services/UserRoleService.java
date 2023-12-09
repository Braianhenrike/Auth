package com.Auth.services;

import com.Auth.enums.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserRoleService {

	public UserRole getUserRoleByName(String roleName) {
	    for (UserRole role : UserRole.values()) {
	        if (role.getRole().equals(roleName)) {
	            return role;
	        }
	    }

        return null;
    }
}
