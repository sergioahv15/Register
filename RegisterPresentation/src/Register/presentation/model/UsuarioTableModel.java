/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Usuario;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fabio
 */
public class UsuarioTableModel extends AbstractTableModel{
    List<Usuario> rows;
    int[] cols;

    public  UsuarioTableModel(int[] cols, List<Usuario> rows){
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
        Usuario curso = rows.get(row);
        switch (cols[col]){
            case CEDULA: return curso.getCedula();
            case TIPO: return curso.getTipo();         
            default: return "";
        }
    }    
    

    public static final int CEDULA=0;
    public static final int TIPO=1;
    
    String[] colNames = new String[12];
    private void initColNames(){
        colNames[CEDULA]= "Cedula";
        colNames[TIPO]= "Tipo";
    }
    
    public Usuario getRowAt(int row) {
        return rows.get(row);
    }
}

