/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Mishel
 * Created: 6/03/2026
 */
CREATE TABLE `jornadas` (
  `jorcodigo` int (11) NOT NULL,
    `jornombre` varchar (50) DEFAULT NULL
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

ALTER TABLE `jornadas`
  ADD PRIMARY KEY (`jorcodigo`);

ALTER TABLE `jornadas`
  MODIFY `jorcodigo` int(11) NOT NULL AUTO_INCREMENT;

CREATE TABLE `asignacion_cursos_alumnos` (
  `carcodigo` int(11) NOT NULL,
  `curcodigo` int(11) NOT NULL,
  `maecodigo` int(11) NOT NULL,
  `alu_codigo` int(11) NOT NULL,
  `jorcodigo` int(11) NOT NULL,
  `acanota` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

ALTER TABLE `asignacion_cursos_alumnos`
  ADD PRIMARY KEY (`carcodigo`,`curcodigo`,`maecodigo`,`alu_codigo`,`jorcodigo`),
  ADD KEY `fk_curso` (`curcodigo`),
  ADD KEY `fk_maestro` (`maecodigo`),
  ADD KEY `fk_alumno` (`alu_codigo`),
  ADD KEY `fk_jornada` (`jorcodigo`);

ALTER TABLE `asignacion_cursos_alumnos`
  ADD CONSTRAINT `fk_alumno` FOREIGN KEY (`alu_codigo`) REFERENCES `alumnos` (`alu_codigo`),
  ADD CONSTRAINT `fk_carrera` FOREIGN KEY (`carcodigo`) REFERENCES `carreras` (`carcodigo`),
  ADD CONSTRAINT `fk_curso` FOREIGN KEY (`curcodigo`) REFERENCES `cursos` (`curcodigo`),
  ADD CONSTRAINT `fk_maestro` FOREIGN KEY (`maecodigo`) REFERENCES `maestros` (`maecodigo`),
  ADD CONSTRAINT `fk_jornada` FOREIGN KEY (`jorcodigo`) REFERENCES `jornadas` (`jorcodigo`);

