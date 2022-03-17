package com.example.personapp;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PersonDataService {
    public static final String PERSON_API = "http://10.0.2.2:8080/Demo/api/person";
    private Context ctx;
    private JSONArray jsonArray;


    public PersonDataService(Context ctx) {
        this.ctx = ctx;
    }

    public void getAllPersons(DataServiceListener serviceListener) {
        String url = PERSON_API;

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        serviceListener.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        serviceListener.onError(error.getMessage());
                    }
                }
        );

        // Add the request to the RequestQueue.
        PersonSingleton.getInstance(ctx).addToRequestQueue(jsonArrayRequest);
    }

    public void getPersonById(int personId, DataServiceListener serviceListener) {
        String url = PERSON_API + "/" + personId;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        serviceListener.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        serviceListener.onError(error.getMessage());
                    }
                }
        );
        // Add the request to the RequestQueue.
        PersonSingleton.getInstance(ctx).addToRequestQueue(jsonObjectRequest);
    }

    public void postPerson(JSONObject person, DataServiceListener dataServiceListener){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                PERSON_API,
                person,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        dataServiceListener.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dataServiceListener.onError(error.getMessage());
                    }
                }
        );
        // Add the request to the RequestQueue.
        PersonSingleton.getInstance(ctx).addToRequestQueue(jsonObjectRequest);
    }

    public void deletePerson(int persId, DataServiceListener dataServiceListener){
        String deleteURL = PERSON_API + "/" + persId;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.DELETE,
                deleteURL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        dataServiceListener.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dataServiceListener.onError(error.getMessage());
                    }
                }
        );
        // Add the request to the RequestQueue.
        PersonSingleton.getInstance(ctx).addToRequestQueue(jsonObjectRequest);
    }

    public void updatePerson(JSONObject person, int persId, DataServiceListener dataServiceListener){
        String updateURL = PERSON_API + "/" + persId;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.PUT,
                updateURL,
                person,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        dataServiceListener.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        dataServiceListener.onError(error.getMessage());
                    }
                }
        );
        // Add the request to the RequestQueue.
        PersonSingleton.getInstance(ctx).addToRequestQueue(jsonObjectRequest);
    }
}