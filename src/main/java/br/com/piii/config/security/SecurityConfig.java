package br.com.piii.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeRequests()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**").permitAll()
                .antMatchers("/*").hasRole("ADMIN")
                .and()
                // some more method calls
                .formLogin().loginPage("/login").permitAll()
                .and()
                .logout().logoutUrl("/logout").permitAll()
                .and()
                .formLogin();

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
           auth.inMemoryAuthentication().withUser("admin").password("univesp").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("fulano").password("univesp").roles("ADMIN");
         /*
       auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enable from tb_user where username=?")
                .authoritiesByUsernameQuery(
                        "select u.username username, r.role role from tb_user u, tb_role r where u.role_id = r.id and username=?");

        auth.jdbcAuthentication().dataSource(dataSource)
                .withDefaultSchema()
                .withUser("admin").password("password").roles("ADMIN");
                */
    }
}

