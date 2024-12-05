import java.util.Scanner;
public class Menu {

    private static Scanner scanner = new Scanner(System.in); //сканер у нас один на весь класс, чтоб не создавать новые объекты и тд

    public Menu() {
        this.scanner = new Scanner(System.in); //поле сканер инициализируется объектом сканер. связанным с потоком ввода с клавиатуры
    }

    //Метод вызова меню
    public static void showMenu() {
        int choice;

        do {
            System.out.println("Выберите задачу:");
            System.out.println("1. Задача A");
            System.out.println("2. Задача B");
            System.out.println("3. Задача C");
            System.out.println("4. Задача D");
            System.out.println("5. Выход");
            System.out.print("Ваш выбор: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    taskA();
                    break;
                case 2:
                    taskB();
                    break;
                case 3:
                    taskC();
                    break;
                case 4:
                    taskD();
                    break;
                case 5:
                    System.out.println("Выход из программы...");
                    break;
                default:
                    System.out.println("Выберите от 1 до 5");
            }
        } while (choice != 5); //завершение программы при выборе 5
    }

    //Задача A
    private static void taskA() {
        int choice;
        Matrix matrix = new Matrix();
        boolean isDataEntered = false; //флаг, чтобы проверить ввод

        do {
            System.out.println("Выбрана: Задача A");
            System.out.println("a. На основе двумерной матрицы с целочисленными значениями сгенерировать новую матрицу, ");
            System.out.println("в которой элементы равны произведению соответствующих элементов исходной матрицы на сумму элементов исходной матрицы.");
            System.out.println("1. Ввести матрицу из консоли");
            System.out.println("2. Ввести из бинарного файла");
            System.out.println("3. Вывести результат");
            System.out.println("4. Сохранить матрицу в бинарный файл");
            System.out.println("5. Сохранить матрицу в текстовый файл");
            System.out.println("6. Вернуться в меню");
            System.out.print("Ваш выбор: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Ввод матрицы из консоли:");
                    inputMatrixFromConsole(matrix); //передаем matrix в метод
                    System.out.println("Исходная матрица:");
                    matrix.printMatrix();
                    isDataEntered = true;
                    break;
                case 2:
                    System.out.println("Ввод матрицы из бинарного файла:");
                    System.out.print("Введите имя файла: ");
                    String inputFile = scanner.next();
                    matrix = FileWork.inputMatrixFromFile(inputFile); //получаем матрицу из файла
                    //если матрицы нет, то
                    if (matrix == null) {
                        System.out.println("Ошибка при загрузке матрицы. Возвращаемся в меню.");
                        break; // Возвращаемся в меню
                    }
                    System.out.println("Исходная матрица:");
                    matrix.printMatrix();
                    isDataEntered = true;
                    break;
                case 3:
                    if (isDataEntered) {
                        System.out.println("Вывод результата:");
                        matrix.createMatrixOfMultiply(); // изменяем матрицу
                        matrix.printMatrix(); // выводим измененную матрицу
                    }
                    break;
                case 4:
                    if (isDataEntered) {
                        System.out.println("Сохранение в бинарный файл:");
                        System.out.print("Введите имя файла: ");
                        String binaryFile = scanner.next();
                        FileWork.saveMatrixToBinaryFile(matrix, binaryFile); //сохраняем в бинарный файл
                    } else {
                        System.out.println("Сначала введите данные матрицы.");
                    }
                    break;
                case 5:
                    if (isDataEntered) {
                        System.out.println("Сохранение в текстовый файл:");
                        System.out.print("Введите имя файла: ");
                        String textFile = scanner.next();
                        FileWork.saveMatrixToTextFile(matrix, textFile); //сохраняем в текстовый
                    } else {
                        System.out.println("Сначала введите данные матрицы.");
                    }
                    break;
                case 6:
                    System.out.println("Возвращение в меню");
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        } while (choice != 6);
    }

