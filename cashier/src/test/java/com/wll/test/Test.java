package com.wll.test;

import com.wll.test.cashier.Cashier;
import com.wll.test.cashier.DiscountType;
import com.wll.test.cashier.Product;
import com.wll.test.receipt.ReceiptPrinter;
import org.junit.Before;

/**
 * Created by wll on 8/19/16.
 */
public class Test {
    @Before
    public void before(){

        Product apple = new Product();
        apple.setBarCode("ITEM00001");
        apple.setCategory("");
        apple.setName("苹果");
        apple.setPrice(5.50);
        apple.setUnit("斤");

        Product cocacola = new Product();
        cocacola.setBarCode("ITEM00002");
        cocacola.setCategory("");
        cocacola.setName("可口可乐");
        cocacola.setPrice(3.00);
        cocacola.setUnit("瓶");

        Product badminton = new Product();
        badminton.setBarCode("ITEM00003");
        badminton.setCategory("");
        badminton.setName("羽毛球");
        badminton.setPrice(1.00);
        badminton.setUnit("个");

        Cashier.addProduct(apple);
        Cashier.addProduct(cocacola);
        Cashier.addProduct(badminton);

        Cashier.addDiscount(apple, DiscountType.five_Percent_off);
        Cashier.addDiscount(badminton, DiscountType.two_Additional);
        Cashier.addDiscount(cocacola, DiscountType.two_Additional);
    }

    @org.junit.Test
    public void test(){
        new ReceiptPrinter().output("[ITEM00001, ITEM00001, ITEM00002-3, ITEM00003-5]");
    }
}
