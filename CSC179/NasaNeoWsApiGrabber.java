//BgRCHR9hPq5hff9I0mqe08wOUOsUSPMbAuJWHzaU
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NasaNeoWsApiGrabber {

    public static void main(String[] args) {
        String apiKey = "BgRCHR9hPq5hff9I0mqe08wOUOsUSPMbAuJWHzaU";  
        String startDate = "2024-06-05";
        String endDate = "2024-06-05";
        String urlString = String.format(
            "https://api.nasa.gov/neo/rest/v1/feed?start_date=%s&end_date=%s&api_key=%s",
            startDate, endDate, apiKey
        );

        try {
            // Create URL object
            URL url = new URL(urlString);
            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Print the response
                System.out.println(response.toString());
            } else {
                System.out.println("GET request not worked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
