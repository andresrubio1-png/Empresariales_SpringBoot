package com.cal.POCEstudiante.controller;
import  com.cal.POCEstudiante.Modelo.*;
import java.util.Date;
import java.util.List;

public interface IBebidaService {
    public  Bebida addBebidas(Bebida bebida) throws Exception;
    public Bebida BuscarBebida (int Codigo);
    public  List<Bebida> listarBebidas();
    public  List<Alcoholica> listarLicores();
    public Bebida actualizarBebida(int Codigo, String Nombre, double Volumen, double Precio,
                                   int Stock, Date FechaVencimiento, String Estado) throws Exception;
    public  Bebida  eliminardelSistema(int Codigo) throws Exception;
    public  double ganancia(Bebida b);
}
