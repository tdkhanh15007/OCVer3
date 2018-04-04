/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import MySsbean.CatererFacadeLocal;
import MySsbean.CusInvoiceFacadeLocal;
import MySsbean.CusOrderFacadeLocal;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author K
 */
@ManagedBean
@RequestScoped
public class InvoiceCusBean {
    @EJB
    private CusOrderFacadeLocal cusOrderFacade;
    @EJB
    private CatererFacadeLocal catererFacade;
    @EJB
    private CusInvoiceFacadeLocal cusInvoiceFacade;
    
    
    public int count1,catererid;
    public String catererName;

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public int getCatererid() {
        return catererid;
    }

    public void setCatererid(int catererid) {
        this.catererid = catererid;
    }

    public String getCatererName() {
        return catererName;
    }

    public void setCatererName(String catererName) {
        this.catererName = catererName;
    }
    
    /**
     * Creates a new instance of InvoiceCusBean
     */
    public InvoiceCusBean() {
    }
    
    public String idtoName(int id){
        String name = catererFacade.find(id).getCatererName();
        return name;
    }
    
//    public int catererID(){
//        List<CusInvoice> listInvoice = cusInvoiceFacade.findAll();
//        for (int i = 0; i < listInvoice.size(); i++) {
//            
//        }
//    }
    
}
