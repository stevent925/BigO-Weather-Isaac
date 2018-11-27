package edu.uncg.csc.bigo.weather.models.weather;
/**
 * This class describes weather data at a given location and time.
 * You should NOT construct this directly. Use the WeatherDataBuilder object instead.
 *
 * @updated 11/14/2018
 * @authors Hao Zhang, John Isaac Wilkinson
 */


import edu.uncg.csc.bigo.weather.models.metrics.*;
import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;

import java.util.Date;


public class WeatherData {
    /**
     * All the properties of WeatherData objects are defined below.
     * Boxed values are used over primitives because some fields are optional.
     */

    private final Temperature apparentTemperature;
    private final Amount cloudCover;
    private final Temperature dewPoint;
    private final Amount humidity;
    private final LocationCoordinate location;
    private final Amount moonPhase;
    private final Distance nearestStormDistance;
    private final ColumnarDensity ozone;
    private final Speed precipitationIntensity;
    private final Amount precipitationProbability;
    private final Pressure pressure;
    private final String summary;
    private final Temperature temperature;
    private final Temperature temperatureHigh;
    private final Temperature temperatureLow;
    private final Date time;
    private final Integer uvIndex;
    private final Distance visibility;
    private final Speed windGust;
    private final Speed windSpeed;
    private final String icon;

    //ADD COMMENT @PARAM FOR TEMPERATURE HIGH HERE VVVVVVVV

    /**
     * This constructs an object containing weather data.
     * Most of the logic are actually defined in the WeatherDataBuilder object. Check there for more
     * details.
     *
     * @param _apparentTemperature      The apparent temperature
     * @param _cloudCover               The cloud cover in percent ratio
     * @param _dewPoint                 The dew point
     * @param _humidity                 The humidity in percent ratio
     * @param _location                 The location
     * @param _moonPhase                The lunation number
     * @param _nearestStormDistance     The nearest storm distance
     * @param _ozone                    The ozone columnar density
     * @param _precipitationIntensity   The precipitation intensity
     * @param _precipitationProbability The precipitation probability
     * @param _pressure                 The pressure
     * @param _summary                  The summary message indicating the general conditions in plain English
     * @param _temperature              The temperature
     * @param _temperatureHigh          The daily high
     * @param _temperatureLow           the daily low
     * @param _time                     The time when the weather data was generated
     * @param _uvIndex                  The ultraviolet index
     * @param _visibility               The visibility
     * @param _windGust                 The wind gust
     * @param _windSpeed                The wind speed
     * @param _icon
     */
    protected WeatherData(
            Temperature _temperatureHigh,
            Temperature _temperatureLow,
            Temperature _apparentTemperature,
            Amount _cloudCover,
            Temperature _dewPoint,
            Amount _humidity,
            LocationCoordinate _location,
            Amount _moonPhase,
            Distance _nearestStormDistance,
            ColumnarDensity _ozone,
            Speed _precipitationIntensity,
            Amount _precipitationProbability,
            Pressure _pressure,
            String _summary,
            Temperature _temperature,
            Date _time,
            Integer _uvIndex,
            Distance _visibility,
            Speed _windGust,
            Speed _windSpeed,
            String _icon
    ) {

        this.apparentTemperature = _apparentTemperature;
        this.cloudCover = _cloudCover;
        this.dewPoint = _dewPoint;
        this.humidity = _humidity;
        this.location = _location;
        this.moonPhase = _moonPhase;
        this.nearestStormDistance = _nearestStormDistance;
        this.ozone = _ozone;
        this.precipitationIntensity = _precipitationIntensity;
        this.precipitationProbability = _precipitationProbability;
        this.pressure = _pressure;
        this.summary = _summary;
        this.temperature = _temperature;
        this.temperatureHigh = _temperatureHigh;
        this.temperatureLow = _temperatureLow;
        this.time = _time;
        this.uvIndex = _uvIndex;
        this.visibility = _visibility;
        this.windGust = _windGust;
        this.windSpeed = _windSpeed;
        this.icon = _icon;
    }


    /**
     * All the field getters are defined below this comment.
     */

    //ADDED TEMPERATURE HIGH HERE
    public Temperature getApparentTemperature() {
        return this.apparentTemperature;
    }


    public Amount getCloudCover() {
        return this.cloudCover;
    }


    public Temperature getDewPoint() {
        return this.dewPoint;
    }


    public Amount getHumidity() {
        return this.humidity;
    }


    public LocationCoordinate getLocation() {
        return this.location;
    }


    public Amount getMoonPhase() {
        return this.moonPhase;
    }


    public Distance getNearestStormDistance() {
        return this.nearestStormDistance;
    }


    public ColumnarDensity getOzone() {
        return this.ozone;
    }


    public Speed getPrecipitationIntensity() {
        return this.precipitationIntensity;
    }


    public Amount getPrecipitationProbability() {
        return this.precipitationProbability;
    }


    public Pressure getPressure() {
        return this.pressure;
    }


    public String getSummary() {
        return this.summary;
    }

    public Temperature getTemperature() {
        return this.temperature;
    }


    public Temperature getTemperatureHigh() {
        return this.temperatureHigh;
    }


    public Temperature getTemperatureLow() {
        return this.temperatureLow;
    }


    public Date getTime() {
        return this.time;
    }


    public Integer getUVIndex() {
        return this.uvIndex;
    }


    public Distance getVisibility() {
        return this.visibility;
    }


    public Speed getWindGust() {
        return this.windGust;
    }


    public Speed getWindSpeed() {
        return this.windSpeed;
    }

    public String getIcon() {
        return this.icon;
    }


    @Override
    public String toString() {
        return String.format(
                "WeatherData[%s] {\n" +
                        "\tApparentTemperature: %s\n" +
                        "\tCloudCover: %s\n" +
                        "\tDewPoint: %s\n" +
                        "\tHumidity: %s\n" +
                        "\tLocation: %s\n" +
                        "\tMoonPhase: %s\n" +
                        "\tNearestStormDistance: %s\n" +
                        "\tOzone: %s\n" +
                        "\tPrecipitationIntensity: %s\n" +
                        "\tPrecipitationProbability: %s\n" +
                        "\tPressure: %s\n" +
                        "\tSummary: %s\n" +
                        "\tIcon: %s\n" +
                        "\tTemperature: %s\n" +
                        "\tUVIndex: %s\n" +
                        "\tVisibility: %s\n" +
                        "\tWindGust: %s\n" +
                        "\tWindSpeed: %s\n" +
                        "\tTemperatureHigh: %s\n" +
                        "\tTemperatureLow: %s\n" +
                        "}",

                this.apparentTemperature,
                this.cloudCover,
                this.dewPoint,
                this.humidity,
                this.location,
                this.moonPhase,
                this.nearestStormDistance,
                this.ozone,
                this.precipitationIntensity,
                this.precipitationProbability,
                this.pressure,
                this.summary,
                this.temperature,
                this.temperatureHigh,
                this.temperatureLow,
                this.time,
                this.uvIndex,
                this.visibility,
                this.windGust,
                this.windSpeed,
                this.icon
        );
    }
}