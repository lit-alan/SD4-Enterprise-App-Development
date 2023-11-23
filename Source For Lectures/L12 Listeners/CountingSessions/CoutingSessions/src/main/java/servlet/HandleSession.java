package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

@WebServlet(name = "HandleSession", value = "/HandleSession")
public class HandleSession extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(false);

            if (session == null) {
                out.println("Session does not exist, so create it");
                session = request.getSession();
                out.println("<br>Session created at " + new Date(session.getCreationTime()));
                out.println("<br>session id " + session.getId());
            }//end if
            else {
                out.println("session exists so invalidate it");
                session.invalidate();
            }//end else

        }//end try
    }//end processRequest

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
