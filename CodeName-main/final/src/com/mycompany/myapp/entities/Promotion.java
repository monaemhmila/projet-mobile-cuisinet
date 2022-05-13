/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;


/**
 *
 * @author PC
 */
public class Promotion {
 
    int id;
    int pourcentage;
    
    public Promotion(int id,int pourcentage) {
        this.id = id;

        this.pourcentage = pourcentage;
      
    }

    public Promotion(int pourcentage) {

        this.pourcentage = pourcentage;

    }



    public Promotion() {
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }



    public int getpourcentage() {
        return  pourcentage;
    }

    public void setpourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }


    @Override
    public String toString() {
        
        return "Promotion{" + "id=" + id + ", pourcentage=" + pourcentage + '}';
    }

    
    

}
