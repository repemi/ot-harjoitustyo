package itemlist.dao;

import itemlist.domain.Item;
import java.util.List;


/**
 * Rajapinta tuotteelle. 
 */
public interface ItemDao {
    
    /**
     * Metodi luo uuden tuotteen.
     * @param item
     * @return
     * @throws Exception 
     */

    Item create(Item item) throws Exception;

    /**
     * Metodi palauttaa tuotteet.
     * @return tuotteet listana.
     */
    List<Item> getAll();

    /**
     * Asettaa tuotteen pakattujen listalle.
     * @param id
     * @throws Exception 
     */
    void setCheck(int id) throws Exception;

}
