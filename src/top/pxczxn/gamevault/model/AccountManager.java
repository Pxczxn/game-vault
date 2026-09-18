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
            acconut_id = accounts.get(i).getId();
            if (acconut_id.equals(id)) {
                num_account = i;
                break;
            }
        }
        String account_propertyid = accounts.get(num_account).getPropertyid();
        for (int j = 0; j < properties.size(); j++) {
            if (account_propertyid.equals(properties.get(j).getPropertyid())) {
                propertyid = properties.get(j).getPropertyid();
            }
        }
        return "id：" + accounts.get(num_account).getId() +
                " 用户名：" + accounts.get(num_account).getName() +
                " 密码：" + passworjEncrypt(accounts.get(num_account).getPassword()) +
                " 等级：" + getProperties(properties, propertyid).getLevel() +
                " 金币：" + getProperties(properties, propertyid).getGold();
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

    //查询账号资产
    public static AccountProperty getProperties(ArrayList<AccountProperty> properties, String properrtyId) {
        int num = 0;
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).equals(properrtyId)) {
                num = i;
            }
        }
        return properties.get(num);
    }
}
