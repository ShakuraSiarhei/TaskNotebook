package by.academy.notebook.bean;

import java.util.ArrayList;

public class Notebook {
    private ArrayList<Note> notes;

    public Notebook () {}

    public Notebook (ArrayList<Note> notes) {
        this.notes = notes;
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }

    public void setNotes(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Notebook notebook = (Notebook) o;

        return notes != null ? notes.equals(notebook.notes) : notebook.notes == null;
    }

    @Override
    public int hashCode() {
        return notes != null ? notes.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "notes=" + notes +
                '}';
    }
}
