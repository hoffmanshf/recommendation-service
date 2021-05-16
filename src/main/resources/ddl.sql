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

DROP TABLE IF EXISTS `recommendation`.`category`;
CREATE TABLE `recommendation`.`category`
(
    `id`         int(0) NOT NULL AUTO_INCREMENT,
    `created_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `name`       varchar(20)  NOT NULL DEFAULT '',
    `icon_url`   varchar(200) NOT NULL DEFAULT '',
    `sort`       int(0) NOT NULL DEFAULT 0,
    PRIMARY KEY (`id`),
    UNIQUE `name_unique_index`(`name`) USING BTREE
);

DROP TABLE IF EXISTS `recommendation`.`shop`;
CREATE TABLE `recommendation`.`shop`
(
    `id`            int(0) NOT NULL AUTO_INCREMENT,
    `created_at`    datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`    datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `name`          varchar(80)    NOT NULL DEFAULT '',
    `remark_score`  decimal(2, 1)  NOT NULL DEFAULT 0,
    `price_per_man` int(0) NOT NULL DEFAULT 0,
    `latitude`      decimal(10, 6) NOT NULL DEFAULT 0,
    `longitude`     decimal(10, 6) NOT NULL DEFAULT 0,
    `category_id`   int(0) NOT NULL DEFAULT 0,
    `tags`          varchar(2000)  NOT NULL DEFAULT '',
    `start_time`    varchar(200)   NOT NULL DEFAULT '',
    `end_time`      varchar(200)   NOT NULL DEFAULT '',
    `address`       varchar(200)   NOT NULL DEFAULT '',
    `seller_id`     int(0) NOT NULL DEFAULT 0,
    `icon_url`      varchar(100)   NOT NULL DEFAULT '',
    PRIMARY KEY (`id`)
);