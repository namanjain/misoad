package dal;

import common.Staff;
import org.hibernate.Session;
import utils.HibernateUtil;
import web.resources.dto.StaffInfo;

public class StaffDal {

    public Integer insertStaff(Staff staff) {
        Session session = getSession();
        session.beginTransaction();
        session.save(staff);
        session.getTransaction().commit();
        closeSession(session);
        //return generated id
        return staff.getStaffId();
    }

    public void updateStaff(Staff staff) {
        Session session = getSession();
        session.beginTransaction();
        session.merge(staff);
        session.getTransaction().commit();
        closeSession(session);
    }

    public Staff getStaff(Integer staffId) {
        Session session = getSession();
        Staff staff = (Staff) session.get(Staff.class, staffId);
        closeSession(session);
        return staff;
    }


    public void deleteStaff(Integer staffId) {
        Session session = getSession();
        session.beginTransaction();
        Staff staff = new Staff();
        staff.setStaffId(staffId);
        session.delete(staff);
        session.getTransaction().commit();
        closeSession(session);
    }

    private Session getSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

    private void closeSession(Session session) {
        session.close();
    }
}
