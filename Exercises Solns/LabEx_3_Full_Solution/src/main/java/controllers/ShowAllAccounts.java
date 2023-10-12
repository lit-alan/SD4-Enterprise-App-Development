package controllers;

import model.Account;
import model.AccountDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAllAccounts", value = "/ShowAllAccounts")
public class ShowAllAccounts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String address;

            try {
                List<Account> list = AccountDB.getAllAccounts();

                if (list == null || list.isEmpty()) {
                    address = "/Error.jsp";
                } else {

                    address = "/ShowAllAccounts.jsp";
                    request.setAttribute("list", list);
                }

            }//end try
            catch (Exception ex) {
                address = "/Error.jsp";
            }//end catch


            RequestDispatcher dispatcher = request.getRequestDispatcher(address);
            dispatcher.forward(request, response);


    }

}
