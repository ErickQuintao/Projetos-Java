/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package sistemacomercial.movie.api;
import java.net.URLEncoder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.UnsupportedEncodingException;
public class MovieApi {

    public static void main(String[] args) throws UnirestException, UnsupportedEncodingException {
       // Host url
      String host = "https://movie-database-imdb-alternative.p.rapidapi.com/";
      String charset = "UTF-8";
      // Headers for a request
      String x_rapidapi_host = "moviesdatabase.p.rapidapi.com";
      String x_rapidapi_key = "73c9f7a09cmsh7a6e0b199996c81p1cc293jsn39b17e71d1bb";
      // Params
      String s = "Pulp";
  // Format query for preventing encoding problems
      String query = String.format("s=%s",
       URLEncoder.encode(s,charset));
      HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
      .header("x-rapidapi-host", x_rapidapi_host)
      .header("x-rapidapi-key", x_rapidapi_key)
      .asJson();
    System.out.println(response.getStatus());
      System.out.println(response.getHeaders().get("Content-Type"));
    }
}
