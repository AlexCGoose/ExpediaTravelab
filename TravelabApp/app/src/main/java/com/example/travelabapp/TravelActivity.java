package com.example.travelabapp;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TravelActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextFlightFrom, editTextFlightTo, editTextDepartDate, editTextReturnDate;
    private Button buttonSearch;
    final TextView textView = (TextView) findViewById(R.id.text);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        editTextFlightFrom = (EditText) findViewById(R.id.editTextFlightFrom);
        editTextFlightTo = (EditText) findViewById(R.id.editTextFlightTo);
        editTextDepartDate = (EditText) findViewById(R.id.editTextDepartDate);
        editTextReturnDate = (EditText) findViewById(R.id.editTextReturnDate);
        buttonSearch = (Button) findViewById(R.id.buttonSearch);

        buttonSearch.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == buttonSearch) {
            //TODO - Must change params to right format e.g. london_gb and 16/11/2019
//            String apiUrl = "https://api.skypicker.com/flights?fly_from="+editTextFlightFrom+"&fly_to="+editTextFlightTo+"&date_from="+editTextDepartDate+"&date_to="+editTextReturnDate+"&partner=picky&vehicle_type=aircraft";
            String apiUrl = "https://api.skypicker.com/flights?fly_from=london_gb&fly_to=cardiff_gb&date_from=16/11/2019&date_to=17/11/2019&partner=picky&vehicle_type=aircraft";
            RequestQueue queue = Volley.newRequestQueue(this);

            StringRequest stringRequest = new StringRequest(Request.Method.GET, apiUrl,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.

                            textView.setText("Response is: "+ response.substring(0,500));
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    textView.setText("That didn't work!");
                }
            });

// Add the request to the RequestQueue.
            queue.add(stringRequest);

        }

    }
}
