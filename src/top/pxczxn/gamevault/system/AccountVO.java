package top.pxczxn.gamevault.system;

import top.pxczxn.gamevault.model.Account;
import top.pxczxn.gamevault.model.AccountManager;

import java.util.Scanner;

import static top.pxczxn.gamevault.model.AccountManager.accountFind;
import static top.pxczxn.gamevault.util.accountUtil.*;

public class AccountVO {
    //注册
    public static void Logup() {
        Scanner sc = new Scanner(System.in);
        String userId = "000000";
        String userName = "";
        String userPassword = "";
        while (!checkRegisterInput(userId, "id")) {
            userId = String.valueOf(ramdomSixNum());
        }
        System.out.println(userId);

        System.out.print("取个满意的昵称：");
        while (true) {
            userName = sc.nextLine();
            if (!checkRegisterInput(userName, "name")) {
                System.out.println("昵称不能为空哦，重新取一个吧~");
            } else {
                break;
            }
        }
        System.out.print("输入您的密码（至少6位数）：");
        while (true) {
            userPassword = sc.nextLine();
            if (!checkRegisterInput(userPassword, "password")) {
                System.out.println("密码格式无效呢，请重新设置呢~（至少6位数）");
            } else {
                break;
            }
        }
        AccountManager.accountInfo(userId, userName, userPassword);
    }

    //登录
    public static void Login(){
        Scanner sc=new Scanner(System.in);
        System.out.print("请入您的id：");
        String id=sc.nextLine();
        if (id.length()>=6) {
            Account loginAccount = findAccountById(id);
            if (loginAccount == null) {
                System.out.println("您得账号似乎还没注册呢~");
            } else {
                System.out.print("输入您的密码：");
                String password = sc.nextLine();
                if (!password.equals(loginAccount.getPassword())) {
                    System.out.println("id或密码错误，请重新输入呢~");
                } else {
                    System.out.println("耶~登录成功！！！");
                    System.out.println(accountFind(id));
                }
            }
        }else{
            System.out.println("您似乎输入了无效id哦~");
        }

    }

}
