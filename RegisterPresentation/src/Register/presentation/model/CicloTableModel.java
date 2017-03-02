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
           /* case ID: return ciclo.getId();
            case NOMBRE: return ciclo.getNombre();
            //case SEXO: return ciclo.getSexo();
            case SEXO: 
                if (ciclo.getSexo()=='M') return new ImageIcon( getClass().getResource( "male.png" ) ); 
                else  return new ImageIcon( getClass().getResource( "female.png" ) );  
            case ESTADO_CIVIL: return estadoCivil(ciclo);
            //case ESTADO_CIVIL: return ciclo.getEstadoCivil().getDescripcion();
            case PASATIEMPO_MUSICA: return ciclo.isPasatiempoMusica();
            case PASATIEMPO_CINE: return ciclo.isPasatiempoCine();
            case PASATIEMPO_DEPORTE: return ciclo.isPasatiempoDeporte();
            case PASATIEMPO_VIDEOJUEGOS: return ciclo.isPasatiempoVideoJuegos();
            case PASATIEMPO_COCINA: return ciclo.isPasatiempoCocina();
            case PASATIEMPO_OTRO: return ciclo.isPasatiempoOtro();
            case PASATIEMPO_OTROTEXTO: return ciclo.getPasatiempoOtroTexto();
            */
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
