package by.academy.notebook.logic;

import by.academy.notebook.bean.Note;
import by.academy.notebook.bean.Notebook;
import by.academy.notebook.view.View;


import java.util.ArrayList;
import java.util.Scanner;

public class NotebookControl {

    private Notebook notebook = new Notebook(new ArrayList<Note>());
    private NotebookLogic notebookLogic = new NotebookLogic();
    private Scanner sc = new Scanner(System.in);

    public void mainControlPanel(){
        boolean endOfWork = false;

        notebookLogic.readAllNotesFromFile(notebook);
        View.showMainMenu();

        while (!endOfWork) {
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    notebookLogic.addNoteFromKeyboard(notebook);
                    View.showMessage("Заметка создана.\n");
                    View.showMainMenu();
                    break;
                case 2:
                    View.showMessage("Введите порядковый номер записи для удаления.");
                    int a = sc.nextInt();
                    notebookLogic.deleteNote(notebook, a);
                    break;
                case 3:
                    notebookLogic.findNoteByTime(notebook);
                    break;
                case 4:
                    View.showMessage("Введите текст для поиска");
                    sc.nextLine();
                    String targetData = sc.nextLine();
                    notebookLogic.findNoteByData(notebook, targetData);
                    break;
                case 5:
                    View.showNotes(notebook);
                    break;
                case 0:
                    endOfWork = true;
                    notebookLogic.writeNotesToFile(notebook);
                    break;
                default:
                    View.showMessage("Неверный ввод. Попробуйте еще раз.");
                    break;
            }
        }

    }

}
