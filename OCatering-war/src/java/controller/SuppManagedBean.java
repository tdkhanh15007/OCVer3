/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import MyEntity.District;
import MyEntity.Supplier;
import MySsbean.DistrictFacadeLocal;
import MySsbean.SupplierFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class SuppManagedBean {
    @EJB
    private DistrictFacadeLocal districtFacade;
    @EJB
    private SupplierFacadeLocal supplierFacade;

    int supID,distID;
    String name,address,phone,mess="";
    boolean status =true;

    public int getSupID() {
        return supID;
    }

    public void setSupID(int supID) {
        this.supID = supID;
    }

    public int getDistID() {
        return distID;
    }

    public void setDistID(int distID) {
        this.distID = distID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    /**
     * Creates a new instance of SuppManagedBean
     */
    public SuppManagedBean() {
    }
    
    public List<Supplier> listAll(){
        return supplierFacade.findAll();
    }
    
    public List<District> listD(){
        return districtFacade.findAll();
    }
    
    public String findSupp(int id){
        Supplier sp = supplierFacade.find(id);
        setSupID(id);
        setName(sp.getName());
        setAddress(sp.getAddress());
        setPhone(sp.getPhone());
        setDistID(sp.getDistrictId().getDistrictId());
        setStatus(sp.getStatus());
        return "updatesupp";
    }
    
    public String updateSupp(int id){
        try{
            Supplier sp = supplierFacade.find(id);
            District ds = districtFacade.find(distID);
            sp.setName(name);
            sp.setPhone(phone);
            sp.setAddress(address);
            sp.setDistrictId(ds);
            sp.setStatus(status);
            supplierFacade.edit(sp);
            return "supplier";
        }catch(Exception e){
            mess = e.getMessage();
            return "updatesupp";
        }
    }
    
    public String createSupp(){
        try{
            District ds = districtFacade.find(distID);
            Supplier sp = new Supplier(name, address, phone, status, ds);
            supplierFacade.create(sp);
            return "supplier";
        }catch(Exception e){
            mess = "met qua";
            return "createsupp";
        }
    }
}
