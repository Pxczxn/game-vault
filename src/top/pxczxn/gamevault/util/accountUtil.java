package top.pxczxn.gamevault.util;

import top.pxczxn.gamevault.model.Account;
import top.pxczxn.gamevault.model.AccountProperty;

import java.util.ArrayList;
import java.util.Random;

import static top.pxczxn.gamevault.model.AccountManager.accounts;
import static top.pxczxn.gamevault.model.AccountManager.properties;

public class accountUtil {
    //加密密码
    public static String passworjEncrypt(String password) {
        return "*";
    }

    //创建账号
    public static Account accountCreate() {
        return new Account();
    }

    //创建账号资产
    public static AccountProperty propertyCreate() {
        return new AccountProperty();
    }

    //查询账号信息
    public static String getAccount(ArrayList<Account> properties, String accountId) {
        int num = 0;
        String acconutId = "";
        String acconutName = "";
        String acconutPassword = "";
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getId().equals(accountId)) {
                num = i;
            }
        }
        acconutId = properties.get(num).getId();
        acconutName = properties.get(num).getName();
        acconutPassword = passworjEncrypt(properties.get(num).getPassword());
        return "id：" + acconutId + " 昵称：" + acconutName + " 密码：" + acconutPassword;
    }

    //查询账号资产
    public static String getProperties(ArrayList<AccountProperty> properties, String properrtyId) {
        int num = 0;
        String level = "";
        String gold = "";
        for (int i = 0; i < properties.size(); i++) {
            if ((properties.get(i)).getPropertyid().equals(properrtyId)) {
                num = i;
            }
        }
        level = "等级：" + properties.get(num).getLevel();
        gold = "金币：" + properties.get(num).getGold();
        return " 等级：" + level + " gold:" + gold;
    }

    //注册校验
    public static Boolean checkRegisterInput(String message, String messageType) {

        boolean flag=true;
        if (messageType.equals("id")) {
            for (int i = 0; i < accounts.size(); i++) {
                if (message.equals(accounts.get(i).getId())) {
                    flag = false;
                }
            }
        }
        if (messageType.equals("name")) {
            if (message.isEmpty()) {
                flag = false;
            }
        }
        if (messageType.equals("password")) {
            if (message.length() < 6) {
                flag = false;
            }
        }
        return flag;
    }

    public static Account findAccountById(String id){
        boolean flag=false;
        int num=-1;
        for (int i = 0; i < accounts.size(); i++) {
            if (id.equals(accounts.get(i).getId())){
                flag= true;
                num=i;
                break;
            }
        }
        return flag?accounts.get(num):null;

    }

    public static AccountProperty findPropertieByPropertyid(String propertyid){
        int num=-1;
        for (int i = 0; i < properties.size(); i++) {
            if (propertyid.equals(properties.get(i).getPropertyid())){
                num=i;
                break;
            }
        }
        return properties.get(num);

    }


    //随机六位数
    public static int ramdomSixNum() {
        Random r = new Random();
        return r.nextInt(100000, 1000000);
    }

    public static void adminAccountInfo() {
        String adminId = "000000";
        String adminname = "破星辰只寻你";
        String adminpassword = "pxczxn000";
        String adminpropertieId = "000000";
        int adminlevel = 1;
        int admingold = 0;
        Account adminaccount = accountCreate();
        AccountProperty accountProperty = propertyCreate();
        adminaccount.setId(adminId);
        adminaccount.setName(adminname);
        adminaccount.setPassword(adminpassword);
        adminaccount.setPropertyid(adminpropertieId);
        accountProperty.setPropertyid(adminpropertieId);
        accountProperty.setLevel(adminlevel);
        accountProperty.setGold(admingold);
        accounts.addFirst(adminaccount);
        properties.addFirst(accountProperty);
    }
}
