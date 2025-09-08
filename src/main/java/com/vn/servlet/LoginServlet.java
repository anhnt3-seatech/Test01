package com.vn.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra tài khoản (hardcoded)
        if ("admin".equals(username) && "1234".equals(password)) {
            // Lưu session
            HttpSession session = request.getSession();
            session.setAttribute("user", username);
            response.sendRedirect("home.jsp");
        } else {
            request.setAttribute("error", "Invalid username or password!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    // Hỗ trợ method GET nếu cần
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}