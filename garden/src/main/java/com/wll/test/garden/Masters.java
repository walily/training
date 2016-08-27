package com.wll.test.garden;

/**
 * Created by wll on 8/27/16.
 */
public enum  Masters implements Master {

    BaoYu{
        public int pay(Servant servant, int month) {
            return 8 * (servant.money_normal(month) + servant.money_reward(month));
        }
    },

    GrandMa{
        public int pay(Servant servant, int month) {
            return 10 * Math.max(servant.money_normal(month), servant.money_reward(month));
        }
    },

    MrsWang{
        public int pay(Servant servant, int month) {
            return 5 * Math.min(servant.money_normal(month), servant.money_reward(month));
        }
    },

    JiaZheng{
        public int pay(Servant servant, int month) {
            return 4 * servant.money_normal(month) + 2 * servant.money_reward(month);
        }
    }
}
