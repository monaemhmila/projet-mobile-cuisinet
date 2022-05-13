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
import com.mycompany.gui.ListProduitForm;
import com.mycompany.myapp.entities.Produit;
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
public class ServiceProduit {

    public static ServiceProduit instance;

    public ServiceProduit() {
        req = new ConnectionRequest();
    }

    public static ServiceProduit getInstance() {
        if (instance == null) {
            instance = new ServiceProduit();
        }
        return instance;
    }
    public ArrayList<Produit> produit;
    private  ConnectionRequest req;
    public boolean resultOK;

    public boolean add(Produit p) {
        String url = Static.BASE_URL + "/AjouterProduitMobile?id=" + p.getid() + "&prix=" + p.getPrix() + "&nom=" + p.getNom()+ "&description=" + p.getdescription()+ "&type=" + p.gettype();

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

    public ArrayList<Produit> parseProduit(String jsonText) {

        try {
           produit = new ArrayList<>();
            JSONParser j = new JSONParser();
          
            
            Map<String, Object> evenementListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) evenementListJson.get("root");
       
            
            System.out.println("list = "+ list);
            for (Map<String, Object> obj : list) {
                
                            System.out.println("list = "+ obj);
                Produit p = new Produit();
                float id = Float.parseFloat(obj.get("id").toString());
                p.setid((int) id);
                p.setNom(obj.get("nom").toString());

                p.setdescription((obj).get("description").toString());
                float prix = Float.parseFloat(obj.get("prix").toString());
                p.settype(obj.get("type").toString());

                p.setPrix((int) prix);

                produit.add(p);
            }
        } catch (Exception e) {
        }
                                    System.out.println("mat = "+ produit);

        return produit;
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
    
    
    public ArrayList<Produit> getAllproduit() {
        req = new ConnectionRequest();
       String url = Static.BASE_URL+"/AfficherProduitsMobile";
        System.out.println("===>"+url);
      
       req.setUrl(url);
       req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                produit = parseProduit(new String(req.getResponseData()));
                System.out.println(produit);
                System.out.println("no");

                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return produit;
    }
    
    
    
    
    

    
    public boolean deleteProduit(int t) {
        String url = Static.BASE_URL + "/SupprimerProduitMobile?id=" + t;
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
    public boolean modifierProduit(Produit produit) {
        String url = Static.BASE_URL +"/UpdateProduitMobile?id="+produit.getid()+"&description="+produit.getdescription()+"&prix="+produit.getPrix()+"&nom="+produit.getNom()+"&type="+produit.gettype();
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
