package service;

import com.sun.jersey.api.NotFoundException;
import common.Staff;
import dal.StaffDal;
import web.resources.dto.StaffInfo;


public class StaffService {

    StaffDal staffDal = new StaffDal();

    public StaffInfo getStaff(Integer id) {
        Staff staff = staffDal.getStaff(id);
        if(staff == null) {
            throw new NotFoundException();
        }
        return convertStaffToStaffInfo(staff);
    }

    public Integer createStaff(StaffInfo staffInfo) {
        validateStaffInfo(staffInfo);
        Staff staff = convertStaffInfoToStaff(staffInfo);
        return staffDal.insertStaff(staff);
    }

    private Staff convertStaffInfoToStaff(StaffInfo staffInfo) {
        return null;
    }


    private StaffInfo convertStaffToStaffInfo(Staff staff) {
        return null;
    }

    private void validateStaffInfo(StaffInfo staffInfo) {

    }
}
