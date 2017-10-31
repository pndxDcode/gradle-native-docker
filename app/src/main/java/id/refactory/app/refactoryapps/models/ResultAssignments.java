package id.refactory.app.refactoryapps.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by massam on 25/10/17.
 */

public class ResultAssignments {
    @SerializedName("success")
    private String success;

    @SerializedName("data")
    private ArrayList<DataAssignments> dataResponse;

    @SerializedName("messages")
    private String message;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public ArrayList<DataAssignments> getDataResponse() {
        return dataResponse;
    }

    public void setDataResponse(ArrayList<DataAssignments> data) {
        this.dataResponse = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
