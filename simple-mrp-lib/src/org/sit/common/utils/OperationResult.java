/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.sit.common.utils;

import java.io.Serializable;

/**
 *
 * @author Golf
 */
public class OperationResult implements Serializable {
    private Boolean complete;
    private String message;
    private Object obj;

    public OperationResult() {
        complete = new Boolean(false);
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
