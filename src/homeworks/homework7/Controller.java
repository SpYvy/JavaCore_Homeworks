package homeworks.homework7;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    YandexWeatherProvider weatherProvider = new YandexWeatherProvider();
    Map<Integer, String> variantResult = new HashMap<>();

    public Controller(){
        variantResult.put(1, "GET_CURRENT_WEATHER");
        variantResult.put(2, "GET_WEATHER_IN_NEXT_5_DAYS");
    }

    public void onUserInput(String input) throws IOException {
        int command = Integer.parseInt(input);
        if (!variantResult.containsKey(command)) {
            throw new IOException("Нет команды для запроса " + command);
        }

        switch (variantResult.get(command)) {
            case "GET_CURRENT_WEATHER":
                getCurrentWeather();
                break;
            case "GET_WEATHER_IN_NEXT_5_DAYS":
                getWeatherIn5Days();
                break;
        }
    }
    private void getCurrentWeather() throws IOException {
        weatherProvider.getWeather("NOW");
    }
    private void getWeatherIn5Days() throws IOException {
        weatherProvider.getWeather("FIVE_DAYS");
    }
}
