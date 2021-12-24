
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.List;

public class main {
    private static String getParamValue(String link, String paramName) throws URISyntaxException {
        List<NameValuePair> queryParams = new URIBuilder(link).getQueryParams();
        return queryParams.stream()
                .filter(param -> param.getName().equalsIgnoreCase(paramName))
                .map(NameValuePair::getValue)
                .findFirst()
                .orElse("");
    }

    private static Client client;
    public static final String userName = "TaskSetApp";
    public static final String password = "1316";
    private static Connection con = null;
    private static String connectionUrl = "jdbc:postgresql://localhost:5432/TaskSetApp";

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(8080);
            Socket clientSocket = serverSocket.accept();

//            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String str = in.readLine();
                String url = str.substring(6);
                String link = url.substring(0, url.length() - 9);
                client = new Client(
                        Long.parseLong(getParamValue(link, "id")),
                        Long.parseLong(getParamValue(link, "timestamp")),
                        Double.parseDouble(getParamValue(link, "lat")),
                        Double.parseDouble(getParamValue(link, "lon")),
                        Float.parseFloat(getParamValue(link, "speed")),
                        Float.parseFloat(getParamValue(link, "bearing")),
                        Double.parseDouble(getParamValue(link, "altitude")),
                        Double.parseDouble(getParamValue(link, "accuracy")),
                        Double.parseDouble(getParamValue(link, "bat")));
                serverSocket.close();
                con = PostgreConnection.getInstance(connectionUrl);
                saveClient();
//            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    private static void saveClient() {
        try (Statement statement = con.createStatement()) {
            statement.executeUpdate("INSERT INTO Client(" +
                    "id, timestamp, lat, lon, speed, bearing, altitude, accuracy, bat) VALUES (" +
                    client.getId() + "," +
                    client.getTimestamp() + "," +
                    client.getLat() + "," +
                    client.getLon() + "," +
                    client.getSpeed() + "," +
                    client.getBearing() + "," +
                    client.getAltitude() + "," +
                    client.getAccuracy() + "," +
                    client.getBearing() + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}