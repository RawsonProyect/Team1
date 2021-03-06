-- MySQL Script generated by MySQL Workbench
-- Thu Dec 13 16:00:30 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema teletrabajo
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `teletrabajo` ;

-- -----------------------------------------------------
-- Schema teletrabajo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `teletrabajo` DEFAULT CHARACTER SET utf8 ;
USE `teletrabajo` ;

-- -----------------------------------------------------
-- Table `teletrabajo`.`prioridad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`prioridad` (
  `idPrioridad` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPrioridad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`cliente` (
  `idCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `cif` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`idCliente`),
  UNIQUE INDEX `cif_UNIQUE` (`cif` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`proyecto` (
  `idProyecto` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `fip` TIMESTAMP NULL DEFAULT NULL,
  `ffp` TIMESTAMP NULL DEFAULT NULL,
  `fir` TIMESTAMP NULL DEFAULT NULL,
  `ffr` TIMESTAMP NULL DEFAULT NULL,
  `estado` BIT(1) NOT NULL,
  `idCliente` INT(11) NOT NULL,
  PRIMARY KEY (`idProyecto`),
  INDEX `idCliente_idx` (`idCliente` ASC),
  CONSTRAINT `idClienteProyecto`
    FOREIGN KEY (`idCliente`)
    REFERENCES `teletrabajo`.`cliente` (`idCliente`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `dni` VARCHAR(15) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE INDEX `dni_UNIQUE` (`dni` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`requisito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`requisito` (
  `idRequisito` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `esIncidencia` BIT(1) NOT NULL,
  `finalizado` BIT(1) NOT NULL,
  `ruta` VARCHAR(255) NULL DEFAULT NULL,
  `idProyecto` INT(11) NOT NULL,
  `idUsuario` INT(11) NOT NULL,
  `idPrioridad` INT(11) NOT NULL,
  PRIMARY KEY (`idRequisito`),
  INDEX `fk_requisitos_proyecto1_idx` (`idProyecto` ASC),
  INDEX `idUsuario_idx` (`idUsuario` ASC),
  INDEX `fk_requisitos_prioridad1_idx` (`idPrioridad` ASC),
  CONSTRAINT `idPrioridad`
    FOREIGN KEY (`idPrioridad`)
    REFERENCES `teletrabajo`.`prioridad` (`idPrioridad`)
    ON UPDATE CASCADE,
  CONSTRAINT `idProyecto`
    FOREIGN KEY (`idProyecto`)
    REFERENCES `teletrabajo`.`proyecto` (`idProyecto`)
    ON UPDATE CASCADE,
  CONSTRAINT `idUsuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `teletrabajo`.`usuario` (`idUsuario`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`tarea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`tarea` (
  `idTarea` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(250) NOT NULL,
  `fip` TIMESTAMP NULL DEFAULT NULL,
  `ffp` TIMESTAMP NULL DEFAULT NULL,
  `fir` TIMESTAMP NULL DEFAULT NULL,
  `ffr` TIMESTAMP NULL DEFAULT NULL,
  `idTareaPadre` INT(11) NULL DEFAULT NULL,
  `idRequisito` INT NOT NULL,
  PRIMARY KEY (`idTarea`),
  INDEX `fk_Tarea_Tarea1_idx` (`idTareaPadre` ASC),
  INDEX `idReq_idx` (`idRequisito` ASC),
  CONSTRAINT `idTareaPadre`
    FOREIGN KEY (`idTareaPadre`)
    REFERENCES `teletrabajo`.`tarea` (`idTarea`)
    ON UPDATE CASCADE,
  CONSTRAINT `idReq`
    FOREIGN KEY (`idRequisito`)
    REFERENCES `teletrabajo`.`requisito` (`idRequisito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`tipoalerta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`tipoalerta` (
  `idTipoAlerta` INT(11) NOT NULL AUTO_INCREMENT,
  `tipoAlerta` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoAlerta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`alerta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`alerta` (
  `idAlerta` INT(11) NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(250) NOT NULL,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idTarea` INT(11) NOT NULL,
  `idTipoAlerta` INT(11) NOT NULL,
  PRIMARY KEY (`idAlerta`),
  INDEX `idTarea_idx` (`idTarea` ASC),
  INDEX `fk_alerta_tipoAlerta1_idx` (`idTipoAlerta` ASC),
  CONSTRAINT `idTareaAlerta`
    FOREIGN KEY (`idTarea`)
    REFERENCES `teletrabajo`.`tarea` (`idTarea`)
    ON UPDATE CASCADE,
  CONSTRAINT `idTipoAlerta`
    FOREIGN KEY (`idTipoAlerta`)
    REFERENCES `teletrabajo`.`tipoalerta` (`idTipoAlerta`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`archivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`archivo` (
  `idArchivo` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `idProyecto` INT(11) NOT NULL,
  PRIMARY KEY (`idArchivo`),
  INDEX `idProyecto_idx` (`idProyecto` ASC),
  CONSTRAINT `idProyectoArchivo`
    FOREIGN KEY (`idProyecto`)
    REFERENCES `teletrabajo`.`proyecto` (`idProyecto`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`chatgrupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`chatgrupo` (
  `idChatGrupo` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idChatGrupo`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`informe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`informe` (
  `idInforme` INT(11) NOT NULL AUTO_INCREMENT,
  `rutaInforme` VARCHAR(255) NOT NULL,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idUsuario` INT(11) NOT NULL,
  PRIMARY KEY (`idInforme`),
  INDEX `idUsuario_idx` (`idUsuario` ASC),
  CONSTRAINT `idUsuarioInforme`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `teletrabajo`.`usuario` (`idUsuario`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`mensaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`mensaje` (
  `idMensaje` INT(11) NOT NULL AUTO_INCREMENT,
  `contenido` VARCHAR(255) NOT NULL,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `idChatGrupo` INT(11) NOT NULL,
  `idUsuario` INT(11) NOT NULL,
  PRIMARY KEY (`idMensaje`, `contenido`, `fecha`),
  INDEX `idChat_grupo_idx` (`idChatGrupo` ASC),
  INDEX `idUsuario_idx` (`idUsuario` ASC),
  CONSTRAINT `idChatGrupo`
    FOREIGN KEY (`idChatGrupo`)
    REFERENCES `teletrabajo`.`chatgrupo` (`idChatGrupo`)
    ON UPDATE CASCADE,
  CONSTRAINT `idUsuarioMensaje`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `teletrabajo`.`usuario` (`idUsuario`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`tipopermiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`tipopermiso` (
  `idTipoPermiso` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoPermiso`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`permiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`permiso` (
  `idPermiso` INT(11) NOT NULL AUTO_INCREMENT,
  `objeto` VARCHAR(45) NOT NULL,
  `idTipoPermiso` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`idPermiso`),
  INDEX `idTipoPermiso_idx` (`idTipoPermiso` ASC),
  CONSTRAINT `idTipoPermiso`
    FOREIGN KEY (`idTipoPermiso`)
    REFERENCES `teletrabajo`.`tipopermiso` (`idTipoPermiso`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`rol` (
  `idRol` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idRol`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`rol_usuario_proyecto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`rol_usuario_proyecto` (
  `idRol` INT(11) NOT NULL,
  `idUsuario` INT(11) NOT NULL,
  `idProyecto` INT(11) NOT NULL,
  PRIMARY KEY (`idRol`, `idUsuario`, `idProyecto`),
  INDEX `fk_rol_has_usuario_has_proyecto_proyecto1_idx` (`idProyecto` ASC),
  INDEX `fk_rol_has_usuario_has_proyecto_usuario_idx` (`idUsuario` ASC),
  CONSTRAINT `idProyectoT`
    FOREIGN KEY (`idProyecto`)
    REFERENCES `teletrabajo`.`proyecto` (`idProyecto`)
    ON UPDATE CASCADE,
  CONSTRAINT `idRolT`
    FOREIGN KEY (`idRol`)
    REFERENCES `teletrabajo`.`rol` (`idRol`)
    ON UPDATE CASCADE,
  CONSTRAINT `idUsuarioT`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `teletrabajo`.`usuario` (`idUsuario`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`rolpermiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`rolpermiso` (
  `idRol` INT(11) NOT NULL,
  `idPermiso` INT(11) NOT NULL,
  PRIMARY KEY (`idRol`, `idPermiso`),
  INDEX `fk_rol_has_permiso_permiso1_idx` (`idPermiso` ASC),
  INDEX `fk_rol_has_permiso_rol_idx` (`idRol` ASC),
  CONSTRAINT `idPermiso`
    FOREIGN KEY (`idPermiso`)
    REFERENCES `teletrabajo`.`permiso` (`idPermiso`)
    ON UPDATE CASCADE,
  CONSTRAINT `idRol`
    FOREIGN KEY (`idRol`)
    REFERENCES `teletrabajo`.`rol` (`idRol`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`tarea_informe`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`tarea_informe` (
  `idTarea` INT(11) NOT NULL,
  `idInforme` INT(11) NOT NULL,
  PRIMARY KEY (`idTarea`, `idInforme`),
  INDEX `fk_Tarea_has_informe_informe1_idx` (`idInforme` ASC),
  INDEX `fk_Tarea_has_informe_Tarea1_idx` (`idTarea` ASC),
  CONSTRAINT `idInformeTareaInforme`
    FOREIGN KEY (`idInforme`)
    REFERENCES `teletrabajo`.`informe` (`idInforme`)
    ON UPDATE CASCADE,
  CONSTRAINT `idTareaTareaInforme`
    FOREIGN KEY (`idTarea`)
    REFERENCES `teletrabajo`.`tarea` (`idTarea`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`tarea_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`tarea_usuario` (
  `idTarea` INT(11) NOT NULL,
  `idUsuario` INT(11) NOT NULL,
  PRIMARY KEY (`idTarea`, `idUsuario`),
  INDEX `fk_Tarea_has_usuario_usuario1_idx` (`idUsuario` ASC),
  INDEX `fk_Tarea_has_usuario_Tarea1_idx` (`idTarea` ASC),
  CONSTRAINT `idTareaTareaUsuario`
    FOREIGN KEY (`idTarea`)
    REFERENCES `teletrabajo`.`tarea` (`idTarea`)
    ON UPDATE CASCADE,
  CONSTRAINT `idUsuarioTareaUsuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `teletrabajo`.`usuario` (`idUsuario`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`usuario_alerta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`usuario_alerta` (
  `idUsuario` INT(11) NOT NULL,
  `idAlerta` INT(11) NOT NULL,
  `fechaVisto` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`idUsuario`, `idAlerta`),
  INDEX `fk_usuario_has_alerta_alerta1_idx` (`idAlerta` ASC),
  INDEX `fk_usuario_has_alerta_usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `idAlertaUsuarioAlerta`
    FOREIGN KEY (`idAlerta`)
    REFERENCES `teletrabajo`.`alerta` (`idAlerta`)
    ON UPDATE CASCADE,
  CONSTRAINT `idUsuarioUsuarioAlerta`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `teletrabajo`.`usuario` (`idUsuario`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`usuario_chatgrupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`usuario_chatgrupo` (
  `idUsuario` INT(11) NOT NULL,
  `idChatGrupo` INT(11) NOT NULL,
  PRIMARY KEY (`idUsuario`, `idChatGrupo`),
  INDEX `fk_usuario_has_chatGrupo_chatGrupo1_idx` (`idChatGrupo` ASC),
  INDEX `fk_usuario_has_chatGrupo_usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `idChatGrupoUsuarioChatGrupo`
    FOREIGN KEY (`idChatGrupo`)
    REFERENCES `teletrabajo`.`chatgrupo` (`idChatGrupo`),
  CONSTRAINT `idUsuarioUsuarioChatGrupo`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `teletrabajo`.`usuario` (`idUsuario`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`usuario_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`usuario_cliente` (
  `idUsuario` INT(11) NOT NULL,
  `idCliente` INT(11) NOT NULL,
  PRIMARY KEY (`idUsuario`, `idCliente`),
  INDEX `fk_usuario_has_cliente_cliente1_idx` (`idCliente` ASC),
  INDEX `fk_usuario_has_cliente_usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `idClienteUsuarioCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `teletrabajo`.`cliente` (`idCliente`)
    ON UPDATE CASCADE,
  CONSTRAINT `idUsuarioUsuarioCliente`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `teletrabajo`.`usuario` (`idUsuario`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `teletrabajo`.`version`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `teletrabajo`.`version` (
  `idVersion` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `fecha` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `path` VARCHAR(255) NOT NULL,
  `idArchivo` INT(11) NOT NULL,
  `idUsuario` INT(11) NOT NULL,
  `esFinal` BIT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`idVersion`),
  INDEX `idArchivo_idx` (`idArchivo` ASC),
  INDEX `idUsuario_idx` (`idUsuario` ASC),
  CONSTRAINT `idArchivo`
    FOREIGN KEY (`idArchivo`)
    REFERENCES `teletrabajo`.`archivo` (`idArchivo`)
    ON UPDATE CASCADE,
  CONSTRAINT `idUsuarioVersion`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `teletrabajo`.`usuario` (`idUsuario`)
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
