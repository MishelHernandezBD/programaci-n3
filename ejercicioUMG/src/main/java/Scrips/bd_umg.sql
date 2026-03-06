/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Mishel
 * Created: 6/03/2026
 */
CREATE TABLE `alumnos` (
  `alu_codigo` int(11) NOT NULL,
  `alu_nombre` varchar(50) NOT NULL,
  `alu_direccion` varchar(150) DEFAULT NULL,
  `alu_estatus` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

CREATE TABLE `asignacion_cursos_alumnos` (
  `carcodigo` int(11) NOT NULL,
  `curcodigo` int(11) NOT NULL,
  `maecodigo` int(11) NOT NULL,
  `alu_codigo` int(11) NOT NULL,
  `jorcodigo` int(11) NOT NULL,
  `acanota` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `carreras` (
  `carcodigo` int(11) NOT NULL,
  `carnombre` varchar(100) DEFAULT NULL,
  `carestatus` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `cursos` (
  `curcodigo` int(11) NOT NULL,
  `curnombre` varchar(100) DEFAULT NULL,
  `curestatus` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


CREATE TABLE `maestros` (
  `maecodigo` int(11) NOT NULL,
  `maenombre` varchar(250) DEFAULT NULL,
  `maedireccion` varchar(250) DEFAULT NULL,
  `maeestatus` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

CREATE TABLE `jornadas` (
  `jorcodigo` int (11) NOT NULL,
    `jornombre` varchar (50) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

-- Indices de la tablas
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`alu_codigo`);

ALTER TABLE `asignacion_cursos_alumnos`
  ADD PRIMARY KEY (`carcodigo`,`curcodigo`,`maecodigo`,`alu_codigo`,`jorcodigo`),
  ADD KEY `fk_curso` (`curcodigo`),
  ADD KEY `fk_maestro` (`maecodigo`),
  ADD KEY `fk_alumno` (`alu_codigo`),
  ADD KEY `fk_jornada` (`jorcodigo`);

ALTER TABLE `carreras`
  ADD PRIMARY KEY (`carcodigo`);

ALTER TABLE `cursos`
  ADD PRIMARY KEY (`curcodigo`);

ALTER TABLE `maestros`
  ADD PRIMARY KEY (`maecodigo`);

ALTER TABLE `jornadas`
  ADD PRIMARY KEY (`jorcodigo`);

-- AUTO_INCREMENT de las tablas volcadas

ALTER TABLE `alumnos`
  MODIFY `alu_codigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `carreras`
  MODIFY `carcodigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `cursos`
  MODIFY `curcodigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `maestros`
  MODIFY `maecodigo` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `jornadas`
  MODIFY `jorcodigo` int(11) NOT NULL AUTO_INCREMENT;

-- Filtros para la tabla `asignacion_cursos_alumnos`
--
ALTER TABLE `asignacion_cursos_alumnos`
  ADD CONSTRAINT `fk_alumno` FOREIGN KEY (`alu_codigo`) REFERENCES `alumnos` (`alu_codigo`),
  ADD CONSTRAINT `fk_carrera` FOREIGN KEY (`carcodigo`) REFERENCES `carreras` (`carcodigo`),
  ADD CONSTRAINT `fk_curso` FOREIGN KEY (`curcodigo`) REFERENCES `cursos` (`curcodigo`),
  ADD CONSTRAINT `fk_maestro` FOREIGN KEY (`maecodigo`) REFERENCES `maestros` (`maecodigo`),
  ADD CONSTRAINT `fk_jornada` FOREIGN KEY (`jorcodigo`) REFERENCES `jornadas` (`jorcodigo`);