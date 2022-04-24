package by.academy.notebook.logic;

import by.academy.notebook.bean.Note;
import by.academy.notebook.bean.Notebook;
import by.academy.notebook.view.View;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class NotebookLogic {

    private File sourceFile = new File("test.txt");
    private Scanner sc = new Scanner(System.in);

    public void readAllNotesFromFile(Notebook notebook) {
        try (FileReader reader = new FileReader(sourceFile)){
            BufferedReader read = new BufferedReader(reader);
            String line = read.readLine();
            while (line != null) {
                String text = line.replace("Note textNote='", "").replace(", dateOfCreate=", "");
                String noteDate = text.substring(text.length() - 10);
                String noteText = text.substring(0,text.length()-11);
                String[] noteDataArray = noteDate.split("-");
                Note note = new Note(noteText, LocalDate.of(parseInt(noteDataArray[0]),parseInt(noteDataArray[1]),parseInt(noteDataArray[2])));
                notebook.getNotes().add(note);
                line = read.readLine();
            }
        }
        catch (IOException ex) {
            ex.getMessage();
        }
    }

    public boolean addNoteFromKeyboard(Notebook notebook) {
        View.showMessage(View.MESSAGE_CREATE);
        String str = sc.nextLine();
        boolean enterControl = true;
        LocalDate date = dateEnter();
        Note note = new Note(str,date);
        notebook.getNotes().add(note);
        return enterControl;
    }

    public void deleteNote(Notebook notebook, int a) {
        if (notebook.getNotes().size() >= a) {
            notebook.getNotes().remove(a - 1);
        } else {
            View.showMessage(View.MESSAGE_NULL_RESULT);
        }
    }

    public void writeNotesToFile(Notebook notebook){
        try (FileWriter writer = new FileWriter(sourceFile, false))
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

    public void findNoteByTime(Notebook notebook) {
        List<Note> result = new ArrayList<Note>();
        LocalDate targetDate = dateEnter();
        for (Note note:notebook.getNotes()) {
            if (note.getDateOfCreate().equals(targetDate)) {
                result.add(note);
            }
        }
        if (result.size() == 0) {
            View.showMessage(View.MESSAGE_NULL_RESULT);
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
            View.showMessage(View.MESSAGE_NULL_RESULT);
        }
        View.showNotes(result);
    }

    public LocalDate dateEnter(){
        int year = 0;
        int month = 0;
        int day = 0;
        while (year <= 2000 || year > 2023) {
            View.showMessage(View.MESSAGE_YEAR);
            if (sc.hasNextInt()) {
                year = sc.nextInt();
            } else {
                sc.nextLine();
                continue;
            }
        }
        while (month < 1 || month > 12) {
            View.showMessage(View.MESSAGE_MONTH);
            if (sc.hasNextInt()) {
                month = sc.nextInt();
            } else {
                sc.nextLine();
                continue;
            }
        }
        while (day < 1 || day > 31) {
            View.showMessage(View.MESSAGE_DAY);
            if (sc.hasNextInt()) {
                day = sc.nextInt();
                sc.nextLine();
            } else {
                sc.nextLine();
                continue;
            }
        }
        LocalDate date = LocalDate.of(year, month, day);
        return date;
    }

}
