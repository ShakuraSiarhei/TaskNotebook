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
    private Scanner sc = new Scanner(System.in);
    private View view;

    public void readAllNotesFromFile(Notebook notebook) {
        try (FileReader reader = new FileReader("test.txt")){
            BufferedReader read = new BufferedReader(reader);
            String line = read.readLine();
            while (line != null) {
                String textNote = line.replace("Note textNote='", "").replace(", dateOfCreate=", "");
                String data2 = textNote.substring(textNote.length() - 10);
                String text = textNote.substring(0,textNote.length()-11);
                String[] data = data2.split("-");
                Note note = new Note(text, LocalDate.of(parseInt(data[0]),parseInt(data[1]),parseInt(data[2])));
                notebook.getNotes().add(note);
                line = read.readLine();
            }
        }
        catch (IOException ex) {
            ex.getMessage();
        }
    }

    public void addNoteFromKeyboard(Notebook notebook) {
        System.out.println("Введите текст заметки.");
        String str = sc.nextLine();
        boolean enterControl = true;
        int year = 0;
        int month = 0;
        int day = 0;
        while (year <= 2000 || year > 2023) {
            System.out.println("Введите дату заметки. Год в формате YYYY (2001 - 2022):");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
            } else {
                sc.nextLine();
                continue;
            }
        }
        while (month < 1 || month > 12) {
            System.out.println("Месяц в формате MM:");
            if (sc.hasNextInt()) {
                month = sc.nextInt();
            } else {
                sc.nextLine();
                continue;
            }
        }
        while (day < 1 || day > 31) {
            System.out.println("День в формате DD:");
            if (sc.hasNextInt()) {
                day = sc.nextInt();
            } else {
                sc.nextLine();
                continue;
            }
        }
        LocalDate date = LocalDate.of(year, month, day);
        Note note = new Note(str,date);
        notebook.getNotes().add(note);
    }

    public void deleteNote(Notebook notebook, int a) {
        if (notebook.getNotes().size() >= a) {
            notebook.getNotes().remove(a - 1);
        } else {
            System.out.println("Введенная запись отсутствует в записной книжке.");
        }
    }

    public void writeNotesToFile(Notebook notebook){
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

    public void findNoteByTime(Notebook notebook, LocalDate targetDate) {
        ArrayList<Note> result = new ArrayList<Note>();
        for (Note note:notebook.getNotes()) {
            if (note.getDateOfCreate().equals(targetDate)) {
                result.add(note);
            }
        }
        if (result.size() == 0) {
            System.out.println("В указанную дату заметок нет.");
        }
        View.showNotes(result);
    }

    public void findNoteByData(Notebook notebook, String data) {
        ArrayList<Note> result = new ArrayList<Note>();
        for (Note note:notebook.getNotes()) {
            if (note.getTextNote().contains(data)) {
                result.add(note);
            }
        }
        if (result.size() == 0) {
            System.out.println("Нет заметок с запрошенным содержанием.");
        }
        View.showNotes(result);
    }

}
