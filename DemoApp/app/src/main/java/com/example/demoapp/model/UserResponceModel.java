package com.example.demoapp.model;

import com.example.demoapp.room.userEntity;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponceModel {

    @SerializedName("statusCode")
    @Expose
    private Integer statusCode;
    @SerializedName("statusMessage")
    @Expose
    private String statusMessage;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<userEntity> data = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserResponceModel() {
    }

    /**
     *
     * @param message
     * @param statusCode
     * @param data
     * @param statusMessage
     */
    public UserResponceModel(Integer statusCode, String statusMessage, String message, List<userEntity> data) {
        super();
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.message = message;
        this.data = data;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<userEntity> getData() {
        return data;
    }

    public void setData(List<userEntity> data) {
        this.data = data;
    }

}
