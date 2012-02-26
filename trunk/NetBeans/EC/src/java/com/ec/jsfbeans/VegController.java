/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ec.jsfbeans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author CHIKI
 */
@ManagedBean ( name = "veg" )
@SessionScoped
public class VegController implements Serializable {
    
    private String item;
    private static Map<String, Integer> ratings = new HashMap<String, Integer>();
    private PieChartModel pieModel;
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    public void updateRating (ActionEvent event) {
        System.out.println(item);
        if ( ratings.containsKey(item) ) {
            ratings.put(item, ratings.get(item) + 1);
        }else {
            ratings.put(item, 0);
        }
       System.out.println(ratings);
       prepareChart();
    }
    
    public Map<String, Integer> getRatings(){
        return ratings;
    }
    
    public PieChartModel getPieModel() {  
        return pieModel;  
    }  
    @PostConstruct
    public void prepareChart () {
        System.out.println("preparing chart"); 
        pieModel = new PieChartModel(); 
         pieModel.set("Mushroom Chilli", ratings.get("0") != null ? ratings.get("0") : 0 );
         pieModel.set("Paneer Chilli", ratings.get("1") != null ? ratings.get("1") : 0 );
         pieModel.set("Mushroom Masala", ratings.get("2") != null ? ratings.get("2") : 0 );
         pieModel.set("Paneer Masala", ratings.get("3") != null ? ratings.get("3") : 0 );
    }
}
