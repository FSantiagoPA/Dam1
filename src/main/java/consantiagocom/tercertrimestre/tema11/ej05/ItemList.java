package consantiagocom.tercertrimestre.tema11.ej05;

import java.util.HashMap;

public class ItemList {
    protected static HashMap<String,Integer> itemList = new HashMap<>();
    private String object;
    private int stack;

    public static HashMap<String, Integer> getItemList() {
        return itemList;
    }

    public String getObject() {
        return object;
    }

    public int getStack() {
        return stack;
    }

    public ItemList(String object, int stack) {
        this.object = object;
        this.stack = stack;
    }

    public ItemList() {
        itemList.put("Sword",1);
        itemList.put("PickAxe",1);
        itemList.put("Wood",64);
        itemList.put("Dirt",64);
        itemList.put("Stone",64);
        itemList.put("EnderPearl",16);
        itemList.put("Egg",16);
    }

    public int confirmItem(String name){
        if( itemList.containsKey(name)){
            return 1;
        }
        return 0;
    }
}
