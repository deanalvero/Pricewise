package com.lowbottgames.pricewise.manager;

import com.lowbottgames.pricewise.model.PItem;

import java.util.ArrayList;

/**
 * Created by Dean on 12/14/2015.
 */
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
    }

    public void remove(int index){
        itemList.remove(index);
    }

    public void clear(){
        itemList.clear();
    }

}
