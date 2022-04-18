package by.academy.notebook.view;

import by.academy.notebook.bean.Note;
import by.academy.notebook.bean.Notebook;

public class View {

    public static void showNotes(Notebook notebook) {
        for (Note note:notebook.getNotes()) {
            System.out.println(note.toString());
        }
    }
}
