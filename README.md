# REST-API-CLIENT

*COMPANY*: CODTECH IT SOLUTIONS

*NAME*: Pranay Jha 

*INTERN ID*: CT04DH539

*DOMAIN*: Java Programming 

*DURATION*: 4 WEEKS

*MENTOR*: NEELA SANTOSH

##Weather App using Java and OpenWeatherMap API

This project is a simple yet functional Java-based REST API client that fetches real-time weather information from a public API. The goal of this task was to create a command-line application in Java that takes a city name as input, makes an HTTP GET request to the OpenWeatherMap API, and displays key weather details such as temperature, humidity, and weather conditions in a readable and structured format.

The application starts by prompting the user to enter the name of any city. This city name is captured using Java’s Scanner class. The program then constructs a request URL based on the OpenWeatherMap API’s endpoint and includes the user-provided city name, a valid API key (generated from the OpenWeatherMap account), and additional query parameters like units set to metric (to get temperature in Celsius).

Once the URL is constructed, the Java HttpClient (introduced in Java 11) is used to send the HTTP GET request to the API. This request returns a response in JSON format. The program uses the external Gson library (Google’s JSON parser for Java) to parse the returned JSON string. Important weather data is extracted from this JSON response, such as:

The temperature (temp)

The humidity (humidity)

A short description of the current weather condition (like “clear sky” or “light rain”)

The program then neatly prints this information in a clear format so that the user can understand the current weather status of the city they searched for. If the user enters an invalid city name, the program checks if the "main" object exists in the response. If it doesn't, a message is shown indicating that the city name is invalid. This provides basic validation to ensure a good user experience and prevents the program from crashing due to unexpected input.

The code is thoroughly commented to help absolute beginners understand each step. It covers key Java concepts such as user input, HTTP communication, string manipulation, JSON parsing, error handling, and console output formatting. The project also introduces the structure of RESTful APIs and how query parameters are used in URLs to customize API requests.

This project is designed to help beginners understand how real-time data can be fetched and used in a Java application. It demonstrates how modern Java features like HttpClient and open-source libraries like Gson can be used to build real-world applications. Through this project, I learned how APIs work, how to interact with them using Java, and how to parse and display JSON responses. I also became familiar with OpenWeatherMap's API documentation and understood the importance of API keys and request formatting.

Technologies used:

Java 11

OpenWeatherMap REST API

Gson (Google’s JSON library)

VS Code and Command Line

Resources: YouTube, ChatGPT, and OpenWeatherMap Docs

In summary, this weather app project is a hands-on implementation of working with public APIs in Java. It fulfills all the given requirements and serves as a strong foundation for future projects involving HTTP requests and JSON parsing in Java.


