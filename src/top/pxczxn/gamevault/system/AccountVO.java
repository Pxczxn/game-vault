package top.pxczxn.gamevault.system;

import top.pxczxn.gamevault.model.AccountManager;

import java.util.Scanner;

import static top.pxczxn.gamevault.util.accountUtil.checkRegisterInput;
import static top.pxczxn.gamevault.util.accountUtil.ramdomSixNum;

public class AccountVO {

    public static void Login() {
        Scanner sc = new Scanner(System.in);
        String userId = "000000";
        String userName = "";
        String userPassword="";
        while (!checkRegisterInput(userId,"id")){
            userId=String.valueOf(ramdomSixNum());
        }
        System.out.println(userId);

        System.out.print("取个满意的昵称：");
        while (true) {
            userName=sc.nextLine();
            if (!checkRegisterInput(userName,"name")){
                System.out.println("昵称不能为空哦，重新取一个吧~");
            }else{
                break;
            }
        }

        System.out.print("输入您的密码（至少6位数）：");
        while (true){
            userPassword = sc.nextLine();
            if (!checkRegisterInput(userPassword,"password")){
                System.out.println("密码格式不合格，请重新设置呢~（至少6位数）");
            }else {
                break;
            }


        }

        AccountManager.accountInfo(userId, userName, userPassword);


    }




}
