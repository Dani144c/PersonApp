package com.example.personapp;

import org.json.JSONArray;
import org.json.JSONObject;

public interface DataServiceListener {
    public void onSuccess(JSONArray jsonArray);

    public void onSuccess(JSONObject jsonObejct);

    public void onError(String error);
}
