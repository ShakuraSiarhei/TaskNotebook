package by.academy.notebook.bean;

import java.util.ArrayList;

public class Notebook {
    private ArrayList<Note> notes;

    public Notebook () {}

    public Notebook (ArrayList<Note> notes) {
        this.notes = new ArrayList<Note>();
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notebook) {
        this.notes = notes;
    }
}
