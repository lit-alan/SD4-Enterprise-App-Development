
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DetectBrowser", value = "/DetectBrowser")
public class DetectBrowser extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userAgent = request.getHeader("User-Agent");
        String browser = detectBrowser(userAgent);

        response.setContentType("text/plain");
        response.getWriter().write("You are using: " + browser);
    }

    private String detectBrowser(String userAgent) {
        if (userAgent.contains("Chrome") && userAgent.contains("Safari") && !userAgent.contains("Edg")) {
            return "Chrome";
        } else if (userAgent.contains("Firefox")) {
            return "Firefox";
        } else if (userAgent.contains("Edg")) {
            return "Edge";
        } else if (userAgent.contains("Safari") && !userAgent.contains("Chrome")) {
            return "Safari";
        } else if (userAgent.contains("OPR") || userAgent.contains("Opera")) {
            return "Opera";
        } else {
            return "Unknown";
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
