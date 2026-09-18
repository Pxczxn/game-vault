package top.pxczxn.gamevault.model;


public class Account {
    private String id;
    private String name;
    private String password;
    private String Propertyid;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPropertyid() {
        return Propertyid;
    }

    public void setPropertyid(String propertyid) {
        Propertyid = propertyid;
    }

    public Account(){
    }

    public Account(String id, String name, String password){
        this.id=id;
        this.name= name;
        this.password=password;
    }
}
