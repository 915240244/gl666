package net.nice.bean;

public class Staff {
    private String staff_Number;
    private String staff_Name;
    private String staff_Password;
    private String staff_phone;

    public Staff() {
    }

    public Staff(String staff_Number, String staff_Password) {
        this.staff_Number = staff_Number;
        this.staff_Password = staff_Password;
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

    public String getStaff_Password() {
        return staff_Password;
    }

    public void setStaff_Password(String staff_Password) {
        this.staff_Password = staff_Password;
    }

    public String getStaff_phone() {
        return staff_phone;
    }

    public void setStaff_phone(String staff_phone) {
        this.staff_phone = staff_phone;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staff_Number='" + staff_Number + '\'' +
                ", staff_Name='" + staff_Name + '\'' +
                ", staff_Password='" + staff_Password + '\'' +
                ", staff_phone='" + staff_phone + '\'' +
                '}';
    }
}
