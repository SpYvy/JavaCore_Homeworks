package homeworks.homework7;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class YandexWeatherProvider {
    private final OkHttpClient client = new OkHttpClient();
    private final static String BASE_HOST = "api.weather.yandex.ru";
    private final static String API_VERSION = "v2";
    private final static String FORECAST = "forecast";
    private final static String API_KEY = "0430abb7-a0de-4c95-8c0b-129952f1e484";

    public void getWeather(String period) throws IOException {
        if (period == "NOW") {
            HttpUrl url = new HttpUrl.Builder() //https://api.weather.yandex.ru/v2/forecast?lat=52.027766&lon=29.225816&lang=ru_RU&limit=1&extra=true
                    .scheme("https")
                    .host(BASE_HOST)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(FORECAST)
                    .addQueryParameter("lat", ApplicationGlobalState.getInstance().getLatitude())
                    .addQueryParameter("lon", ApplicationGlobalState.getInstance().getLongitude())
                    .addQueryParameter("lang", "ru_RU")// Ответ на русском языке
                    .addQueryParameter("limit", "1")   // Запрос погоды на ближайшие 5 дней
                    .build();
            // Заголовок содержащий ключ API
            Request request = new Request.Builder()
                    .addHeader("X-Yandex-API-Key", API_KEY)
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            String jsonResponse = response.body().string();

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode country = objectMapper
                    .readTree(jsonResponse)
                    .at("/geo_object/country/name");

            JsonNode locality = objectMapper
                    .readTree(jsonResponse)
                    .at("/geo_object/locality/name");

            JsonNode date = objectMapper
                    .readTree(jsonResponse)
                    .at("/forecasts/0/date");

            JsonNode condition = objectMapper
                    .readTree(jsonResponse)
                    .at("/forecasts/0/parts/day_short/condition");
            String fineCondition = getFineCondition(condition.asText());     // Делаю названия погодных условий читабельными

            JsonNode temperature = objectMapper
                    .readTree(jsonResponse)
                    .at("/forecasts/0/parts/day_short/temp");

            System.out.println("Cтрана: " + country.asText() + ", город: " + locality.asText() + ":\n" +
                    "Сегодня, " + date.asText() + " " + fineCondition + ", температура: " + temperature + "°C");

        } else if (period == "FIVE_DAYS") {
            HttpUrl url = new HttpUrl.Builder() //https://api.weather.yandex.ru/v2/forecast?lat=52.027766&lon=29.225816&lang=ru_RU&limit=5&extra=true
                    .scheme("https")
                    .host(BASE_HOST)
                    .addPathSegment(API_VERSION)
                    .addPathSegment(FORECAST)
                    .addQueryParameter("lat", ApplicationGlobalState.getInstance().getLatitude())
                    .addQueryParameter("lon", ApplicationGlobalState.getInstance().getLongitude())
                    .addQueryParameter("lang", "ru_RU")// Ответ на русском языке
                    .addQueryParameter("limit", "5")   // Запрос погоды на ближайшие 5 дней
                    .build();
            // Заголовок содержащий ключ API
            Request request = new Request.Builder()
                    .addHeader("X-Yandex-API-Key", API_KEY)
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            String jsonResponse = response.body().string();

            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode country = objectMapper
                    .readTree(jsonResponse)
                    .at("/geo_object/country/name");

            JsonNode locality = objectMapper
                    .readTree(jsonResponse)
                    .at("/geo_object/locality/name");
            System.out.println("Cтрана: " + country.asText() + ", город: " + locality.asText() + ":");

            for(int i = 0; i < 5; i++){
                JsonNode date = objectMapper
                        .readTree(jsonResponse)
                        .at("/forecasts/" + i + "/date");

                JsonNode condition = objectMapper
                        .readTree(jsonResponse)
                        .at("/forecasts/" + i + "/parts/day_short/condition");
                String fineCondition = getFineCondition(condition.asText());   // Делаю названия погодных условий читабельными


                JsonNode temperature = objectMapper
                        .readTree(jsonResponse)
                        .at("/forecasts/" + i + "/parts/day_short/temp");
                System.out.println("Днём " + date.asText() + " будет " + fineCondition + ", температура: " + temperature + "°C");
            }
        }
    }
    private String getFineCondition(String jsonCondition) {
        String result = switch (jsonCondition) {
            case "clear" -> "ясно";
            case "partly-cloudy" -> "малооблачно";
            case "cloudy" -> "облачно с прояснениями";
            case "overcast" -> "пасмурно";
            case "drizzle" -> "морось";
            case "light-rain" -> "небольшой дождь";
            case "rain" -> "дождь";
            case "moderate-rain" -> "умеренно сильный дождь";
            case "heavy-rain" -> "сильный дождь";
            case "continuous-heavy-rain" -> "длительный сильный дождь";
            case "showers" -> "ливень";
            case "wet-snow" -> "дождь со снегом";
            case "light-snow" -> "небольшой снег";
            case "snow" -> "снег";
            case "snow-showers" -> "снегопад";
            case "hail" -> "град";
            case "thunderstorm" -> "гроза";
            case "thunderstorm-with-rain" -> "дождь с грозой";
            case "thunderstorm-with-hail" -> "гроза с градом";
            default -> null;
        };
        return result;
    }
}
