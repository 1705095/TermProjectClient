package sample;

public class ContactStudentTable {
    String name,email,date,status;
    public ContactStudentTable(String name,String email,String date,String status)
    {
        this.name=name;
        this.email=email;
        this.date=date;
        this.status=status;
    }
    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return  email;
    }
    public String getDate()
    {
        return  date;
    }
    public  String getStatus()
    {
        return status;
    }
    public void setName(String name)
    {
        this.name=name;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public void setDate(String date)
    {
        this.date=date;
    }
    public  void setStatus(String status)
    {
        this.status=status;
    }

}
