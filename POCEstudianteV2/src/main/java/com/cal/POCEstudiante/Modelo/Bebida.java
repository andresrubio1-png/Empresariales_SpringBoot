package com.cal.POCEstudiante.Modelo;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Andres
 */
@Data
public abstract class Bebida {

    public static double ImpuestoBebida = 0.19;
    private int Codigo;
    private String Nombre;
    private double Volumen;
    private double PrecioProduccion;
    private int Stock;
    private double CantidadAzucar;
    private String TipoEnvase;
    private Date FechaVencimiento; // Remplazar por localdatetime
    private String Estado;

    //Constructor
    public Bebida(int Codigo, String Nombre, double Volumen, double Precio,
                  int Stock, double CantidadAzucar, String TipoEnvase, Date FechaVencimiento, String Estado) throws Exception {
        setCodigo(Codigo);
        this.Nombre = Nombre;
        setVolumen(Volumen);
        this.PrecioProduccion = Precio;
        this.Stock = Stock;
        this.CantidadAzucar = CantidadAzucar;
        this.TipoEnvase = TipoEnvase;
        this.FechaVencimiento = FechaVencimiento;
        this.Estado = Estado;

    }

    //Metodo Polimorfismo
    public abstract double calcularValorFinal();


    public double getPrecioVenta() {
        return calcularValorFinal();
    }

    //Verificar que el Volumen de la bebida sea mayor o Igual a 200ml
    public void setVolumen(double Volumen) throws Exception {
        if (Volumen < 200) {
            throw new Exception("Bebida muy pequena, no puede ser vendida!");
        }

        this.Volumen = Volumen;
    }

    //Verificar que es un codigo valido
    public void setCodigo(int Codigo) throws Exception {
        if (Codigo < 1) {
            throw new Exception("Código no válido!");
        }
        this.Codigo = Codigo;
    }

    public String getTipo() {
        return "Bebida";
    }

}