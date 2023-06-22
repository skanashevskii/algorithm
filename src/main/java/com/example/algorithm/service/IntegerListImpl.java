package com.example.algorithm.service;

import com.example.algorithm.exception.NullItemException;
import com.example.algorithm.exception.invalideIndexException;
import com.example.algorithm.exception.starageIsFullException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    //массив для хранения строк
    private final Integer[] storage;

    //поле для хранения реального размера листа
    private int size;

    //конструктор
    public IntegerListImpl() {
        storage = new Integer[10];
    }

    //конструктор
    public IntegerListImpl(int initSize) {
        storage = new Integer[initSize];
    }

    //добавление в конец
    @Override
    public Integer add(Integer item) {
        validateSize();
        validateItem(item);
        storage[size++] = item;
        return item;
    }

    //добавление по индексу
    @Override
    public Integer add(int index, Integer item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            storage[size++] = item;
            return item;//чтобы прервать метод
        }
        //если индекс не равен size, то сдвигаем
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    //добавит объект в данную ячейку по индексу
    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
        return item;
    }

    //удаление по элементу
    @Override
    public Integer remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);

        return remove(index);
    }

    //удаление по индексу
    @Override
    public Integer remove(int index) {
        validateIndex(index);

        Integer item = storage[index];
        if (index != size) {
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;
    }

    //возвращает -1, значит элемент в коллекции
    @Override
    public boolean contains(Integer item) {
        //новый массив
        Integer[] storageCopy = toArray();
        sort(storageCopy);
        return binarySearch(storageCopy, item);
    }

    //вернет -1 , если элемент не найден
    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            Integer s = storage[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    //вернет -1 , если элемент не найден
    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            Integer s = storage[i];
            if (s.equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return storage[index];
    }

    //
    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    //
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //обнуляем size
    @Override
    public void clear() {
        size = 0;
    }

    //метод возвращает массив без пустых ячеек
    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    /**
     * Методы валидации хранилища на null,на размер и индекс
     *
     * @param item
     */

    //проверка на null
    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    //проверка на размер хранилища
    private void validateSize() {
        if (size == storage.length) {
            throw new starageIsFullException();
        }
    }

    //проверка индекса
    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new invalideIndexException();
        }
    }

    //метод сортировки массива вставкой
    private void sort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    //бинарный поиск
    public boolean binarySearch(Integer[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

}
