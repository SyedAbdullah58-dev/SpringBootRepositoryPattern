package com.example.demo.security;

public enum ApplicationUserPermission {
    EMPLOYEE_READ("employee:read"),
    EMPLOYEE_WRITE("employee:write"),
    EMPLOYEE_DELETE("employee:delete"),
    DEPARTMENT_WRITE("department:write"),
    DEPARTMENT_READ("department:read");
        private final String permission;
    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
