package common;

import java.sql.Blob;
import java.sql.Timestamp;

public class Staff implements java.io.Serializable, Entity {

    private static final long serialVersionUID = 2L;

    private Integer staffId;
    private String firstName;
    private String lastName;
    private String address;
    private Blob picture;
    private String email;
    private Integer storeId;
    private Boolean active;
    private String username;
    private String password;
    private Timestamp lastUpdated;

    public Staff() {
    }

    public Staff(Integer staffId, String firstName, String lastName, String address, Blob picture, String email,
                 Integer storeId, Boolean active, String username, String password, Timestamp lastUpdated) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.picture = picture;
        this.email = email;
        this.storeId = storeId;
        this.active = active;
        this.username = username;
        this.password = password;
        this.lastUpdated = lastUpdated;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public Integer getEntityId() {
        return staffId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture(Blob picture) {
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
