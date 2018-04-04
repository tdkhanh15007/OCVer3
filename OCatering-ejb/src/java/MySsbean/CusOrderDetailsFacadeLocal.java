/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.CusOrderDetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khanh
 */
@Local
public interface CusOrderDetailsFacadeLocal {

    void create(CusOrderDetails cusOrderDetails);

    void edit(CusOrderDetails cusOrderDetails);

    void remove(CusOrderDetails cusOrderDetails);

    CusOrderDetails find(Object id);

    List<CusOrderDetails> findAll();

    List<CusOrderDetails> findRange(int[] range);

    int count();
    
}
