package com.example.array;

//import java.util.Arrays;


public class bubblesort {

    public static int[] bubbleSortCopy(int[] v){
        int[] copy=new int[v.length];
        System.arraycopy(v, 0, copy, 0, v.length);
        bubbleSort(copy);
        return copy;
    }
    
    public static void bubbleSort(int[] v){     //Arrays.sort(copy);
                                                // nel caso si potesse usare piuttosto che programmare manualmente il bubble sort
                                                //(meglio per array di grandi dimensioni)
        boolean control=true;
        for (int i = 0; i < v.length-1; i++) {
            if (control==false) {
                break;
            }
            control=false;
            for (int j = 0; j < v.length-i-1; j++) {
                if (v[j]>v[j+1]) {
                    int temp=v[j];
                    v[j]=v[j+1];
                    v[j+1]=temp; 
                    control=true;           
                }
            }
        }
    }

    
}

