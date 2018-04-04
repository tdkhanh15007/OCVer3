/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.FavList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khanh
 */
@Local
public interface FavListFacadeLocal {

    void create(FavList favList);

    void edit(FavList favList);

    void remove(FavList favList);

    FavList find(Object id);

    List<FavList> findAll();

    List<FavList> findRange(int[] range);

    int count();

    public int countFav(String us);
    
}
