/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Grupo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fabio
 */
public class HistorialTableModel  extends AbstractTableModel{
    List<String> rows;
    int[] cols;

    public  HistorialTableModel(int[] cols, List<String> rows){
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
        String historial_str = rows.get(row);
        String delimitador = " ";
        String[] historial = historial_str.split(delimitador);
        switch (cols[col]){
            case CURSO: return historial[0];
            case NOTA: {if(historial.length==3)return historial[1]+" "+historial[2];else return historial[1];}
            default: return "";
        }
    }
    
    public static final int CURSO=0;
    public static final int NOTA=1;
    
    String[] colNames = new String[2];
    private void initColNames(){
        colNames[CURSO]= "Curso";
        colNames[NOTA]= "Nota";
    }
    
    public String getRowAt(int row) {
        return rows.get(row);
    }
}
