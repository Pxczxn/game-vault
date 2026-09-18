package top.pxczxn.gamevault.system;

import top.pxczxn.gamevault.model.AccountManager;

import java.util.Scanner;

public class UserVO {

    public static void Login(){
        Scanner sc =new Scanner(System.in);
        System.out.print("取个满意的ID：");
        String userId=sc.nextLine();
        System.out.print("取个满意的昵称：");
        String userName = sc.nextLine();
        System.out.print("输入您的密码：");
        String userPassword=sc.nextLine();
        AccountManager.accountInfo(userId,userName,userPassword);
    }

}
