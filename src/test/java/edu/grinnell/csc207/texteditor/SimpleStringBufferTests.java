package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SimpleStringBufferTests {
    
    @Test
        public void insertEmpty() {
            SimpleStringBuffer a = new SimpleStringBuffer();
            a.insert('b');
            
            assertEquals('b', a.getChar(0));
        }

    @Test
        public void insertFull() {
            SimpleStringBuffer a = new SimpleStringBuffer();
            a.insert('a');
            a.insert('b');
            a.insert('c');
            a.insert('d');
            
            assertEquals('a', a.getChar(0));
        }

    @Test
        public void delete() {
            SimpleStringBuffer a = new SimpleStringBuffer();
            a.insert('a');
            a.insert('b');
            a.insert('c');
            a.insert('d');
            a.delete();
            a.insert('e');
            assertEquals('e', a.getChar(3));
        }

        @Test
        public void getCursorPositionLeft() {
            SimpleStringBuffer a = new SimpleStringBuffer();
            a.insert('a');
            a.insert('b');
            a.insert('c');
            a.insert('d');
            a.insert('e');
            a.moveLeft();
            a.moveLeft();
            assertEquals(3, a.getCursorPosition());
        }

    @Test
        public void getCursorPositionRight() {
            SimpleStringBuffer a = new SimpleStringBuffer();
            a.insert('a');
            a.insert('b');
            a.insert('c');
            a.insert('d');
            a.insert('e');
            a.moveLeft();
            a.moveLeft();
            a.moveLeft();
            a.moveRight();
            assertEquals(3, a.getCursorPosition());
        }

        @Test
        public void getCursorPositionEmpty() {
            SimpleStringBuffer a = new SimpleStringBuffer();

            assertEquals(0, a.getCursorPosition());
        }
    }