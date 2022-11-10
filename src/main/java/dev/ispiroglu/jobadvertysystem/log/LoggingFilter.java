package dev.ispiroglu.jobadvertysystem.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Slf4j
@Component
public class LoggingFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        long startTime = System.currentTimeMillis();
        filterChain.doFilter(requestWrapper, responseWrapper);
        long timeTaken = System.currentTimeMillis() - startTime;

        String requestBody = getBody(requestWrapper.getContentAsByteArray(), request.getCharacterEncoding());
        String responseBody = getBody(responseWrapper.getContentAsByteArray(), response.getCharacterEncoding());

        log.info("REQUEST LOG : SessionID = {}, Method = {}, RequestURI = {}, RequestBody = {} | ResponseBody{}, Time Taken = {}",
                request.getSession().getId(), request.getMethod(), request.getRequestURI(), requestBody, responseBody, timeTaken);
            responseWrapper.copyBodyToResponse();
    }


    private String getBody(byte[] bytes, String characterEncoding) {
        try {
            return new String(bytes, 0, bytes.length, characterEncoding);
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
