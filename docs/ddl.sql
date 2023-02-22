CREATE TABLE `ezpark`.`admin` (
                                  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                  `first_name` VARCHAR(100) NOT NULL,
                                  `last_name` VARCHAR(100) NOT NULL,
                                  `nickname` VARCHAR(50) NOT NULL,
                                  `role` VARCHAR(20) NOT NULL,
                                  `password` VARCHAR(512) NOT NULL,
                                  `mobile` VARCHAR(20) NOT NULL,
                                  `mobile_code` VARCHAR(10) DEFAULT 123456,
                                  `mobile_verified` TINYINT(1) UNSIGNED NOT NULL,
                                  `status` TINYINT(1) UNSIGNED NOT NULL,
                                  `last_login_at` DATETIME NULL,
                                  `created_at` DATETIME NOT NULL,
                                  `updated_at` DATETIME NULL,
                                  PRIMARY KEY (`id`),
                                  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE);

CREATE TABLE `ezpark`.`access_log` (
                                       `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                       `client_ip` VARCHAR(100) NOT NULL,
                                       `method` VARCHAR(10) NOT NULL,
                                       `req_uri` VARCHAR(500) NOT NULL,
                                       `protocol` VARCHAR(100) NOT NULL,
                                       `res_code` VARCHAR(100) NOT NULL,
                                       `byte_code` INT NULL,
                                       `req_ttl` INT NULL,
                                       `req_date` DATETIME NOT NULL,
                                       `created_at` DATETIME NOT NULL,
                                       `updated_at` DATETIME NULL,
                                       PRIMARY KEY (`id`));

CREATE TABLE `ezpark`.`spot` (
                                       `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                       `name` VARCHAR(100) NOT NULL,
                                       `status` TINYINT(1) UNSIGNED NOT NULL,
                                       `created_at` DATETIME NOT NULL,
                                       `updated_at` DATETIME NULL,
                                       PRIMARY KEY (`id`));

CREATE TABLE `ezpark`.`membership` (
                                       `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                       `nickname` VARCHAR(100) NOT NULL DEFAULT 'membership12',
                                       `car_number` VARCHAR(20) NOT NULL DEFAULT 'NL AS9527XZ',
                                       `hash` VARCHAR(512) NOT NULL DEFAULT '4b5776e7a665e7a02275c18f90138249c22c5228555efbc4788c0f7f15d5739c2f62942262df5aa36ed2987c535816d1521aa99e7bca8a9dfb0456ddf8c29c3a',
                                       `mobile` VARCHAR(50) NOT NULL DEFAULT '+31 6 26 47 71 13',
                                       `mobile_verified` TINYINT(1) NOT NULL DEFAULT 0,
                                       `start_date` DATE NOT NULL DEFAULT '21-02-16',
                                       `end_date` DATE NOT NULL DEFAULT '21-02-23',
                                       `card_number` VARCHAR(20) NOT NULL DEFAULT '375981654321001',
                                       `bod` VARCHAR(10) NOT NULL DEFAULT '1999-01-01',
                                       `gender` VARCHAR(2) NOT NULL DEFAULT 'F',
                                       `status` TINYINT(1) NOT NULL DEFAULT 1,
                                       `created_at` DATETIME NOT NULL,
                                       `updated_at` DATETIME NULL,
                                       PRIMARY KEY (`id`),
                                       UNIQUE INDEX `mobile_UNIQUE` (`mobile` ASC) VISIBLE,
                                       UNIQUE INDEX `car_number_UNIQUE` (`car_number` ASC) VISIBLE);

CREATE TABLE `ezpark`.`coupon` (
                                   `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                                   `code` VARCHAR(45) NOT NULL DEFAULT 'EZ14FEB23ALBERTHIJN',
                                   `rate` INT UNSIGNED NOT NULL DEFAULT 15,
                                   `issued_date` DATE NOT NULL DEFAULT '01-01-2023',
                                   `expired_date` DATE NOT NULL DEFAULT '31-12-2023',
                                   `status` TINYINT(1) NOT NULL,
                                   `created_at` DATETIME NOT NULL,
                                   `created_by` VARCHAR(45) NOT NULL DEFAULT 'gildong12',
                                   `updated_at` DATETIME NULL,
                                   `updated_by` VARCHAR(45) NULL DEFAULT 'gildong12',
                                   PRIMARY KEY (`id`),
                                   UNIQUE INDEX `code_UNIQUE` (`code` ASC) VISIBLE);

