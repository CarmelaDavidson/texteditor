package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GapBufferTests {
    
    @Test
    public void insertEmpty() {
        GapBuffer a = new GapBuffer();
        a.insert('b');
        
        assertEquals('b', a.getChar(0));
    }

    @Test
    public void sizeEmpty() {
        GapBuffer a = new GapBuffer();
        assertEquals(0, a.getSize());
    }

    @Test
    public void LRtest(){
        GapBuffer a = new GapBuffer();
        a.insert('a');
        a.insert('a');
        a.insert('a');
        a.insert('a');
        a.insert('a');
        a.insert('a');
        a.moveLeft();
        a.moveLeft();
        a.moveLeft();
        a.moveLeft();
        a.moveRight();
        a.moveRight();
        a.moveRight();

        assertEquals(5, a.getCursorPosition());
    }

    @Test
    public void insertFront() {
        GapBuffer a = new GapBuffer();
        a.insert('a');
        a.insert('b');
        a.insert('c');
        a.insert('d');
        a.moveLeft();
        a.moveLeft();
        a.moveLeft();
        a.moveLeft();
        a.insert('Z');
        assertEquals('Z', a.getChar(0));
    }

@Test
    public void insertFull() {
        GapBuffer a = new GapBuffer();
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
        GapBuffer a = new GapBuffer();
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
    public void insertTest(){
        GapBuffer buf = new GapBuffer();
        buf.insert('a');
        buf.insert('b');
        buf.insert('c');
        buf.moveLeft();
        buf.moveLeft();
        buf.insert('!');
        buf.insert('!');
        assertEquals(5, buf.getSize(), "size");
        assertEquals(3, buf.getCursorPosition(), "cursor");
        assertEquals("a!!bc", buf.toString(), "contents");
    }

    @Test
    public void getCursorPositionEmpty() {
        SimpleStringBuffer a = new SimpleStringBuffer();

        assertEquals(0, a.getCursorPosition());
    }
}
