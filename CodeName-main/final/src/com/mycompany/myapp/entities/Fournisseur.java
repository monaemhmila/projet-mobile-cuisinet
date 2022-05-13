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
public class Fournisseur {
 
    int idfor,tel ;
    String nom;
    String descfor ;

    public Fournisseur(int idfor,int tel,String nom, String descfor) {
        this.idfor = idfor;
        this.tel = tel;
        this.nom = nom;
        this.descfor = descfor;
    }

    public Fournisseur(String nom, String descfor , int tel) {
        this.nom = nom;
        this.descfor = descfor;
        this.tel = tel;
    }

    public Fournisseur( int tel, String nom, String descfor) {
        this.tel = tel;
        this.nom = nom;
        this.descfor = descfor;
    }

    public Fournisseur() {
    }

    public int getIdfor() {
        return idfor;
    }

    public void setIdfor(int idfor) {
        this.idfor = idfor;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescfor() {
        return descfor;
    }

    public void setDescfor(String descfor) {
        this.descfor = descfor;
    }
    @Override
    public String toString() {
        return "Evenement{" + "idfor=" + idfor + ", tel=" + tel + ", nom=" + nom + ", descfor=" + descfor + '}';
    }
    

}
