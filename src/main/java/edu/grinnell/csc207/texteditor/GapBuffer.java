package edu.grinnell.csc207.texteditor;

import java.util.Arrays;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {

    public int curs;
    public int gap_i;
    public int last_i;
    public int sz;
    public char[] arr;

    public GapBuffer(){
        this.gap_i = 0;
        this.last_i = 0;
        this.sz = 1;
        this.arr = new char[10];
    }

    public void insert(char ch) {
        if(gap_i == 0){
            arr[gap_i] = ch;
        }else if(gap_i == last_i){
            arr = Arrays.copyOf(arr, sz * 2);
            for(int j = last_i; j < (arr.length - last_i); j++){
                for(int i = last_i; i < arr.length; i++){
                    arr[i] = arr[i-1];
                }
            } 
        }
        last_i = (arr.length - last_i);
        if(arr.length >= sz){
            arr[gap_i] = ch;
            gap_i++;
            sz++;
        }
    }

    public void delete() {
        if(gap_i != 0){
            gap_i--;
        }
    }

    public int getCursorPosition() {
        return gap_i;
    }

    public void moveLeft() {
        if(gap_i > 0){
            arr[last_i - 1] = arr[gap_i];
            gap_i--; 
            last_i--;
        }
    }

    public void moveRight() {
        if(gap_i < arr.length - last_i){
            arr[gap_i] = arr[last_i];
            gap_i++;
            last_i++;
        }
    }

    public int getSize() {
        return sz;
    }

    public char getChar(int i) {
        if(i < gap_i){
            return arr[i];
        }else{
            return arr[(i - gap_i) + last_i];
        }
    }

    public String toString() {
        String first = Arrays.copyOfRange(arr, 0, (gap_i - 1)).toString();
        String last = Arrays.copyOfRange(arr, last_i, arr.length-1).toString();
        return first + last;
    }
}
