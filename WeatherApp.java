// Task 2 : REST API CLIENT
import java.net.http.*; // Importing the HttpClient and related classes
import java.net.URI; // Importing URI class for creating URIs
import java.util.Scanner; // Importing Scanner class  for taking input from the user

import com.google.gson.JsonObject; // Importing JsonObject class from Gson library for JSON parsing of the response
import com.google.gson.JsonParser;// Importing JsonParser class from Gson library for parsing received JSON strings

public class WeatherApp { // Main class for the Weather App
        public static void main(String[] args) throws Exception {  // Main method where the program execution starts can throw Exception
        Scanner scanner = new Scanner(System.in);  //Scanner object 

        //Asking to enter any city name
        System.out.print("Enter a city name: "); //Asking the user to enter a city name
        //Taking input from the user
        String city = scanner.nextLine();

        //My default API key I got from OpenWeatherMap
        String apiKey = "487ae44d386167dd51f2ff4b6080763b"; //My API key

        //Building the request URL
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" //API format for openweathermap
                    + city + "&appid=" + apiKey + "&units=metric";        //API format for openweathermap 

        //Http client for sending the request
        HttpClient client = HttpClient.newHttpClient(); // Creating a new HttpClient object
        HttpRequest request = HttpRequest.newBuilder() //requesting the weather data in builder format
                                .uri(URI.create(url)) // Creating a URI from the URL string
                                .build();// Building the request 

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());// Sending the request and getting the response as a String

        //Parsing the received JSON resonse
        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();

        // Displaying Weather Data of the city 
        if (json.has("main")) {
            JsonObject main = json.getAsJsonObject("main"); // Getting the "main" object from the JSON response
            double temp = main.get("temp").getAsDouble(); // Extracting the temperature from the "main" object as a double
            int humidity = main.get("humidity").getAsInt(); // Extracting the humidity from the "main" object as an int

            String description = json.getAsJsonArray("weather") // Getting the "weather" array from the JSON response
                                     .get(0).getAsJsonObject() // Accessing the first element of the "weather" array
                                     .get("description").getAsString(); // Extracting the weather description as a String

            System.out.println("\n*****Weather Information of " + city + "*****"); // Displaying the city name
            System.out.println("Temperature : " + temp + " °C");// Displaying the temperature in Celsius
            System.out.println("Humidity    : " + humidity + "%");// Displaying the humidity percentage
            System.out.println("Condition   : " + description);// Displaying the weather condition 
        } else {
            System.out.println("\nInvalid city name");// If the "main" object is not present,indicate an invalid city name
        }
    }
}
// for compiling use this "javac -cp gson-2.10.1.jar WeatherApp.java" in terminal
// for running use this "java -cp ".;gson-2.10.1.jar" WeatherApp" in terminal after compiling
// Sources used for making this program : Youtube , OpenWeatherMap API documentation ,ChatGpt
