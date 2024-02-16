package br.com.arthouseserv.services.produto;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculoRolosService {

    private static final BigDecimal larguraRoloDefault = BigDecimal.valueOf(1.59);

    public Integer calculoRolos(BigDecimal largura, BigDecimal altura) {
        var metroQuadradoDoRolo = calculoMetroQuadradoRoloPelaParede(larguraRoloDefault, altura);
        var metroQuadradoParede = calculoMetroQuadradoDaParede(largura, altura);

        return valorQuantidadeDeRolosPelaParede(metroQuadradoDoRolo, metroQuadradoParede);
    }

    private BigDecimal calculoMetroQuadradoRoloPelaParede(BigDecimal larguraRolo, BigDecimal alturaParede) {
        return larguraRolo.multiply(alturaParede);
    }

    private BigDecimal calculoMetroQuadradoDaParede(BigDecimal larguraParede, BigDecimal alturaParede) {
        return larguraParede.multiply(alturaParede);
    }

    private Integer valorQuantidadeDeRolosPelaParede(BigDecimal metroQuadradoDoRolo, BigDecimal metroQuadradoParede) {

        var valorDeRolosBigDecimal = metroQuadradoParede.divide(metroQuadradoDoRolo, 2, RoundingMode.HALF_UP);

        return valorDeRolosBigDecimal.intValue() + 1;
    }
}
