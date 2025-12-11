package edu.grinnell.csc207.texteditor;

import java.util.Arrays;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {

    public int curs;
    public int start_i;
    public int last_i;
    public int sz;
    public char[] arr;

    public GapBuffer(){
        this.start_i = 0;
        this.last_i = 10;
        this.sz = 10;
        this.arr = new char[sz];
    }

    public void insert(char ch) {
        //if buffer size is not 0
        //insert char at start
        //move start over
        //if buffer 0, increase buffer size
        //push left and right ends to ends of arr
        if(start_i == last_i){
            arr = Arrays.copyOf(arr, sz*2);
            for(int i = 0; i < arr.length - start_i; i++){
                arr[i + sz/2] = arr[i];
            }
        } 
            arr[start_i] = ch;
            start_i++;

        // if(start_i == 0){
        //     for(int i = last_i; i < arr.length; i++){
        //         arr[i] = arr[i-1];
        //     }
        // }else if(start_i == last_i){
        //     arr = Arrays.copyOf(arr, sz * 2);
        //     for(int j = last_i; j < (arr.length - last_i); j++){
        //         for(int i = last_i; i < arr.length; i++){
        //             arr[i] = arr[i-1];
        //         }
        //     } 
        // }
        // last_i = (arr.length - last_i);
        // if(arr.length >= sz){
        //     arr[start_i] = ch;
        //     start_i++;
        //     sz++;
        // }
    }

    public void delete() {
        if(start_i != 0){
            start_i--;
        }
    }

    public int getCursorPosition() {
        return start_i;
    }

    public void moveLeft() {
        if(start_i > 0){
            start_i--;
            last_i--;
            arr[last_i] = arr[start_i];
        }
        //move last back 1
        //move start back 1
        //set start 1 to last 
    }

    public void moveRight() {
        if(start_i < arr.length - 1){
            start_i++;
            last_i++;
            arr[start_i] = arr[last_i];
        }
    }

    public int getSize() {
        return arr.length - (last_i - start_i);
    }

    public char getChar(int i) {
        //if(i < arr.length){
            return arr[i];
       // }
    }

    public String toString() {
        String first = "";
        for(int i = 0; i < start_i; i++){
                first = first + arr[i];
        }
        for(int i = last_i; i < arr.length; i++){
            first = first + arr[i];
    }
        return first;
    }
}
