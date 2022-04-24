package by.academy.notebook.test;

import by.academy.notebook.bean.Note;
import by.academy.notebook.bean.Notebook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NotebookTest {
    private Notebook notebook;

    @Before
    public void createNotebook(){
        notebook = new Notebook();
    }

    @Test
    public void notebookTest001(){
        List <Note> actual = notebook.getNotes();

        Assert.assertEquals(null, actual);
    }

    @Test
    public void notebookTest002(){
        ArrayList <Note> expected = new ArrayList<Note>();
        notebook.setNotes(new ArrayList<Note>());
        ArrayList <Note> actual = notebook.getNotes();

        Assert.assertEquals(expected, actual);
    }

}