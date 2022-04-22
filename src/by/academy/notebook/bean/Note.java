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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Note note = (Note) o;

        if (textNote != null ? !textNote.equals(note.textNote) : note.textNote != null) return false;
        return dateOfCreate != null ? dateOfCreate.equals(note.dateOfCreate) : note.dateOfCreate == null;
    }

    @Override
    public int hashCode() {
        int result = textNote != null ? textNote.hashCode() : 0;
        result = 31 * result + (dateOfCreate != null ? dateOfCreate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Note " +
                "textNote='" + textNote + '\'' +
                ", dateOfCreate=" + dateOfCreate;
    }
}
