/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Profesor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fabio
 */
public class ProfesorTableModel extends AbstractTableModel{
    List<Profesor> rows;
    int[] cols;

    public  ProfesorTableModel(int[] cols, List<Profesor> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }

    public int getColumnCount() {
        return cols.length;
    }

    public String getColumnName(int col){
        return colNames[cols[col]];
    }
        
    public int getRowCount() {
        return rows.size();
    }

    public Object getValueAt(int row, int col) {
        Profesor curso = rows.get(row);
        switch (cols[col]){
            case NOMBRE: return curso.getNombre();
            case CEDULA: return curso.getCedula();
            case TELEFONO: return curso.getTel();
            case EMAIL: return curso.getEmail();            
            default: return "";
        }
    }    
    
    
    public static final int NOMBRE=0;
    public static final int CEDULA=1;
    public static final int TELEFONO=2;
    public static final int EMAIL=3;
    
    String[] colNames = new String[11];
    private void initColNames(){
        colNames[NOMBRE]= "Nombre";
        colNames[CEDULA]= "Cedula";
        colNames[TELEFONO]= "Telefono";
        colNames[EMAIL]= "Email";
    }
    
    public Profesor getRowAt(int row) {
        return rows.get(row);
    }
}

