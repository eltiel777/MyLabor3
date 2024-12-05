public class Array {
    //ПОЛЯ
    private int[] data; //данные исходные с которыми работаем
    private int size; //текущее количество элементов

    //КОНСТРУКТОРЫ

    public Array() //конструктор без аргументов
    {
        this.data = new int[0];
    }

    public Array(int size) //конструктор с аргументом для создания массива заданного размера
    {
        data = new int[size];
    }

    public Array(int[] inputData) //конструктор клонирования
    {
        this.data = new int[inputData.length]; //создается массив длиной как исходный
        for (int i = 0; i < this.data.length; i++) //перебираем
        {
            this.data[i] = inputData[i]; //и этому объекту присваиваем
        }
    }

    //МЕТОДЫ
    public int[] getData() {
        return data; //возвращаем данные массива
    }

    public void sort() //сортировка по возрастанию пузырьком
    {
        size = data.length; //длина массива
        for (int i = 0; i < size - 1; i++)
        {
            for (int j = 0; j < size - i - 1; j++)
            {
                if (data[j] > data[j + 1])
                {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    //метод для добавления элемента в массив
    public void addElement(int newElement) { //на вход элемент, который нужно добавить
        int[] newData = new int[data.length + 1]; //создаем новый массив, который больше исходного на 1 элемент
        for (int i = 0; i < data.length; i++)
        {
            newData[i] = data[i]; //копируем элементы старого в новый массив
        }
        newData[newData.length - 1] = newElement; //добавляем элемент в конец массива
        this.data = newData; //поменяли ссылку на массив
    }

    public void printArray() { //вывод массива
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }


}