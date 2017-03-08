/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

import Register.Entities.Estudiante;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Fabio
 */
public class EstudianteTableModel extends AbstractTableModel{
    List<Estudiante> rows;
    int[] cols;

    public  EstudianteTableModel(int[] cols, List<Estudiante> rows){
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
        Estudiante curso = rows.get(row);
        switch (cols[col]){
            case NOMBRE: return curso.getNombre();
            case CEDULA: return curso.getCedula();
            case TELEFONO: return curso.getTel();
            case EMAIL: return curso.getEmail(); 
            case FECHA_NAC: return curso.getFechaNac(); 
            case CARRERA: return curso.getCarrera().getNombre(); 
            default: return "";
        }
    }    
    
    
    public static final int NOMBRE=0;
    public static final int CEDULA=1;
    public static final int TELEFONO=2;
    public static final int EMAIL=3;
    public static final int FECHA_NAC=4;
    public static final int CARRERA=5;
    
    String[] colNames = new String[11];
    private void initColNames(){
        colNames[NOMBRE]= "Nombre";
        colNames[CEDULA]= "Cedula";
        colNames[TELEFONO]= "Telefono";
        colNames[EMAIL]= "Email";
        colNames[FECHA_NAC]= "Fecha Nacimiento";
        colNames[CARRERA]= "Carrera";
    }
    
    public Estudiante getRowAt(int row) {
        return rows.get(row);
    }
}

