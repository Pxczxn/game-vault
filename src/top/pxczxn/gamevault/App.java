package top.pxczxn.gamevault;

import top.pxczxn.gamevault.system.Menu;

import static top.pxczxn.gamevault.util.accountUtil.adminAccountInfo;

public class App {
    public static void main(String[] args) {
        adminAccountInfo();
        new Menu().init();
    }
}
