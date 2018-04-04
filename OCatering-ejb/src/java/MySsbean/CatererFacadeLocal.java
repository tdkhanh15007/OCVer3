/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.Caterer;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khanh
 */
@Local
public interface CatererFacadeLocal {

    void create(Caterer caterer);

    void edit(Caterer caterer);

    void remove(Caterer caterer);

    Caterer find(Object id);

    List<Caterer> findAll();

    List<Caterer> findRange(int[] range);

    int count();

    public List<Object[]> getCatererUS();
    
}
