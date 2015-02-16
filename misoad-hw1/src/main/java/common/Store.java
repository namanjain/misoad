package common;

import java.sql.Timestamp;


public class Store implements java.io.Serializable, Entity {

    private static final long serialVersionUID = 1L;

    private Integer storeId;
    private Integer managerId;
    private String address;
    private Timestamp lastUpdated;

    public Store() {
    }

    public Store(Integer storeId, Integer managerId, String address, Timestamp lastUpdated) {
        this.storeId = storeId;
        this.managerId = managerId;
        this.address = address;
        this.lastUpdated = lastUpdated;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public Integer getEntityId() {
        return storeId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Timestamp getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Timestamp lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
