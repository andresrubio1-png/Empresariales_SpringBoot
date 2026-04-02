package com.cal.POCEstudiante.Modelo;

import java.util.Date;
import lombok.Data;

@Data
public class Alcoholica extends Bebida implements IFormulasAlcohol {

    private static double ValorporGrado = 750;
    private Double PorcentajeAlcohol;
    private String TipoLicor;

    // Constructor con parámetros
    public Alcoholica(Double PorcentajeAlcohol, String TipoLicor, String LoteProduccion, Integer Codigo, String Nombre,
                      Double Volumen, Double PrecioProduccion, Integer Stock, Date FechaVencimiento, String Estado) {

        super(Codigo, Nombre, Volumen, PrecioProduccion, Stock, FechaVencimiento, Estado);
        setPorcentajeAlcohol(PorcentajeAlcohol);
        this.TipoLicor = TipoLicor;
    }


    public Alcoholica() {
    }


    public void setPorcentajeAlcohol(Double porcentajeAlcohol) {
        if (porcentajeAlcohol != null) {
            if (porcentajeAlcohol <= 0 || porcentajeAlcohol > 100) {
                throw new RuntimeException("Porcentaje de alcohol inválido");
            }
            this.PorcentajeAlcohol = porcentajeAlcohol / 100;
        }
    }

    @Override
    public double CalcularImpuestoAlcohol() {
        double impuesto = 0;
        if (PorcentajeAlcohol != null) {
            impuesto = PorcentajeAlcohol * ValorporGrado;
        }
        return impuesto;
    }

    @Override
    public double calcularValorFinal() {
        double impuesto = CalcularImpuestoAlcohol();
        double precio = getPrecioProduccion() != null ? getPrecioProduccion() : 0;
        precio += impuesto + (precio * ImpuestoBebida);
        return precio;
    }

    @Override
    public String getTipo() {
        return "Alcoholica";
    }
}