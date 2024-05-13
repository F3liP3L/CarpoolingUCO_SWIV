package co.edu.uco.infrastructure.adapter.jwt;

import co.edu.uco.entity.model.JwtResponse;
import co.edu.uco.infrastructure.controller.response.Response;
import co.edu.uco.infrastructure.controller.response.dto.Message;
import co.edu.uco.util.json.UtilMapperJson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final int CODE_DEFAULT = HttpServletResponse.SC_UNAUTHORIZED;
    private final UtilMapperJson mapperJson;

    public JwtAuthenticationEntryPoint(UtilMapperJson mapperJson) {
        this.mapperJson = mapperJson;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        String message;
        if (authException instanceof BadCredentialsException) {
            message = "The credentials entered are incorrect.";
        } else if (authException instanceof InsufficientAuthenticationException) {
            message = "Insufficient authentication details provided";
        } else {
            message = "Unauthorized access";
        }
        response.setStatus(CODE_DEFAULT);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Response<JwtResponse> responseAuth = new Response<>();
        Message responseMessage = Message.createErrorMessage(message, "Error authentication");
        responseAuth.addMessage(responseMessage);
        Optional<String> tokenResponse = mapperJson.execute(responseAuth);
        if (tokenResponse.isPresent()) {
            response.getWriter().write(tokenResponse.get());
        }
    }
}