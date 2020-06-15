package frb.edu.br.controladores;

import frb.edu.br.dominio.contratos.IIdioma;
import frb.edu.br.dominio.entidades.IdiomaDto;
import frb.edu.br.infra.repositorios.IdiomaRepositorio;
import java.util.List;

/**
 *
 * @author 1920530342
 */
public class IdiomaController {

    private IdiomaDto idioma;
    private List<IdiomaDto> idiomas = null;
    private final IIdioma idiomaRepositorio = new IdiomaRepositorio();
    
    
    public IdiomaController() {
    }

    public IdiomaDto getIdioma() {
        return idioma;
    }

    public void setIdioma(IdiomaDto idioma) {
        this.idioma = idioma;
    }

    public List<IdiomaDto> getIdiomas() {
        if(idiomas==null){
            idiomas = idiomaRepositorio.getListaTodos();
        }
        return idiomas;
    }
    
    public String prepararInclusao(){
        idioma = new IdiomaDto();
        return "vaiParaIncluir";
    }
    
    public String finalizaInclusao(){
        idiomaRepositorio.incluir(idioma);
        idiomas = null;
        return "voltaParaListagem";
    }
    
    public String finalizaEdicao(){
        idiomaRepositorio.alterar(idioma);
        idiomas = null;
        return "voltaParaListagem";
    }
    
    public String finalizaExclusao(){
        idiomaRepositorio.deletar(idioma.getIdioma_id());
        idiomas = null;
        return "refresh";
    }
    
}
