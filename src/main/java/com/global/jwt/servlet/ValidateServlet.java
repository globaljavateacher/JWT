package com.global.jwt.servlet;

import java.io.IOException;

import com.global.jwt.service.ValidateService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/validate")
public class ValidateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ValidateService.validate(req);
		req.getRequestDispatcher("/WEB-INF/views/jwt_validate.jsp").forward(req, resp);
	}
}
