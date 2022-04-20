package by.academy.notebook.logic;

import by.academy.notebook.bean.Note;
import by.academy.notebook.bean.Notebook;
import by.academy.notebook.view.View;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class NotebookLogic {
    public Scanner sc = new Scanner(System.in);
    public View view;

    public void readAllNotesFromFile(Notebook notebook) {
        try (FileReader reader = new FileReader("test.txt")){
            BufferedReader read = new BufferedReader(reader);
            String line = read.readLine();
            while (line != null) {
                String textNote = line;
                line = read.readLine();
                String[] date = line.split("-");
                Note note = new Note(textNote, LocalDate.of(parseInt(date[0]),parseInt(date[1]),parseInt(date[2])));
                notebook.getNotes().add(note);
                line = read.readLine();
            }
        }
        catch (IOException ex) {
            ex.getMessage();
        }
    }

//    public void addNoteFromFile(Notebook notebook){
//        Note note = new Note();
//        try (FileReader reader = new FileReader("text.txt"))
//        {
//            int c;
//            String str = "";
//            while ((c = reader.read()) != -1) {
//                str = str + String.valueOf((char) c);
//            }
//            note.setTextNote(str.trim());
//        }
//        catch (IOException ex) {
//            ex.getMessage();
//        }
//        note.setDateOfCreate(LocalDate.now());
//        notebook.getNotes().add(note);
//    }

    public void addNoteFromKeyboard(Notebook notebook) {
        System.out.println("Введите текст заметки.");
        String str = sc.nextLine();
        System.out.println("Введите дату заметки в формате YYYY-MM-DD");
        LocalDate date = LocalDate.parse(sc.nextLine());
        Note note = new Note(str,date);
        notebook.getNotes().add(note);
    }

    public void deleteNote(Notebook notebook, int a) {
        if (notebook.getNotes().size() > a) {
            notebook.getNotes().remove(a - 1);
        } else {
            System.out.println("Введенная запись отсутствует в записной книжке.");
        }
    }

    public void writeNote(Notebook notebook){
        try (FileWriter writer = new FileWriter("test.txt", false))
        {
            for (Note note:notebook.getNotes()) {
                String text = note.toString();
                writer.write(text);
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
        View.showNotes(result);
    }

    public void findNoteByData(Notebook notebook, String data) {

    }

}
