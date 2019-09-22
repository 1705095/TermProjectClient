package sample;

public class RankingTable {
    String Name;
    int Mark,Pos;
    public RankingTable(String Name,int Mark, int Pos)
    {
        this.Name=Name;
        this.Mark=Mark;
        this.Pos=Pos;

    }
    public String getName()
    {
        return Name;
    }
    public void setName(String name)
    {
        this.Name=Name;
    }
    public  int getMark()
    {
        return  Mark;
    }
    public  void setMark(int Mark)
    {
        this.Mark=Mark;
    }
}