    // Задача B
    private static void taskB() {
        int choice;
        Matrix matrix = new Matrix();
        boolean isDataEntered = false;

        do {
            System.out.println("Выбрана: Задача B");
            System.out.println("b. Сдвинуть в правый край матрицы все элементы, равные нулю.");
            System.out.println("1. Ввести матрицу из консоли");
            System.out.println("2. Ввести из бинарного файла");
            System.out.println("3. Вывести результат");
            System.out.println("4. Сохранить матрицу в бинарный файл");
            System.out.println("5. Сохранить матрицу в текстовый файл");
            System.out.println("6. Вернуться в меню");
            System.out.print("Ваш выбор: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Ввод матрицы из консоли:");
                    inputMatrixFromConsole(matrix);
                    System.out.println("Исходная матрица:");
                    matrix.printMatrix();
                    isDataEntered = true;
                    break;
                case 2:
                    System.out.println("Ввод матрицы из бинарного файла:");
                    System.out.print("Введите имя файла: ");
                    String inputFile = scanner.next();
                    matrix = FileWork.inputMatrixFromFile(inputFile);
                    if (matrix == null) {
                        System.out.println("Ошибка при загрузке матрицы. Возвращаемся в меню.");
                        return; // Возвращаемся в меню
                    }
                    System.out.println("Исходная матрица:");
                    matrix.printMatrix();
                    isDataEntered = true;
                    break;
                case 3:
                    if (isDataEntered) {
                        System.out.println("Вывод результата:");
                        matrix.moveZeros(); //меняем её
                        matrix.printMatrix(); //выводим измененную матрицу
                    }
                    break;
                case 4:
                    if (isDataEntered) {
                        System.out.println("Сохранение в бинарный файл:");
                        System.out.print("Введите имя файла: ");
                        String binaryFile = scanner.next();
                        FileWork.saveMatrixToBinaryFile(matrix, binaryFile);
                    } else {
                        System.out.println("Сначала введите данные матрицы.");
                    }
                    break;
                case 5:
                    if (isDataEntered) {
                        System.out.println("Сохранение в текстовый файл:");
                        System.out.print("Введите имя файла: ");
                        String textFile = scanner.next();
                        FileWork.saveMatrixToTextFile(matrix, textFile);
                    } else {
                        System.out.println("Сначала введите данные матрицы.");
                    }
                    break;
                case 6:
                    System.out.println("Возвращение в меню");
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        } while (choice != 6);
    }

    // Задача C
    private static void taskC() {
        int choice;
        Matrix matrix = new Matrix();
        boolean isDataEntered = false;

        do {
            System.out.println("Выбрана: Задача C");
            System.out.println("c. Сгенерировать новую одномерную матрицу из элементов двумерной преобразованной матрицы, расположив элементы в порядке возрастания.");
            System.out.println("1. Ввести матрицу из консоли");
            System.out.println("2. Ввести из бинарного файла");
            System.out.println("3. Вывести результат");
            System.out.println("4. Сохранить матрицу в бинарный файл");
            System.out.println("5. Сохранить матрицу в текстовый файл");
            System.out.println("6. Вернуться в меню");
            System.out.print("Ваш выбор: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Ввод матрицы из консоли:");
                    inputMatrixFromConsole(matrix);
                    System.out.println("Исходная матрица:");
                    matrix.printMatrix();
                    isDataEntered = true;
                    break;
                case 2:
                    System.out.println("Ввод матрицы из бинарного файла:");
                    System.out.print("Введите имя файла: ");
                    String inputFile = scanner.next();
                    matrix = FileWork.inputMatrixFromFile(inputFile);
                    if (matrix == null) {
                        System.out.println("Ошибка при загрузке матрицы. Возвращаемся в меню.");
                        return;
                    }
                    System.out.println("Исходная матрица:");
                    matrix.printMatrix();
                    isDataEntered = true;
                    break;
                case 3:
                    if (isDataEntered) {
                        System.out.println("Вывод результата:");
                        Array oneMatr = matrix.matrixtoArray(); //преобразуем матрицу в массив
                        oneMatr.sort(); //сортируем массив
                        System.out.println("Итоговый массив:");
                        oneMatr.printArray(); //выводим итоговый массив
                    } else {
                        System.out.println("Сначала введите данные матрицы.");
                    }
                    break;
                case 4:
                    if (isDataEntered) {
                        System.out.println("Сохранение в бинарный файл:");
                        System.out.print("Введите имя файла: ");
                        String binaryFile = scanner.next();
                        FileWork.saveMatrixToBinaryFile(matrix, binaryFile);
                    } else {
                        System.out.println("Сначала введите данные матрицы.");
                    }
                    break;
                case 5:
                    if (isDataEntered) {
                        System.out.println("Сохранение в текстовый файл:");
                        System.out.print("Введите имя файла: ");
                        String textFile = scanner.next();
                        FileWork.saveMatrixToTextFile(matrix, textFile);
                    } else {
                        System.out.println("Сначала введите данные матрицы.");
                    }
                    break;
                case 6:
                    System.out.println("Возвращение в меню");
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        } while (choice != 6);
    }

