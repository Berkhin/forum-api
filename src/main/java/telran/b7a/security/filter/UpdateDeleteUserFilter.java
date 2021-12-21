package telran.b7a.security.filter;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;


import telran.b7a.security.SecurityContext;

/*
 * Update user
 * Delete user
 * Add post
 * Add comments
 */

@Service
@Order(30)
public class UpdateDeleteUserFilter implements Filter {
	
	SecurityContext securityContext;
	
	public UpdateDeleteUserFilter(SecurityContext securityContext) {
		this.securityContext = securityContext;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		if (checkEndPoints(request.getServletPath(), request.getMethod())) {
			Principal principal = request.getUserPrincipal();
			String[] nameUser = request.getServletPath().split("/");
			if (!principal.getName().equals(nameUser[nameUser.length-1])) {
				response.sendError(403);
				return;
			}
		}
		chain.doFilter(request, response);
	}

	private boolean checkEndPoints(String path, String method) {
		return path.matches("[/]account[/]user[/]\\w+[/]?") || ("POST".equalsIgnoreCase(method) && path.matches("[/]forum[/]post[/]\\w+[/]?")) || path.matches("[/]forum[/]post[/]\\w+[/]comment[/]\\w+[/]?");
	}
}
