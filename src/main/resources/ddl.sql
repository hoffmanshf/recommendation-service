CREATE TABLE `recommendation`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `phone` VARCHAR(45) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `nick_name` VARCHAR(45) NOT NULL,
  UNIQUE INDEX `phone_unique_index` USING BTREE (`phone` ASC),
  PRIMARY KEY (`id`));
