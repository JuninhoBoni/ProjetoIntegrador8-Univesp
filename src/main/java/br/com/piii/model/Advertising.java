package br.com.piii.model;

import javax.persistence.*;

@Entity(name = "TB_ADVERTISING")
public class Advertising {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    private User agentName;
    @ManyToOne
    private User userEndereco;
    private String contato;
    private String descricao;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public User getAgentName() {
        return agentName;
    }

    public void setAgentName(User user) {
        this.agentName = user;
    }

    public User getUserEndereco() {
        return userEndereco;
    }

    public void setUserEndereco(User user) {
        this.userEndereco = user;
    }

}
