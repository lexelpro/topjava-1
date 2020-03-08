package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.repository.UserRepository;
import ru.javawebinar.topjava.repository.inmemory.InMemoryUserRepository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class UserServlet extends HttpServlet {
    private static final Logger log = getLogger(UserServlet.class);

	private UserRepository userRepository;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		userRepository = new InMemoryUserRepository();
	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("forward to users");
        log.debug("User id is {}", request.getParameter("userid"));
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.debug("forward to users");
		log.debug("User id is {}", req.getParameter("userId"));
		String paramUserId = req.getParameter("userId");
		SecurityUtil.setAuthUserId(Integer.parseInt(paramUserId));
		req.setAttribute("userId", req.getParameter("userId"));
		req.getRequestDispatcher("/users.jsp").forward(req, resp);
	}
}
