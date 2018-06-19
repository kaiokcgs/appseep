package br.com.appseep.cursoandroid.appseep.model;

import java.io.Serializable;

/**
 * Created by rair.angelos on 09/05/2018.
 */
public class Escola implements Serializable{

    private String inepe;
    private String gestor;
    private String escola;
    private String implantacao;
    private String data_gestao;
    private String jornada;
    private String municipio;
    private String celular;
    private String telefone;
    private String gre;
    private String idepe;
    private String ano1;
    private String ano2;
    private String ano3;
    private String endereco;
    private String foto;

    public Escola() {

    }

    public String getInepe() {
        return inepe;
    }

    public void setInepe(String inepe) {
        this.inepe = inepe;
    }

    public String getGestor() {
        return gestor;
    }

    public void setGestor(String gestor) {
        this.gestor = gestor;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public String getImplantacao() {
        return implantacao;
    }

    public void setImplantacao(String implantacao) {
        this.implantacao = implantacao;
    }

    public String getData_gestao() {
        return data_gestao;
    }

    public void setData_gestao(String data_gestao) {
        this.data_gestao = data_gestao;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGre() {
        return gre;
    }

    public void setGre(String gre) {
        this.gre = gre;
    }

    public String getIdepe() {
        return idepe;
    }

    public void setIdepe(String idepe) {
        this.idepe = idepe;
    }

    public String getAno1() {
        return ano1;
    }

    public void setAno1(String ano1) {
        this.ano1 = ano1;
    }

    public String getAno2() {
        return ano2;
    }

    public void setAno2(String ano2) {
        this.ano2 = ano2;
    }

    public String getAno3() {
        return ano3;
    }

    public void setAno3(String ano3) {
        this.ano3 = ano3;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
