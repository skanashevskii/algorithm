package com.example.algorithm.service;

import com.example.algorithm.exception.NullItemException;
import com.example.algorithm.exception.invalideIndexException;
import com.example.algorithm.exception.starageIsFullException;

import java.util.Arrays;

public class StringListImpl implements StringList {

    //массив для хранения строк
    private final String[] storage;

    //поле для хранения реального размера листа
    private int size;

    //конструктор
    public StringListImpl() {
       storage = new String[10];
    }
    //конструктор
    public StringListImpl(int initSize) {
       storage = new String[initSize];
    }

    //добавление в конец
    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        storage[size++] = item;
        return item;
    }
    //добавление по индексу
    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index==size){
          storage[size++]=item;
          return item;//чтобы прервать метод
        }
        //если индекс не равен size, то сдвигаем
        System.arraycopy(storage,index,storage,index+1,size-index);
        storage[index]=item;
        size++;
        return item;
    }
    //добавит объект в данную ячейку по индексу
    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        storage[index]=item;
        return item;
    }
    //удаление по элементу
    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);

        return remove(index);
    }
    //удаление по индексу
    @Override
    public String remove(int index) {
        validateIndex(index);

        String item = storage[index];
        if (index!=size){
            System.arraycopy(storage, index + 1, storage, index, size - index);
        }
        size--;
        return item;
    }
    //возвращает -1, значит элемент в коллекции
    @Override
    public boolean contains(String item) {
        return indexOf(item)!=-1;
    }
    //вернет -1 , если элемент не найден
    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            String s = storage[i];
            if (s.equals(item)){
                return i;
            }
        }
        return -1;
    }
    //вернет -1 , если элемент не найден
    @Override
    public int lastIndexOf(String item) {
        for (int i = size-1; i >= 0; i--) {
            String s = storage[i];
            if (s.equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return storage[index];
    }
    //
    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(),otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }
    //
    @Override
    public boolean isEmpty() {
        return size==0;
    }
    //обнуляем size
    @Override
    public void clear() {
        size = 0;
    }
    //метод возвращает массив без пустых ячеек
    @Override
    public String[] toArray() {
        return Arrays.copyOf(storage,size);
    }

    /**
     * Методы валидации хранилища на null,на размер и индекс
     * @param item
     */

    //проверка на null
    private void validateItem(String item){
        if(item==null){
            throw new NullItemException();
        }
    }
    //проверка на размер хранилища
    private void validateSize(){
        if (size==storage.length) {
            throw new starageIsFullException();
        }
    }
    //проверка индекса
    private void validateIndex(int index){
        if (index <0 || index > size){
            throw new invalideIndexException();
        }
    }
}
