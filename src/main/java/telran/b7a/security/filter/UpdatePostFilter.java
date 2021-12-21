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

import telran.b7a.account.dao.AccountMongoRepository;
import telran.b7a.forum.dao.ForumMongoRepository;
import telran.b7a.security.SecurityContext;

@Service
@Order(30)
public class UpdatePostFilter implements Filter {
	
	ForumMongoRepository forumRepository;

	public UpdatePostFilter(ForumMongoRepository forumRepository) {
		this.forumRepository =forumRepository;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		if (checkEndPoints(request.getServletPath(), request.getMethod())) {
			Principal principal = request.getUserPrincipal();
			String[] authorPost = request.getServletPath().split("/");
			String postId = authorPost[authorPost.length - 1];
			if (forumRepository.findById(postId).isEmpty()) {
				response.sendError(403);
				return;
			}
			String nameUser = forumRepository.findById(postId).get().getAuthor();
			for (int i = 0; i < authorPost.length; i++) {
				System.out.println(authorPost[i]);
			}
			if (!principal.getName().equals(nameUser)) {
				response.sendError(403);
				return;
			}
		}

		chain.doFilter(request, response);
	}

	private boolean checkEndPoints(String path, String method) {
		return ("PUT".equalsIgnoreCase(method) && path.matches("[/]forum[/]post[/]\\w+[/]?"));
	}

}
