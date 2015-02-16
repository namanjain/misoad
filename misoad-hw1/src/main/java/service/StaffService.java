package service;

import com.sun.jersey.api.NotFoundException;
import common.*;
import dal.StaffDal;
import org.apache.commons.collections.CollectionUtils;
import utils.LinkUtils;
import utils.StringUtils;
import web.resources.dto.Link;
import web.resources.dto.Name;
import web.resources.dto.StaffData;
import web.resources.dto.StaffInfo;

import java.util.ArrayList;
import java.util.List;


public class StaffService {

    StaffDal staffDal = new StaffDal();

    public StaffInfo getStaff(Integer id) throws NotFoundException {
        Staff staff = staffDal.getStaff(id);
        if(staff == null) {
            throw new NotFoundException();
        }
        return convertStaffToStaffInfo(staff, true);
    }

    public void deleteStaff(Integer staffId) {
        staffDal.deleteStaff(staffId);

    }

    public ValidationResult createStaff(StaffInfo staffInfo) {
        ValidationResult validationResult = validateStaffInfo(staffInfo);
        if(ValidationResultType.success.equals(validationResult.getValidationResultType())) {
            Staff staff = convertStaffInfoToStaff(staffInfo);
            Integer staffId = staffDal.insertStaff(staff);
            ValidationResultSuccess<Integer> result = new ValidationResultSuccess<Integer>();
            result.setEntity(staffId);
            return result;
        }
        return validationResult;
    }

    public ValidationResult updateStaff(Integer staffId, StaffInfo staffInfo) {
        ValidationResult validationResult = validateStaffInfo(staffInfo);
        if(ValidationResultType.success.equals(validationResult.getValidationResultType())) {
            Staff staff = convertStaffInfoToStaff(staffInfo);
            staff.setStaffId(staffId);
            staffDal.updateStaff(staff);
            return new ValidationResultSuccess<Integer>();
        }
        return validationResult;
    }

    private Staff convertStaffInfoToStaff(StaffInfo staffInfo) {
        Staff staff = new Staff();
        if(staffInfo != null) {
            //converting staffInfoStaff fist
            StaffInfo.Staff staffInfoStaff = staffInfo.getStaff();
            if(staffInfoStaff != null) {
                StaffData staffData = staffInfoStaff.getData();
                Name name = staffData.getName();
                if(name != null) {
                    if(StringUtils.isNotEmpty(name.getFirst())) {
                        staff.setFirstName(name.getFirst());
                    }
                    if(StringUtils.isNotEmpty(name.getLast())) {
                        staff.setLastName(name.getLast());
                    }
                }
                if(StringUtils.isNotEmpty(staffData.getEmail())) {
                    staff.setEmail(staffData.getEmail());
                }
                if (staffData.getId() != null) {
                    staff.setStaffId(staffData.getId());
                }
                if(StringUtils.isNotEmpty(staffData.getPassword())) {
                    staff.setPassword(staffData.getPassword());
                }
                if(StringUtils.isNotEmpty(staffData.getUsername())) {
                    staff.setUsername(staffData.getUsername());
                }
            }
            //converting other variables
            //TODO: ignoring picture for now
            if(staffInfo.getActive() != null) {
                staff.setActive(staffInfo.getActive());
            }
            if(StringUtils.isNotEmpty(staffInfo.getAddress())) {
                staff.setAddress(staffInfo.getAddress());
            }
            if(staffInfo.getTimestamp() != null) {
                staff.setLastUpdated(staffInfo.getTimestamp());
            }
        }
        return staff;
    }


    private StaffInfo convertStaffToStaffInfo(Staff staff, boolean addLinks) {
        StaffInfo staffInfo = new StaffInfo();
        if (staff != null) {
            //converting staffInfoStaff first
            StaffInfo.Staff staffInfoStaff = staffInfo.getStaff();
            StaffData staffData = new StaffData();
            if (staff.getStaffId() != null) {
                staffData.setId(staff.getStaffId());
            }
            if (StringUtils.isNotEmpty(staff.getPassword())) {
                staffData.setPassword(staff.getPassword());
            }
            if (StringUtils.isNotEmpty(staff.getUsername())) {
                staffData.setUsername(staff.getUsername());
            }
            if (StringUtils.isNotEmpty(staff.getEmail())) {
                staffData.setEmail(staff.getEmail());
            }
            if (StringUtils.isNotEmpty(staff.getFirstName()) || StringUtils.isNotEmpty(staff.getFirstName())) {
                Name name = new Name();
                if (StringUtils.isNotEmpty(staff.getFirstName())) {
                    name.setFirst(staff.getFirstName());
                }
                if (StringUtils.isNotEmpty(staff.getLastName())) {
                    name.setLast(staff.getLastName());
                }
                staffData.setName(name);
            }
            staffInfoStaff.setData(staffData);
            if (addLinks) {
                Link staffInfoStaffLink = new Link();
                staffInfoStaffLink.setRel(Relation.self);
                staffInfoStaffLink.setHref(LinkUtils.getStaffLink(staff.getStaffId()));
                staffInfoStaff.setLink(staffInfoStaffLink);
            }
            //converting other variables
            //TODO: ignoring picture for now
            if (StringUtils.isNotEmpty(staff.getAddress())) {
                staffInfo.setAddress(staff.getAddress());
            }
            if (staff.getActive() != null) {
                staffInfo.setActive(staff.getActive());
            }
            if (staff.getLastUpdated() != null) {
                staffInfo.setTimestamp(staff.getLastUpdated());
            }
        }
        return staffInfo;
    }

    private ValidationResult validateStaffInfo(StaffInfo staffInfo) {
        ValidationResult validationResult;
        List<ValidationErrorCodes> errorCodesList = new ArrayList<ValidationErrorCodes>();
        if(staffInfo != null) {
            StaffInfo.Staff staffInfoStaff = staffInfo.getStaff();
            if(staffInfoStaff == null) {
                errorCodesList.add(ValidationErrorCodes.MISSING_FIRST_NAME);
                errorCodesList.add(ValidationErrorCodes.MISSING_LAST_NAME);
            } else {
                StaffData staffData = staffInfoStaff.getData();
                Name name = staffData.getName();
                if(name == null) {
                    errorCodesList.add(ValidationErrorCodes.MISSING_FIRST_NAME);
                    errorCodesList.add(ValidationErrorCodes.MISSING_LAST_NAME);
                } else {
                    if(StringUtils.isEmpty(name.getFirst())) {
                        errorCodesList.add(ValidationErrorCodes.MISSING_FIRST_NAME);
                    }
                    if(StringUtils.isEmpty(name.getLast())) {
                        errorCodesList.add(ValidationErrorCodes.MISSING_LAST_NAME);
                    }
                }
                if(staffData.getId() != null) {
                    errorCodesList.add(ValidationErrorCodes.ID_NOT_ALLOWED);
                }
                //validate email
            }
        }
        if(CollectionUtils.isEmpty(errorCodesList)) {
            validationResult = new ValidationResultSuccess();
        } else {
            ValidationResultFailure failure = new ValidationResultFailure();
            failure.setErrors(errorCodesList);
            validationResult = failure;
        }
        return validationResult;
    }
}
