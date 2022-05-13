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
import com.mycompany.myapp.entities.Materiel;
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
public class ServiceMateriel {

    public static ServiceMateriel instance;

    public ServiceMateriel() {
        req = new ConnectionRequest();
    }

    public static ServiceMateriel getInstance() {
        if (instance == null) {
            instance = new ServiceMateriel();
        }
        return instance;
    }
    public ArrayList<Materiel> materiel;
    private  ConnectionRequest req;
    public boolean resultOK;

    public boolean add(Materiel p) {
        String url = Static.BASE_URL + "/mobile/Ajoutermateriel?Descmat=" + p.getDescmat() + "&prix=" + p.getPrix() + "&nom=" + p.getNom();

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

    public ArrayList<Materiel> parseMateriel(String jsonText) {

        try {
           materiel = new ArrayList<>();
            JSONParser j = new JSONParser();
          
            
            Map<String, Object> evenementListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) evenementListJson.get("root");
       
            
            System.out.println("list = "+ list);
            for (Map<String, Object> obj : list) {
                
                            System.out.println("list = "+ obj);
                Materiel r = new Materiel();
                float id = Float.parseFloat(obj.get("idmat").toString());
                r.setIdmat((int) id);
                r.setDescmat((obj).get("descmat").toString());
                float prix = Float.parseFloat(obj.get("prix").toString());
                r.setPrix((int) prix);
                r.setNom(obj.get("nom").toString());
                materiel.add(r);
            }
        } catch (Exception e) {
        }
                                    System.out.println("mat = "+ materiel);

        return materiel;
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
    
    
    public ArrayList<Materiel> getAllmateriel() {
        req = new ConnectionRequest();
       String url = Static.BASE_URL+"/mobile/materiel";
        System.out.println("===>"+url);
      
       req.setUrl(url);
       req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                materiel = parseMateriel(new String(req.getResponseData()));
                System.out.println(materiel);
                System.out.println("no");

                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return materiel;
    }


        public boolean exel() {
        String url = Static.BASE_URL + "/exel";
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
        
    public boolean deleteMateriel(int t) {
        String url = Static.BASE_URL + "/mobile/SupprimerMateriel?idmat=" + t;
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
    public boolean modifierMateriel(Materiel materiel) {
        String url = Static.BASE_URL +"/mobile/updateMateriel?idmat="+materiel.getIdmat()+"&descmat="+materiel.getDescmat()+"&prix="+materiel.getPrix()+"&nom="+materiel.getNom();
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
