/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Fournisseur;
import com.mycompany.myapp.utils.Static;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public class ServiceFournisseur {

    public static ServiceFournisseur instance;

    public ServiceFournisseur() {
        req = new ConnectionRequest();
    }

    public static ServiceFournisseur getInstance() {
        if (instance == null) {
            instance = new ServiceFournisseur();
        }
        return instance;
    }
    public ArrayList<Fournisseur> fournisseur;
    private  ConnectionRequest req;
    public boolean resultOK;

    public boolean add(Fournisseur p) {
        String url = Static.BASE_URL + "/mobile/AjouterFournisseur?Descfor=" + p.getDescfor() + "&tel=" + p.getTel() + "&nom=" + p.getNom();

        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;

    }

    public ArrayList<Fournisseur> parseFournisseur(String jsonText) {

        try {
           fournisseur = new ArrayList<>();
            JSONParser j = new JSONParser();
          
            
            Map<String, Object> evenementListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) evenementListJson.get("root");
       
            
            System.out.println("list = "+ list);
            for (Map<String, Object> obj : list) {
                
                            System.out.println("list = "+ obj);
                Fournisseur r = new Fournisseur();
                float id = Float.parseFloat(obj.get("idfor").toString());
                r.setIdfor((int) id);
                r.setDescfor((obj).get("descfor").toString());
                float tel = Float.parseFloat(obj.get("tel").toString());
                r.setTel((int) tel);
                r.setNom(obj.get("nom").toString());
                fournisseur.add(r);
            }
        } catch (Exception e) {
        }
                                    System.out.println("for = "+ fournisseur);

        return fournisseur;
    }
    

 /*   public ArrayList<Evenement>affichageEvenement(){
        ArrayList<Evenement> result = new ArrayList<>();
        
        String url = Static.BASE_URL+"/events";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>(){
            @Override
            public void actionPerformed(NetworkEvent evt){
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try(
                        Map<String,Object>mapEvenements = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                        
                        List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapEvenements.get("root");
                        
                        for(Map<String, Object> obj : listOfMaps)(
                                Evenement ev = new Evenement());
                        float id = Float.parseFloat(obj.get("id").toString());
                        String nom = obj.get("nom").toString();
                        String image = obj.get("image").toString();
                        
                        String DateConverter = obj.get("DateDebut").toString().substring(obj.get("DateDebut").toString().indexOf("timestamp")+ 10 , obj.get("obj").toString().lastIndexOf(")"));
                        Date currentTime = new Date(Double.valueOf(DateConverter).longValue()* 1000);
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        String dateString = formatter.format(currentTime);
                        ev.setDate(dateString);
                        
                        
                        
                        )catch(Exception ex){
                                
                                ex.printStackTrace();
                                }
            }
            
                }
    });
    
    */
    
    
    public ArrayList<Fournisseur> getAllfournisseur() {
        req = new ConnectionRequest();
       String url = Static.BASE_URL+"/mobile/Fournisseur";
        System.out.println("===>"+url);
      
       req.setUrl(url);
       req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                fournisseur = parseFournisseur(new String(req.getResponseData()));
                System.out.println(fournisseur);
                System.out.println("no");

                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return fournisseur;
    }
    
    
    
    
    

    
    public boolean deleteFournisseur(int t) {
        String url = Static.BASE_URL + "/mobile/SupprimerFournisseur?idfor=" + t;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    // update 
    public boolean modifierFournisseur(Fournisseur fournisseur) {
        String url = Static.BASE_URL +"/mobile/updateFournisseur?idfor="+fournisseur.getIdfor()+"&Descfor="+fournisseur.getDescfor()+"&tel="+fournisseur.getTel()+"&nom="+fournisseur.getNom();
        req.setUrl(url);
        System.out.println("aaaaaaaaaaa");
        req.addResponseListener(new ActionListener<NetworkEvent>(){
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200 ;
                req.removeResponseListener(this);
            }
        });
    NetworkManager.getInstance().addToQueueAndWait(req);
    return resultOK;
    
    }
    
    
    
    
}
