/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.Foods;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khanh
 */
@Local
public interface FoodsFacadeLocal {

    void create(Foods foods);

    void edit(Foods foods);

    void remove(Foods foods);

    Foods find(Object id);

    List<Foods> findAll();

    List<Foods> findRange(int[] range);

    int count();

    public List<Foods> listOldFood(String us);

    
}
