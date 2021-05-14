DROP TABLE IF EXISTS `recommendation`.`user`;
CREATE TABLE `recommendation`.`user`
(
    `id`          INT          NOT NULL AUTO_INCREMENT,
    `create_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `phone`       VARCHAR(45)  NOT NULL,
    `password`    VARCHAR(200) NOT NULL,
    `nick_name`   VARCHAR(45)  NOT NULL,
    UNIQUE `phone_unique_index` USING BTREE (`phone`),
    PRIMARY KEY (`id`)
);
