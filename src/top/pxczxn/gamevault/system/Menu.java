package top.pxczxn.gamevault.system;

import java.util.Scanner;

import static top.pxczxn.gamevault.model.AccountManager.*;

public class Menu {
    public void init(){
        Scanner sc =new Scanner(System.in);

        while (true) {
            System.out.print("""
                    ====== 游戏账号管理系统 ======
                    1. 注册账号
                    2. 登录账号
                    3. 查看所有账号
                    4. 修改账号
                    5. 删除账号
                    6. 退出系统
                    ===========================
                    请选择：""");
            int choose = sc.nextInt();

            switch (choose){
                case 1-> AccountVO.Login();
                case 2-> System.out.println(choose);
                case 3-> accountFindAll(accounts,properties);
                case 4-> System.out.println(choose);
                case 5-> System.out.println(choose);
                case 6-> System.exit(0);
            }
        }
    }
}
