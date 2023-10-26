package controllers;

import model.Account;
import model.AccountDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AccountDrillDown", value = "/AccountDrillDown")
public class AccountDrillDown extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            String address;
            int accountID = 0;
            try {
                accountID = Integer.parseInt(request.getParameter("id"));
                String fNAme = request.getParameter("fNAme");
            } catch (Exception ex) {
                address = "/UnknownCustomer.jsp";
            }

            Account a = AccountDB.getAccountByID(accountID);

            if (a == null) {
                address = "/UnknownCustomer.jsp";
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("account", a);
                address = "/AccountDetails.jsp";
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);
        }//end doGET

  }//end Servlet

