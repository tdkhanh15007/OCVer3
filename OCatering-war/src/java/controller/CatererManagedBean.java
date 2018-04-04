/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import MyEntity.Caterer;
import MyEntity.CusInvoice;
import MyEntity.District;
import MySsbean.CatererFacadeLocal;
import MySsbean.CusInvoiceFacadeLocal;
import MySsbean.CusOrderFacadeLocal;
import MySsbean.DistrictFacadeLocal;
import MySsbean.FavListFacadeLocal;
import dao.MainMethod;
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
public class CatererManagedBean {
    @EJB
    private FavListFacadeLocal favListFacade;
    @EJB
    private CusOrderFacadeLocal cusOrderFacade;
    @EJB
    private CusInvoiceFacadeLocal cusInvoiceFacade;
    @EJB
    private DistrictFacadeLocal districtFacade;
    @EJB
    private CatererFacadeLocal catererFacade;
    

    String caterer_us, password, address, phone, caterer_name, pass2, mess;
    int dist_id;
    boolean status = true;

    public String getCaterer_us() {
        return caterer_us;
    }

    public void setCaterer_us(String caterer_us) {
        this.caterer_us = caterer_us;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCaterer_name() {
        return caterer_name;
    }

    public void setCaterer_name(String caterer_name) {
        this.caterer_name = caterer_name;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public int getDist_id() {
        return dist_id;
    }

    public void setDist_id(int dist_id) {
        this.dist_id = dist_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDis(int id) {
        District ds = districtFacade.find(id);
        return ds.getDistname();
    }

    /**
     * Creates a new instance of CatererManagedBean
     */
    public CatererManagedBean() {
    }

    public List<Caterer> listAll() {
        return catererFacade.findAll();
    }

    public List<District> listD() {
        return districtFacade.findAll();
    }

    public String findCat(String us) {
        Caterer ct = catererFacade.find(us);
        setCaterer_us(ct.getCatererUs());
        setCaterer_name(ct.getCatererName());
        setPassword("");
        setDist_id(ct.getDistrictId().getDistrictId());
        setAddress(ct.getAddress());
        setStatus(ct.getStatus());
        setPhone(ct.getPhone());
        return "updatecat";
    }

    public String updateCat(String us) {
        try {
            MainMethod mmt = new MainMethod();
            String md5 = mmt.covertoMD5(password);
            Caterer ct = catererFacade.find(us);
            District ds = districtFacade.find(dist_id);
            ct.setCatererName(caterer_name);
            ct.setPassword(md5);
            ct.setAddress(address);
            ct.setStatus(status);
            ct.setPhone(phone);
            ct.setDistrictId(ds);
            catererFacade.edit(ct);
            return "caterer";
        } catch (Exception e) {
            return "updatecat";
        }
    }

    public String createCat() {
        try {
            District ds = districtFacade.find(dist_id);
            Caterer ct = new Caterer(caterer_us, password, address, status, phone, caterer_name, ds);
            catererFacade.create(ct);
            return "caterer";
        } catch (Exception e) {
            return "createcat";
        }
    }

    public int countInvoice(String cus_us) {
        int i = 0;
        List<Object[]> ls1 = cusInvoiceFacade.getOrderID();
        Caterer us = catererFacade.find(cus_us);
        i = cusOrderFacade.getCatererID(ls1, us.getCatererUs());
        return i;
    }
    
    public int countFav(String cus_us){
        int i = 0;
        Caterer us = catererFacade.find(cus_us);
        i = favListFacade.countFav(us.getCatererUs());
        return i;
    }

}
