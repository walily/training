package com.wll.test.receipt;

import com.wll.test.cashier.DiscountType;
import com.wll.test.cashier.Product;

/**
 * Created by wll on 8/18/16.
 */
public class ReceiptItem {
    private Product product;
    private DiscountType discountType;

    private int total_count = 0;
    private int free_count = 0;
    private double total_money = 0;
    private double free_money = 0;

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public Product getProduct() {
        return product;
    }

    public void increase(int count) {
        total_count += count;
    }

    public int getTotal_count() {
        return total_count;
    }

    public int getFree_count() {
        return free_count;
    }

    public double getTotal_money() {
        return total_money;
    }

    public double getFree_money() {
        return free_money;
    }

    public void calculate(){
        free_count = discountType.get_Free_Count(this);
        free_money = discountType.get_Free_Money(this);
        total_money = discountType.get_Total_Money(this);
    }

    public String detail(){
        return discountType.detail(this);
    }

    @Override
    public boolean equals(Object o) {
        return this.product.getBarCode().equals(((ReceiptItem)o).product.getBarCode());
    }
}
