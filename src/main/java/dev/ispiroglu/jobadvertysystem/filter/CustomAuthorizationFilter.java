package dev.ispiroglu.jobadvertysystem.filter;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@Slf4j
public class CustomAuthorizationFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    log.info("Incoming request: " + request.getRequestURI());
    log.info("\tProtocol: " + request.getProtocol());

    if ( request.getServletPath().equals("/api/v1/login") ||
            request.getServletPath().equals("/swagger-ui.html") ||
            request.getServletPath().equals("/api/v1/users/registration") ||
            request.getServletPath().equals("/log")
    ) {
      filterChain.doFilter(request, response);
      return;
    }

    String authHeader = request.getHeader(AUTHORIZATION);
    if (authHeader != null && authHeader.startsWith("Bearer ")) {
      try {
        String token = authHeader.substring("Bearer ".length());
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        JWTVerifier verifier = JWT.require(algorithm).build();

        DecodedJWT decodedJWT = verifier.verify(token);
        String username = decodedJWT.getSubject();
        String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Arrays.stream(roles).forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
            username, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authToken);
        filterChain.doFilter(request, response);
      } catch (Exception e) {
        log.error("Error logging in: {}", e.getMessage());
        log.error("Token -> {}", request.getParameter(authHeader));
        response.setHeader("error", e.getMessage());
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);

        Map<String, String> errors = new HashMap<>();
        errors.put("error_message", e.getMessage());
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), errors);
      }
    } else {
      filterChain.doFilter(request, response);
    }

  }
}
