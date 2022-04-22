package by.academy.notebook.logic;

import by.academy.notebook.bean.Note;
import by.academy.notebook.bean.Notebook;
import by.academy.notebook.view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class NotebookControl {

    private Notebook notebook = new Notebook(new ArrayList<Note>());
    private NotebookLogic notebookLogic = new NotebookLogic();

    public NotebookLogic getNotebookLogic() {
        return notebookLogic;
    }
    public void setNotebookLogic(NotebookLogic notebookLogic) {
        this.notebookLogic = notebookLogic;
    }
    public Notebook getNotebook() {
        return notebook;
    }
    public void setNotebook(Notebook notebook) {
        this.notebook = notebook;
    }

    public void mainControlPanel(){
        getNotebookLogic().readAllNotesFromFile(getNotebook());
        Scanner sc = new Scanner(System.in);
        System.out.println("Добро пожаловать в меню. Сделайте свой выбор.");
        System.out.println("1 - Create note");
        System.out.println("2 - Delete note by number");
        System.out.println("3 - Show notes by time");
        System.out.println("4 - Find note by data");
        System.out.println("5 - Show all notes");
        System.out.println("0 - exit");
        boolean endOfWork = false;

        while (!endOfWork) {
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    getNotebookLogic().addNoteFromKeyboard(getNotebook());
                    break;
                case 2:
                    System.out.println("Введите порядковый номер записи для удаления.");
                    int a = sc.nextInt();
                    getNotebookLogic().deleteNote(getNotebook(), a); //прописать проверку наличия такой записи
                    break;
                case 3:
                    System.out.println("Enter target date (year in format YYYY:");
                    int year = sc.nextInt();
                    System.out.println("Enter target date (month in format MM:");
                    int month = sc.nextInt();
                    System.out.println("Enter target date (day in format DD:");
                    int day = sc.nextInt();
                    LocalDate targetDate = LocalDate.of(year, month, day);
                    getNotebookLogic().findNoteByTime(notebook, targetDate);
                    break;
                case 4:
                    System.out.println("Введите текст для поиска");
                    sc.nextLine();
                    String targetData = sc.nextLine();
                    getNotebookLogic().findNoteByData(notebook, targetData);
                    break;
                case 5:
                    View.showNotes(getNotebook());
                    break;
                case 0:
                    endOfWork = true;
                    getNotebookLogic().writeNotesToFile(getNotebook());
                    break;
                default:
                    break;
            }
        }

    }

}
