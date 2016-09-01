package com.wll.test.garden;

import java.util.Calendar;

/**
 * Created by wll on 8/27/16.
 */
public class PaymentCalculator {

    public static int pay(Servant servant, Master master){
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        return pay(month, servant, master);
    }

    public static int pay(int month, Servant servant, Master master){
        return master.pay(servant, month);
    }
}
