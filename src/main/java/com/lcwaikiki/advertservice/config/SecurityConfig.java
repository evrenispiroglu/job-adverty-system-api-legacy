package com.lcwaikiki.advertservice.config;


import com.lcwaikiki.advertservice.filter.CustomAuthenticationFilter;
import com.lcwaikiki.advertservice.filter.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor //Should config component based
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;
  private final BCryptPasswordEncoder passwordEncoder;

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    CustomAuthenticationFilter filter = new CustomAuthenticationFilter(authenticationManagerBean());
    filter.setFilterProcessesUrl("/api/v1/login");
    http.cors().and().csrf().disable();
    /*
     * TODO : SHOULD CONFIGURE THIS AREA CORRECLLY
     * */
    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    http.authorizeRequests().antMatchers("/api/v1/login/**").permitAll();
    http.authorizeRequests().antMatchers("/api/v1/users/registration/**").permitAll();
    http.authorizeRequests().antMatchers("/api/v1/users/login/{email}/**").permitAll();

    //    Advert Requests
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/adverts/**")
        .hasAnyAuthority("LOGGED_IN");
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/adverts/filter")
        .hasAnyAuthority("LOGGED_IN");
    http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/v1/adverts/**/applications/**")
        .hasAnyAuthority("employee");
    http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/v1/adverts")
        .hasAnyAuthority("employer");
    http.authorizeRequests().antMatchers(HttpMethod.PATCH, "/api/v1/adverts")
        .hasAnyAuthority("employer");
    http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/v1/adverts")
        .hasAnyAuthority("employer");
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/adverts/{id}/applications")
        .hasAnyAuthority("employer");

    // User Requests
    http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/v1/users/{id}/**")
        .hasAnyAuthority("LOGGED_IN");
    http.authorizeRequests().antMatchers(HttpMethod.PATCH, "/api/v1/users/{id}/**")
        .hasAnyAuthority("employee");
    http.authorizeRequests().antMatchers("/api/v1/users/**/photo")
        .hasAnyAuthority("employee");
    http.authorizeRequests().antMatchers("/api/v1/users/**/cv")
        .hasAnyAuthority("employee");

    http.addFilter(filter);
    http.addFilterBefore(new CustomAuthorizationFilter(),
        UsernamePasswordAuthenticationFilter.class);
    http.authorizeRequests().anyRequest().authenticated();
  }

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }
}
