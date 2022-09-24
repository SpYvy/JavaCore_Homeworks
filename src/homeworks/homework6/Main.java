package homeworks.homework6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.FileInputStream;

import java.io.*;
import java.util.Properties;

public class Main {
    static Properties prop = new Properties();

    public static void main(String[] args) throws IOException {
        loadProperties();
        OkHttpClient client = new OkHttpClient();

        // Сегментированное построение URL
        HttpUrl url = new HttpUrl.Builder() //https://api.weather.yandex.ru/v2/forecast?lat=52.027766&lon=29.225816&lang=ru_RU&limit=5&extra=true
                .scheme("https")
                .host(prop.getProperty("BASE_HOST"))                           // api.weather.yandex.ru
                .addPathSegment(prop.getProperty("API_VERSION"))               // v2
                .addPathSegment(prop.getProperty("FORECAST"))                  // forecast
                .addQueryParameter("lat", prop.getProperty("LATITUDE"))  // Широта и
                .addQueryParameter("lon", prop.getProperty("LONGITUDE")) // долгота Санкт-Петербурга
                .addQueryParameter("lang", "ru_RU")                // Ответ на русском языке
                .addQueryParameter("limit", "5")                   // Запрос погоды на ближайшие 5 дней
                .build();

        System.out.println(url.toString());

        // Заголовок содержащий ключ API
        Request requesthttp = new Request.Builder()
                .addHeader("X-Yandex-API-Key", prop.getProperty("API_KEY"))
                .url(url)
                .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();
        System.out.println(jsonResponse);
    }

    private static void loadProperties() throws IOException {
        try(FileInputStream configFile = new FileInputStream("src/homeworks/homework6/homework6.properties")){
            prop.load(configFile);
        }
    }
}
