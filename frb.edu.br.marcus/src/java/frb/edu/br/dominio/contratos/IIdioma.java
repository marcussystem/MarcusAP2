package frb.edu.br.dominio.contratos;

import frb.edu.br.dominio.entidades.IdiomaDto;
import java.util.List;

/**
 *
 * @author 1920530342
 */
public interface IIdioma {
    boolean incluir(IdiomaDto idioma);
    boolean alterar(IdiomaDto idioma);
    boolean deletar(int id);
    
    IdiomaDto getRegistroPorId(int id);
    List<IdiomaDto> getListaTodos();
}
