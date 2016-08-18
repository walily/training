package com.wll.test.receipt;

import com.wll.test.cashier.Cashier;
import com.wll.test.cashier.DiscountType;
import com.wll.test.cashier.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wll on 8/18/16.
 */
public class ReceiptPrinter {
    private ArrayList<ReceiptItem> all_Receipt_Items;
    private ArrayList<ReceiptItem> two_Additional_Receipt_Items;

    private final static String header = "***<没钱赚商店>购物清单***";
    private final static String seperator = "-----------------------------";
    private final static String totalConsume = "总计:%.02f(元)";
    private final static String totalDiscount = "节省:%.02f(元)";

    private final static String twoAdditional = "买二增一商品:";
    private final static String twoAdditional_item = "名称:%s, 数量:%d%s";

    public void output(String input){
        parse(input);

        print(header);

        for(ReceiptItem receiptItem : all_Receipt_Items){
            receiptItem.calculate();
            print(receiptItem.detail());
        }

        print(seperator);

        if(two_Additional_Receipt_Items != null){
            print(twoAdditional);
            for(ReceiptItem receiptItem : two_Additional_Receipt_Items){
                print(String.format(twoAdditional_item, receiptItem.getProduct().getName(), receiptItem.getFree_count(), receiptItem.getProduct().getUnit()));
            }
        }

        print(seperator);
        double total_consume = 0;
        double total_discount = 0;
        for(ReceiptItem receiptItem : all_Receipt_Items){
            total_consume += receiptItem.getTotal_money();
            total_discount += receiptItem.getFree_money();
        }
        print(String.format(totalConsume, total_consume));
        print(String.format(totalDiscount, total_discount));
    }

    private void parse(String input) {
        Map<String, ReceiptItem> map = new HashMap<String, ReceiptItem>();
        Map<String, ReceiptItem> map2 = new HashMap<String, ReceiptItem>();

        for(String one : input.substring(1, input.length()-1).split(",")){
            String[] info = one.split("-");
            String barCode = info[0].trim();
            Integer count   = info.length < 2 ? 1 : Integer.parseInt(info[1]);

            Product product = Cashier.getProductInfo(barCode);
            DiscountType discountType = Cashier.getDiscountType(barCode);

            ReceiptItem receiptItem;
            if(map.containsKey(product.getBarCode())){
                receiptItem = map.get(product.getBarCode());
            }
            else{
                receiptItem = new ReceiptItem();
                receiptItem.setProduct(product);
                receiptItem.setDiscountType(discountType);
                map.put(product.getBarCode(), receiptItem);
            }
            receiptItem.increase(count);

            if(discountType == DiscountType.two_Additional){
                map2.put(product.getBarCode(), receiptItem);
            }
        }
        all_Receipt_Items = new ArrayList<ReceiptItem>(map.values());
        two_Additional_Receipt_Items = new ArrayList<ReceiptItem>(map2.values());
    }

    private void print(String string){
        System.out.println(string);
    }
}
