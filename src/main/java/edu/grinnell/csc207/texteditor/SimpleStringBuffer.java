package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {

    public int curs;
    public int sz;
    private String str;

    public SimpleStringBuffer(){
        this.curs = 0;
        this.sz = 0;
        this.str = "";
    }

    public void insert(char ch) {
        if(str.length() == 0){
            str = "" + ch;
        }else{
            String first = str.substring(0, curs);
            String last = str.substring(curs - 1, sz - 1);
            str = first + ch + last;
        }
        curs++;
        sz++;
    
    }

    public void delete() {
        if(sz != 0){
            String first = str.substring(0, curs - 1);
            String last = str.substring(curs, sz);
            str = first + last;
            curs--;
            sz--;
        }
    }

    public int getCursorPosition() {
        return curs;
    }

    public void moveLeft() {
        if(curs > 0){
            curs--;
        }
        
    }

    public void moveRight() {
        if(curs < sz){
            curs++;
        }
    }

    public int getSize() {
        return sz;
    }

    public char getChar(int i) {
        if(i < sz){
            return str.charAt(i);
        }
        throw new IndexOutOfBoundsException("Invalid Index");
    }

    @Override
    public String toString() {
        return str;
    }
}
