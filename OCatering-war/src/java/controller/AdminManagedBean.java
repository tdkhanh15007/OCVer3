/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import MyEntity.Admin;
import MySsbean.AdminFacadeLocal;
import dao.AdminDAO;
import dao.MainMethod;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author K
 */
@ManagedBean
@RequestScoped
public class AdminManagedBean {

    @EJB
    private AdminFacadeLocal adminFacade;

    public AdminManagedBean() {
    }
    public String adm_us,adm_email,adm_pass,mess="",pass2;
    public boolean status=true;

    public String getAdm_us() {
        return adm_us;
    }

    public void setAdm_us(String adm_us) {
        this.adm_us = adm_us;
    }

    public String getAdm_email() {
        return adm_email;
    }

    public void setAdm_email(String adm_email) {
        this.adm_email = adm_email;
    }

    public String getAdm_pass() {
        return adm_pass;
    }

    public void setAdm_pass(String adm_pass) {
        this.adm_pass = adm_pass;
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

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }
    
    public List<Admin> listAdm(){
        return adminFacade.findAll();
    }
    
    public String createAdm(){
        try{
            Admin adm = new Admin(adm_us, adm_email, adm_pass, status);
            adminFacade.create(adm);
            return "index";
        }catch(Exception e){
            mess = "Can not create.";
            return "createadm";
        }
    }
    
    public String findAdm(String us){
        try{
            Admin adm = adminFacade.find(us);
            setAdm_us(adm.getAdminUs());
            setAdm_email(adm.getAdminEmail());
            setAdm_pass("");
            setStatus(adm.getStatus());
            return "updateadm";
        }catch(Exception e){
            return "index";
        }        
    }
    
    public String updateAdm(String us){
        try{
            Admin adm = adminFacade.find(us);
            adm.setAdminEmail(adm_email);
            adm.setPassword(adm_pass);
            adm.setStatus(status);
            adminFacade.edit(adm);
            return "index";
        }catch(Exception e){
            mess = "Can not update.";
            return "updateadm";
        }
    }
    
    
    
}
