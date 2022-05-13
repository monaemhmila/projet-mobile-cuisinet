/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Produit {
 
    int id;
    float prix ;
    String type;
    String nom;
    String description ;

    public Produit(int id,float prix,String nom, String description,String type) {
        this.id = id;
        this.prix = prix;
        this.nom = nom;
        this.type = type;

        this.description = description;
    }

    public Produit(String nom, String description , float prix,String type) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.type = type;

    }

    public Produit( float prix, String nom, String description,String type) {
        this.prix = prix;
        this.nom = nom;
        this.description = description;
        this.type = type;
    }

    public Produit() {
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public float getPrix() {
        return  prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
         public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Produitt{" + "id=" + id + ", prix=" + prix + ", nom=" + nom + ", description=" + description + ", type=" + type + '}';
    }

    
    

}
