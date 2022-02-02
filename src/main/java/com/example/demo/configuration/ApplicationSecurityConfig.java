package com.example.demo.configuration;
import com.example.demo.security.ApplicationUserPermission;
/*import com.example.demo.service.ApplicationUserService;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.concurrent.TimeUnit;

import static com.example.demo.security.ApplicationUserRole.ADMIN;
import static com.example.demo.security.ApplicationUserRole.EMPLOYEE;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
   /* private final ApplicationUserService applicationUserService;
*/
@Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;

}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.
               csrf().disable().
               authorizeRequests().antMatchers("/","index","/css/*","/js/*").permitAll()
               .antMatchers(HttpMethod.POST,"/api/v1/**").hasAuthority(ApplicationUserPermission.EMPLOYEE_WRITE.getPermission())
               .antMatchers(HttpMethod.DELETE,"/api/v1/**").hasAuthority(ApplicationUserPermission.EMPLOYEE_WRITE.getPermission())
               .antMatchers(HttpMethod.PUT,"/api/v1/**").hasAuthority(ApplicationUserPermission.EMPLOYEE_WRITE.getPermission())
               .antMatchers(HttpMethod.GET,"/api/v1/**").hasAnyRole(ADMIN.name(),EMPLOYEE.name())
               .anyRequest()
               .authenticated()
               .and()
               .formLogin()
                       .loginPage("/login").
               permitAll().defaultSuccessUrl("/success",true)
               .passwordParameter("password")
               .usernameParameter("username")
               .and().rememberMe().tokenValiditySeconds((int)
                       TimeUnit.DAYS.toSeconds(21))
               .key("gotsecured").
               and().
               logout().
               logoutUrl("/logout")
               .clearAuthentication(true)
               .invalidateHttpSession(true)
               .deleteCookies("JSESSIONID","remember-me")
               .logoutSuccessUrl(("/login"));

}

  /*  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }*/
/*
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
    DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
    daoAuthenticationProvider.setUserDetailsService(applicationUserService);
    return daoAuthenticationProvider;
    }*/


    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails adminUser=
        User.builder().username("admin").password(
             passwordEncoder.encode(
                     "11223344")).authorities(ADMIN.getGrantedAuthorities()).build();
                /*.roles(ADMIN.name())*/

        UserDetails employeeUser=
                User.builder().username("employee").password(
                        passwordEncoder.encode(
                                "11223344")
                ).authorities(EMPLOYEE.getGrantedAuthorities()).build();
return new InMemoryUserDetailsManager(adminUser,
        employeeUser);
    }
}
