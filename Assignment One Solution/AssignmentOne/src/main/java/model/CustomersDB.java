package model;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class CustomersDB {

    public static Optional<Customer> getAccountByID(int id) {
        EntityManager em = DBUtil.getEMF().createEntityManager();

        Customer customer = null;
        try {
            customer = em.find(Customer.class, id);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        // Check if the customer exists
        if (customer != null) {
            return Optional.of(customer);
        } else {
            return Optional.empty(); // Return an empty Optional if customer is not found
        }
    }

    public static List<Customer> getAll() {
        EntityManager em = DBUtil.getEMF().createEntityManager();

        String query = "SELECT c from Customer c";

        TypedQuery<Customer> tq = em.createQuery(query, Customer.class);

        List<Customer> list = null;

        try {
            list = tq.getResultList();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        return list;
    }


}
