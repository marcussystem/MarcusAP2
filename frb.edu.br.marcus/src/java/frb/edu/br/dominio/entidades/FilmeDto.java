package frb.edu.br.dominio.entidades;

import java.util.Date;

/**
 *
 * @author 1920530342
 */
public class FilmeDto {
    private int filme_id;
    private String titulo;
    private String descricao;
    private int ano_de_lancamento;
    private IdiomaDto idioma_id;
    private IdiomaDto idioma_original_id;
    private int duracao_da_locacao;
    private float preco_da_locacao;
    private int duracao_do_filme;
    private float custo_de_substituicao;
    private String classificacao;
    private String recursos_especiais;
    private Date ultima_atualizacao;

    public FilmeDto() {
        idioma_id = new IdiomaDto();
        idioma_original_id = new IdiomaDto();
    }

    public FilmeDto(int filme_id, String titulo, String descricao, int ano_de_lancamento, IdiomaDto idioma_id, IdiomaDto idioma_original_id, int duracao_da_locacao, float preco_da_locacao, int duracao_do_filme, float custo_de_substituicao, String classificacao, String recursos_especiais, Date ultima_atualizacao) {
        this.filme_id = filme_id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.ano_de_lancamento = ano_de_lancamento;
        this.idioma_id = idioma_id;
        this.idioma_original_id = idioma_original_id;
        this.duracao_da_locacao = duracao_da_locacao;
        this.preco_da_locacao = preco_da_locacao;
        this.duracao_do_filme = duracao_do_filme;
        this.custo_de_substituicao = custo_de_substituicao;
        this.classificacao = classificacao;
        this.recursos_especiais = recursos_especiais;
        this.ultima_atualizacao = ultima_atualizacao;
    }

    public FilmeDto(int filme_id) {
        this.filme_id = filme_id;
        idioma_id = new IdiomaDto();
        idioma_original_id = new IdiomaDto();
    }

    public int getFilme_id() {
        return filme_id;
    }

    public void setFilme_id(int filme_id) {
        this.filme_id = filme_id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getAno_de_lancamento() {
        return ano_de_lancamento;
    }

    public void setAno_de_lancamento(int ano_de_lancamento) {
        this.ano_de_lancamento = ano_de_lancamento;
    }

    public IdiomaDto getIdioma_id() {
        return idioma_id;
    }

    public void setIdioma_id(IdiomaDto idioma_id) {
        this.idioma_id = idioma_id;
    }

    public IdiomaDto getIdioma_original_id() {
        return idioma_original_id;
    }

    public void setIdioma_original_id(IdiomaDto idioma_original_id) {
        this.idioma_original_id = idioma_original_id;
    }

    public int getDuracao_da_locacao() {
        return duracao_da_locacao;
    }

    public void setDuracao_da_locacao(int duracao_da_locacao) {
        this.duracao_da_locacao = duracao_da_locacao;
    }

    public float getPreco_da_locacao() {
        return preco_da_locacao;
    }

    public void setPreco_da_locacao(float preco_da_locacao) {
        this.preco_da_locacao = preco_da_locacao;
    }

    public int getDuracao_do_filme() {
        return duracao_do_filme;
    }

    public void setDuracao_do_filme(int duracao_do_filme) {
        this.duracao_do_filme = duracao_do_filme;
    }

    public float getCusto_de_substituicao() {
        return custo_de_substituicao;
    }

    public void setCusto_de_substituicao(float custo_de_substituicao) {
        this.custo_de_substituicao = custo_de_substituicao;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getRecursos_especiais() {
        return recursos_especiais;
    }

    public void setRecursos_especiais(String recursos_especiais) {
        this.recursos_especiais = recursos_especiais;
    }

    public Date getUltima_atualizacao() {
        return ultima_atualizacao;
    }

    public void setUltima_atualizacao(Date ultima_atualizacao) {
        this.ultima_atualizacao = ultima_atualizacao;
    }

    
    
    
    
}
