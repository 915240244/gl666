package net.nice.bean;

public class AdminStaff {

    private String Staff_Number;
    private String Staff_Name;
    private String Staff_Password;
    private String Staff_Phoner;

    public AdminStaff(String staff_Number, String staff_Password) {
        Staff_Number = staff_Number;
        Staff_Password = staff_Password;
    }
    public AdminStaff() {
    }

    @Override
    public String toString() {
        return "AdminStaff{" +
                "Staff_Number='" + Staff_Number + '\'' +
                ", Staff_Name='" + Staff_Name + '\'' +
                ", Staff_Password='" + Staff_Password + '\'' +
                ", Staff_Phoner='" + Staff_Phoner + '\'' +
                '}';
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

    public String getStaff_Password() {
        return Staff_Password;
    }

    public void setStaff_Password(String staff_Password) {
        Staff_Password = staff_Password;
    }

    public String getStaff_Phoner() {
        return Staff_Phoner;
    }

    public void setStaff_Phoner(String staff_Phoner) {
        Staff_Phoner = staff_Phoner;
    }
}
