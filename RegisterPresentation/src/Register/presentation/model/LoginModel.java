/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Register.presentation.model;

/**
 *
 * @author Fabio
 */
public class LoginModel extends java.util.Observable{
    public LoginModel() {
    }
    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();        
        notifyObservers(LOGIN_MODEL);
    }
    
    public static Integer LOGIN_MODEL=1;
    
//======= LOGIN ============    
   /*Login loginCurrent;
    Hashtable<String,String> errores;
    String mensaje;
    int modo;
    

    private void initLogin(){
        setLoginCurrent(new Login());
        clearErrors();
    }
    
    public int getModo() {
        return modo;
    }

    public void setModo(int modo) {
        this.modo = modo;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Hashtable<String, String> getErrores() {
        return errores;
    }

    public void setErrores(Hashtable<String, String> errores) {
        this.errores = errores;
    }
    
    public void clearErrors(){
        setErrores(new Hashtable<String,String>());
        setMensaje("");
        
    }
    public Login getLoginCurrent() {
        return loginCurrent;
    }

    public void setLoginCurrent(Login loginCurrent) {
        this.loginCurrent = loginCurrent;
        setChanged();
        notifyObservers(LOGIN_CURRENT);        
    }

//======== LOGINES ===========
    Login filtro;
    LoginTableModel loginModel;
    
    private void initLogin(){
        filtro = new Login();
        List<Login> rows = new ArrayList<Login>();
        setLogin(rows);
    }
    
    public void setLogin(List<Login> rows){
        int[] cols={LoginTableModel.NOMBRE,LoginTableModel.CEDULA,LoginTableModel.TELEFONO,LoginTableModel.EMAIL,LoginTableModel.FECHA_NAC,LoginTableModel.CARRERA};
        setLoginModel(new LoginTableModel(cols,rows));        
    }
    
    public Login getFiltro() {
        return filtro;
    }
    
    public void setFiltro(Login filtro) {
        this.filtro = filtro;
    }
    
     public LoginTableModel getLoginModel() {
        return loginModel;
    }

    public void addObserver(java.util.Observer o) {
        super.addObserver(o);
        setChanged();
        notifyObservers(LOGIN_CURRENT);
        setChanged();        
        notifyObservers(LOGIN_MODEL);
    }
    
    public void setLoginModel(LoginTableModel loginModel) {
        this.loginModel = loginModel;
        setChanged();
        notifyObservers(LOGIN_MODEL);
    }
    
    public static Integer LOGIN_CURRENT=1;
    public static Integer LOGIN_MODEL=2;
    */
}

