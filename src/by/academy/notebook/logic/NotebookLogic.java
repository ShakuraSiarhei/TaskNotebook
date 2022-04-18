package by.academy.notebook.logic;

import by.academy.notebook.bean.Note;
import by.academy.notebook.bean.Notebook;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class NotebookLogic {
    Scanner sc = new Scanner(System.in);

    public void addNoteFromFile(Notebook notebook){
        Note note = new Note();
        try (FileReader reader = new FileReader("text.txt"))
        {
            int c;
            String str = "";
            while ((c = reader.read()) != -1) {
                str = str + String.valueOf((char) c);
            }
            note.setTextNote(str.trim());
        }
        catch (IOException ex) {
            ex.getMessage();
        }
        note.setDateOfCreate(LocalDate.now());
        notebook.getNotes().add(note);
    }

    public void addNoteFromKeyboard(Notebook notebook) {
        System.out.println("Введите текст заметки.");
        String str = sc.nextLine();
        System.out.println("Введите дату заметки в формате YYYY-MM-DD");
        LocalDate date = LocalDate.parse(sc.nextLine());
        Note note = new Note(str,date);
        notebook.getNotes().add(note);
    }

    public void deleteNote(Notebook notebook, int a) {
        notebook.getNotes().remove(a);
    }

    public void writeNote(Notebook notebook){
        try (FileWriter writer = new FileWriter("test.txt", false))
        {
            for (Note note:notebook.getNotes()) {
                String text = note.toString();
                writer.write(text);
                writer.append('\n');
                writer.write("Next note!");
                writer.append('\n');
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void findNoteByTime(Notebook notebook, String targetDate) {
        ArrayList<Note> result = new ArrayList<Note>();
        for (Note note:notebook.getNotes()) {
            if (note.getDateOfCreate().equals(targetDate)) {
                result.add(note);
            }
        }
        for (Note note:result) {
            note.toString();
        }
    }



//    public void readNote(){
//        try (FileReader reader = new FileReader("test.txt"))
//        {
//            int c;
//            while ((c=reader.read()) != -1) {
//                System.out.print((char) c);
//            }
//        }
//        catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }

}
