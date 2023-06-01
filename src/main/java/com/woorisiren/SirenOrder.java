package com.woorisiren;

import com.woorisiren.exception.BalanceException;
import com.woorisiren.io.Console;
import com.woorisiren.model.Item;
import com.woorisiren.model.Menu;
import com.woorisiren.model.Order;
import com.woorisiren.model.Store;
import com.woorisiren.model.StoreList;
import com.woorisiren.model.User;

public class SirenOrder {

    public static void order() {
        SirenOrder main = new SirenOrder();
        int result = 2;

        while (result != 1) {
            try {
                main.run();
                break;
            } catch (BalanceException e) {
                result = checkRetry();
            }
        }

    }

    private static int checkRetry() {
        Console.println("다시 주문하겠습니까? (1: 종료, 2: 다시 주문) : ");
        while (true) {
            String s = Console.read();
            if (!(s.equals("1") || s.equals("2"))) {
                continue;
            }
            return Integer.parseInt(s);
        }
    }

    private void run() {
        Console.println("===== 사이렌 오더 =====");
        StoreList storeList = new StoreList();
        Menu menu = new Menu();
        User user = new User("고객", 10_000);

        // 매장 정보 출력
        storeList.printStoreList();

        // 매장 선택
        Console.print("매장을 선택해주세요: ");
        int index = Console.readInt();
        Store store = storeList.getStore(index);

        // 상품 선택 (장바구니 추가)
        while (true) {
            Console.println();
            Console.println("====== 리스트 ======");
            menu.printMenu();
            Console.println();

            Console.print("상품번호를 선택해주세요: ");
            int itemNumber = Console.readInt();   // 상품 이름
            Item item = menu.getItem(itemNumber);
            item.setOptions();

            Console.print("수량을 입력해주세요: ");
            int count = Console.readInt();  // 상품 수량

            user.addToCart(item, count);
            if (isSelectFinish()) {
                break;
            }
        }

        // 주문 내역 확인 (장바구니 확인)
        user.printOrderList();

        // 계산
        Order order = user.pay();

        // 주문 내역 출력
        order.printResult(store);

    }

    private boolean isSelectFinish() {
        while (true) {
            Console.print("상품을 더 추가하시겠습니까? (1 or 2 // 1: Yes, 2: No): ");
            String choice = Console.read();

            if (!(choice.equals("1") || choice.equals("2"))) {
                Console.println("다시 입력해주세요");
                continue;
            }

            return Integer.parseInt(choice) == 2;
        }
    }

}
