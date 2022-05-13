/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Produit;
import com.mycompany.myapp.service.ServiceProduit;

/**
 *
 * @author zribi
 */
public class ModifierProduitForm extends BaseForm {
    
    Form current;
   public ModifierProduitForm(Produit p,Resources res) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Produit");
        getContentPane().setScrollVisible(false);
        
        
        ////     TABDIL
        
         TextField id = new TextField(String.valueOf(p.getid()) , "id" , 20 , TextField.ANY);
                 TextField Nom = new TextField(p.getNom() , "nom" , 20 , TextField.ANY);


        TextField description = new TextField(p.getdescription() , "description" , 20 , TextField.ANY);

        TextField prix = new TextField(String.valueOf(p.getPrix()) , "prix" , 20 , TextField.ANY);
         TextField type = new TextField(String.valueOf(p.gettype()) , "type" , 20 , TextField.ANY);


    //    TextField image = new TextField(String.valueOf(r.getQuantite()) , "Prix" , 20 , TextField.ANY);
       //  TextField Id = new TextField(r.getId() , "id" , 20 , TextField.ANY);


     
        //etat bch na3mlo comobbox bon lazm admin ya3mlleha approuver mais just chnwarikom ComboBox
        
       
        
//        if(r.getEtat() == 0 ) {
//            etatCombo.setSelectedIndex(0);
//        }
//        else 
//            etatCombo.setSelectedIndex(1);
        id.setUIID("NewsTopLine");
        description.setUIID("NewsTopLine");
        prix.setUIID("NewsTopLine");
        Nom.setUIID("NewsTopLine");
                type.setUIID("NewsTopLine");

        
        
        id.setSingleLineTextArea(true);
        description.setSingleLineTextArea(true);
        prix.setSingleLineTextArea(true);
        Nom.setSingleLineTextArea(true);
               type.setSingleLineTextArea(true);

        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           p.setid(id.getAsInt(BASELINE));
           p.setdescription(description.getText());
           p.setPrix (prix.getAsInt(BASELINE));
         //  r.setImage(prix.getAsInt(BASELINE));
           p.setNom(Nom.getText());
                      p.settype(type.getText());

       //appel fonction modfier reclamation men service
       
       if(ServiceProduit.getInstance().modifierProduit(p)) { // if true
           new ListProduitForm(current,res).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new ListProduitForm(current,res).show();
       });
       
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       Label l6 = new Label("");

       
        Label l1 = new Label();
        
        /////   TABDIL
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
                new FloatingHint(description),
                new FloatingHint(prix),
                new FloatingHint(Nom),
                new FloatingHint(type),

               // new FloatingHint(imageP),
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }
}



    
