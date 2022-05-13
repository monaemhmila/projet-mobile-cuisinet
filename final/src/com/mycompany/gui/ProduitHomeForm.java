/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.Layout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author PC
 */
public class ProduitHomeForm  extends BaseForm{
    Form current ; 
    public ProduitHomeForm(Resources res){
        
        
         current=this; 
        refreshTheme();
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("List Materiel");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
        tb.addSearchCommand(e -> {});
        
        
     setTitle("cuisinet"); 
     setLayout(BoxLayout.y()); 
Container add = add(new Label ("Select an option ")); 
Button Add = new Button ("Materiel"); 
Button List = new Button ("Liste Materiel"); 
Add.addActionListener(e-> new ProduitForm(current,res).show()); 
List.addActionListener(e-> new ListProduitForm(current,res).show());

        Container addAll = addAll(Add, List); 
    
        
       /*    Container add2 = add(new Label ("Select an option ")); 
Button Add2 = new Button ("Evenement"); 
Button List2 = new Button ("Liste Evenement"); 
Add.addActionListener(e-> new EvenementForm(current).show()); 
List.addActionListener(e-> new ListeEvenementForm(current).show());

        Container addAll2 = addAll(Add2, List2); */
    }

  //  void addSideMenu(Resources res) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }

  /*  void addSideMenu(Resources res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */

    public ProduitHomeForm(String title, Layout contentPaneLayout) {
        super(title, contentPaneLayout);
    }
}
 