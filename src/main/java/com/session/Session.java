package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/session")
public class Session extends HttpServlet {

    protected void service(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();

        long creationTime = session.getCreationTime();

        long lastAccessedTime = session.getLastAccessedTime();

        out.println("<html>");
        out.println("<body>");

        out.println("<h2>Session Information</h2>");

        out.println("<p>Session ID: " + session.getId() + "</p>");

        out.println("<p>Session Creation Time: "
                + new java.util.Date(creationTime)
                + "</p>");

        out.println("<p>Last Accessed Time: "
                + new java.util.Date(lastAccessedTime)
                + "</p>");

        out.println("</body>");
        out.println("</html>");
    }
}