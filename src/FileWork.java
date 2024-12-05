import java.io.*;

public class FileWork {

    public static void saveMatrixToBinaryFile(Matrix matrix, String fileName) {
        // Проверяем, что файл имеет расширение ".bin", если нет — добавляем его
        if (!fileName.toLowerCase().endsWith(".bin")) {
            fileName += ".bin";
        }

        // Потоки для записи данных в бинарный файл
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            // Определяем количество строк и столбцов в матрице
            int rows = matrix.getData().length;
            int cols = matrix.getData()[0].length;

            // Записываем размеры матрицы
            dos.writeInt(rows);
            dos.writeInt(cols);

            // Записываем элементы матрицы
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    dos.writeInt(matrix.getData()[i][j]);
                }
            }

            System.out.println("Матрица успешно сохранена в бинарный файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public static Matrix inputMatrixFromFile(String fileName) {
        // Проверяем, что файл имеет расширение ".bin"
        if (!fileName.toLowerCase().endsWith(".bin")) {
            System.out.println("Ошибка: файл должен быть бинарным (расширение .bin).");
            return null; // Возвращаем null, чтобы сигнализировать об ошибке
        }

        Matrix matrix = null;

        // Открываем поток для чтения бинарного файла
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            // Проверка, пуст ли файл
            if (dis.available() == 0) { // Возвращает количество оставшихся байт для чтения
                System.out.println("Ошибка, файл пуст");
                return null; // Если пуст, то возвращаем null
            }

            // Устанавливаем размеры матрицы
            int rows = dis.readInt();
            int cols = dis.readInt();

            // Проверяем, что размеры положительные
            if (rows <= 0 || cols <= 0) {
                System.out.println("Ошибка, количество строк и столбцов должно быть положительным");
                return null; // Если размеры не подходят, возвращаем null
            }

            // Создаем матрицу заданного размера
            matrix = new Matrix(rows, cols);

            // Чтение и проверка элементов матрицы
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (dis.available() < Integer.BYTES) { // Если данных меньше, чем нужно
                        System.out.println("Ошибка, недостаточно данных для матрицы");
                        return null; // Если данных недостаточно, возвращаем null
                    }
                    matrix.getData()[i][j] = dis.readInt(); // Чтение элемента
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка при обработке данных: " + e.getMessage());
        }

        return matrix;
    }
    // метод сохранения матрицы в текстовый файл
    public static void saveMatrixToTextFile(Matrix matrix, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Записываем размеры матрицы
            int rows = matrix.getData().length;
            int cols = matrix.getData()[0].length;
            writer.write(rows + " " + cols); // Размеры через пробел
            writer.newLine();

            // Записываем элементы матрицы
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    writer.write(matrix.getData()[i][j] + " ");
                }
                writer.newLine(); // Переход на новую строку после записи каждого ряда
            }

            System.out.println("Матрица успешно сохранена в текстовый файл: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    private String text;  // Поле для хранения текста

    // Метод чтения текста из файла
    public void readTextFromFile(String fileName) {
        // Проверяем, не является ли имя файла пустым
        if (fileName == null || fileName.isEmpty()) {
            System.out.println("Ошибка, имя файла не может быть пустым");
            return;
        }

        // Проверка на существование файла
        File file = new File(fileName); // Создаем объект класса файл, для работы с файлом
        if (!file.exists()) { // Проверяет, существует ли он
            System.out.println("Ошибка, файл не существует");
            return;
        }

        // Проверка существования и пустоты файла
        if (!file.exists()) {
            System.out.println("Ошибка: Файл не существует.");

        } else if (file.length() == 0) {
            System.out.println("Ошибка: Файл пуст.");
        }


        // BufferedReader для построчного чтения файла
        // FileReader(fileName) открываем файл для чтения
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder fileText = new StringBuilder(); // Для обработки строк
            String line; // Переменная для хранения текущей строки из файла
            // line = следующая строка не пуста (файл не кончился)
            while ((line = reader.readLine()) != null) {
                fileText.append(line).append(" "); // Добавляем прочитанную строку к объекту через пробел
            }
            this.text = fileText.toString().trim(); // Преобразуем полученную строку в обычную и убираем лишние пробелы
            System.out.println("Текст прочитан из файла");
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    // Метод записи текста с результатом в файл
    public void writeTextToFile(String fileName, String result) {
        // Проверка пустое ли имя
        if (fileName == null || fileName.isEmpty()) {
            System.out.println("Ошибка, имя файла не может быть пустым");
            return;
        }

        // Проверка на пустой результат
        if (result == null || result.isEmpty()) {
            System.out.println("Ошибка, результат не может быть пустым");
            return;
        }

        // Проверка на нужное расширение файла (.txt)
        if (!fileName.endsWith(".txt")) {
            System.out.println("Ошибка, имя файла должно заканчиваться на '.txt'");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(result); // Записываем результат
            System.out.println("Результат записан в файл");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
        }
    }
    public String getText() {
        return this.text; // Где text — это поле, которое хранит текст.
    }

}
