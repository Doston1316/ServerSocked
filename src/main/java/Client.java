
public class Client {
        private long id;
        private long timestamp;
        private double lat;
        private double lon;
        private float speed;
        private float bearing;
        private double altitude;
        private double accuracy;
        private double bat;


    public Client(long id,
                  long timestamp,
                  double lat,
                  double lon,
                  float speed,
                  float bearing,
                  double altitude,
                  double accuracy,
                  double bat) {
        this.id = id;
        this.timestamp = timestamp;
        this.lat = lat;
        this.lon = lon;
        this.speed = speed;
        this.bearing = bearing;
        this.altitude = altitude;
        this.accuracy = accuracy;
        this.bat = bat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getBearing() {
        return bearing;
    }

    public void setBearing(float bearing) {
        this.bearing = bearing;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getBat() {
        return bat;
    }

    public void setBat(double bat) {
        this.bat = bat;
    }
}

