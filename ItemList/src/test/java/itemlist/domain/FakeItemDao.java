/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itemlist.domain;

import itemlist.dao.ItemDao;
import java.util.ArrayList;
import java.util.List;

public class FakeItemDao implements ItemDao {
List<Item> items;

public FakeItemDao(){
    items = new ArrayList<>();
}
    @Override
    public Item create(Item item) throws Exception {
     item.setId(items.size()+1);
     items.add(item);
     return item;
    }

    @Override
    public List<Item> getAll() {
        return items;
    }

    @Override
    public void setCheck(int id) throws Exception {
        for(Item item: items){
            if(item.getId()==id){
                item.setCheck();
            }
        }
    }
    
}
