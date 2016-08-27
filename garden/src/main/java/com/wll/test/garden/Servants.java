package com.wll.test.garden;

/**
 * Created by wll on 8/27/16.
 */
public enum Servants implements Servant {
    QingWen {
        public int money_normal(int month) {
            return month % 2 == 0 ? 900 : 800;
        }

        public int money_reward(int month) {
            return 500;
        }
    },

    SheYue {
        public int money_normal(int month) {
            return 600;
        }

        public int money_reward(int month) {
            return month <= 6 ? 400 : 700;
        }
    },

    XiRen {
        public int money_normal(int month) {
            return month % 6 <= 3 ? 1000 : 1500;
        }

        public int money_reward(int month) {
            return 2000;
        }
    }
}
