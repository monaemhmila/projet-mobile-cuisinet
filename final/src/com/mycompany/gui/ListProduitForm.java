/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.ui.BrowserComponent;
import com.codename1.ui.Button;
import com.codename1.ui.CN;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Produit;
import com.mycompany.myapp.service.ServiceProduit;

import java.io.IOException;

/**
 *
 * @author PC
 */
public class ListProduitForm extends BaseForm {

    private Resources theme;

    ListProduitForm(Form previous,Resources res) {
        
        
        
        refreshTheme();
        Toolbar tb = new Toolbar(true);
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("List user");
        getContentPane().setScrollVisible(false);
        
        super.addSideMenu(res);
        tb.addSearchCommand(e -> {});
        
        
        
        
        setTitle("List Produit");
        for (Produit p : ServiceProduit.getInstance().getAllproduit()) {
            addItem(p,res);
        }

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

    ListProduitForm(Resources res) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addItem(Produit p,Resources res) {
        Container C1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Label description = new Label("Description du produit : " + p.getdescription());
        Label prix = new Label("prix : " + p.getPrix());
        Label nom = new Label("Nom : " + p.getNom());
        Label type = new Label("type : " + p.gettype());


        Button btnsupprimer = new Button("supprimer");
        btnsupprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ServiceProduit.getInstance().deleteProduit(p.getid());
            }
        });

        // Update icon
        /*   Label lModifier = new Label(" ");
       lModifier.setUIID("NewsTopLine");
       Style modifierStyle = new Style(lModifier.getUnselectedStyle());
       modifierStyle.setFgColor(0xf7ad02);
       
       FontImage mFontImage = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
       lModifier.setIcon(mFontImage);
       lModifier.setTextPosition(LEFT);
       
       lModifier.addPointerPressedListener(l -> {
     //   System.out.println("Update Event");
     new ModifierEvenementForm(res , v).show();
    });
         */
        ///// LISTEN TAA UPDATE
        Button btnupdate = new Button("update");
       btnupdate.addActionListener(new ActionListener() {
          @Override
           public void actionPerformed(ActionEvent evt) {
                ServiceProduit.getInstance().modifierProduit(p);

                new ModifierProduitForm(p,res).show();

            }
        });

        Label sep = new Label("------------------------------------------------------------------");
        C1.add(nom);
        C1.add(description);
        C1.add(prix);
        C1.add(type);

        C1.add(btnsupprimer);
       C1.add(btnupdate);
        C1.add(sep);
        C2.add(C1);
        add(C2);
    }

}
