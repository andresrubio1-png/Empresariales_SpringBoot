package com.cal.POCEstudiante.Modelo;
import java.util.Date;
import lombok.Data;

@Data
public abstract class Bebida {

    public static double ImpuestoBebida = 0.19;

    private Integer Codigo;
    private String Nombre;
    private Double Volumen;
    private Double PrecioProduccion;
    private Integer Stock;
    private Date FechaVencimiento;
    private String Estado;

    // Constructor con parámetros
    public Bebida(Integer Codigo, String Nombre, Double Volumen, Double PrecioProduccion,
                  Integer Stock, Date FechaVencimiento, String Estado) {

        setCodigo(Codigo);
        this.Nombre = Nombre;
        setVolumen(Volumen);
        this.PrecioProduccion = PrecioProduccion;
        this.Stock = Stock;
        this.FechaVencimiento = FechaVencimiento;
        this.Estado = Estado;
    }

    // Constructor vacío (OBLIGATORIO para Spring)
    public Bebida() {
    }

    // Método abstracto
    public abstract double calcularValorFinal();

    public double getPrecioVenta() {
        return calcularValorFinal();
    }

    // Validaciones SIN Exception checked
    public void setVolumen(Double Volumen) {
        if (Volumen != null && Volumen < 200) {
            throw new RuntimeException("Bebida muy pequeña, no puede ser vendida!");
        }
        this.Volumen = Volumen;
    }

    public void setCodigo(Integer Codigo) {
        if (Codigo != null && Codigo < 1) {
            throw new RuntimeException("Código no válido!");
        }
        this.Codigo = Codigo;
    }

    public String getTipo() {
        return "Bebida";
    }
}