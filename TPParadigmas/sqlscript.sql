-- MySQL Script generated by MySQL Workbench
-- Mon Oct 23 20:36:20 2017
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pp` DEFAULT CHARACTER SET utf8 ;
USE `pp` ;

-- -----------------------------------------------------
-- Table `pp`.`cocina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pp`.`cocina` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `idUsuario` INT(11) NULL DEFAULT NULL,
  `idEstado` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pp`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pp`.`estado` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Descripcion` VARCHAR(45) NULL DEFAULT NULL,
  `TiempoDemoraDesde` INT(11) NULL DEFAULT NULL,
  `TiempoDemoraHasta` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pp`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pp`.`pedido` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Numero` INT(11) NULL DEFAULT NULL,
  `Mesa` VARCHAR(45) NULL DEFAULT NULL,
  `idUsuario` INT(11) NULL DEFAULT NULL,
  `idMenu` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pp`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pp`.`producto` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Marca` VARCHAR(45) NULL DEFAULT NULL,
  `menu` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `pp`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pp`.`usuario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NULL DEFAULT NULL,
  `Apellido` VARCHAR(45) NULL DEFAULT NULL,
  `TipoUsuario` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;