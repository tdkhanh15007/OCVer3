/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.Worker;
import MyEntity.WorkerType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khanh
 */
@Local
public interface WorkerFacadeLocal {

    void create(Worker worker);

    void edit(Worker worker);

    void remove(Worker worker);

    Worker find(Object id);

    List<Worker> findAll();

    List<Worker> findRange(int[] range);

    int count();

//    public List<Worker> findType(WorkerType id);

    public List<Worker> findAllWorker();
    
}
