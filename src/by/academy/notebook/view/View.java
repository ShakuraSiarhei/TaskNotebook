package by.academy.notebook.view;

import by.academy.notebook.bean.Note;
import by.academy.notebook.bean.Notebook;

import java.util.List;

public class View {

    public static void showNotes(Notebook notebook) {
        int n = 1;
        for (Note note:notebook.getNotes()) {
            System.out.println(n + "." + note.toString());
            n++;
        }
    }

    public static void showNotes(List<Note> notes) {
        int n = 1;
        for (Note note:notes) {
            System.out.println(n + "." + note.toString());
            n++;
        }
    }
}
