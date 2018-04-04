/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.CusInvoice;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khanh
 */
@Local
public interface CusInvoiceFacadeLocal {

    void create(CusInvoice cusInvoice);

    void edit(CusInvoice cusInvoice);

    void remove(CusInvoice cusInvoice);

    CusInvoice find(Object id);

    List<CusInvoice> findAll();

    List<CusInvoice> findRange(int[] range);

    int count();

    public List<Object[]> getOrderID();
    
}
