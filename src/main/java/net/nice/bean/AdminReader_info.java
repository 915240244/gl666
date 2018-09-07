package net.nice.bean;

public class AdminReader_info {
    private  int propagationID;
    private  String Reader_ID;
    private  String Reader_Name;
    private  String Reader_Password;
    private  String Reader_Phone;
    private  String Reader_Address;
    private  char Reader_Gender;
    private  String Reader_Photo;
    private  String Reader_Email;
    private  int Borrow_Count;

    @Override
    public String toString() {
        return "AdminReader_info{" +
                "propagationID=" + propagationID +
                ", Reader_ID='" + Reader_ID + '\'' +
                ", Reader_Name='" + Reader_Name + '\'' +
                ", Reader_Password='" + Reader_Password + '\'' +
                ", Reader_Phone='" + Reader_Phone + '\'' +
                ", Reader_Address='" + Reader_Address + '\'' +
                ", Reader_Gender=" + Reader_Gender +
                ", Reader_Photo='" + Reader_Photo + '\'' +
                ", Reader_Email='" + Reader_Email + '\'' +
                ", Borrow_Count=" + Borrow_Count +
                '}';
    }

    public int getPropagationID() {
        return propagationID;
    }

    public void setPropagationID(int propagationID) {
        this.propagationID = propagationID;
    }

    public String getReader_ID() {
        return Reader_ID;
    }

    public void setReader_ID(String reader_ID) {
        Reader_ID = reader_ID;
    }

    public String getReader_Name() {
        return Reader_Name;
    }

    public void setReader_Name(String reader_Name) {
        Reader_Name = reader_Name;
    }

    public String getReader_Password() {
        return Reader_Password;
    }

    public void setReader_Password(String reader_Password) {
        Reader_Password = reader_Password;
    }

    public String getReader_Phone() {
        return Reader_Phone;
    }

    public void setReader_Phone(String reader_Phone) {
        Reader_Phone = reader_Phone;
    }

    public String getReader_Address() {
        return Reader_Address;
    }

    public void setReader_Address(String reader_Address) {
        Reader_Address = reader_Address;
    }

    public char getReader_Gender() {
        return Reader_Gender;
    }

    public void setReader_Gender(char reader_Gender) {
        Reader_Gender = reader_Gender;
    }

    public String getReader_Photo() {
        return Reader_Photo;
    }

    public void setReader_Photo(String reader_Photo) {
        Reader_Photo = reader_Photo;
    }

    public String getReader_Email() {
        return Reader_Email;
    }

    public void setReader_Email(String reader_Email) {
        Reader_Email = reader_Email;
    }

    public int getBorrow_Count() {
        return Borrow_Count;
    }

    public void setBorrow_Count(int borrow_Count) {
        Borrow_Count = borrow_Count;
    }

    public AdminReader_info() {
    }
}
