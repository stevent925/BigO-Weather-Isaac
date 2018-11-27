package edu.uncg.csc.bigo.weather.views.activities;


import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import edu.uncg.csc.bigo.weather.R;
import edu.uncg.csc.bigo.weather.controllers.WeatherController;
import edu.uncg.csc.bigo.weather.models.weather.Icons;
import edu.uncg.csc.bigo.weather.models.weather.WeatherData;
import edu.uncg.csc.bigo.weather.models.weather.WeatherDataBuilder;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentWeather extends Fragment {


    private TextView mTextMessage;
    private TextView TextViewZipFormat;
    private EditText editTextZip;
    private Button button;
    private ImageView image;


    public CurrentWeather() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_current_weather, container, false);

        //Initialize the EditText box.
        editTextZip = (EditText) v.findViewById(R.id.editTextZip);

        //Initialize the button
        button = (Button) v.findViewById(R.id.button);

        //Initialize the message TextView box
        mTextMessage = (TextView) v.findViewById(R.id.currentMessage);

        //Initialize the formatting message TextView box
        TextViewZipFormat = (TextView) v.findViewById(R.id.TextViewZipFormat);

        //Initialize the image box
        image = (ImageView) v.findViewById(R.id.imageView);

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
                message.append("Currently: \n");
                String[] testCurrentWeatherController = WeatherController.getWeatherCurrent(zipCode);

                message.append("Temperature: " + testCurrentWeatherController[18] + "\n");
                message.append("Summary: " + testCurrentWeatherController[3] + "\n");
                message.append("Precipitation: " + testCurrentWeatherController[2] + "\n");
                message.append("Humidity: " + testCurrentWeatherController[7] + "\n");
                message.append("Wind Speed: " + testCurrentWeatherController[17] + "\n");
                message.append("Icon: " + testCurrentWeatherController[21] + "\n");

                switch (testCurrentWeatherController[21]) {
                    case "clear-day":
                        Icons clear_day = Icons.valueOf("Clear_day".toUpperCase(Locale.ENGLISH));
                        image.setImageResource(clear_day.getIconResId());
                        break;

                    case "clear-night":
                        Icons clear_night = Icons.valueOf("Clear_night".toUpperCase(Locale.ENGLISH));
                        image.setImageResource(clear_night.getIconResId());
                        break;

                    case "cloudy":
                        Icons cloudy = Icons.valueOf("Cloudy".toUpperCase(Locale.ENGLISH));
                        image.setImageResource(cloudy.getIconResId());
                        break;

                    case "fog":
                        Icons fog = Icons.valueOf("Fog".toUpperCase(Locale.ENGLISH));
                        image.setImageResource(fog.getIconResId());
                        break;

                    case "partly-cloudy-day":
                        Icons partly_cloudy_day = Icons.valueOf("Partly_cloudy_day".toUpperCase(Locale.ENGLISH));
                        image.setImageResource(partly_cloudy_day.getIconResId());
                        break;

                    case "partly-cloudy-night":
                        Icons partly_cloudy_night = Icons.valueOf("Partly_cloudy_night".toUpperCase(Locale.ENGLISH));
                        image.setImageResource(partly_cloudy_night.getIconResId());
                        break;

                    case "rain":
                        Icons rain = Icons.valueOf("Rain".toUpperCase(Locale.ENGLISH));
                        image.setImageResource(rain.getIconResId());
                        break;

                    case "sleet":
                        Icons sleet = Icons.valueOf("Sleet".toUpperCase(Locale.ENGLISH));
                        image.setImageResource(sleet.getIconResId());
                        break;

                    case "snow":
                        Icons snow = Icons.valueOf("Snow".toUpperCase(Locale.ENGLISH));
                        image.setImageResource(snow.getIconResId());
                        break;

                    case "wind":
                        Icons wind = Icons.valueOf("Wind".toUpperCase(Locale.ENGLISH));
                        image.setImageResource(wind.getIconResId());
                        break;
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
