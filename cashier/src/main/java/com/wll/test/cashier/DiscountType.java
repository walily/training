package com.wll.test.cashier;

import com.wll.test.receipt.ReceiptCalculate;
import com.wll.test.receipt.ReceiptFormat;
import com.wll.test.receipt.ReceiptItem;

/**
 * Created by wll on 8/18/16.
 */
public enum DiscountType implements ReceiptFormat, ReceiptCalculate {
    none {
        public double get_Total_Money(ReceiptItem receiptItem) {
            return receiptItem.getTotal_count() * receiptItem.getProduct().getPrice();
        }

        public double get_Free_Money(ReceiptItem receiptItem) {
            return 0;
        }

        public int get_Free_Count(ReceiptItem receiptItem) {
            return 0;
        }

        public String detail(ReceiptItem receiptItem) {
            Product product = receiptItem.getProduct();
            return String.format(item1, product.getName(),  receiptItem.getTotal_count(), product.getUnit(), product.getPrice(), get_Total_Money(receiptItem));
        }
    },

    five_Percent_off {
        public double get_Total_Money(ReceiptItem receiptItem) {
            return receiptItem.getTotal_count() * receiptItem.getProduct().getPrice() * 0.95;
        }

        public double get_Free_Money(ReceiptItem receiptItem) {
            return receiptItem.getTotal_count() * receiptItem.getProduct().getPrice() * 0.05;
        }

        public int get_Free_Count(ReceiptItem receiptItem) {
            return 0;
        }

        public String detail(ReceiptItem receiptItem) {
            Product product = receiptItem.getProduct();
            return String.format(item2, product.getName(), receiptItem.getTotal_count(), product.getUnit(), product.getPrice(), get_Total_Money(receiptItem), get_Free_Money(receiptItem));
        }
    },

    two_Additional {
        public double get_Total_Money(ReceiptItem receiptItem) {
            return (receiptItem.getTotal_count() - get_Free_Count(receiptItem)) * receiptItem.getProduct().getPrice();
        }

        public double get_Free_Money(ReceiptItem receiptItem) {
            return get_Free_Count(receiptItem) * receiptItem.getProduct().getPrice();
        }

        public int get_Free_Count(ReceiptItem receiptItem) {
            int total_count = receiptItem.getTotal_count();
            return total_count/3;
        }

        public String detail(ReceiptItem receiptItem) {
            Product product = receiptItem.getProduct();
            return String.format(item1, product.getName(), receiptItem.getTotal_count(), product.getUnit(), product.getPrice(), get_Total_Money(receiptItem));
        }
    };

    private final static String item1 = "名称:%s, 数量:%d%s, 单价:%.02f(元), 小计:%.02f(元)";
    private final static String item2 = "名称:%s, 数量:%d%s, 单价:%.02f(元), 小计:%.02f(元), 节省:%.02f(元)";
}
