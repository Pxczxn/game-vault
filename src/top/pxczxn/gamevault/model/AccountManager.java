package top.pxczxn.gamevault.model;

import java.util.ArrayList;
import java.util.Random;

public class AccountManager {
    public static ArrayList<Account> accounts=new ArrayList<>();
    static ArrayList<AccountProperty> properties=new ArrayList<>();

    //初始化账号信息
    public static void accountInfo(String userId,String userName,String userPassword){
        Random r =new Random();
        Account account =accountCreate();
        AccountProperty property=propertyCreate();
        account.setId(userId);
        account.setName(userName);
        account.setPassword(userPassword);
        property.setPropertyid(String.valueOf(r.nextInt(100000,1000000)));
        property.setLevel(1);
        property.setGold(0);
        accounts.addLast(account);
        properties.addLast(property);
    }

    //查询所有账号
    public static void accountFindAll(ArrayList<Account> accounts){

        for (int i = 0; i < accounts.size(); i++) {
            String message = accountFind(accounts,accounts.get(i).getId());
            System.out.println(message);
        }
    }

    //查询指定账号
    public static String accountFind(ArrayList<Account> accounts, String id){
        String acconut_id="0";
        int num=0;
        for (int i = 0; i < accounts.size(); i++) {
            acconut_id = accounts.get(i).getId();
            if (acconut_id.equals(id)) {
                num=i;
            }
        }

        return "id："+accounts.get(num).getId()+
                " 用户名："+accounts.get(num).getName()+
                " 密码："+passworjEncrypt(accounts.get(num).getPassword());
    }

    //创建账号
    public static Account accountCreate(){
        return new Account();
    }
    //创建账号资产
    public static AccountProperty propertyCreate(){
        return new AccountProperty();
    }
    //加密密码
    public static String passworjEncrypt(String password){
        StringBuilder resule= new StringBuilder();
        for (int i = 0; i < password.length(); i++) {
            resule.append("*");
        }
        return resule.toString();
    }

}
