package c1zc.rrss.controlador;

// Importaciones necesarias para el funcionamiento del controlador
import java.util.HashMap;
import java.util.List;
import java.util.Map; // Interfaz de servicio para manejar operaciones relacionadas con empleados

import org.slf4j.Logger; // Biblioteca para el registro de eventos (logging)
import org.slf4j.LoggerFactory; // Fábrica para crear instancias de Logger
import org.springframework.beans.factory.annotation.Autowired; // Anotación para inyección de dependencias
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import c1zc.rrss.excepcion.RecursoNoEncontradoExcepcion;
import c1zc.rrss.modelo.Empleado;
import c1zc.rrss.servicio.IEmpleadoServicio;

/**
 * EmpleadoControlador es una clase que actúa como controlador REST para manejar solicitudes relacionadas
 * con empleados en el sistema de Recursos Humanos.
 *
 * Las solicitudes HTTP a las rutas que empiezan con "rh-app" serán manejadas por este controlador.
 * Permite solicitudes de orígenes cruzados desde "http://locahost:3000".
 */
@RestController
// Mapea las solicitudes HTTP que empiezan con "rrss-app"
@RequestMapping("rrss-app")
// Permite solicitudes de orígenes cruzados desde "http://locahost:3000"  "https://c1zc.github.io/rrss/" "https://rrss-production.up.railway.app/"

@CrossOrigin(value = "http://localhost:3000/")
public class EmpleadoControlador {

    // Logger para registrar eventos y mensajes durante la ejecución del programa
    private static final Logger logger =
            LoggerFactory.getLogger(EmpleadoControlador.class);

    // Inyección de dependencias para la interfaz de servicio IEmpleadoServicio
    @Autowired
    private IEmpleadoServicio empleadoServicio;

    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados(){
        var empleados = empleadoServicio.listarEmpleados();
        empleados.forEach((empleado -> logger.info(empleado.toString())));
        return empleados;
    }
    @PostMapping ("/empleados")
    public Empleado agregarEmpleado(@RequestBody Empleado empleado){
        logger.info("Empleado a Agregar: " + empleado);
        return empleadoServicio.guardarEmpleado(empleado);
    }
    @GetMapping ("/empleados/{id}")
    public ResponseEntity<Empleado>
            obtenerEmpleadoPorId(@PathVariable Integer id){
        Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
        if (empleado == null)
            throw new RecursoNoEncontradoExcepcion("Nose Encontro el ID" + id);
        return ResponseEntity.ok(empleado);
    }
    @PutMapping("/empleados/{id}")
        public ResponseEntity<Empleado>
            actualizarEmpleado(@PathVariable Integer id, @RequestBody Empleado empleadoRecibido){
            Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
            if(empleado==null)
                throw new RecursoNoEncontradoExcepcion("El Id Recibido No Existe:" + id);
            empleado.setNombre(empleadoRecibido.getNombre());
            empleado.setDepartamento(empleadoRecibido.getDepartamento());
            empleado.setSueldo(empleadoRecibido.getSueldo());
            empleadoServicio.guardarEmpleado(empleado);
            return ResponseEntity.ok(empleado);

    }
    @DeleteMapping("/empleados/{id}")
        public ResponseEntity<Map<String, Boolean>>
            eliminarEmpleado(@PathVariable Integer id){
            Empleado empleado = empleadoServicio.buscarEmpleadoPorId(id);
            if (empleado == null)
                throw new RecursoNoEncontradoExcepcion("El ID Recibido no Existe:" + id);
            empleadoServicio.eliminarEmpleado(empleado);
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
    }
}
