-- Creacion de la base de datos
CREATE DATABASE IF NOT EXISTS taller_jdbc;
USE taller_jdbc;

-- Crear la tabla empleados
CREATE TABLE empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    cargo VARCHAR(50) NOT NULL,
    salario DOUBLE NOT NULL
);
