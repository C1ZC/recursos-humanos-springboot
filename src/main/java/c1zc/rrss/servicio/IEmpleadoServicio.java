package c1zc.rrss.servicio;

// Importaciones necesarias
import c1zc.rrss.modelo.Empleado; // Clase de la entidad Empleado
import java.util.List; // Importación de la clase List de la biblioteca Java

/**
 * IEmpleadoServicio es una interfaz que define los métodos de servicio
 * para manejar las operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * para la entidad Empleado.
 * Esta interfaz proporciona una abstracción para los servicios relacionados con Empleado,
 * permitiendo diferentes implementaciones según sea necesario.
 */
public interface IEmpleadoServicio {

    /**
     * Lista todos los empleados.
     *
     * @return una lista de todos los empleados
     */
    public List<Empleado> listarEmpleados();
    /**
     * Busca un empleado por su ID.
     *
     * @param idEmpleado el ID del empleado a buscar
     * @return el empleado encontrado, o null si no se encuentra
     */
    public Empleado buscarEmpleadoPorId(Integer idEmpleado);

    /**
     * Guarda un empleado.
     *
     * @param empleado el empleado a guardar
     * @return el empleado guardado
     */
    public Empleado guardarEmpleado(Empleado empleado);

    /**
     * Elimina un empleado.
     *
     * @param empleado el empleado a eliminar
     */
    public void eliminarEmpleado(Empleado empleado);

}

