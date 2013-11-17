package org.example.entities;

import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by a202898 on 11/16/13.
 */
public class EntityPersonTest {
    SessionFactory factory;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testSelect() {
        PropertyConfigurator.configure(EntityPersonTest.class.getClassLoader().getResource("log4j.properties"));
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List phones = session.createQuery("FROM EntityPerson p join fetch p.emailsById").list();
            for (Iterator iterator = phones.iterator(); iterator.hasNext(); ) {
                EntityPerson person = (EntityPerson) iterator.next();
                System.out.print("id: " + person.getId());
                System.out.print(" Name: " + person.getCompleteName());
                System.out.println(" Birth date: " + person.getBirthDate());
                System.out.println(" Emails: " + person.getEmailsById());
                //System.out.println(" Phones: " + person.getPhonesById());
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @After
    public void tearDown() throws Exception {

    }
}
