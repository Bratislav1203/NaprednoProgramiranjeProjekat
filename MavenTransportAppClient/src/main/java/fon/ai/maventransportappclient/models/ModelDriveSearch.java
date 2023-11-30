/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fon.ai.maventransportappclient.models;

import fon.ai.maventransportappcommon.domain.Drive;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author stackOverflow
 */
public class ModelDriveSearch extends AbstractTableModel{
    private ArrayList<Drive> drives;
    private String[] columns = {"BrCMR", "Date", "FacturePrice", "Truck", "Trailer", "Driver"};
    public ModelDriveSearch() {
        drives = new ArrayList<>();
    }

    public ModelDriveSearch(ArrayList<Drive> drives) {
        this.drives = drives;
    }
    
    @Override
    public int getRowCount() {
        return drives.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Drive d = drives.get(i);
        switch(i1){
            case 0: return d.getId();
            case 1: return sdf.format(d.getDate());
            case 2: return d.getFacturePrice();
            case 3: return d.getT().getRegistrationMark();
            case 4: return d.getTr().getRegistrationMark();
            case 5: return d.getD().getIDCard();
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int i) {
        return columns[i];
    }

    public void search(String filter) {
        ArrayList<Drive> filterList = new ArrayList<>();
        for (Drive d : drives) {
            if(Integer.toString(d.getId()).contains(filter) || d.getT().getRegistrationMark().contains(filter) || d.getTr().getRegistrationMark().contains(filter)){
                filterList.add(d);
            }
        }
        drives = filterList;
        fireTableDataChanged();
    }

    public ArrayList<Drive> getDrives() {
        return drives;
    }

    public void setDrives(ArrayList<Drive> drives) {
        this.drives = drives;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public Drive getSelectedRow(int row) {
        return drives.get(row);
    }
    
    public void add(Drive d){
        drives.add(d);
    }
    
}
