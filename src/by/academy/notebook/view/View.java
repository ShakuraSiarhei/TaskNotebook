package by.academy.notebook.view;

import by.academy.notebook.bean.Note;
import by.academy.notebook.bean.Notebook;

import java.security.PublicKey;
import java.util.List;

public class View {
    public static final String MESSAGE_YEAR = "Введите дату заметки. Год в формате YYYY (2001 - 2022):";
    public static final String MESSAGE_MONTH = "Месяц в формате MM:";
    public static final String MESSAGE_DAY = "День в формате DD:";
    public static final String MESSAGE_CREATE = "Введите текст заметки:";
    public static final String MESSAGE_NULL_RESULT = "Проверьте введенные данные. Запрошенная информация отсутствует в блокноте.";

    public static void showMainMenu(){
        System.out.println("Добро пожаловать в меню. Сделайте свой выбор.");
        System.out.println("1 - Create note");
        System.out.println("2 - Delete note by number");
        System.out.println("3 - Show notes by time");
        System.out.println("4 - Find note by data");
        System.out.println("5 - Show all notes");
        System.out.println("0 - exit");
    }

    public static void showMessage(String message){
        System.out.println(message);
    }

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
