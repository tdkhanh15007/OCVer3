/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.WorkerType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khanh
 */
@Local
public interface WorkerTypeFacadeLocal {

    void create(WorkerType workerType);

    void edit(WorkerType workerType);

    void remove(WorkerType workerType);

    WorkerType find(Object id);

    List<WorkerType> findAll();

    List<WorkerType> findRange(int[] range);

    int count();
    
}
