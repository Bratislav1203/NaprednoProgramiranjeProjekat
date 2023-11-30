/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappclient.models;

import fon.ai.maventransportappcommon.domain.CostItem;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author stackOverflow
 */
public class ModelCostPrikaz extends AbstractTableModel{
    String[] kolone = {"Tip troska", "Iznos"};
    ArrayList<CostItem> costItems;

    public ModelCostPrikaz() {
        costItems = new ArrayList<>();
    }

    public ModelCostPrikaz(ArrayList<CostItem> costItems) {
        this.costItems = costItems;
    }
    
    
    @Override
    public int getRowCount() {
        return costItems.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        CostItem c = costItems.get(i);
        
        switch(i1){
            case 0: return c.getCostType().toString();
            case 1: return c.getAmount();
            default: return "n/a";
         }
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    public int getVelicinaListe() {
        return costItems.size();
    }
    
    
    
}
