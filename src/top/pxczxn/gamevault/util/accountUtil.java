package top.pxczxn.gamevault.util;

import top.pxczxn.gamevault.model.Account;
import top.pxczxn.gamevault.model.AccountProperty;

import java.util.Random;

import static top.pxczxn.gamevault.model.AccountManager.accounts;
import static top.pxczxn.gamevault.model.AccountManager.properties;

public class accountUtil {

    //创建账号
    public static Account accountCreate() {
        return new Account();
    }

    //创建账号资产
    public static AccountProperty propertyCreate() {
        return new AccountProperty();
    }

    //查询账号信息
    public static String getAccount(String accountId) {
        int num = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(accountId)) {
                num = i;
            }
        }
        String acconutId = accounts.get(num).getId();
        String acconutName = accounts.get(num).getName();
        return "id：" + acconutId + " 昵称：" + acconutName + " 密码：" + "*";
    }

    //查询账号资产
    public static String getProperties( String properrtyId) {
        int num = 0;
        for (int i = 0; i < properties.size(); i++) {
            if ((properties.get(i)).getPropertyid().equals(properrtyId)) {
                num = i;
            }
        }
        String level = "等级：" + properties.get(num).getLevel();
        String gold = "金币：" + properties.get(num).getGold();
        return  level +  gold;
    }

    //注册校验
    public static Boolean checkRegisterInput(String message, String messageType) {

        boolean flag=true;
        if (messageType.equals("id")) {
            for (int i = 0; i < accounts.size(); i++) {
                if (message.equals(accounts.get(i).getId())) {
                    flag = false;
                    break;
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

    public static AccountProperty findPropertiesByPropertyid(String propertyid){
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
        Account adminaccount = accountCreate();
        AccountProperty accountProperty = propertyCreate();
        adminaccount.setId("000000");
        adminaccount.setName("破星辰只寻你");
        adminaccount.setPassword("pxczxn000");
        adminaccount.setPropertyid("000000");
        accountProperty.setPropertyid("000000");
        accountProperty.setLevel(1);
        accountProperty.setGold(0);
        accounts.addFirst(adminaccount);
        properties.addFirst(accountProperty);
    }
}
