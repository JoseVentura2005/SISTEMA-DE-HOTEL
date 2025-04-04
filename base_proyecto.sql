CREATE DATABASE hotel_tarea2006;
USE hotel_tarea2006;


select * from huespedes;
select * from reservas;
CREATE TABLE huespedes (
    id_huesped INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,  
    telefono VARCHAR(15) NOT NULL UNIQUE 
);

CREATE TABLE habitaciones (
    id_habitacion INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL
);

CREATE TABLE reservas (
    id_reserva INT AUTO_INCREMENT PRIMARY KEY,
    id_huesped INT NOT NULL,
    id_habitacion INT NOT NULL,
    fecha_entrada DATE NOT NULL,
    fecha_salida DATE NOT NULL,
    FOREIGN KEY (id_huesped) REFERENCES huespedes(id_huesped),
    FOREIGN KEY (id_habitacion) REFERENCES habitaciones(id_habitacion)
);

CREATE TABLE pagos (
    id_pago INT AUTO_INCREMENT PRIMARY KEY,
    id_reserva INT NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_reserva) REFERENCES reservas(id_reserva)
);

CREATE TABLE empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    puesto VARCHAR(50) NOT NULL
);



INSERT INTO huespedes (nombre, email, telefono) VALUES
('Jose Ventura', 'jose.ventura@gmail.com', '88772510'),
('Jared Garcia', 'jared.garcia@gmail.com', '97214510'),
('Carlos Zelaya', 'carlos.zelaya@gmail.com', '98522005');


INSERT INTO habitaciones (tipo, precio) VALUES
('Individual', 100.00),
('Doble', 150.00),
('Suite', 300.00);


INSERT INTO reservas (id_huesped, id_habitacion, fecha_entrada, fecha_salida) VALUES
(1, 2, '2023-10-15', '2023-10-20'),  
(2, 1, '2023-11-01', '2023-11-05'),  
(3, 3, '2023-12-10', '2023-12-15');  


INSERT INTO pagos (id_reserva, monto) VALUES
(1, 750.00),  
(2, 400.00), 
(3, 1500.00); 


INSERT INTO empleados (nombre, puesto) VALUES
('Jose Ventura', 'Recepcionista'),
('Jared Garcia', 'Limpieza'),
('Carlos Zelaya', 'Gerente');