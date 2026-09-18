package top.pxczxn.gamevault.model;

public class AccountProperty {
    private String Propertyid;
    private int level;
    private long gold;


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getGold() {
        return gold;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    public String getPropertyid() {
        return Propertyid;
    }

    public void setPropertyid(String propertyid) {
        this.Propertyid=propertyid;
    }
}
