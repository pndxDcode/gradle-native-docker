package id.refactory.app.refactoryapps.models;

import android.provider.ContactsContract;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by massam on 25/10/17.
 */

public class UpdateAssignments {
    @SerializedName("success")
    private String success;

    @SerializedName("data")
    private ContactsContract.Data dataResponse;

    @SerializedName("message")
    private String message;


    @SerializedName("content_value")
    private String contentValue;

    @SerializedName("result_attachments")
    private String resultAttachments;

    public UpdateAssignments(String value, String name){
        this.contentValue = value;
        this.resultAttachments = name;

    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public ContactsContract.Data getDataResponse() {
        return dataResponse;
    }

    public void setDataResponse(ContactsContract.Data data) {
        this.dataResponse = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
