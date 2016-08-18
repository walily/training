package com.wll.test.cashier;

import com.wll.test.receipt.ReceiptPrinter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wll on 8/18/16.
 */
public class Cashier {
    private static Map<String, Product> productMap = new HashMap<String, Product>();
    private static Map<String, DiscountType> discountMap = new HashMap<String, DiscountType>();

    public static void addProduct(Product product){
        productMap.put(product.getBarCode(), product);
    }

    public static void addDiscount(Product product, DiscountType discountType){
        if(!discountMap.containsKey(discountType) || discountMap.get(discountType) == DiscountType.five_Percent_off){
            discountMap.put(product.getBarCode(), discountType);
        }
    }

    public static Product getProductInfo(String barCode) {
        return productMap.get(barCode);
    }

    public static DiscountType getDiscountType(String barCode) {
        if(discountMap.containsKey(barCode)){
            return discountMap.get(barCode);
        }
        return DiscountType.none;
    }

    public static void print() {
        new ReceiptPrinter().output("");
    }
}
