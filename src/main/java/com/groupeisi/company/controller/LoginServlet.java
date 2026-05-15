package com.groupeisi.company.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    // GET: show the login page
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("LoginServlet GET - displaying login page");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    // POST: handle login form submission
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        logger.info("Login attempt for user: {}", username);

        // Simple hardcoded check (later replaced with DB)
        if ("admin".equals(username) && "admin".equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", username);
            logger.info("Login SUCCESS for user: {}", username);
            resp.sendRedirect(req.getContextPath() + "/welcome");
        } else {
            logger.warn("Login FAILED for user: {}", username);
            req.setAttribute("error", "Invalid username or password.");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

//    @WebServlet("/welcome")
    public static class WelcomeServlet extends HttpServlet {

        private static final Logger logger = LoggerFactory.getLogger(WelcomeServlet.class);

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {
            logger.info("WelcomeServlet - loading welcome page");
            req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
        }
    }
}