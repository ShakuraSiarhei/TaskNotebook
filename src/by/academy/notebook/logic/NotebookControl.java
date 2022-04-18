package by.academy.notebook.logic;

import by.academy.notebook.bean.Note;
import by.academy.notebook.bean.Notebook;
import by.academy.notebook.view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class NotebookControl {
    Notebook notebook = new Notebook(new ArrayList<Note>());
    NotebookLogic notebookLogic = new NotebookLogic();

    public void mainControlPanel(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать в меню. Сделайте свой выбор.");
        System.out.println("1 - Create note");
        System.out.println("2 - Delete note by number");
        System.out.println("3 - Show notes by time");
        System.out.println("4 - Find note by data");
        System.out.println("5 - Show all notes");
        System.out.println("0 - exit");
        boolean rightChoice = false;

        while (!rightChoice) {
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("1 - Добавить заметку из файла.");
                    System.out.println("2 - Ввести заметку вручную.");
                    int ch1 = sc.nextInt();
                    switch (ch1){
                        case 1:
                            notebookLogic.addNoteFromFile(notebook);
                            break;
                        case 2:
                            notebookLogic.addNoteFromKeyboard(notebook);
                            break;
                        default:
                            System.out.println("Введен неверный символ.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Enter note for delete");
                    int a = sc.nextInt();
                    notebookLogic.deleteNote(notebook, a); //прописать проверку наличия такой записи
                    break;
                case 3:
                    System.out.println("Enter target date (year in format YYYY:");
                    int year = sc.nextInt();
                    System.out.println("Enter target date (month in format MM:");
                    int month = sc.nextInt();
                    System.out.println("Enter target date (day in format DD:");
                    int day = sc.nextInt();
                    String targetDate = year + "-" + month + "-" + day;
                    notebookLogic.findNoteByTime(notebook, targetDate);
                    break;
                case 4:
                    //rightChoice = true;
                    break;
                case 5:
                    View.showNotes(notebook);
                    break;
                case 0:
                    rightChoice = true;
                    notebookLogic.writeNote(notebook);
                    break;
                default:
                    break;
            }
        }

    }

}
