package net.nice.bean;

public class Borrowed {
   private Integer propagationID;
   private String borrowed_ID;
   private String book_ID;
   private String reader_ID;
   private String title;
   private String reader_Name;
   private String staff_Number;
   private String staff_Name;
   private String borrowed_Time;
   private Integer give_Back;

    public Borrowed() {
    }

    public Borrowed(String borrowed_ID, Integer give_Back) {
        this.borrowed_ID = borrowed_ID;
        this.give_Back = give_Back;
    }

    public Integer getPropagationID() {
        return propagationID;
    }

    public void setPropagationID(Integer propagationID) {
        this.propagationID = propagationID;
    }

    public String getBorrowed_ID() {
        return borrowed_ID;
    }

    public void setBorrowed_ID(String borrowed_ID) {
        this.borrowed_ID = borrowed_ID;
    }

    public String getBook_ID() {
        return book_ID;
    }

    public void setBook_ID(String book_ID) {
        this.book_ID = book_ID;
    }

    public String getReader_ID() {
        return reader_ID;
    }

    public void setReader_ID(String reader_ID) {
        this.reader_ID = reader_ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReader_Name() {
        return reader_Name;
    }

    public void setReader_Name(String reader_Name) {
        this.reader_Name = reader_Name;
    }

    public String getStaff_Number() {
        return staff_Number;
    }

    public void setStaff_Number(String staff_Number) {
        this.staff_Number = staff_Number;
    }

    public String getStaff_Name() {
        return staff_Name;
    }

    public void setStaff_Name(String staff_Name) {
        this.staff_Name = staff_Name;
    }


    public String getBorrowed_Time() {
        return borrowed_Time;
    }

    public void setBorrowed_Time(String borrowed_Time) {
        this.borrowed_Time = borrowed_Time;
    }

    public Integer getGive_Back() {
        return give_Back;
    }

    public void setGive_Back(Integer give_Back) {
        this.give_Back = give_Back;
    }

    @Override
    public String toString() {
        return "Borrowed{" +
                "propagationID=" + propagationID +
                ", borrowed_ID='" + borrowed_ID + '\'' +
                ", book_ID='" + book_ID + '\'' +
                ", reader_ID='" + reader_ID + '\'' +
                ", title='" + title + '\'' +
                ", reader_Name='" + reader_Name + '\'' +
                ", staff_Number='" + staff_Number + '\'' +
                ", staff_Name='" + staff_Name + '\'' +
                ", borrowed_Time='" + borrowed_Time + '\'' +
                ", give_Back=" + give_Back +
                '}';
    }
}
