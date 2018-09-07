package net.nice.bean;

public class Return_record {
    private  Integer  propagationID;
    private  String  borrowed_ID;
    private  String  title;
    private  String  reader_Name;
    private  String  staff_Number;
    private  String  staff_Name;
    private  String  return_Time;

    public Return_record() {
    }

    public Return_record(String borrowed_ID, String title, String reader_Name, String staff_Number, String staff_Name, String return_Time) {
        this.borrowed_ID = borrowed_ID;
        this.title = title;
        this.reader_Name = reader_Name;
        this.staff_Number = staff_Number;
        this.staff_Name = staff_Name;
        this.return_Time = return_Time;
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

    public String getReturn_Time() {
        return return_Time;
    }

    public void setReturn_Time(String return_Time) {
        this.return_Time = return_Time;
    }

    @Override
    public String toString() {
        return "return_record{" +
                "propagationID=" + propagationID +
                ", borrowed_ID='" + borrowed_ID + '\'' +
                ", title='" + title + '\'' +
                ", reader_Name='" + reader_Name + '\'' +
                ", staff_Number='" + staff_Number + '\'' +
                ", staff_Name='" + staff_Name + '\'' +
                ", return_Time='" + return_Time + '\'' +
                '}';
    }
}
