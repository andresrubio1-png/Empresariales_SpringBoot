package com.cal.POCEstudiante.Modelo;

import java.util.Date;
import lombok.Data;
@Data
public class Alcoholica extends Bebida implements IFormulasAlcohol {

    private static double ValorporGrado = 750;
    private double PorcentajeAlcohol;
    private String TipoLicor;
    private String LoteProduccion;

    public Alcoholica(double PorcentajeAlcohol, String TipoLicor, String LoteProduccion, int Codigo, String Nombre,
                      double Volumen, double Precio, int Stock, double CantidadAzucar, String TipoEnvase, Date FechaVencimiento, String Estado) throws Exception {
        super(Codigo, Nombre, Volumen, Precio, Stock, CantidadAzucar, TipoEnvase, FechaVencimiento, Estado);
        setPorcentajeAlcohol(PorcentajeAlcohol);
        this.TipoLicor = TipoLicor;
        this.LoteProduccion = LoteProduccion;

    }

    //Convertir el Porcentaje de alcohol
    public void setPorcentajeAlcohol(double porcentajeAlcohol) throws Exception {
        if (porcentajeAlcohol <= 0 || porcentajeAlcohol > 100) {
            throw new Exception("Porcentaje de alcohol inválido");
        }
        this.PorcentajeAlcohol = porcentajeAlcohol / 100;
    }

    @Override
    public double CalcularImpuestoAlcohol() {
        double ImpuestoAnadido = 0;
        ImpuestoAnadido += PorcentajeAlcohol * ValorporGrado;
        return ImpuestoAnadido;
    }

    @Override
    public double calcularValorFinal() {
        double ImpuestoAnadido = CalcularImpuestoAlcohol();
        double precio = getPrecioProduccion();
        precio += ImpuestoAnadido + (precio * ImpuestoBebida);
        return precio;
    }

    @Override
    public String getTipo() {
        return "Alcoholica";
    }

}