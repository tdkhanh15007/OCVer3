/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.MatSup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khanh
 */
@Local
public interface MatSupFacadeLocal {

    void create(MatSup matSup);

    void edit(MatSup matSup);

    void remove(MatSup matSup);

    MatSup find(Object id);

    List<MatSup> findAll();

    List<MatSup> findRange(int[] range);

    int count();
    
}
