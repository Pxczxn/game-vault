package top.pxczxn.gamevault.model;

import java.util.ArrayList;

import static top.pxczxn.gamevault.util.accountUtil.*;

public class AccountManager {
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<AccountProperty> properties = new ArrayList<>();

    //初始化账号信息
    public static void accountInfo(String userId, String userName, String userPassword) {
        String propertyid = String.valueOf(ramdomSixNum());
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

    //查询所有账号信息
    public static void accountFindAll(ArrayList<Account> accounts,ArrayList<AccountProperty> properties) {

        for (int i = 0; i < accounts.size(); i++) {
            String message = getAccount(accounts,accounts.get(i).getId())+
                            getProperties(properties,properties.get(i).getPropertyid());
            System.out.println(message);
        }
    }

    //查询指定账号
    public static String accountFind (String id) {
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
        return getAccount(accounts,acconut_id)+getProperties(properties,propertyid);
    }

}
