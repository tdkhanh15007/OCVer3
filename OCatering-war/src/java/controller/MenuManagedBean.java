/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import MyEntity.Category;
import MyEntity.FoodMat;
import MyEntity.FoodMatPK;
import MyEntity.Foods;
import MyEntity.Material;
import MySsbean.CategoryFacadeLocal;
import MySsbean.CatererFacadeLocal;
import MySsbean.FoodMatFacadeLocal;
import MySsbean.FoodsFacadeLocal;
import MySsbean.MaterialFacadeLocal;
import MySsbean.SupplierFacadeLocal;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;

/**
 *
 * @author Khanh
 */
@ManagedBean
@RequestScoped
public class MenuManagedBean {

    @EJB
    private FoodMatFacadeLocal foodMatFacade;
    @EJB
    private FoodsFacadeLocal foodsFacade;
    @EJB
    private SupplierFacadeLocal supplierFacade;
    @EJB
    private MaterialFacadeLocal materialFacade;
    @EJB
    private CategoryFacadeLocal categoryFacade;
    @EJB
    private CatererFacadeLocal catererFacade;

    int id, category_id;
    double mat_quantity;
    String name, description, mess = "";
    Part file;
    String fileNamed, nameLike = "";
    List<Integer> listIDSearhMat;
    public List<FoodMat> listFM;

    public List<FoodMat> getListFM() {
        return listFM;
    }

    public void setListFM(List<FoodMat> listFM) {
        this.listFM = listFM;
    }

    public List<Integer> getListIDSearhMat() {
        return listIDSearhMat;
    }

    public void setListIDSearhMat(List<Integer> listIDSearhMat) {
        this.listIDSearhMat = listIDSearhMat;
    }

    public String getNameLike() {
        return nameLike;
    }

    public void setNameLike(String nameLike) {
        this.nameLike = nameLike;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getFileNamed() {
        return fileNamed;
    }

    public void setFileNamed(String fileNamed) {
        this.fileNamed = fileNamed;
    }

    public double getMat_quantity() {
        return mat_quantity;
    }

    public void setMat_quantity(double mat_quantity) {
        this.mat_quantity = mat_quantity;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Category> listC() {
        return categoryFacade.findAll();
    }

    public List<Material> listM() {
        return materialFacade.findAll();
    }
//
//    public List<FoodMat> listFM() {
//        return foodMatFacade.findAll();
//    }

    /**
     * Creates a new instance of MenuManagedBean
     */
    public MenuManagedBean() {
    }

    public List<Foods> listOld() {
        return foodsFacade.listOldFood("hoasu1");
    }

    public String createFood() {
        try {
            int testID = 0;
            Category ct = categoryFacade.find(category_id);
            InputStream input = file.getInputStream();
            String itemName = file.getSubmittedFileName();
            String filename = itemName.substring(
                    itemName.lastIndexOf("\\") + 1);
            fileNamed = filename;
            String dirPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/upload");
            File f = new File(dirPath + "\\" + filename);
            if (!f.exists()) {
                f.createNewFile();
            }
            FileOutputStream output = new FileOutputStream(f);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            resize(dirPath + "\\" + filename, dirPath + "\\" + filename, 200, 200);
            input.close();
            output.close();
            Foods foods = new Foods(name, description, fileNamed, ct);
            foodsFacade.create(foods);
            List<Foods> listFood = foodsFacade.findAll();
            for (Foods foods1 : listFood) {
                if (testID < foods1.getFoodId()) {
                    testID = foods1.getFoodId();
                }
            }
            id=testID;
            List<Material> listMat = materialFacade.findAll();
////            
//            System.out.println(listfood.get(listfood.lastIndexOf(listfood)));
            for (Material material : listMat) {
                FoodMatPK fmk = new FoodMatPK(material.getMatId(), testID);
                FoodMat fm = new FoodMat(fmk, 0);
                foodMatFacade.create(fm);
            }
            //reset name like to null values
            nameLike = "";
            return "recipe";
        } catch (Exception e) {
            mess = "Can not create";
            return "newfood";
        }
    }

    public void action22(int id1,int id2){
        System.out.println(id1+" met "+id2);
    }

    public void searchAction() {
        listFM = materialFacade.listMatbyName(nameLike, id);        
    }

    public String idtoName(int id) {
        return materialFacade.find(id).getName();
    }

//    public String createRecipe(){
//        try{
//            
//        }catch(Exception e){
//            
//        }
//    }
    public void resize(String inputImagePath,
            String outputImagePath, int scaledWidth, int scaledHeight)
            throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);

        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        // extracts extension of output file
        String formatName = outputImagePath.substring(outputImagePath
                .lastIndexOf(".") + 1);

        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath));
    }

}
