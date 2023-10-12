package model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {

    private static final EntityManagerFactory EMF =
            Persistence.createEntityManagerFactory("default");

    public static EntityManagerFactory getEMF() { return EMF; }
}