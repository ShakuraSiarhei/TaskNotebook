package by.academy.notebook.view;

import by.academy.notebook.bean.Note;
import by.academy.notebook.bean.Notebook;

import java.util.List;

public class View {
    public static final String MESSAGE_YEAR = "Введите дату заметки. Год в формате YYYY (2001 - 2022):";
    public static final String MESSAGE_MONTH = "Месяц в формате MM:";
    public static final String MESSAGE_DAY = "День в формате DD:";
    public static final String MESSAGE_CREATE = "Введите текст заметки:";
    public static final String MESSAGE_NULL_RESULT = "Проверьте введенные данные. Запрошенная информация отсутствует в блокноте.";

    public static void showMainMenu(){
        System.out.println("Добро пожаловать в меню. Сделайте свой выбор.");
        System.out.println("1 - Создать заметку.");
        System.out.println("2 - Удалить заметку по номеру в общем списке.");
        System.out.println("3 - Показать заметки на определенную дату.");
        System.out.println("4 - Показать заметки с определенным содержанием.");
        System.out.println("5 - Показать все заметки.");
        System.out.println("0 - Выход.");
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
