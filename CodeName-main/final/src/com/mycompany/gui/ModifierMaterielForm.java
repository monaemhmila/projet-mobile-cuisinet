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
import com.mycompany.myapp.entities.Materiel;
import com.mycompany.myapp.service.ServiceMateriel;

/**
 *
 * @author zribi
 */
public class ModifierMaterielForm extends BaseForm {
    
    Form current;
   public ModifierMaterielForm(Materiel r,Resources res) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Materiel");
        getContentPane().setScrollVisible(false);
        
        
        ////     TABDIL
        
         TextField id = new TextField(String.valueOf(r.getIdmat()) , "id" , 20 , TextField.ANY);

        TextField Descmat = new TextField(r.getDescmat() , "Descmat" , 20 , TextField.ANY);

        TextField prix = new TextField(String.valueOf(r.getPrix()) , "prix" , 20 , TextField.ANY);

    //    TextField image = new TextField(String.valueOf(r.getQuantite()) , "Prix" , 20 , TextField.ANY);
       //  TextField Id = new TextField(r.getId() , "id" , 20 , TextField.ANY);

        TextField Nom = new TextField(r.getNom() , "nom" , 20 , TextField.ANY);

     
        //etat bch na3mlo comobbox bon lazm admin ya3mlleha approuver mais just chnwarikom ComboBox
        
       
        
//        if(r.getEtat() == 0 ) {
//            etatCombo.setSelectedIndex(0);
//        }
//        else 
//            etatCombo.setSelectedIndex(1);
        id.setUIID("NewsTopLine");
        Descmat.setUIID("NewsTopLine");
        prix.setUIID("NewsTopLine");
        Nom.setUIID("NewsTopLine");
        
        
        id.setSingleLineTextArea(true);
        Descmat.setSingleLineTextArea(true);
        prix.setSingleLineTextArea(true);
        Nom.setSingleLineTextArea(true);
       
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   { 
           r.setIdmat(id.getAsInt(BASELINE));
           r.setDescmat(Descmat.getText());
           r.setPrix (prix.getAsInt(BASELINE));
         //  r.setImage(prix.getAsInt(BASELINE));
           r.setNom(Nom.getText());
       //appel fonction modfier reclamation men service
       
       if(ServiceMateriel.getInstance().modifierMateriel(r)) { // if true
           new ListMaterielForm(current,res).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           new ListMaterielForm(current,res).show();
       });
       
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
        Label l1 = new Label();
        
        /////   TABDIL
        
        Container content = BoxLayout.encloseY(
                l1, l2, 
                new FloatingHint(Descmat),
                new FloatingHint(prix),
                new FloatingHint(Nom),
               // new FloatingHint(imageP),
                btnModifier,
                btnAnnuler
                
               
        );
        
        add(content);
        show();
        
        
    }
}



    
