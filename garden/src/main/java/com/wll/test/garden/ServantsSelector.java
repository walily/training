package com.wll.test.garden;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wll on 8/27/16.
 */
public class ServantsSelector {

    private static List<Integer> servantIndexList = new ArrayList<Integer>();

    private static List<Pair<Servant,Master>> pairList = new ArrayList<Pair<Servant,Master>>();

    static {
        for(int i=0; i< Servants.values().length; i++){
            servantIndexList.add(i);
        }

        for(Master master : Masters.values()) {
            for (int i = 0; i < master.servantNumber(); i++) {
                Servant servant = select();
                if (servant == null) {
                    continue;
                }
                pairList.add(new Pair<Servant, Master>(servant, master));
            }
        }
    }

    public static Servant select(){
        if(servantIndexList.size() <= 0){
            return null;
        }
        int index = new Random().nextInt(servantIndexList.size());
        Servant servant = Servants.values()[servantIndexList.get(index)];
        servantIndexList.remove(index);
        return servant;
    }

    public static void main(String[] args) {
        for(Pair<Servant, Master> pair : pairList){
            System.out.println(pair.key + " serves " + pair.value);
        }
    }

    public static class Pair<K, V>{
        public K key;
        public V value;

        public Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
