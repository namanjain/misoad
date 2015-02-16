package service;

import com.sun.jersey.api.NotFoundException;
import common.*;
import dal.StoreDal;
import org.apache.commons.collections.CollectionUtils;
import utils.LinkUtils;
import utils.StringUtils;
import web.resources.dto.Link;
import web.resources.dto.StaffData;
import web.resources.dto.StoreData;
import web.resources.dto.StoreInfo;

import java.util.ArrayList;
import java.util.List;


public class StoreService {

    StoreDal storeDal = new StoreDal();

    public StoreInfo getStore(Integer storeId) throws NotFoundException {
        Store store = storeDal.getStore(storeId);
        if(store == null) {
            throw new NotFoundException();
        }
        return convertStoreToStoreInfo(store, true);
    }

    public void deleteStore(Integer staffId) {
        storeDal.deleteStore(staffId);
    }

    public ValidationResult createStore(StoreInfo storeInfo) {
        ValidationResult validationResult = validateStoreInfo(storeInfo);
        if(ValidationResultType.success.equals(validationResult.getValidationResultType())) {
            Store store = convertStoreInfoToStore(storeInfo);
            Integer storeId = storeDal.insertStore(store);
            ValidationResultSuccess<Integer> result = new ValidationResultSuccess<Integer>();
            result.setEntity(storeId);
            return result;
        }
        return validationResult;
    }

    public ValidationResult updateStore(Integer storeId, StoreInfo storeInfo) {
        ValidationResult validationResult = validateStoreInfo(storeInfo);
        if(ValidationResultType.success.equals(validationResult.getValidationResultType())) {
            Store store = convertStoreInfoToStore(storeInfo);
            store.setStoreId(storeId);
            storeDal.updateStore(store);
            return new ValidationResultSuccess<Integer>();
        }
        return validationResult;
    }

    private ValidationResult validateStoreInfo(StoreInfo storeInfo) {
        ValidationResult validationResult;
        List<ValidationErrorCodes> errorCodesList = new ArrayList<ValidationErrorCodes>();
        if(storeInfo != null) {
            StoreInfo.Store storeInfoStore = storeInfo.getStore();
            if(storeInfoStore != null) {
                StoreData storeData = storeInfoStore.getData();
                if(storeData.getId() != null) {
                    errorCodesList.add(ValidationErrorCodes.ID_NOT_ALLOWED);
                }
            }
            StoreInfo.Manager manager = storeInfo.getManager();
            if(manager == null) {
                errorCodesList.add(ValidationErrorCodes.MISSING_MANAGER);
            } else {
                StaffData staffData = manager.getData();
                if(staffData.getId() == null) {
                    errorCodesList.add(ValidationErrorCodes.MISSING_MANAGER);
                }
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

    private Store convertStoreInfoToStore(StoreInfo storeInfo) {
        Store store = new Store();
        if(storeInfo != null) {
            StoreInfo.Store storeInfoStore = storeInfo.getStore();
            if(storeInfoStore != null) {
                StoreData storeData = storeInfoStore.getData();
                if(storeData.getId() != null) {
                    store.setStoreId(storeData.getId());
                }
            }

            StoreInfo.Manager manager = storeInfo.getManager();
            if(manager != null) {
                StaffData managerData = manager.getData();
                if(managerData.getId() != null) {
                    store.setManagerId(managerData.getId());
                }
            }

            if(StringUtils.isNotEmpty(storeInfo.getAddress())) {
                store.setAddress(storeInfo.getAddress());
            }
            if(storeInfo.getTimestamp() != null) {
                store.setLastUpdated(storeInfo.getTimestamp());
            }
        }
        return store;
    }

    private StoreInfo convertStoreToStoreInfo(Store store, boolean addLinks) {
        StoreInfo storeInfo = new StoreInfo();
        if(store != null) {
            StoreInfo.Store storeInfoStore = storeInfo.getStore();
            StoreData storeData = new StoreData();
            if(store.getStoreId() != null) {
                storeData.setId(store.getStoreId());
            }
            storeInfoStore.setData(storeData);
            if(addLinks) {
                Link storeInfoStoreLink = new Link();
                storeInfoStoreLink.setRel(Relation.self);
                storeInfoStoreLink.setHref(LinkUtils.getStoreLink(store.getStoreId()));
                storeInfoStore.setLink(storeInfoStoreLink);
            }

            if(StringUtils.isNotEmpty(store.getAddress())) {
                storeInfo.setAddress(store.getAddress());
            }
            if(store.getLastUpdated() != null) {
                storeInfo.setTimestamp(store.getLastUpdated());
            }
        }
        return storeInfo;
    }
}
