/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Carrera;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fabio
 */
public class CarreraTableModel extends AbstractTableModel{
    List<Carrera> rows;
    int[] cols;

    public  CarreraTableModel(int[] cols, List<Carrera> rows){
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
        Carrera carrera = rows.get(row);
        switch (cols[col]){
            case CODIGO: return carrera.getCodigo();
            case NOMBRE: return carrera.getNombre();
            case TITULO: return carrera.getTitulo();            
            default: return "";
        }
    }    
    
    
    public static final int CODIGO=0;
    public static final int NOMBRE=1;
    public static final int TITULO=2;
    
    String[] colNames = new String[3];
    private void initColNames(){
        colNames[CODIGO]= "Codigo";
        colNames[NOMBRE]= "Nombre";
        colNames[TITULO]= "Titulo";
    }
    
    public Carrera getRowAt(int row) {
        return rows.get(row);
    }
}
