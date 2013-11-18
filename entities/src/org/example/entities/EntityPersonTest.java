package org.example.entities;

import org.apache.log4j.PropertyConfigurator;
import org.hibernate.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import java.util.Iterator;

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
            Criteria criteria = session.createCriteria(EntityPerson.class);
            criteria.setFetchMode("emailsById", FetchMode.JOIN);
            criteria.setFetchMode("phonesById", FetchMode.JOIN);
            //List<EntityPerson> persons = (List<EntityPerson>) session.createQuery("FROM EntityPerson p left join fetch p.emailsById left join p.phonesById").list();
            List<EntityPerson> persons = (List<EntityPerson>) session.createQuery("FROM EntityPerson p left join fetch p.emailsById").list();
            for (EntityPerson person : persons) {
                System.out.println(person);
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
