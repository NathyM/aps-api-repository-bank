package br.unit.domain.client;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

    private @Id
    @GeneratedValue
    Double numeroConta;
    private String nome;
    private Double saldoConta;

    public Account() {
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Double numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(Double saldoConta) {
        this.saldoConta = saldoConta;
    }
    public void saque(Double valor){
        this.saldoConta -= valor;
    }
    public void deposito(Double valor){
        this.saldoConta += valor;
    }
}
