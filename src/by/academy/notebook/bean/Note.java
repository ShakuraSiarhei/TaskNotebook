package by.academy.notebook.bean;

import java.time.LocalDate;

public class Note {
    private String textNote;
    private LocalDate dateOfCreate;

    public Note() {}

    public Note(String textNote, LocalDate dateOfCreate) {
        this.textNote = textNote;
        this.dateOfCreate = dateOfCreate;
    }

    public String getTextNote() {
        return textNote;
    }

    public void setTextNote(String textNote) {
        this.textNote = textNote;
    }

    public LocalDate getDateOfCreate() {
        return dateOfCreate;
    }

    public void setDateOfCreate(LocalDate dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    @Override
    public String toString() {
        return  "textNote=" + textNote + '\n'+ "dateOfCreate=" + dateOfCreate;
    }
}
