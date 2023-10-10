package instrumentos.data;

import instrumentos.logic.Instrumento;
import instrumentos.logic.TipoInstrumento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class InstrumentosDao {

    Database db;
    public InstrumentosDao() {db = Database.instance();}

    public void create(Instrumento e) throws Exception {
        String sql = "insert into " +
                "Instrumento " +
                "(serie, tipo, descripcion, minimo, maximo, tolerancia) " +
                "values(?,?,?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getSerie());
        stm.setString(2, e.getTipo().getCodigo());
        stm.setString(3, e.getDescripcion());
        stm.setInt(2, e.getMinimo());
        stm.setInt(2, e.getMaximo());
        stm.setInt(2, e.getTolerancia());

        db.executeUpdate(stm);
    }

    public Instrumento read(String serie) throws Exception {
        String sql = "select " +
                "* " +
                "from  Instrumento t " +
                "where t.serie=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, serie);
        ResultSet rs = db.executeQuery(stm);
        if (rs.next()) {
            return from(rs, "t");
        } else {
            throw new Exception("INSTRUMENTO NO EXISTE");
        }
    }

    public void update(Instrumento e) throws Exception {
        String sql = "update " +
                "Instrumento " +
                "set tipo=?, descripcion=?, minimo=?, maximo=?, tolerancia=? " +
                "where serie=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getTipo().getCodigo());
        stm.setString(2, e.getDescripcion());
        stm.setInt(3, e.getMinimo());
        stm.setInt(4, e.getMaximo());
        stm.setInt(5, e.getTolerancia())
        stm.setString(6, e.getSerie());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("INSTRUMENTO NO EXISTE");
        }

    }

    public void delete(Instrumento e) throws Exception {
        String sql = "delete " +
                "from Instrumento " +
                "where serie=?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, e.getSerie());
        int count = db.executeUpdate(stm);
        if (count == 0) {
            throw new Exception("INSTRUMENTO NO EXISTE");
        }
    }

    public List<Instrumento> search(Instrumento e) throws Exception {
        List<TipoInstrumento> resultado = new ArrayList<TipoInstrumento>();
        String sql = "select * " +
                "from " +
                "TipoInstrumento t " +
                "where t.nombre like ?";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, "%" + e.getNombre() + "%");
        ResultSet rs = db.executeQuery(stm);
        while (rs.next()) {
            resultado.add(from(rs, "t"));
        }
        return resultado;
    }

    public TipoInstrumento from(ResultSet rs, String alias) throws Exception {
        TipoInstrumento e = new TipoInstrumento();
        e.setCodigo(rs.getString(alias + ".codigo"));
        e.setNombre(rs.getString(alias + ".nombre"));
        e.setUnidad(rs.getString(alias + ".unidad"));
        return e;
    }
}
