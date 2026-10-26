package top.pxczxn.gamevault.system;

import top.pxczxn.gamevault.util.*;
import top.pxczxn.gamevault.model.accountManager;

import java.util.Scanner;

public class menuProperty {
    public static void menu_property_manager(){
        Scanner sc =new Scanner(System.in);
        boolean flag=true;
        while (flag){
            System.out.print("""
                    ========== 账号资产管理 ==========
                    
                    1. 查看账号资产
                    2. 给账号加金币
                    3. 查看等级排行榜
                    4. 返回主菜单
                    
                    请选择：
                    """);
            int choose=sc.nextInt();

            switch (choose){
                case 1-> accountManager.findProperty();
                case 2-> System.out.print("给账号加金币");
                case 3-> accountUtil.sortByLevel();
                case 4-> flag=false;
            }

        }

    }

}
