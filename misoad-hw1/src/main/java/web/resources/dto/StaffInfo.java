package web.resources.dto;

import java.sql.Timestamp;


public class StaffInfo {

    private Staff staff;
    private String address;
    private Link picture;
    private Boolean active;
    private Timestamp timestamp;

    public StaffInfo() {
        staff = new Staff();
    }

    public StaffInfo(Staff staff, String address, Link picture, Boolean active, Timestamp timestamp) {
        this.staff = staff;
        this.address = address;
        this.picture = picture;
        this.active = active;
        this.timestamp = timestamp;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Link getPicture() {
        return picture;
    }

    public void setPicture(Link picture) {
        this.picture = picture;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public class Staff {
        StaffData data;
        Link link;

        public Staff() {
        }

        public Staff(StaffData data, Link link) {
            this.data = data;
            this.link = link;
        }

        public StaffData getData() {
            return data;
        }

        public void setData(StaffData data) {
            this.data = data;
        }

        public Link getLink() {
            return link;
        }

        public void setLink(Link link) {
            this.link = link;
        }
    }

    public class Store {
        StoreData data;
        Link link;

        public Store() {
        }

        public Store(StoreData data, Link link) {
            this.data = data;
            this.link = link;
        }

        public StoreData getData() {
            return data;
        }

        public void setData(StoreData data) {
            this.data = data;
        }

        public Link getLink() {
            return link;
        }

        public void setLink(Link link) {
            this.link = link;
        }
    }
}
