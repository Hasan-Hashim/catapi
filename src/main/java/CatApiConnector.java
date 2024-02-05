import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class CatApiConnector {

    private static final String API_KEY = "live_EqsnuIiqR4ML149RsngBSTDOwNd1w97P4PtNI1eY1ipWxmViCBWblO5ybhJ9qz1q";
    private static final String API_URL = "https://api.thecatapi.com/v1/images/search";

    public static void getCatData() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("x-api-key", API_KEY)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        parseJson(response.body());
    }

    private static void parseJson(String responseBody) {
        JSONArray jsonArray = new JSONArray(responseBody);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            System.out.println(jsonObject.toString(4)); // Print formatted JSON
        }
    }

    public static void main(String[] args) {
    try {
        getCatData();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
