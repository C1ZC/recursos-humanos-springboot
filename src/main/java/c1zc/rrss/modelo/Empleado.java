package c1zc.rrss.modelo;

// Importaciones necesarias para definir la entidad y utilizar anotaciones
import jakarta.persistence.Entity; // Define que esta clase es una entidad JPA
import jakarta.persistence.GeneratedValue; // Define que el valor del campo será generado automáticamente
import jakarta.persistence.GenerationType; // Estrategia de generación de valores
import jakarta.persistence.Id; // Define el campo como la clave primaria de la entidad
import lombok.AllArgsConstructor; // Genera un constructor con todos los argumentos
import lombok.Data; // Genera getters, setters, toString, equals y hashCode
import lombok.NoArgsConstructor; // Genera un constructor sin argumentos
import lombok.ToString; // Genera un método toString

/**
 * Empleado es una clase que representa a un empleado en el sistema de Recursos Humanos.
 * Esta clase está mapeada a una tabla de base de datos utilizando JPA.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Empleado {
    // Identificador único del empleado, generado automáticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEmpleado;

    // Nombre del empleado
    String nombre;

    // Departamento al que pertenece el empleado
    String departamento;

    // Sueldo del empleado
    Double sueldo;
}
