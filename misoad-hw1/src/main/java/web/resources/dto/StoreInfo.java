package web.resources.dto;

import java.sql.Timestamp;

public class StoreInfo {

    Store store;
    Manager manager;
    String address;
    Timestamp timestamp;

    public StoreInfo() {
        Store store = new Store();
        Manager manager = new Manager();
    }

    public StoreInfo(Store store, Manager manager, String address, Timestamp timestamp) {
        this.store = store;
        this.manager = manager;
        this.address = address;
        this.timestamp = timestamp;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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

    public class Manager {
        StaffData data;
        Link link;

        public Manager() {
        }

        public Manager(StaffData data, Link link) {
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
}
