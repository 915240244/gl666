package net.nice.bean;

public class AdminReturn_record {

    private  int  propagationID;
    private  String  Borrowed_ID;
    private  String  Title;
    private  String  Reader_Name;
    private  String  Staff_Number;
    private  String  Staff_Name;
    private  String  Return_Time;

    @Override
    public String toString() {
        return "AdminReturn_record{" +
                "propagationID=" + propagationID +
                ", Borrowed_ID='" + Borrowed_ID + '\'' +
                ", Title='" + Title + '\'' +
                ", Reader_Name='" + Reader_Name + '\'' +
                ", Staff_Number='" + Staff_Number + '\'' +
                ", Staff_Name='" + Staff_Name + '\'' +
                ", Return_Time='" + Return_Time + '\'' +
                '}';
    }

    public int getPropagationID() {
        return propagationID;
    }

    public void setPropagationID(int propagationID) {
        this.propagationID = propagationID;
    }



    public AdminReturn_record(String borrowed_ID, String title, String reader_Name, String staff_Number, String staff_Name, String return_Time) {
        Borrowed_ID = borrowed_ID;
        Title = title;
        Reader_Name = reader_Name;
        Staff_Number = staff_Number;
        Staff_Name = staff_Name;
        Return_Time = return_Time;
    }


    public String getBorrowed_ID() {
        return Borrowed_ID;
    }

    public void setBorrowed_ID(String borrowed_ID) {
        Borrowed_ID = borrowed_ID;
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

    public String getReturn_Time() {
        return Return_Time;
    }

    public void setReturn_Time(String return_Time) {
        Return_Time = return_Time;
    }

    public AdminReturn_record() {
    }
}
