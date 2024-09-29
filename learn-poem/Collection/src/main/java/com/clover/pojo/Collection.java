package com.clover.pojo;

import java.util.Date;

public class Collection {
    private int id;
    private String resourceType;
    private String collectionTableName;
    private int resourceId;
    private int userId;
    private Date collectionTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getCollectionTableName() {
        return collectionTableName;
    }

    public void setCollectionTableName(String collectionTableName) {
        this.collectionTableName = collectionTableName;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Date collectionTime) {
        this.collectionTime = collectionTime;
    }
}
