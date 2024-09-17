package com.deepblue.cruddemo.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import javax.sql.DataSource

@Configuration
class SecurityConfig {
    @Bean
    fun userDetailManager(dataSource: DataSource): UserDetailsManager {
        return JdbcUserDetailsManager(dataSource)
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { configurer ->
            configurer
                .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        }
        http.httpBasic(Customizer.withDefaults())

        http.csrf{csrf->csrf.disable()}

        // Build and return the SecurityFilterChain
        return http.build()
    }

    /*
@Bean
fun userDetail(): InMemoryUserDetailsManager {
    val user1 = User.builder()
        .username("jone")
        .password("{noop}1234")
        .roles("EMPLOYEE")
        .build()
    val user2 = User.builder()
        .username("mary")
        .password("{noop}1234")
        .roles("EMPLOYEE", "MANAGER")
        .build()
    val user3 = User.builder()
        .username("susan")
        .password("{noop}1234")
        .roles("EMPLOYEE", "MANAGER", "ADMIN")
        .build()

    return InMemoryUserDetailsManager(user1, user2, user3)
}
*/
}