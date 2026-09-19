package top.pxczxn.gamevault.model;

public class AccountProperty {
    private String Propertyid;
    private int level;
    private int gold;


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getPropertyid() {
        return Propertyid;
    }

    public void setPropertyid(String propertyid) {
        this.Propertyid=propertyid;
    }
}
