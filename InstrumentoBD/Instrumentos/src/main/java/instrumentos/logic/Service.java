/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentos.logic;

import instrumentos.data.TipoInstrumentoDao;
import java.util.List;

public class Service {
    private static Service theInstance;
    public static Service instance(){
        if (theInstance==null){ 
            theInstance=new Service();
        }
        return theInstance;
    }
    
    private TipoInstrumentoDao tipoInstrumentoDao;

    public Service() {
        try{
            tipoInstrumentoDao = new TipoInstrumentoDao();
        }
        catch(Exception e){
        }
    }

    // ------------ TIPOS DE INTRUMENTO -------------
    public void create(TipoInstrumento e)throws Exception{
        tipoInstrumentoDao.create(e);
    }

    public TipoInstrumento read(TipoInstrumento e) throws Exception{
        return tipoInstrumentoDao.read(e.getCodigo());
    }  

    public void update(TipoInstrumento e)throws Exception{
        tipoInstrumentoDao.update(e);
    }

    public void delete(TipoInstrumento e)throws Exception{
        tipoInstrumentoDao.delete(e);
    }

    public List<TipoInstrumento> search(TipoInstrumento e) throws Exception {
        return tipoInstrumentoDao.search(e);
    }

    // ------------ INSTRUMENTOS -------------
    public void create(Instrumento e) throws Exception{
        throw new Exception("Not implemented");
    }
    
    public Instrumento read(Instrumento e) throws Exception{
        throw new Exception("Not implemented");
    }

    public void update(Instrumento e)throws Exception{
        throw new Exception("Not implemented");
    }

    public void delete(Instrumento e)throws Exception{
        throw new Exception("Not implemented");
    }

    public List<Instrumento> search(Instrumento v) throws Exception {
        throw new Exception("Not implemented");
    }
}
