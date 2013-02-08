package br.com.mycompany.entity;

import java.util.Objects;

public final class CidadeEntity extends AbstractEntity {

    private Integer codigo;
    private String nome;

    public CidadeEntity() {}

    public CidadeEntity(Integer codigo, String nome) {
        setCodigo(codigo);
        setNome(nome);
    }

    public Integer getCodigo() {
        return codigo = dbObject.getInt("codigo");
    }

    public void setCodigo(Integer codigo) {
        dbObject.put("codigo", this.codigo = codigo);
    }

    public String getNome() {
        return nome = dbObject.getString("nome");
    }

    public void setNome(String nome) {
        dbObject.put("nome", this.nome = nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        CidadeEntity other = (CidadeEntity) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codigo);
        return hash;
    }
}