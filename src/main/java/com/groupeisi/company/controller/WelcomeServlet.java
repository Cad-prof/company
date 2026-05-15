package com.groupeisi.company.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {

    private static final Logger logger = LoggerFactory.getLogger(WelcomeServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.info("WelcomeServlet - loading welcome page");
        req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
    }
}