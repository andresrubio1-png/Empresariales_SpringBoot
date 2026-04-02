package com.cal.POCEstudiante.controller;
import com.cal.POCEstudiante.Modelo.Bebida;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping(value = "/alcohol")
public class BebidaController {
    private BebidaService service = BebidaService.getInstance();

    //Crear Bebida
    @PostMapping
    public Bebida crear(@RequestBody Bebida bebida) throws Exception {
        return service.addBebidas(bebida);
    }
    // Listar las bebidas
    @GetMapping(value = "/getBebidas")
    public List<Bebida> Listar(){
        return service.listarBebidas();
    }
    //Buscar Bebida
    @GetMapping("/{codigo}")
    public ResponseEntity<Object> buscar(@PathVariable int codigo) {

        Bebida b = service.BuscarBebida(codigo);
        if(b == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(b);
    }
    //Actualizar Bebida
    @PutMapping("/actualizar/{codigo}")
    public ResponseEntity<Bebida> actualizar(@PathVariable int codigo, @RequestBody Bebida bebida) {
        try {
                Bebida actualizada = service.actualizarBebida(
                    codigo,
                    bebida.getNombre(),
                    bebida.getVolumen(),
                    bebida.getPrecioProduccion(),
                    bebida.getStock(),
                    bebida.getFechaVencimiento(),
                    bebida.getEstado()
            );
            return ResponseEntity.ok(actualizada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    //Eliminar Bebida
    @DeleteMapping("/eliminar/{codigo}")
    public ResponseEntity<Bebida> eliminar(@PathVariable int codigo) {
        try {
            Bebida eliminada = service.eliminardelSistema (codigo);
            return ResponseEntity.ok(eliminada);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
