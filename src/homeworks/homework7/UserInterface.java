package homeworks.homework7;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {
    private final Controller controller = new Controller();

    public void runApplication() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            while (true) {
                System.out.println();
                System.out.println("Введите название города.");
                String city = scanner.nextLine();
                checkIfExit(city);

                YandexCoordinatesProvider ycp = new YandexCoordinatesProvider();
                String coordinates = ycp.getCoordinates(city);                          // Запускаю Геокодер для поиска координат

                String[] longLat = coordinates.split("\\s+");                     // Получаю две координаты искомого объекта
                // longLat => ["Долгота","Широта"]
                try {
                    setCoordinates(longLat);                                            // Запоминаю координаты
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Не найдено города по Вашему запросу.");
                    continue;
                }

                String cityFound = YandexCoordinatesProvider.getCityName();             // Уточняю, верен ли результат по запросу
                System.out.println("Результат по запросу: " + cityFound + ".\nПродолжить? 1 - Да, 2 - Ввести запрос еще раз.");
                String answer = scanner.nextLine();
                checkIfExit(answer);

                try {
                    validateUserInput(answer);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if(answer.equals("1")){
                    break;
                }
            }
            System.out.println("Введите ответ:\n1 - Получить текущую погоду,\n2 - Получить погоду на следующие 5 дней,\n" +
                    "Выход (exit) - завершить работу.");
            String result = scanner.nextLine();
            checkIfExit(result);

            try {
                validateUserInput(result);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            try {
                notifyController(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void setCoordinates(String[] longLat) {
        ApplicationGlobalState.getInstance().setLongitude(longLat[0]);          // Устанавливаю долготу
        ApplicationGlobalState.getInstance().setLatitude(longLat[1]);           // Устанавливаю широту
    }
    private void checkIfExit(String result) {
        if(result.toLowerCase().equals("выход") || result.toLowerCase().equals("exit")){
            System.out.println("Завершаю работу.");
            System.exit(0);
        }
    }

    private void validateUserInput(String userInput) throws IOException {
        if (userInput == null || userInput.length() != 1) {
            throw new IOException("Неверный запрос: ожидалась цифра как ответ, но вместо этого получил " + userInput);
        }
        int answer = 0;
        try {
            answer = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IOException("Неверный запрос: ответ не является цифрой!");
        }
    }

    private void notifyController(String input) throws IOException {
        controller.onUserInput(input);
    }
}
