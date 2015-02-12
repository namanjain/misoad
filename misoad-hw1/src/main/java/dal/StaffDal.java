package dal;

import common.Staff;
import org.hibernate.Session;

public class StaffDal {

    public Integer insertStaff(Staff staff) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(staff);
        session.getTransaction().commit();
//        Staff myStaff = new Staff();
        //return generated id
        return staff.getStaffId();
    }

    public Staff getStaff(Integer staffId) {

        return new Staff();
    }


}
