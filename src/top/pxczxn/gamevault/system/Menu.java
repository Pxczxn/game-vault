package top.pxczxn.gamevault.system;

import java.util.Scanner;

public class Menu {
    public void init(){
        Scanner sc =new Scanner(System.in);
        System.out.print("""
                ====== 游戏账号管理系统 ======
                1. 注册账号
                2. 登录账号
                3. 查看所有账号
                4. 修改账号
                5. 删除账号
                6. 退出系统
                请选择：""");
        int choose =sc.nextInt();
        System.out.println(choose);
    }
}
