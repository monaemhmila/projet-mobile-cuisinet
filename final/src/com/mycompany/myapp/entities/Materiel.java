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
public class Materiel {
 
    int idmat,prix ;
    String nom;
    String descmat ;

    public Materiel(int idmat,int prix,String nom, String descmat) {
        this.idmat = idmat;
        this.prix = prix;
        this.nom = nom;
        this.descmat = descmat;
    }

    public Materiel(String nom, String descmat , int prix) {
        this.nom = nom;
        this.descmat = descmat;
        this.prix = prix;
    }

    public Materiel( int prix, String nom, String descmat) {
        this.prix = prix;
        this.nom = nom;
        this.descmat = descmat;
    }

    public Materiel() {
    }

    public int getIdmat() {
        return idmat;
    }

    public void setIdmat(int idmat) {
        this.idmat = idmat;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescmat() {
        return descmat;
    }

    public void setDescmat(String descmat) {
        this.descmat = descmat;
    }
    @Override
    public String toString() {
        return "Evenement{" + "idmat=" + idmat + ", prix=" + prix + ", nom=" + nom + ", descmat=" + descmat + '}';
    }
    

}
