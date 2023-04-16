import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // System.out.println("Hello world!");
        String url="https://api.zippopotam.us/us/33162";

        //Building a request
        HttpRequest request=HttpRequest.newBuilder().GET().uri(URI.create(url)).build();

        //Getting the HttpClient object
        HttpClient httpClient=HttpClient.newBuilder().build();

        HttpResponse<String> httpResponse = httpClient.send(request,HttpResponse.BodyHandlers.ofString());

        //statusCode and body
        System.out.println(httpResponse.statusCode());
        System.out.println(httpResponse.body());
    }
}