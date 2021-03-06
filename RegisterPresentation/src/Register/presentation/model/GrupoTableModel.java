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
public class GrupoTableModel extends AbstractTableModel{
    List<Grupo> rows;
    int[] cols;

    public  GrupoTableModel(int[] cols, List<Grupo> rows){
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
        Grupo grupo = rows.get(row);
        switch (cols[col]){
            case NUMERO: return grupo.getNumeroGrupo();
            case PROFE: return grupo.getProfesor().getNombre();
            case HORARIO: return grupo.getHorario();       
            default: return "";
        }
    }    
    
    
    public static final int NUMERO=0;
    public static final int PROFE=1;
    public static final int HORARIO=2;
    
    String[] colNames = new String[11];
    private void initColNames(){
        colNames[NUMERO]= "Numero";
        colNames[PROFE]= "Profesor";
        colNames[HORARIO]= "Horario";
    }
    
    public Grupo getRowAt(int row) {
        return rows.get(row);
    }
}
