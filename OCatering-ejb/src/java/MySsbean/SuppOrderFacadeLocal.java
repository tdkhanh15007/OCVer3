/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.SuppOrder;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khanh
 */
@Local
public interface SuppOrderFacadeLocal {

    void create(SuppOrder suppOrder);

    void edit(SuppOrder suppOrder);

    void remove(SuppOrder suppOrder);

    SuppOrder find(Object id);

    List<SuppOrder> findAll();

    List<SuppOrder> findRange(int[] range);

    int count();
    
}
