import java.sql.*;

public class Conexion {


    private static final String URL = "jdbc:mysql://localhost:3306/taller_jdbc";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Método para obtener la conexión
    private Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Método para insertar un empleado
    public void insertarEmpleado(String nombre, String cargo, double salario) {
        String sql = "INSERT INTO empleados (nombre, cargo, salario) VALUES (?, ?, ?)";
        try (Connection conexion = conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, cargo);
            pstmt.setDouble(3, salario);
            pstmt.executeUpdate();
            System.out.println("Empleado insertado correctamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para consultar empleados
    public void consultarEmpleados() {
        String sql = "SELECT * FROM empleados";
        try (Connection conexion = conectar(); Statement stmt = conexion.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d, Nombre: %s, Cargo: %s, Salario: %.2f%n",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("cargo"),
                        rs.getDouble("salario"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para actualizar un empleado
    public void actualizarEmpleado(int id, String nombre, String cargo, double salario) {
        String sql = "UPDATE empleados SET nombre = ?, cargo = ?, salario = ? WHERE id = ?";
        try (Connection conexion = conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
            pstmt.setString(2, cargo);
            pstmt.setDouble(3, salario);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
            System.out.println("Empleado actualizado correctamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un empleado
    public void eliminarEmpleado(int id) {
        String sql = "DELETE FROM empleados WHERE id = ?";
        try (Connection conexion = conectar(); PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Empleado eliminado correctamente!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}