package com.example.travelabapp;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TravelActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextFlightFrom, editTextFlightTo, editTextDepartDate, editTextReturnDate;
    private Button buttonSearch;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        editTextFlightFrom = (EditText) findViewById(R.id.editTextFlightFrom);
        editTextFlightTo = (EditText) findViewById(R.id.editTextFlightTo);
        editTextDepartDate = (EditText) findViewById(R.id.editTextDepartDate);
        editTextReturnDate = (EditText) findViewById(R.id.editTextReturnDate);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);
        textView = (TextView) findViewById(R.id.text);

        buttonSearch.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view == buttonSearch) {
            //TODO - Must change params to right format e.g. london_gb and 16/11/2019
//            String apiUrl = "https://api.skypicker.com/flights?fly_from="+editTextFlightFrom+"&fly_to="+editTextFlightTo+"&date_from="+editTextDepartDate+"&date_to="+editTextReturnDate+"&partner=picky&vehicle_type=aircraft";
            String apiUrl = "https://api.skypicker.com/flights?flyFrom=PRG&to=LGW&dateFrom=17/11/2019&dateTo=18/11/2019&partner=picky";
            RequestQueue queue = Volley.newRequestQueue(this);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                    (Request.Method.GET, apiUrl, null, new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            textView.setText("Response: " + response.toString().substring(0, 500));
                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO: Handle error
                            textView.setText("That didn't work!" + error);
                        }
                    });

// Access the RequestQueue through your singleton class.
            queue.add(jsonObjectRequest);

        }

    }
}
