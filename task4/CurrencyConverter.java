package task4;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class CurrencyConverter {
    private static final String API_KEY = "5561b61997cf448798de612d34534d98";
    private static final String API_URL = "https://openexchangerates.org/api/latest.json?app_id=" + API_KEY;

    public static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        // Fetch exchange rate data from API
        double exchangeRate = getExchangeRate(fromCurrency, toCurrency);
        
        // Perform currency conversion
        double convertedAmount = amount * exchangeRate;
        
        return convertedAmount;
    }

    private static double getExchangeRate(String fromCurrency, String toCurrency) {
        try {
            // Construct the URL for the API request
            String urlString = API_URL + "&symbols=" + fromCurrency + "," + toCurrency;
            URL url = new URL(urlString);
            
            // Send HTTP request to the API
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);  // Set connection timeout
            connection.setReadTimeout(5000);  // Set read timeout

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            
            // Parse the JSON response
            JSONObject jsonResponse = new JSONObject(response.toString());
            JSONObject rates = jsonResponse.getJSONObject("rates");

            // Get the exchange rate for the fromCurrency and toCurrency
            double fromRate = rates.getDouble(fromCurrency);
            double toRate = rates.getDouble(toCurrency);

            // Calculate and return the exchange rate between the two currencies
            return toRate / fromRate;
        } catch (Exception e) {
            System.err.println("Error fetching exchange rate: " + e.getMessage());
            return 1.0; // Default to 1:1 if there's an error
        }
    }

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	System.out.print("Enter the base currency:");
    	String fromCurrency = sc.next();
    	System.out.print("Enter the target currency:");
    	String toCurrency = sc.next();
    	
    	System.out.print("Enter the amount you want to convert:");
        double amount = sc.nextDouble();
      
        
        double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);
        convertedAmount=Math.round(convertedAmount*100.0)/100.0;
        System.out.println(amount + " " + fromCurrency + " is equal to " + convertedAmount + " " + toCurrency);
    }
}
