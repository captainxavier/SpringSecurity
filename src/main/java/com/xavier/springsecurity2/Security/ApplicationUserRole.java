package com.xavier.springsecurity2.Security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.xavier.springsecurity2.Security.ApplicationUserPermission.*;


public enum ApplicationUserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(USER_READ,USER_WRITE,EMPLOYEE_READ,EMPLOYEE_WRITE));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }


    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }
}
