package net.nice.bean;

public class AdminBborrowed_record {
        private int  propagationID;
        private String  Borrowed_ID;
        private String  Book_ID;
        private String  Reader_ID;
        private String  Title;
        private String  Reader_Name;
        private String  Staff_Number;
        private String  Staff_Name;
        private String  Borrowed_Time;
        private int  Give_Back;

    public AdminBborrowed_record(String borrowed_ID, int give_Back) {
        Borrowed_ID = borrowed_ID;
        Give_Back = give_Back;
    }


    @Override
    public String toString() {
        return "AdminBborrowed_record{" +
                "propagationID=" + propagationID +
                ", Borrowed_ID='" + Borrowed_ID + '\'' +
                ", Book_ID='" + Book_ID + '\'' +
                ", Reader_ID='" + Reader_ID + '\'' +
                ", Title='" + Title + '\'' +
                ", Reader_Name='" + Reader_Name + '\'' +
                ", Staff_Number='" + Staff_Number + '\'' +
                ", Staff_Name='" + Staff_Name + '\'' +
                ", Borrowed_Time='" + Borrowed_Time + '\'' +
                ", Give_Back=" + Give_Back +
                '}';
    }

    public int getPropagationID() {
        return propagationID;
    }

    public void setPropagationID(int propagationID) {
        this.propagationID = propagationID;
    }

    public String getBorrowed_ID() {
        return Borrowed_ID;
    }

    public void setBorrowed_ID(String borrowed_ID) {
        Borrowed_ID = borrowed_ID;
    }

    public String getBook_ID() {
        return Book_ID;
    }

    public void setBook_ID(String book_ID) {
        Book_ID = book_ID;
    }

    public String getReader_ID() {
        return Reader_ID;
    }

    public void setReader_ID(String reader_ID) {
        Reader_ID = reader_ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getReader_Name() {
        return Reader_Name;
    }

    public void setReader_Name(String reader_Name) {
        Reader_Name = reader_Name;
    }

    public String getStaff_Number() {
        return Staff_Number;
    }

    public void setStaff_Number(String staff_Number) {
        Staff_Number = staff_Number;
    }

    public String getStaff_Name() {
        return Staff_Name;
    }

    public void setStaff_Name(String staff_Name) {
        Staff_Name = staff_Name;
    }

    public String getBorrowed_Time() {
        return Borrowed_Time;
    }

    public void setBorrowed_Time(String borrowed_Time) {
        Borrowed_Time = borrowed_Time;
    }

    public int getGive_Back() {
        return Give_Back;
    }

    public void setGive_Back(int give_Back) {
        Give_Back = give_Back;
    }

    public AdminBborrowed_record() {
    }
}
