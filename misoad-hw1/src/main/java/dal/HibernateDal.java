package dal;

import common.Entity;
import common.Rental;
import org.hibernate.Session;
import utils.HibernateUtils;


public class HibernateDal {

    public Integer insert(Entity entity) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
            return entity.getEntityId();
        } finally {
            HibernateUtils.returnSession(session);
        }
    }

    public void update(Entity entity) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            session.merge(entity);
            session.getTransaction().commit();
        } finally {
            HibernateUtils.returnSession(session);
        }
    }

    public void delete(Entity entity) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } finally {
            HibernateUtils.returnSession(session);
        }
    }
}
