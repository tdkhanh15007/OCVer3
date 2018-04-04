/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.WorkerSalary;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khanh
 */
@Local
public interface WorkerSalaryFacadeLocal {

    void create(WorkerSalary workerSalary);

    void edit(WorkerSalary workerSalary);

    void remove(WorkerSalary workerSalary);

    WorkerSalary find(Object id);

    List<WorkerSalary> findAll();

    List<WorkerSalary> findRange(int[] range);

    int count();
    
}
