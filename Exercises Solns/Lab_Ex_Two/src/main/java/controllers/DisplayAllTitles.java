package controllers;

import model.Title;
import model.TitleDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DisplayAllTitles", value = "/DisplayAllTitles")
public class DisplayAllTitles extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            TitleDB.connectToDB();

            List<Title> titles = TitleDB.getAllTitles();

            TitleDB.disconnectFromDB();
            request.setAttribute("titles", titles);

            RequestDispatcher rd = request.getRequestDispatcher("allTitles.jsp");

            rd.forward(request, response);
        } catch (Exception ex) {
            log("ERROR: " + ex);
        }
    }


}
