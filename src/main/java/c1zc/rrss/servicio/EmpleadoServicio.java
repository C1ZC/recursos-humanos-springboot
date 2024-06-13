package c1zc.rrss.servicio;

// Importaciones necesarias para el servicio
import c1zc.rrss.modelo.Empleado; // Clase de la entidad Empleado
import c1zc.rrss.repositorio.EmpleadoRepositorio; // Interfaz del repositorio para Empleado
import org.springframework.beans.factory.annotation.Autowired; // Anotación para inyección de dependencias
import org.springframework.stereotype.Service; // Anotación para definir una clase de servicio

import java.util.List; // Importación de la clase List de la biblioteca Java

/**
 * EmpleadoServicio es una clase que implementa la interfaz IEmpleadoServicio y proporciona
 * las implementaciones de los métodos definidos para manejar las operaciones CRUD para la entidad Empleado.
 *
 * Esta clase es un servicio de Spring que se anota con @Service para indicar que es un componente de servicio.
 */
@Service
public class EmpleadoServicio implements IEmpleadoServicio {

    // Inyección de dependencias para el repositorio de empleados
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    /**
     * Método para listar todos los empleados.
     *
     * @return una lista de todos los empleados
     */
    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll();
    }

    /**
     * Método para buscar un empleado por su ID.
     *
     * @param idEmpleado el ID del empleado a buscar
     * @return el empleado encontrado, o null si no se encuentra
     */
    @Override
    public Empleado buscarEmpleadoPorId(Integer idEmpleado) {
        Empleado empleado = empleadoRepositorio.findById(idEmpleado).orElse(null);
        return empleado;
    }

    /**
     * Método para guardar un empleado.
     *
     * @param empleado el empleado a guardar
     * @return el empleado guardado
     */
    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    /**
     * Método para eliminar un empleado.
     *
     * @param empleado el empleado a eliminar
     */
    @Override
    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepositorio.delete(empleado);
    }
}
