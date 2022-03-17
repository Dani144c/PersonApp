package com.example.personapp;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PersonDataService dataService = new PersonDataService(MainActivity.this);

        dataService.getAllPersons(new DataServiceListener() {
            @Override
            public void onSuccess(JSONArray response) {
                Log.d("MyData", "Data: " + response.toString());
            }

            @Override
            public void onSuccess(JSONObject jsonObject) {
            }

            @Override
            public void onError(String error) {
                Log.d("MyData", "" + error);
            }
        });

        dataService.getPersonById(3, new DataServiceListener() {
            @Override
            public void onSuccess(JSONObject response) {
                Gson gson = new Gson();
                Person p = gson.fromJson(response.toString(), Person.class);

                Log.d("MyData", p.toString());
            }

            @Override
            public void onError(String error) {
                Log.d("MyData", "" + error);
            }

            @Override
            public void onSuccess(JSONArray jsonArray) {
            }
        });

        JSONObject j = new JSONObject();
        try {
            j.put("fullName", "Lazzz");
            j.put("email", "yaskii@hotmail.com");
            j.put("note", "henlo");

        } catch (JSONException e){
            e.printStackTrace();
        }

        dataService.postPerson(j, new DataServiceListener() {
            @Override
            public void onSuccess(JSONArray jsonArray) { }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                Log.d("MyData", jsonObject.toString());
            }

            @Override
            public void onError(String error) {
                Log.d("MyData", "" + error);
            }
        });

        dataService.deletePerson(1011, new DataServiceListener() {
            @Override
            public void onSuccess(JSONArray jsonArray) {

            }

            @Override
            public void onSuccess(JSONObject jsonObejct) {
                Log.d("MyData", "1");
            }

            @Override
            public void onError(String error) {
                Log.d("MyData", "" + error);
            }
        });

        JSONObject update = new JSONObject();
        try {
            update.put("fullName", "Draco Malfoy");
            update.put("email", "dm@slytherin.hogwarts");
            update.put("note", "He is evil (kinda)");

        } catch (JSONException e){
            e.printStackTrace();
        }

        dataService.updatePerson(update, 1006, new DataServiceListener() {
            @Override
            public void onSuccess(JSONArray jsonArray) { }

            @Override
            public void onSuccess(JSONObject jsonObject) {
                Log.d("MyData", jsonObject.toString());
            }

            @Override
            public void onError(String error) {
                Log.d("MyData", "" + error);
            }
        });
    }
}