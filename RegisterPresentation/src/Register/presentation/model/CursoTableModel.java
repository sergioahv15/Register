/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Curso;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Estudiante
 */
public class CursoTableModel extends AbstractTableModel{
    List<Curso> rows;
    int[] cols;

    public  CursoTableModel(int[] cols, List<Curso> rows){
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
        Curso curso = rows.get(row);
        switch (cols[col]){
            case CODIGO: return curso.getCodigo();
            case NOMBRE: return curso.getNombre();
            case CARRERA: return curso.getCarrera().getNombre();
            case CREDITOS: return curso.getCreditos();
            case HORAS_SEMANALES: return curso.getHorasSemanales();            
            default: return "";
        }
    }    
    
    
    public static final int CODIGO=0;
    public static final int NOMBRE=1;
    public static final int CARRERA=2;
    public static final int CREDITOS=3;
    public static final int HORAS_SEMANALES=4;
    
    String[] colNames = new String[11];
    private void initColNames(){
        colNames[CODIGO]= "Codigo";
        colNames[NOMBRE]= "Nombre";
        colNames[CARRERA]= "Carrera";
        colNames[CREDITOS]= "Creditos";
        colNames[HORAS_SEMANALES]= "Horas Semanales";
    }
    
    public Curso getRowAt(int row) {
        return rows.get(row);
    }
}
