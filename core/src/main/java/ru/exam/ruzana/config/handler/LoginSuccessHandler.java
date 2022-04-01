package ru.exam.ruzana.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.exam.ruzana.model.PersonDataEntity;
import ru.exam.ruzana.model.Roles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    /**
     * Redirects to url depending on role after successful authentication.
     *
     * @param request the request which caused the successful authentication
     * @param response the response
     * @param authentication the <tt>Authentication</tt> object which was created during
     * the authentication process.
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        Collection<String> roles = authentication.getAuthorities().stream().map(i -> ((Roles)i).getRole()).collect(Collectors.toList());

        if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("/api/admin/users/");
        } else if (roles.contains("ROLE_USER")) {
            Long id = ((PersonDataEntity) authentication.getPrincipal()).getId();
            response.sendRedirect("/user/" + id);
        }
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
