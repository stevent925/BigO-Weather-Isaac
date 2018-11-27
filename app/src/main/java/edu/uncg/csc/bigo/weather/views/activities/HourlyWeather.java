package edu.uncg.csc.bigo.weather.views.activities;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import edu.uncg.csc.bigo.weather.R;
import edu.uncg.csc.bigo.weather.controllers.WeatherController;
import edu.uncg.csc.bigo.weather.models.util.Globals;


/**
 * A simple {@link Fragment} subclass.
 */
public class HourlyWeather extends Fragment {


    private TextView mTextMessage;
    private TextView TextViewZipFormat;
    private EditText editTextZip;
    private Button button;



    public HourlyWeather() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_hourly_weather, container, false);

        //Initialize the EditText box.
        editTextZip = (EditText) v.findViewById(R.id.editTextZip);

        //Initialize the button
        button = (Button) v.findViewById(R.id.button);

        //Initialize the message TextView box
        mTextMessage = (TextView) v.findViewById(R.id.hourlyMessage);

        //Initialize the formatting message TextView box
        TextViewZipFormat = (TextView) v.findViewById(R.id.TextViewZipFormat);

        //Set the button to listen for clicks, and do something when it hears one.

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View view = getView();
        if (view != null) {
            view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Make sure the user inputs a properly formatted zip.
                    if (editTextZip.getText().toString().length() < 5 || editTextZip.getText().toString().isEmpty()) {
                        TextViewZipFormat.setText("Enter a Properly Formatted Zip");
                        mTextMessage.setText(" ");
                        editTextZip.setText("");
                    } else if (editTextZip.getText().toString().length() > 5) {
                        TextViewZipFormat.setText("Enter a Properly Formatted Zip");
                        mTextMessage.setText(" ");
                        editTextZip.setText("");
                    }
                    //If the zip is correctly formatted assign it to zipCode
                    else if (editTextZip.getText().toString().length() == 5) {
                        int zipCode = Integer.valueOf(editTextZip.getText().toString());
                        TextViewZipFormat.setText("");
                        new Test().execute();
                    }
                }
            });
        }
    }


    /**
     * This is where we will test things
     */
    public class Test extends AsyncTask<Void, Void, String> {


        protected String doInBackground(Void... nothing) {
            try {


                // Store a message buffer to append strings to.
                StringBuffer message = new StringBuffer();

                //Get the zipcode entered by the user.
                int zipCode = Integer.valueOf(editTextZip.getText().toString());


                //Testing the WeatherController methods
                message.append("Hourly: \n");
                String[][] testHourlyWeatherForecastController = WeatherController.getWeatherHourlyForecast(zipCode);
                message.append(testHourlyWeatherForecastController[0][Globals.CITY_STATE_ZIP]+"\n");
                for (int i = 0; i<12; i++){
                    message.append(testHourlyWeatherForecastController[i][Globals.TIME]+"\n");
                    message.append(testHourlyWeatherForecastController[i][Globals.SUMMARY]+"\n");
                    message.append(testHourlyWeatherForecastController[i][Globals.TEMPERATURE]+"\n\n");
                    message.append(testHourlyWeatherForecastController[i][Globals.ICON]+"\n\n");
                }


                return message.toString();
            } catch (Exception exception) {
                return exception.toString();
            }
        }


        protected void onPostExecute(String result) {
            mTextMessage.setText(result);
        }
    }

}
