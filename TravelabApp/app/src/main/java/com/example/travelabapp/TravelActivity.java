package com.example.travelabapp;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import android.app.DatePickerDialog;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Iterator;

public class TravelActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextFlightFrom, editTextFlightTo, editTextDepartDate, editTextReturnDate;
    private Button buttonSearch;

    private Button returnDate;
    private Button departDate;
    private TextView returnDate1;
    private TextView departDate1;
    private String storeDate1;
    private String storeDate2;
    Calendar c;
    DatePickerDialog dpd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        editTextFlightFrom = (EditText) findViewById(R.id.editTextFlightFrom);
        editTextFlightTo = (EditText) findViewById(R.id.editTextFlightTo);
        departDate = (Button) findViewById(R.id.departDate);
        returnDate = (Button) findViewById(R.id.returnDate);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        //textView = (TextView) findViewById(R.id.departDate1);
        departDate1 = (TextView) findViewById(R.id.departDate1);
        returnDate1 = (TextView) findViewById(R.id.returnDate1);


        buttonSearch.setOnClickListener(this);
        returnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(TravelActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDayOfMonth) {
                        storeDate1 = mDayOfMonth + "/" + (mMonth + 1) + "/" + mYear;
                        returnDate1.setText("Depart Date: " + storeDate1);
                    }
                }, day, month, year);
                dpd.show();

            }
        });

        departDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                int day = c.get(Calendar.DAY_OF_MONTH);
                int month = c.get(Calendar.MONTH);
                int year = c.get(Calendar.YEAR);

                dpd = new DatePickerDialog(TravelActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int mYear, int mMonth, int mDayOfMonth) {
                        storeDate2 = mDayOfMonth + "/" + (mMonth + 1) + "/" + mYear;
                        departDate1.setText("Depart Date: " + storeDate2);
                    }
                }, day, month, year);
                dpd.show();

            }
        });

    }


    @Override

    public void onClick(View view) {
        if (view == buttonSearch) {

            String apiUrl = "https://api.skypicker.com/flights?flyFrom=PRG&to=LGW&dateFrom=17/11/2019&dateTo=18/11/2019&partner=picky";
            URL obj = new URL(GET_URL);
            Gson gson = new Gson();

            String json = gson.toJson(apiUrl);
            Toast.makeText(this, json, Toast.LENGTH_LONG).show();

        }

    }

}

