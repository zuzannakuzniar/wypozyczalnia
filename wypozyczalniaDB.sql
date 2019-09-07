-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema wypozyczalnia
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema wypozyczalnia
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wypozyczalnia` DEFAULT CHARACTER SET utf8 ;
USE `wypozyczalnia` ;

-- -----------------------------------------------------
-- Table `wypozyczalnia`.`equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wypozyczalnia`.`equipment` (
  `idequipment` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idequipment`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wypozyczalnia`.`cars`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wypozyczalnia`.`cars` (
  `idcar` INT NOT NULL AUTO_INCREMENT,
  `brand` VARCHAR(45) NOT NULL,
  `model` VARCHAR(45) NOT NULL,
  `engine` VARCHAR(45) NOT NULL,
  `price` VARCHAR(45) NOT NULL,
  `equipment_idequipment` INT NOT NULL,
  PRIMARY KEY (`idcar`),
  INDEX `fk_cars_equipment1_idx` (`equipment_idequipment` ASC) VISIBLE,
  CONSTRAINT `fk_cars_equipment1`
    FOREIGN KEY (`equipment_idequipment`)
    REFERENCES `wypozyczalnia`.`equipment` (`idequipment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wypozyczalnia`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wypozyczalnia`.`users` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `driving_license_serial_number` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`iduser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wypozyczalnia`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wypozyczalnia`.`orders` (
  `idorder` INT NOT NULL AUTO_INCREMENT,
  `users_idusers` INT NOT NULL,
  `summary_payment` DECIMAL(8,2) NOT NULL,
  `date` DATETIME NOT NULL,
  INDEX `fk_orders_users1_idx` (`users_idusers` ASC) VISIBLE,
  PRIMARY KEY (`idorder`),
  CONSTRAINT `fk_orders_users1`
    FOREIGN KEY (`users_idusers`)
    REFERENCES `wypozyczalnia`.`users` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `wypozyczalnia`.`basket`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wypozyczalnia`.`basket` (
  `quantity` INT NOT NULL,
  `cars_idcar` INT NOT NULL,
  `orders_idorder` INT NOT NULL,
  INDEX `fk_basket_cars1_idx` (`cars_idcar` ASC) VISIBLE,
  INDEX `fk_basket_orders1_idx` (`orders_idorder` ASC) VISIBLE,
  CONSTRAINT `fk_basket_cars1`
    FOREIGN KEY (`cars_idcar`)
    REFERENCES `wypozyczalnia`.`cars` (`idcar`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_basket_orders1`
    FOREIGN KEY (`orders_idorder`)
    REFERENCES `wypozyczalnia`.`orders` (`idorder`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