    private static void taskD() {
        Scanner scanner = new Scanner(System.in);
        FileWork fileWork = new FileWork();
        String sentence = ""; //для хранения введенного предложения
        boolean isDataEntered = false; //флаг для проверки ввода данных
        int choice;

        do {
            System.out.println("Выбрана: Задача D");
            System.out.println("d. Найти количество слов в предложении, стоящих между самым коротким и самым длинным словом.");
            System.out.println("1. Ввести предложение из консоли");
            System.out.println("2. Ввести из файла");
            System.out.println("3. Вывести результат");
            System.out.println("4. Сохранить результат в файл");
            System.out.println("5. Вернуться в меню");
            System.out.print("Ваш выбор: ");

            choice = scanner.nextInt();
            scanner.nextLine(); //очистка буфера

            switch (choice) {
                case 1:
                    System.out.println("Ввод предложения из консоли:");
                    String sentenceInput;
                    do {
                        System.out.print("Введите предложение (только буквы, без чисел и символов): ");
                        sentenceInput = scanner.nextLine().trim();  //считываем строку и удаляем лишние пробелы

                        //проверка на пустое предложение
                        if (sentenceInput.isEmpty()) {
                            System.out.println("Ошибка, предложение не может быть пустым");
                        }

                        // Проверка на наличие цифр или символов
                        else if (!sentenceInput.matches("[a-zA-Zа-яА-ЯёЁ ]+")) { //проверяем соответствует ли шаблону
                            System.out.println("Ошибка, предложение может содержать только буквы и пробелы");
                        }

                    } while (sentenceInput.isEmpty() || !sentenceInput.matches("[a-zA-Zа-яА-ЯёЁ ]+"));

                    sentence = sentenceInput;  //записываем корректное предложение
                    isDataEntered = true; //помечаем флаг
                    break; //закончили ввод

                case 2:
                    System.out.println("Введите имя файла для чтения:");
                    String readFileName = scanner.nextLine();

                    //Проверка расширения файла
                    if (!readFileName.endsWith(".txt")) {
                        System.out.println("Ошибка, файл должен иметь расширение .txt");
                        break;
                    }

                    //Чтение текста из файла
                    fileWork.readTextFromFile(readFileName); //Чтение текста из файла
                    sentence = fileWork.getText(); //Получаем текст из объекта FileWork
                    System.out.println(sentence);
                    isDataEntered = true;
                    break;

                case 3:
                    if (isDataEntered) {
                        System.out.println("Вывод результата:");
                        String[] words = sentence.split(" "); // Разделяем предложение на слова
                        int[] lengths = new int[words.length]; // Массив длин слов
                        for (int i = 0; i < words.length; i++) {
                            lengths[i] = words[i].length(); // Заполняем массив длинами слов
                        }

                        //Находим индексы самого длинного и самого короткого слов
                        int minLengthIndex = 0, maxLengthIndex = 0;
                        for (int i = 1; i < words.length; i++) {
                            if (lengths[i] < lengths[minLengthIndex]) {
                                minLengthIndex = i;
                            }
                            if (lengths[i] > lengths[maxLengthIndex]) {
                                maxLengthIndex = i;
                            }
                        }

                        //Находим количество слов между самым длинным и самым коротким
                        int result = Math.abs(maxLengthIndex - minLengthIndex) - 1;
                        if (result<0){
                            result=0;
                        }

                        System.out.println("Предложение: " + sentence);
                        System.out.println("Результат (кол-во слов между): " + result);
                    } else {
                        System.out.println("Сначала введите текст.");
                    }
                    break;

                case 4:
                    if (isDataEntered) {
                        System.out.println("Введите имя файла для записи:");
                        String writeFileName = scanner.nextLine();

                        //Проверка, добавление расширения .txt, если его нет
                        if (!writeFileName.endsWith(".txt")) {
                            writeFileName += ".txt";
                        }

                        //Записываем предложение в файл
                        fileWork.writeTextToFile(writeFileName, sentence);
                    } else {
                        System.out.println("Сначала введите текст.");
                    }
                    break;

                case 5:
                    System.out.println("Возвращение в меню...");
                    break;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        } while (choice != 5);
    }
    public static void inputMatrixFromConsole(Matrix matrix) {
        try {
            System.out.println("Введите размеры матрицы (строки и столбцы):");
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            if (rows <= 0 || cols <= 0) {
                System.out.println("Размеры матрицы должны быть положительными числами.");
                return;
            }

            matrix.setMatrix(new int[rows][cols]);  //cоздаем объект с матрицей

            System.out.println("Введите элементы матрицы (строка за строкой):");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (scanner.hasNextInt()) {
                        matrix.getMatrix()[i][j] = scanner.nextInt(); //доб элемент в матрицу
                    } else {
                        System.out.println("Ошибка ввода: ожидалось целое число.");
                        scanner.next();
                        j--;
                    }
                }
            }

            System.out.println("Введенная матрица:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print(matrix.getMatrix()[i][j] + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка при вводе данных: " + e.getMessage());
            scanner.nextLine();
        }
    }


}