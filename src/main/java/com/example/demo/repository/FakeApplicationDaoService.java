/*
package com.example.demo.repository;

import com.example.demo.model.ApplicationUser;
import com.example.demo.security.ApplicationUserPermission;
import com.example.demo.security.ApplicationUserRole;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("fake")
public class FakeApplicationDaoService implements ApplicationUserDao {
    @Override
    public Optional<ApplicationUser> findByUsername(String username) {
        return getApplicationUsers().stream().filter(applicationUser -> applicationUser.getUsername().equals(username)).findFirst();
    }



    public List<ApplicationUser> getApplicationUsers() {
         List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser(ApplicationUserRole.ADMIN.getGrantedAuthorities(), "11223344", "admin", true, true, true, true),
                new ApplicationUser(ApplicationUserRole.EMPLOYEE.getGrantedAuthorities(), "11223344", "employee", true, true, true, true)
        );
        return applicationUsers;
    }
}

*/
