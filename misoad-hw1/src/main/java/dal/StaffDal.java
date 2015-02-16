package dal;

import common.Staff;
import org.hibernate.Session;
import utils.HibernateUtils;

public class StaffDal {

    HibernateDal hibernateDal = new HibernateDal();

    public Staff getStaff(Integer staffId) {
        Session session = null;
        try {
            session = HibernateUtils.getSession();
            return (Staff) session.get(Staff.class, staffId);
        } finally {
            HibernateUtils.returnSession(session);
        }
    }

    public Integer insertStaff(Staff staff) {
        return hibernateDal.insert(staff);
    }

    public void updateStaff(Staff staff) {
        hibernateDal.update(staff);
    }

    public void deleteStaff(Integer staffId) {
        Staff staff = new Staff();
        staff.setStaffId(staffId);
        hibernateDal.delete(staff);
    }
}
