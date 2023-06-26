package com.example.algorithm;


import java.util.Arrays;
import java.util.Random;

public class ArrayGeneratorAndSpeedTest {
        public static void main(String[] args) {
            int[] array = generateArray(100_000);
            int[] arrayCopy1 = Arrays.copyOf(array,array.length);
            int[] arrayCopy2 = Arrays.copyOf(array,array.length);
            int[] arrayCopy3 = Arrays.copyOf(array,array.length);

            long startTime, endTime, executionTime;
            startTime = System.currentTimeMillis();
            sortBubble(arrayCopy1);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            System.out.println("Bubble Sort Execution Time: " + executionTime + " milliseconds");

            // Сортировка выбором
            startTime = System.currentTimeMillis();
            sortSelection(arrayCopy2);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            System.out.println("Selection Sort Execution Time: " + executionTime + " milliseconds");

            // Сортировка слиянием
            startTime = System.currentTimeMillis();
            mergeSort(arrayCopy3);
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;
            System.out.println("Merge Sort Execution Time: " + executionTime + " milliseconds");

        }

        public static int[] generateArray(int length) {
            int[] array = new int[length];
            Random random = new Random();
            for (int i = 0; i < length; i++) {
                array[i] = random.nextInt();
            }
            return array;
        }
    //Метод swapElement используется для обмена элементов массива.
    //Он принимает массив и два индекса и меняет значения элементов с соответствующими индексами.
    public static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    //пузырьковая сортировка
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }
    //сортировка выбором
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return; // базовый случай - массив уже отсортирован
        }

        int middle = arr.length / 2;
        int [] left = new int[middle];
        int [] right = new int[arr.length - middle];

        // Заполнение левого и правого подмассивов
        for (int i = 0; i < middle; i++) {
            left[i] = arr[i];
        }
        for (int i = middle; i < arr.length; i++) {
            right[i - middle] = arr[i];
        }

        // Рекурсивное сортировка левого и правого подмассивов
        mergeSort(left);
        mergeSort(right);

        // Слияние отсортированных подмассивов
        merge(left, right, arr);
    }

    public static void merge(int[] left, int[] right, int[] arr) {
        int leftLength = left.length;
        int rightLength = right.length;
        int i = 0, j = 0, k = 0;

        // Сравниваем элементы из левого и правого подмассивов и помещаем их в итоговый массив
        while (i < leftLength && j < rightLength) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Добавляем оставшиеся элементы из левого подмассива, если они есть
        while (i < leftLength) {
            arr[k++] = left[i++];
        }

        // Добавляем оставшиеся элементы из правого подмассива, если они есть
        while (j < rightLength) {
            arr[k++] = right[j++];
        }
    }

    /**
     *  ИТОГ сортировки 3 методами*/


    //Bubble Sort Execution Time: -----------23157 milliseconds
    //Selection Sort Execution Time: --------10784 milliseconds
    //Merge Sort Execution Time: ---------------37 milliseconds
}


