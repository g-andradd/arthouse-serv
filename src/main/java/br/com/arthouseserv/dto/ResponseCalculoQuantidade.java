package br.com.arthouseserv.dto;

import java.math.BigDecimal;

public class ResponseCalculoQuantidade {

    private BigDecimal largura;
    private BigDecimal altura;

    public BigDecimal getLargura() {
        return largura;
    }

    public void setLargura(BigDecimal largura) {
        this.largura = largura;
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }
}
