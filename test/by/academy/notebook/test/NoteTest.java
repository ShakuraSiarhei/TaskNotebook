package by.academy.notebook.test;

import by.academy.notebook.bean.Note;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;


public class NoteTest {
    private Note noteTest;

    @Before
    public void createNote() {
        noteTest = new Note();
    }

    @Test
    public void noteTest001() {
        String actual = noteTest.getTextNote();

        Assert.assertEquals(null, actual);
    }

    @Test
    public void noteTest002() {
        String expected = "Test text.";
        noteTest.setTextNote("Test text.");
        String actual = noteTest.getTextNote();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void noteTest003() {
        LocalDate expected = LocalDate.of(2022,04,24);
        noteTest.setDateOfCreate(LocalDate.of(2022,04,24));
        LocalDate actual = noteTest.getDateOfCreate();

        Assert.assertEquals(expected,actual);
    }

}