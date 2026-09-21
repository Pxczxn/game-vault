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
        return "id：" + accountId + " 昵称：" +
                accounts.get(findAccountIndexById(accountId)).getName() + " 密码：" + "*";
    }

    //查询账号资产
    public static String getProperties( String properrtyId) {
        String level = "等级：" + findPropertyByIndex(findPropertyIndexByPropertyId(properrtyId)).getLevel();
        String gold = "金币：" + findPropertyByIndex(findPropertyIndexByPropertyId(properrtyId)).getGold();
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

    //通过账号索引找账号
    public static Account findAccountByIndex(int index){
        return index==-1?null:accounts.get(index);

    }

    //通过资产索引找资产
    public static AccountProperty findPropertyByIndex(int index){
        return index==-1?null:properties.get(index);
    }


    //通过id找账号索引
    public static int findAccountIndexById(String id){
        int index = -1;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(id)){
                index=i;
            }
        }
        return index;
    }

    //通过资产id找资产索引
    public static int findPropertyIndexByPropertyId(String propertyId){
        int index=0;
        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getPropertyid().equals(propertyId)){
                index=i;
            }
        }
        return index;
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
