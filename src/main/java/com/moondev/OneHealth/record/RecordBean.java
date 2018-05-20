package com.moondev.OneHealth.record;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

public class RecordBean {

    private int recordId;

    private int personId;

    @NotEmpty
    private String type;

    @NotNull
    private float value;

    private String comments;

    private LocalDateTime dateTime;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
