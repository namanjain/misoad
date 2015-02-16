package dal;

import common.Store;
import org.hibernate.Session;
import utils.HibernateUtils;

public class StoreDal {


    public Integer insertStore(Store store) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            session.save(store);
            session.getTransaction().commit();
            return store.getStoreId();
        } finally {
            HibernateUtils.returnSession(session);
        }
    }

    public void updateStore(Store store) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            session.merge(store);
            session.getTransaction().commit();
        } finally {
            HibernateUtils.returnSession(session);
        }
    }

    public Store getStore(Integer storeId) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            Store store = (Store) session.get(Store.class, storeId);
            HibernateUtils.returnSession(session);
            return store;
        } finally {
            HibernateUtils.returnSession(session);
        }
    }


    public void deleteStore(Integer storeId) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            Store store = new Store();
            store.setStoreId(storeId);
            session.delete(store);
            session.getTransaction().commit();
        } finally {
            HibernateUtils.returnSession(session);
        }
    }

}
