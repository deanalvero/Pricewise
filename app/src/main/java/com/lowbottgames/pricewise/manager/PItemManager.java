package com.lowbottgames.pricewise.manager;

import com.lowbottgames.pricewise.model.PItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PItemManager {

    private static PItemManager INSTANCE;
    private ArrayList<PItem> itemList = new ArrayList<>();

    public static PItemManager getInstance(){
        if (INSTANCE == null){
            INSTANCE = new PItemManager();
        }
        return INSTANCE;
    }

    public ArrayList<PItem> getItemList(){ return this.itemList; }

    public void add(PItem item){
        itemList.add(item);
        Collections.sort(itemList, new Comparator<PItem>() {
            @Override
            public int compare(PItem o1, PItem o2) {
                if (o1.getRatio() > o2.getRatio()) {
                    return 1;
                } else if (o1.getRatio() < o2.getRatio()) {
                    return -1;
                }
                return 0;
            }
        });
    }

    public void remove(int index){
        itemList.remove(index);
    }

    public void clear(){
        itemList.clear();
    }

}
