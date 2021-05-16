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

DROP TABLE IF EXISTS `recommendation`.`seller`;
CREATE TABLE `recommendation`.`seller`
(
    `id`            int(0) NOT NULL AUTO_INCREMENT,
    `name`          varchar(80)   NOT NULL DEFAULT '',
    `created_at`    datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`    datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `remark_score`  decimal(2, 1) NOT NULL DEFAULT 0,
    `disabled_flag` int(0) NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`)
);