import java.util.Scanner;
import java.io.*;



public class Matrix{
    private int[][] data;
    private int sum;

    //КОНСТРУКТОРЫ

    public Matrix() //конструктор без аргументов, т.е. матрица будет пустой
    {
        this.data = new int[0][0]; //this - ссылка на текущий объект
    }

    public Matrix(int i, int j){ //конструктор с аргументами
        data = new int[i][j]; //создаем массив таких размерностей
    }

    public Matrix(int[][] inputData) { //конструктор клонирования
        this.data = new int[inputData.length][inputData[0].length]; //новая матрица с размерами inputData
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                this.data[i][j] = inputData[i][j]; //копируем данные из входной матрицы
            }
        }
    }

    public int[][] getData() { //получение данных
        return data;
    }

    public void createMatrixOfMultiply() {
        sum = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sum += data[i][j];
            }
        }

        // Изменяем текущую матрицу
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] *= sum;
            }
        }
    }

    public void moveZeros() { //сдвиг нулей
        for (int i = 0; i < data.length; i++) {
            int index = 0; //индекс ненулевых
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != 0) { //если не равно 0
                    data[i][index++] = data[i][j]; //то перемещается влево к началу строки
                }
            }
            while (index < data[i].length) {
                data[i][index++] = 0; //на место ненулевых в оставшиеся ставятся нули
            }
        }
    }

    public Array matrixtoArray() {
        int[] result = new int[data.length * data[0].length]; //длиной как кол-во элементов
        int index = 0;

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                result[index++] = data[i][j];
            }
        }
        return new Array(result);
    }

    public void printMatrix() { // вывод матрицы
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
    public int[][] getMatrix() {
        return data;
    }

    public void setMatrix(int[][] matrix) {
        this.data = matrix;
    }

}


