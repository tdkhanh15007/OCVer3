/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MySsbean;

import MyEntity.FoodMat;
import MyEntity.FoodMatPK;
import MyEntity.Foods;
import MyEntity.Material;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Khanh
 */
@Local
public interface FoodMatFacadeLocal {

    void create(FoodMat foodMat);

    void edit(FoodMat foodMat);

    void remove(FoodMat foodMat);

    FoodMat find(Object id);

    List<FoodMat> findAll();

    List<FoodMat> findRange(int[] range);

    int count();

    public FoodMat returnFM(int idF, int idM);
    
}
