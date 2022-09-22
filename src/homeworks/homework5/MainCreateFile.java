package homeworks.homework5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainCreateFile {
    public static ArrayList<DataForFile> dataForFileArrayList = new ArrayList<>();
    public static final String pathToFile = "src/homeworks/homework5/file.csv";
    public static final String header = "value1" + ";" + "value2" + ";" +"value3" + ";" + System.getProperty("line.separator");

    public static void createDataForFile(){
        Random rand = new Random();

        for (int i = 1; i < 100; i++){
            dataForFileArrayList.add(new DataForFile(i, rand.nextInt(1000), rand.nextInt(10000)));
        }
    }

    public static void main(String[] args) throws IOException {
        createDataForFile();
        writer();

        AppData appData = fileToObject();
        FileWriter fw = new FileWriter(pathToFile);
        fw.write(123);
        save(appData);
    }

    public static void writer() throws IOException {
        try(FileWriter writer = new FileWriter(pathToFile);){
            writer.write(header);
            for (DataForFile data : dataForFileArrayList){
                writer.write(data.getValue1() + ";" + data.getValue2()
                        + ";" + data.getValue3() + ";" + System.getProperty("line.separator"));
            }
        }
    }

    public static AppData fileToObject() throws IOException{
        AppData appData = new AppData();
        List<List<String>> info = new ArrayList<>();        // Вспомогательный двумерный ArrayList для записи данных в виде квадрата n к 3
        try (BufferedReader buffReader = new BufferedReader(new FileReader(pathToFile))){
            String str = buffReader.readLine();             // Записываю в локальную переменную str каждую строку по очереди
            appData.setHeader(str.split(";"));        // Считываю строку с заголовком указав методу split разделитель ";"
            while((str = buffReader.readLine()) != null){   // В цикле пробегаюсь по каждой строке и если она не пустая, записываю ее в ранее объявленный ArrayList
                info.add(List.of(str.split(";")));
            }
        }
        int[][] resultInfo = new int[info.size()][3];       // Создаю локальный двумерный массив для записи данных из него в AppData.
                                                            // Количество строк определяется в размером ArrayList, а количество столбцов заранее известно как 3.
        for(int i = 0; i < info.size(); i++){
            for(int j = 0; j < info.get(i).size(); j++){
                resultInfo[i][j] = Integer.parseInt(info.get(i).get(j)); //Все данные из двумерного ArrayList передаю в двумерный массив.
            }
        }
        appData.setData(resultInfo);
        return appData;
    }

    public static void save(AppData data) throws IOException {          // Метод использует данные объекта AppData для записи их в file.scv
        ArrayList<DataForFile> newDataForFile = new ArrayList<>();      // Создаем вспомогательный ArrayList
        for (int i = 0; i < data.getData().length; i++){
            int value1 = 0, value2 = 0 , value3 = 0;
            for (int j = 0; j < data.getData()[i].length; j++){         // Читая через цикл содержание AppData сохраняем данные в переменные value1,2,3
                if (j == 0) value1 = data.getData()[i][j];
                if (j == 1) value2 = data.getData()[i][j];
                if (j == 2) value3 = data.getData()[i][j];
            }
            newDataForFile.add(new DataForFile(value1, value2, value3));// и далее в ArrayList
        }
        try(FileWriter writer = new FileWriter(pathToFile);) {          // Создаем writer для записи в file.csv
            writer.write(header);
            for (DataForFile dataForSave : newDataForFile) {
                writer.write(dataForSave.getValue1() + ";" + dataForSave.getValue2()
                        + ";" + dataForSave.getValue3() + ";" + System.getProperty("line.separator"));  // Записываем все данные из ArrayList в file.scv
            }
        }
    }
}
