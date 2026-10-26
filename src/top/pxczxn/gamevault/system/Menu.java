package top.pxczxn.gamevault.system;

import java.util.Scanner;

import static top.pxczxn.gamevault.model.accountManager.*;
import static top.pxczxn.gamevault.system.accountVO.Login;

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
                    6. 账号资产管理
                    7. 退出系统
                    ===========================
                    请选择：""");
            int choose = sc.nextInt();

            switch (choose){
                case 1-> accountVO.Logup();
                case 2-> Login();
                case 3-> accountFindAll();
                case 4-> updateAccount();
                case 5-> deleteAccount();
                case 6-> menuProperty.menu_property_manager();
                case 7-> System.exit(0);
                default -> System.out.println("输入好像无效呢~");
            }
        }
    }
}
