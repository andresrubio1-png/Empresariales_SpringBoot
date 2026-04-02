package com.cal.POCEstudiante.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import  com.cal.POCEstudiante.Modelo.*;
public class BebidaService implements IBebidaService {
    //Creacion de la coleccion de bebidas disponibles a despacho
    private static BebidaService bebidaService; //Singleton
    private static List<Bebida> Bebidas = new ArrayList();

    private BebidaService() {

    }

    public static BebidaService getInstance() {
        if (bebidaService == null) {
            bebidaService = new BebidaService();
        }
        return bebidaService;
    }

    //Método de agregación
    @Override
    public Bebida addBebidas(Bebida bebida) throws Exception {
        for (Bebida b : Bebidas) {
            if (b.getCodigo() == bebida.getCodigo()) {
                throw new Exception("Ya existe una bebida con ese código");
            }
        }
        Bebidas.add(bebida);

        return bebida;
    }

    //Metodo de busqueda general
    @Override
    public Bebida BuscarBebida(int Codigo) {
        for (Bebida b : Bebidas) {
            if (b.getCodigo() == Codigo) {
                return b;
            }
        }
        return null;
    }

    @Override
    public Bebida actualizarBebida(int Codigo, String Nombre, double Volumen, double Precio,
                                   int Stock,Date FechaVencimiento, String Estado) throws Exception {

        Bebida b = BuscarBebida(Codigo);
        if (b == null) {
            throw new Exception("Bebida no existente");
        }
        b.setNombre(Nombre);
        b.setVolumen(Volumen);
        b.setPrecioProduccion(Precio);
        b.setStock(Stock);
        b.setEstado(Estado);
        if (FechaVencimiento != null) {
            b.setFechaVencimiento(FechaVencimiento);
        }

        return b;
    }

    //Metodo de listar TODO
    @Override
    public List<Bebida> listarBebidas() {
        return Bebidas;
    }

    //Metodo de listar SOLO LICORES
    @Override
    public List<Alcoholica> listarLicores() {
        List<Alcoholica> alcoholica = new ArrayList();
        for (Bebida b : Bebidas) {
            if (b instanceof Alcoholica) {
                alcoholica.add((Alcoholica) b);
            }
        }
        return alcoholica;
    }

    //Metodo de eliminacion del sistema
    @Override
    public Bebida  eliminardelSistema(int codigo) throws Exception {
        Bebida b = BuscarBebida(codigo);
        if (b == null) {
            throw new Exception("Bebida no encontrada");
        }

        b.setStock(0);
        b.setEstado("No disponible");
        return b;

    }

    //Calcular Ganancia de venta x Stock
    @Override
    public double ganancia(Bebida b) {
        double Ganancia = 0;
        Ganancia = b.calcularValorFinal() * b.getStock();
        return Ganancia;
    }

}
