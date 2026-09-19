package top.pxczxn.gamevault.model;

import java.util.ArrayList;
import java.util.Random;

public class AccountManager {
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<AccountProperty> properties = new ArrayList<>();

    //初始化账号信息
    public static void accountInfo(String userId, String userName, String userPassword) {
        Random r = new Random();
        String propertyid = String.valueOf(r.nextInt(100000, 1000000));
        Account account = accountCreate();
        AccountProperty property = propertyCreate();
        account.setId(userId);
        account.setName(userName);
        account.setPassword(userPassword);
        account.setPropertyid(propertyid);
        property.setPropertyid(propertyid);
        property.setLevel(1);
        property.setGold(0);
        accounts.addLast(account);
        properties.addLast(property);
    }

    //查询所有账号
    public static void accountFindAll(ArrayList<Account> accounts,ArrayList<AccountProperty> properties) {

        for (int i = 0; i < accounts.size(); i++) {
            String message = accountFind(accounts,properties, accounts.get(i).getId());
            System.out.println(message);
        }
    }

    //查询指定账号
    public static String accountFind(ArrayList<Account> accounts, ArrayList<AccountProperty> properties, String id) {
        String acconut_id = "0";
        int num_account = 0;
        String propertyid = "0";
        for (int i = 0; i < accounts.size(); i++) {
            if (acconut_id.equals(id)) {
                num_account = i;
                break;
            }
            acconut_id = accounts.get(i).getId();
        }
        String account_propertyid = accounts.get(num_account).getPropertyid();
        for (int j = 0; j < properties.size(); j++) {
            if (account_propertyid.equals(properties.get(j).getPropertyid())) {
                propertyid = properties.get(j).getPropertyid();
            }
        }
        return getAccount(accounts,acconut_id,"id")+" "+
                getAccount(accounts,acconut_id,"name")+" "+
                getAccount(accounts,acconut_id,"password")+" "+
                getProperties(properties,propertyid,"level")+" "+
                getProperties(properties,propertyid,"gold");
    }

    //创建账号
    public static Account accountCreate() {
        return new Account();
    }

    //创建账号资产
    public static AccountProperty propertyCreate() {
        return new AccountProperty();
    }

    //加密密码
    public static String passworjEncrypt(String password) {
        StringBuilder resule = new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            resule.append("*");
        }
        return resule.toString();
    }

    //查询账号信息
    public static String getAccount(ArrayList<Account> properties,String accountId,String account){
        int num =0;
        String acconutId="";
        String acconutName="";
        String acconutPassword="";
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getId().equals(accountId)){
                num=i;
            }
        }
        acconutId="id："+properties.get(num).getId();
        acconutName="昵称："+properties.get(num).getName();
        acconutPassword="密码："+passworjEncrypt(properties.get(num).getPassword());
        return account.equals("id")?acconutId:(account.equals("name")?acconutName:acconutPassword);
    }

    //查询账号资产
    public static String getProperties(ArrayList<AccountProperty> properties, String properrtyId,String property) {
        int num = 0;
        String level="";
        String gold="";
        for (int i = 0; i < properties.size(); i++) {
            if ((properties.get(i)).getPropertyid().equals(properrtyId)) {
                num = i;
            }
        }
        level = "等级："+properties.get(num).getLevel();
        gold = "金币："+ properties.get(num).getGold();
        return property.equals("level")?level:gold;
    }
}
