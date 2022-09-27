package homeworks.homework7;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class YandexCoordinatesProvider {
    private final OkHttpClient client = new OkHttpClient();
    private final static String BASE_HOST = "geocode-maps.yandex.ru";
    private final static String API_VERSION = "1.x";
    private final static String API_KEY = "b9a5809d-a47d-46a8-b272-5479c6d120b4";

    public static String getCityName() {
        return cityName;
    }

    public static void setCityName(String cityName) {
        YandexCoordinatesProvider.cityName = cityName;
    }

    private static String cityName;

    public String getCoordinates(String cityName) throws IOException {

        HttpUrl url = new HttpUrl.Builder() //https://geocode-maps.yandex.ru/1.x?geocode=CITYNAME&apikey=b9a5809d-a47d-46a8-b272-5479c6d120b4&format=json
                .scheme("https")
                .host(BASE_HOST)
                .addPathSegment(API_VERSION)
                .addQueryParameter("geocode", cityName)
                .addQueryParameter("results", "1") // В ответе будет самый вероятный результат
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("format", "json")
                .build();

        //Выполнить запрос
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String jsonResponse = response.body().string();

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode cityFound = objectMapper
                .readTree(jsonResponse)
                .at("/response/GeoObjectCollection/featureMember/0/GeoObject/metaDataProperty/GeocoderMetaData/text");
        setCityName(cityFound.asText());

        JsonNode coordinates = objectMapper
                .readTree(jsonResponse)
                .at("/response/GeoObjectCollection/featureMember/0/GeoObject/Point/pos");
        return coordinates.asText();
    }
}
