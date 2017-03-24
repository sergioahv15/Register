/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;


import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fabio
 */
public class NotaTableModel extends AbstractTableModel{
    List<String> rows;
    int[] cols;

    public  NotaTableModel(int[] cols, List<String> rows){
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
        String nota_str = rows.get(row);
        String delimitador = " ";
        String[] nota = nota_str.split(delimitador);
        switch (cols[col]){
            case ESTUDIANTE: return nota[0];
            case NOTA: {if(nota.length==3)return nota[1]+" "+nota[2];else return nota[1];}
            default: return "";
        }
    }    
    
    //String cadena = "texto de que quieras";
   // String delimitadores= "[ .,;?!¡¿\'\"\\[\\]]+";
   // String[] palabrasSeparadas = cadena.split(delimitadores);
    
    public static final int ESTUDIANTE=0;
    public static final int NOTA=1;
    
    String[] colNames = new String[2];
    private void initColNames(){
        colNames[ESTUDIANTE]= "Estudiante";
        colNames[NOTA]= "Nota";
    }
    
    public String getRowAt(int row) {
        return rows.get(row);
    }
}
