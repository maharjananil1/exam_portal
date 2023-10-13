package org.personal.exam_portal_backend.common.exceptionhandler.exception;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/** created by: maharjananil created on: 10/12/2023 */
@Component
public class AuthenticationException implements AuthenticationEntryPoint {
    private static final Gson gson =
            new GsonBuilder().disableHtmlEscaping().serializeNulls().create();

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            org.springframework.security.core.AuthenticationException authException)
            throws IOException, ServletException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        Map<String,Object> message = new HashMap<>();
        message.put("message","Please login");
        message.put("timestamp",System.currentTimeMillis());
        message.put("code","Test");
        response.getWriter().write(gson.toJson(message));
    }
}
