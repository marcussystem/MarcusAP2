package frb.edu.br.infra.repositorios;

import frb.edu.br.dominio.contratos.IFilme;
import frb.edu.br.dominio.entidades.FilmeDto;
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
public class FilmeRepositorio extends DAOUtil implements IFilme{

    public FilmeRepositorio() {
        super();
    }

    @Override
    public boolean incluir(FilmeDto filme) {
        String sql = "INSERT INTO Filme (titulo,descricao,ano_de_lancamento,idioma_id,idioma_original_id,duracao_da_locacao,preco_da_locacao,duracao_do_filme,custo_de_substituicao,classificacao,recursos_especiais)"+
                     " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = super.getPreparedStatement(sql);
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getDescricao());
            ps.setInt(3, filme.getAno_de_lancamento());
            ps.setInt(4, filme.getIdioma_id().getIdioma_id());
            ps.setInt(5, filme.getIdioma_original_id().getIdioma_id());
            ps.setInt(6, filme.getDuracao_da_locacao());
            ps.setFloat(7, filme.getPreco_da_locacao());
            ps.setInt(8, filme.getDuracao_do_filme());
            ps.setFloat(9, filme.getCusto_de_substituicao());
            ps.setString(10, filme.getClassificacao());
            ps.setString(11, filme.getRecursos_especiais());            
            
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
    public boolean alterar(FilmeDto filme) {
        String sql = "UPDATE Filme SET titulo=?,descricao=?,ano_de_lancamento=?,idioma_id=?"+
                     ",idioma_original_id=?,duracao_da_locacao=?,preco_da_locacao=?"+
                     ",duracao_do_filme=?,custo_de_substituicao=?,classificacao=?"+
                     ",recursos_especiais=?,ultima_atualizacao=?"+
                     " WHERE filme_id=?";
        PreparedStatement ps;
        int ret=-1;
        try {
            ps = super.getPreparedStatement(sql);
            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getDescricao());
            ps.setInt(3, filme.getAno_de_lancamento());
            ps.setInt(4, filme.getIdioma_id().getIdioma_id());
            ps.setInt(5, filme.getIdioma_original_id().getIdioma_id());
            ps.setInt(6, filme.getDuracao_da_locacao());
            ps.setFloat(7, filme.getPreco_da_locacao());
            ps.setInt(8, filme.getDuracao_do_filme());
            ps.setFloat(9, filme.getCusto_de_substituicao());
            ps.setString(10, filme.getClassificacao());
            ps.setString(11, filme.getRecursos_especiais());            
            ps.setDate(12, new java.sql.Date(filme.getUltima_atualizacao().getTime()));
            ps.setInt(13, filme.getFilme_id());
            
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
        String sql = "DELETE FROM Filme WHERE filme_id=?";
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
    public FilmeDto getRegistroPorId(int id) {
        FilmeDto filme = new FilmeDto();
        String sql = "SELECT filme_id,titulo,descricao,ano_de_lancamento,idioma_id,idioma_original_id,duracao_da_locacao,preco_da_locacao,duracao_do_filme,custo_de_substituicao,classificacao,recursos_especiais,ultima_atualizacao "+
                     " FROM Filme WHERE filme_id=?";
        
        IdiomaRepositorio idioma = new IdiomaRepositorio();
        IdiomaRepositorio idioma_original = new IdiomaRepositorio();
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                filme = new FilmeDto(rs.getInt("filme_id"),
                                     rs.getString("titulo"),
                                     rs.getString("descricao"),
                                     rs.getInt("ano_de_lancamento"),
                                     idioma.getRegistroPorId(rs.getInt("idioma_id")),
                                     idioma_original.getRegistroPorId(rs.getInt("idioma_original_id")),
                                     rs.getInt("duracao_da_locacao"),
                                     rs.getFloat("preco_da_locacao"),
                                     rs.getInt("duracao_do_filme"),
                                     rs.getFloat("custo_de_substituicao"),
                                     rs.getString("classificacao"),
                                     rs.getString("recursos_especiais"),
                                     rs.getDate("ultima_atualizacao"));
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return filme;
    }

    @Override
    public List<FilmeDto> getListaTodos() {
        List<FilmeDto> filme = new LinkedList<FilmeDto>();
        String sql = "SELECT filme_id,titulo,descricao,ano_de_lancamento,idioma_id,idioma_original_id,duracao_da_locacao,preco_da_locacao,duracao_do_filme,custo_de_substituicao,classificacao,recursos_especiais,ultima_atualizacao "+
                     " FROM Filme order by filme_id desc";
        
        IdiomaRepositorio idioma = new IdiomaRepositorio();
        IdiomaRepositorio idioma_original = new IdiomaRepositorio();
        try {
            PreparedStatement ps = super.getPreparedStatement(sql);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                filme.add (new FilmeDto(
                                     rs.getInt("filme_id"),
                                     rs.getString("titulo"),
                                     rs.getString("descricao"),
                                     rs.getInt("ano_de_lancamento"),
                                     idioma.getRegistroPorId(rs.getInt("idioma_id")),
                                     idioma_original.getRegistroPorId(rs.getInt("idioma_original_id")),
                                     rs.getInt("duracao_da_locacao"),
                                     rs.getFloat("preco_da_locacao"),
                                     rs.getInt("duracao_do_filme"),
                                     rs.getFloat("custo_de_substituicao"),
                                     rs.getString("classificacao"),
                                     rs.getString("recursos_especiais"),
                                     rs.getDate("ultima_atualizacao"))
                );
            }
            rs.close();
            ps.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(IdiomaRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return filme;
    }
    
}
