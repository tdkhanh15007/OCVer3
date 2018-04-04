/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.SuppInvoice;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khanh
 */
@Local
public interface SuppInvoiceFacadeLocal {

    void create(SuppInvoice suppInvoice);

    void edit(SuppInvoice suppInvoice);

    void remove(SuppInvoice suppInvoice);

    SuppInvoice find(Object id);

    List<SuppInvoice> findAll();

    List<SuppInvoice> findRange(int[] range);

    int count();
    
}
