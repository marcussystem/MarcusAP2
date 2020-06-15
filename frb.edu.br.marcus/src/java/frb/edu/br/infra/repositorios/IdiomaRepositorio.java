package frb.edu.br.infra.repositorios;

import frb.edu.br.dominio.contratos.IIdioma;
import frb.edu.br.dominio.entidades.IdiomaDto;
import frb.edu.br.infra.data.DAOUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 1920530342
 */
public class IdiomaRepositorio extends DAOUtil implements IIdioma{

    public IdiomaRepositorio() {
        super();
    }
    
    @Override
    public boolean incluir(IdiomaDto idioma) {
        String sql = "INSERT INTO Idioma (nome)"+
                     " VALUES (?)";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = super.getPreparedStatement(sql);
            ps.setString(1, idioma.getNome());
            
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return ret > 0;
    }

    @Override
    public boolean alterar(IdiomaDto idioma) {
        String sql = "UPDATE Idioma SET nome=?"+
                     " WHERE idioma_id=?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = super.getPreparedStatement(sql);
            ps.setString(1, idioma.getNome());
            ps.setInt(2, idioma.getIdioma_id());
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return ret > 0;
    }

    @Override
    public boolean deletar(int id) {
        String sql = "DELETE FROM Idioma WHERE idioma_id=?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = super.getPreparedStatement(sql);
            ps.setInt(1, id);
            ret = ps.executeUpdate();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return ret > 0;
    }

    @Override
    public IdiomaDto getRegistroPorId(int id) {
        IdiomaDto idioma = new IdiomaDto();
        String sql = "SELECT DISTINCT idioma_id,nome,ultima_atualizacao FROM Idioma"+
                     " WHERE idioma_id=?";
        
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                idioma = new IdiomaDto(rs.getInt("idioma_id"),
                                       rs.getString("nome"),
                                       rs.getDate("ultima_atualizacao"));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return idioma;
    }

    @Override
    public List<IdiomaDto> getListaTodos() {
        List<IdiomaDto> idiomas = new LinkedList<IdiomaDto>();
        String sql = "SELECT DISTINCT idioma_id,nome,ultima_atualizacao FROM Idioma;";
        
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                idiomas.add( new IdiomaDto(rs.getInt("idioma_id"),
                                           rs.getString("nome"),
                                           rs.getDate("ultima_atualizacao")));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return idiomas;
    }
    
}
