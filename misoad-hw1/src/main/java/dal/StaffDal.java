package dal;

import common.Staff;
import org.hibernate.Session;
import utils.HibernateUtils;

public class StaffDal {

    public Integer insertStaff(Staff staff) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            session.save(staff);
            session.getTransaction().commit();
            return staff.getStaffId();
        } finally {
            HibernateUtils.returnSession(session);
        }
    }

    public void updateStaff(Staff staff) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            session.merge(staff);
            session.getTransaction().commit();
        } finally {
            HibernateUtils.returnSession(session);
        }
    }

    public Staff getStaff(Integer staffId) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            return (Staff) session.get(Staff.class, staffId);
        } finally {
            HibernateUtils.returnSession(session);
        }
    }


    public void deleteStaff(Integer staffId) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            session.beginTransaction();
            Staff staff = new Staff();
            staff.setStaffId(staffId);
            session.delete(staff);
            session.getTransaction().commit();
        } finally {
            HibernateUtils.returnSession(session);
        }
    }
}
