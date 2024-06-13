package c1zc.rrss.repositorio;

// Importaciones necesarias para definir el repositorio
import c1zc.rrss.modelo.Empleado; // Clase de la entidad Empleado
import org.springframework.data.jpa.repository.JpaRepository; // Interfaz JPA Repository de Spring Data

/**
 * EmpleadoRepositorio es una interfaz que extiende JpaRepository para proporcionar
 * métodos CRUD (Crear, Leer, Actualizar, Eliminar) para la entidad Empleado.
 *
 * Esta interfaz hereda varios métodos para trabajar con la persistencia de Empleado,
 * incluyendo la capacidad de encontrar, guardar, eliminar y actualizar empleados.
 */
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
}
