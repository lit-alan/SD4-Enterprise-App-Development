package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class AccountDB {

    public static List<Account> getAllAccounts() {
        EntityManager em = DBUtil.getEMF().createEntityManager();

        String query = "SELECT a from Account a";

        TypedQuery<Account> tq = em.createQuery(query, Account.class);

        List<Account> list = null;

        try {
            list = tq.getResultList();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }
        return list;
    }

    public static Account getAccountByID(int accountID) {
        EntityManager em = DBUtil.getEMF().createEntityManager();

        Account account = null;
        try {
            account = em.find(Account.class, accountID);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

        return account;
    }

    public static void updateAccount(Account a) {

        EntityManager em = DBUtil.getEMF().createEntityManager();

        EntityTransaction trans = em.getTransaction();

        try {
            trans.begin();
            em.merge(a);
            trans.commit();
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            em.close();
        }

    }//end updateAuthor

}