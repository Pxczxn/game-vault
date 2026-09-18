package top.pxczxn.gamevault.system;

import top.pxczxn.gamevault.model.UserAccount;

import java.util.Scanner;

public class UserVO {
    Scanner sc =new Scanner(System.in);
    public void Login(){
        System.out.print("取个满意的昵称：");
        String userId=sc.nextLine();
        String userName = sc.nextLine();
        String userPassword=sc.nextLine();
        UserAccount user =new UserAccount(userId,userName,userPassword);
    }

}
