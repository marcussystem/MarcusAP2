package frb.edu.br.controladores;

import frb.edu.br.dominio.contratos.IFilme;
import frb.edu.br.dominio.entidades.FilmeDto;
import frb.edu.br.infra.repositorios.FilmeRepositorio;
import java.util.List;

public class FilmeController {
    private IFilme filmeDao = new FilmeRepositorio();
    private FilmeDto filme;
    private List<FilmeDto> filmes = null;

    public FilmeController() {
    }

    public FilmeDto getFilme() {
        return filme;
    }

    public void setFilme(FilmeDto filme) {
        this.filme = filme;
    }

    public List<FilmeDto> getFilmes() {
    if(filmes==null){
            filmes = filmeDao.getListaTodos();
        }
        return filmes;
    }

    public String prepararInclusao(){
        filme = new FilmeDto();
        return "vaiParaIncluir";
    }
    
    public String finalizaInclusao(){
        filmeDao.incluir(filme);
        filmes = null;
        return "voltaParaListagem";
    }
    
    public String finalizaEdicao(){
        filmeDao.alterar(filme);
        filmes = null;
        return "voltaParaListagem";
    }
    
    public String finalizaExclusao(){
        filmeDao.deletar(filme.getFilme_id());
        filmes = null;
        return "refresh";
    }
    
}
