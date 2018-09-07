package net.nice.bean;

public class Reader {
    private Integer propagationID;
    private String reader_ID;
    private String reader_Name;
    private String reader_Password;
    private String reader_Phone;
    private String reader_Address;
    private String reader_Gender;
    private String reader_Photo;
    private String reader_Email;
    private Integer borrow_Count;

    public Reader() {
    }


    public Reader(String reader_ID, String reader_Password, String reader_Email) {
        this.reader_ID = reader_ID;
        this.reader_Password = reader_Password;
        this.reader_Email = reader_Email;
    }

    public Reader(String reader_ID, String reader_Password) {
        this.reader_ID = reader_ID;
        this.reader_Password = reader_Password;
    }

    public Integer getPropagationID() {
        return propagationID;
    }

    public void setPropagationID(Integer propagationID) {
        this.propagationID = propagationID;
    }

    public String getReader_ID() {
        return reader_ID;
    }

    public void setReader_ID(String reader_ID) {
        this.reader_ID = reader_ID;
    }

    public String getReader_Name() {
        return reader_Name;
    }

    public void setReader_Name(String reader_Name) {
        this.reader_Name = reader_Name;
    }

    public String getReader_Password() {
        return reader_Password;
    }

    public void setReader_Password(String reader_Password) {
        this.reader_Password = reader_Password;
    }

    public String getReader_Phone() {
        return reader_Phone;
    }

    public void setReader_Phone(String reader_Phone) {
        this.reader_Phone = reader_Phone;
    }

    public String getReader_Address() {
        return reader_Address;
    }

    public void setReader_Address(String reader_Address) {
        this.reader_Address = reader_Address;
    }

    public String getReader_Gender() {
        return reader_Gender;
    }

    public void setReader_Gender(String reader_Gender) {
        this.reader_Gender = reader_Gender;
    }

    public String getReader_Photo() {
        return reader_Photo;
    }

    public void setReader_Photo(String reader_Photo) {
        this.reader_Photo = reader_Photo;
    }

    public String getReader_Email() {
        return reader_Email;
    }

    public void setReader_Email(String reader_Email) {
        this.reader_Email = reader_Email;
    }

    public Integer getBorrow_Count() {
        return borrow_Count;
    }

    public void setBorrow_Count(Integer borrow_Count) {
        this.borrow_Count = borrow_Count;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "propagationID=" + propagationID +
                ", reader_ID='" + reader_ID + '\'' +
                ", reader_Name='" + reader_Name + '\'' +
                ", reader_Password='" + reader_Password + '\'' +
                ", reader_Phone='" + reader_Phone + '\'' +
                ", reader_Address='" + reader_Address + '\'' +
                ", reader_Gender='" + reader_Gender + '\'' +
                ", reader_Photo='" + reader_Photo + '\'' +
                ", reader_Email='" + reader_Email + '\'' +
                ", borrow_Count=" + borrow_Count +
                '}';
    }
}
