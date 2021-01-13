package com.lindx.example.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class SessionUtil {

    private static Session session = null;
    private static Transaction transaction = null;

    public static Session getSession(){
        return session;
    }

    public static Transaction getTransaction() {
        return transaction;
    }
    
    public static Session openSession(){

        try {

            return HibernateUtil.getSessionFactory().openSession();
            
        } catch (Exception e) {

            transaction = getTransaction();

            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }

        throw new RuntimeException();
    }

    public static Session openTransactionSession() {
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public static void closeSession(){
        session.close();
    }

    public static void closeTransactionSession() {
        transaction.commit();
        closeSession();
    }
}
