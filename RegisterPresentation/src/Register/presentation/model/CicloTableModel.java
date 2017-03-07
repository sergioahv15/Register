/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Ciclo;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fabio
 */
public class CicloTableModel extends AbstractTableModel{
    List<Ciclo> rows;
    int[] cols;

    public  CicloTableModel(int[] cols, List<Ciclo> rows){
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

    public Class<?> getColumnClass(int col){
        switch (cols[col]){
            case ACTIVO: return Boolean.class;
            default: return super.getColumnClass(col);
        }    
    }    
    
    public int getRowCount() {
        return rows.size();
    }

    public Object getValueAt(int row, int col) {
        Ciclo ciclo = rows.get(row);
        switch (cols[col]){
        case NUMERO: return ciclo.getNumero();
        case ANYO: return ciclo.getAnyo();
        case FECHA_INICIO: return ciclo.getFechaInicio();
        case FECHA_FIN: return ciclo.getFechaFin();
        case ACTIVO: return ciclo.isActivo(); 
        default: return "";
        }

    }    
    
    
    public static final int NUMERO=0;
    public static final int ANYO=1;
    public static final int FECHA_INICIO=2;
    public static final int FECHA_FIN=3;
    public static final int ACTIVO=4;  
    
    String[] colNames = new String[11];
    private void initColNames(){
        colNames[NUMERO]= "Numero";
        colNames[ANYO]= "Año";
        colNames[FECHA_INICIO]= "Fecha Inicio";
        colNames[FECHA_FIN]= "Fecha Fin";
        colNames[ACTIVO]= "Activo";
    }
    
    public Ciclo getRowAt(int row) {
        return rows.get(row);
    }
        
}
