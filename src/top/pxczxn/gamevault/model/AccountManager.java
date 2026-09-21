package top.pxczxn.gamevault.model;

import java.util.ArrayList;
import java.util.Scanner;

import static top.pxczxn.gamevault.util.accountUtil.*;

public class AccountManager {
    public static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<AccountProperty> properties = new ArrayList<>();

    //初始化账号信息
    public static void accountInfo(String userId, String userName, String userPassword) {
        String propertyid = String.valueOf(ramdomSixNum());
        Account account = accountCreate();
        AccountProperty property = propertyCreate();
        account.setId(userId);
        account.setName(userName);
        account.setPassword(userPassword);
        account.setPropertyid(propertyid);
        property.setPropertyid(propertyid);
        property.setLevel(1);
        property.setGold(0);
        accounts.addLast(account);
        properties.addLast(property);
    }

    //查询所有账号信息
    public static void accountFindAll() {
        System.out.println("====================== 所有账号列表 ========================");
        for (int i = 0; i < accounts.size(); i++) {
            Account account = findAccountByIndex(i);
            if (account != null) {
                System.out.println("id：" + account.getId() +
                        " 昵称：" + account.getName() +
                        " 密码：" + "*" +
                        " 等级：" + findPropertyByIndex(findPropertyIndexByPropertyId(account.getPropertyid())).getLevel() +
                        " 金币：" + findPropertyByIndex(findPropertyIndexByPropertyId(account.getPropertyid())).getGold());
            }

        }
    }

    //查询指定账号
    public static String accountFind(String id) {
        Account account = findAccountByIndex(findAccountIndexById(id));
        AccountProperty property;
        String message="您的账号似乎还没注册呢~";
        if (account != null) {
            property = findPropertyByIndex(findAccountIndexById(account.getPropertyid()));
            String accountMessage = getAccount(account.getId());
            String accountProperty = getProperties(property.getPropertyid());
            message=accountMessage+accountProperty;
        }

        return message;
    }

    //修改账号
    public static void updateAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入您的id：");
        String id = sc.nextLine();
        String name;
        String password;
        Account account = findAccountByIndex(findAccountIndexById(id));
        if (account != null) {
            System.out.print("你的新昵称？");
            name = sc.nextLine();
            if (name.equals(account.getName())) {
                System.out.println("不能跟旧昵称一样哦~");
            } else {
                if (checkRegisterInput(name, "name")) {
                    System.out.print("输入您的新密码呢：");
                    password = sc.nextLine();
                    if (password.equals(account.getPassword())) {
                        System.out.println("不能跟旧密码一样哦~");
                    } else {
                        if (checkRegisterInput(password, "password")) {
                            account.setName(name);
                            account.setPassword(password);
                            System.out.println("更新成功！！！");
                        } else {
                            System.out.println("密码格式无效呢，请重新设置呢~（至少6位数）");
                        }
                    }
                } else {
                    System.out.println("昵称不能为空哦~");
                }
            }
        } else {
            System.out.println("您得账号似乎还没注册呢~");
        }
    }

    //删除账号
    public static void deleteAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入您要删除账号的id：");
        String id = sc.nextLine();
        if (id.length() == 6) {
            Account deleteaccount = findAccountByIndex(findAccountIndexById(id));
            if (deleteaccount != null) {
                System.out.print("输入您的密码：");
                String password = sc.nextLine();
                if (!password.equals(deleteaccount.getPassword())) {
                    System.out.println("id或密码错误，请重新输入呢~");
                } else {
                    System.out.print("您真的要删除吗？（Y/N）");
                    String check = sc.nextLine();
                    if (check.equals("Y") | check.equals("y")) {
                        AccountProperty deleteproperty = findPropertyByIndex(findPropertyIndexByPropertyId(findAccountByIndex(findAccountIndexById(id)).getPropertyid()));
                        properties.remove(deleteproperty);
                        accounts.remove(deleteaccount);
                        System.out.println("删除成功，我会想你的~");
                    } else if (check.equals("N") | check.equals("n")) {
                        System.out.println("好滴，已终止删除流程~");
                    } else {
                        System.out.println("好像输入无效呢（Y/N）");
                    }
                }
            } else {
                System.out.println("您得账号似乎还没注册呢~");
            }
        } else {
            System.out.println("您似乎输入了无效id哦~");
        }
    }
}

