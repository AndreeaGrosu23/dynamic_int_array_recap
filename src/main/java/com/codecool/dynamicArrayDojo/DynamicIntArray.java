package com.codecool.dynamicArrayDojo;

// put your code here!
public class DynamicIntArray {

    int[] array;
    int count;
    int size;

    public DynamicIntArray(int length) {
        this.size = length;
        count = 0;
        array = new int[length];
    }

    public DynamicIntArray() {
        size = 1;
        count = 0;
        array = new int[1];
    }

    public void add(int n) {
        if(count==size) {
            growSize();
        }
        array[count] = n;
        count++;
    }

    public void growSize() {
        int[] temp=null;
        if (count == size) {
            temp = new int[size+1];
            for (int i=0; i<size; i++) {
                temp[i] = array[i];
            }
        }
        array=temp;
        size++;
    }

    public void remove(int index) {
        int[] finalArray = new int[array.length-1];
        if (index==0) {
            for (int i=0; i<array.length-1; i++)
                finalArray[i] = array[i+1];
        }
        if (index==array.length) {
            for (int i=0; i<array.length-1; i++)
                finalArray[i] = array[i];
        }
        for (int i=0; i<index; i++)
            finalArray[i] = array[i];
        for (int i=index; i<finalArray.length; i++)
            finalArray[i] = array[i+1];
        array = finalArray;
        size--;
        count--;
    }

    public void insert(int index, int value) {
        int[] finalArray = new int[array.length+1];
        if (index>=array.length)
            add(value);
        else {
            for (int i = 0; i < index; i++)
                finalArray[i] = array[i];
            finalArray[index] = value;
            for (int i = index; i < array.length; i++)
                finalArray[i+1] = array[i];
            array = finalArray;
            size++;
            count++;
        }
    }


    @Override
    public String toString() {
        String arrayString = "";
        for(int i=0; i<array.length; i++) {
            arrayString += " " + array[i];
        }
        return arrayString;
    }
}
