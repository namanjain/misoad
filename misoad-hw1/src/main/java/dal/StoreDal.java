package dal;

import common.Store;
import org.hibernate.Session;
import utils.HibernateUtils;

public class StoreDal {

    HibernateDal hibernateDal = new HibernateDal();

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

    public Integer insertStore(Store store) {
        return hibernateDal.insert(store);
    }

    public void updateStore(Store store) {
        hibernateDal.update(store);
    }

    public void deleteStore(Integer storeId) {
        Store store = new Store();
        store.setStoreId(storeId);
        hibernateDal.delete(store);
    }
}
