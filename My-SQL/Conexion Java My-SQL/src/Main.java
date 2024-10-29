import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conexion ConexionMySQL = new Conexion ();

        int opcion;

        do {
            System.out.println("\n--- Menú de Empleados ---");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Consultar empleados");
            System.out.println("3. Actualizar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese el cargo del empleado: ");
                    String cargo = scanner.next();
                    System.out.print("Ingrese el salario del empleado: ");
                    double salario = scanner.nextDouble();
                    ConexionMySQL.insertarEmpleado(nombre, cargo, salario);
                    break;

                case 2:
                    System.out.println("\nLista de empleados:");
                    ConexionMySQL.consultarEmpleados();
                    break;

                case 3:
                    System.out.print("Ingrese el ID del empleado a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    System.out.print("Ingrese el nombre: ");
                    String nuevoNombre = scanner.next();
                    System.out.print("Ingrese el cargo: ");
                    String nuevoCargo = scanner.next();
                    System.out.print("Ingrese el salario: ");
                    double nuevoSalario = scanner.nextDouble();
                    ConexionMySQL.actualizarEmpleado(idActualizar, nuevoNombre, nuevoCargo, nuevoSalario);
                    break;

                case 4:
                    System.out.print("Ingrese el ID del empleado a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    ConexionMySQL.eliminarEmpleado(idEliminar);
                    break;

                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
