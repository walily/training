package com.wll.test.receipt;

/**
 * Created by wll on 8/18/16.
 */
public interface ReceiptCalculate {
    double get_Total_Money(ReceiptItem receiptItem);
    double get_Free_Money(ReceiptItem receiptItem);
    int get_Free_Count(ReceiptItem receiptItem);
}
