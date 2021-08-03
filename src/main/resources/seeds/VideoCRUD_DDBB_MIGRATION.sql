-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Created: Mon Aug  2 15:19:52 2021
-- Workbench Version: 8.0.26
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------

CREATE TABLE  `alquileres` (
  `id_alquiler` BIGINT NOT NULL AUTO_INCREMENT,
  `id_pelicula` BIGINT NOT NULL,
  `id_usuario` BIGINT NOT NULL,
  `esta_alquilada` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id_alquiler`),
  INDEX `fk_pelicula_idx` (`id_pelicula` ASC) VISIBLE,
  INDEX `fk_usuario_idx` (`id_usuario` ASC) VISIBLE,
  CONSTRAINT `fk_pelicula`
    FOREIGN KEY (`id_pelicula`)
    REFERENCES `peliculas` (`id_pelicula`)
    ON UPDATE CASCADE,
  CONSTRAINT `fk_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `usuarios` (`id_usuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table m98nehshkuq5oy2x.categorias
-- ----------------------------------------------------------------------------
CREATE TABLE `categorias` (
  `id_categoria` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_categoria`),
  UNIQUE INDEX `id_categoria_UNIQUE` (`id_categoria` ASC) VISIBLE)

ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table m98nehshkuq5oy2x.peliculas
-- ----------------------------------------------------------------------------
CREATE TABLE `peliculas` (
  `id_pelicula` BIGINT NOT NULL AUTO_INCREMENT,
  `id_categoria` BIGINT NOT NULL,
  `titulo` VARCHAR(100) NOT NULL,
  `esta_disponible` TINYINT(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id_pelicula`),
  UNIQUE INDEX `id_pelicula_UNIQUE` (`id_pelicula` ASC) VISIBLE,
  INDEX `id_categoria` (`id_categoria` ASC) VISIBLE,
  CONSTRAINT `fk_cat`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `categorias` (`id_categoria`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 14
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table m98nehshkuq5oy2x.usuarios
-- ----------------------------------------------------------------------------
CREATE TABLE `usuarios` (
  `id_usuario` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(85) NOT NULL,
  `telefono` VARCHAR(20) NOT NULL,
  `dnie` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `id_usuario_UNIQUE` (`id_usuario` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
SET FOREIGN_KEY_CHECKS = 1;
