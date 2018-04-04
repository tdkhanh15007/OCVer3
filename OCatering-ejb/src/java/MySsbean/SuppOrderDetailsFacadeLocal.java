/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.SuppOrderDetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khanh
 */
@Local
public interface SuppOrderDetailsFacadeLocal {

    void create(SuppOrderDetails suppOrderDetails);

    void edit(SuppOrderDetails suppOrderDetails);

    void remove(SuppOrderDetails suppOrderDetails);

    SuppOrderDetails find(Object id);

    List<SuppOrderDetails> findAll();

    List<SuppOrderDetails> findRange(int[] range);

    int count();
    
}
