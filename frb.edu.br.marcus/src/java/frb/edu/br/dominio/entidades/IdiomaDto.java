package frb.edu.br.dominio.entidades;

import java.util.Date;

/**
 *
 * @author 1920530342
 */
public class IdiomaDto {
    private int idioma_id;
    private String nome;
    private Date ultima_atualizacao;

    public IdiomaDto() {
    }

    public IdiomaDto(int idioma_id, String nome, Date ultima_atualizacao) {
        this.idioma_id = idioma_id;
        this.nome = nome;
        this.ultima_atualizacao = ultima_atualizacao;
    }

    public IdiomaDto(int idioma_id) {
        this.idioma_id = idioma_id;
    }
    
    public IdiomaDto(String nome) {
        this.nome = nome;
    }

    public IdiomaDto(String nome, Date ultima_atualizacao) {
        this.nome = nome;
        this.ultima_atualizacao = ultima_atualizacao;
    }

    public int getIdioma_id() {
        return idioma_id;
    }
    
    public void setIdioma_id(int idioma_id) {
        this.idioma_id = idioma_id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getUltima_atualizacao() {
        return ultima_atualizacao;
    }

    public void setUltima_atualizacao(Date ultima_atualizacao) {
        this.ultima_atualizacao = ultima_atualizacao;
    }
    
    
}
