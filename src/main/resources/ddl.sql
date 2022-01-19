CREATE TABLE `dian-ping`.`users`  (
  `id` int ZEROFILL NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `update_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `telephone` varchar(40) NOT NULL DEFAULT '',
  `password` varchar(200) NOT NULL DEFAULT '',
  `nick_name` varchar(40) NOT NULL DEFAULT '',
  `gender` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `telephone_unique_idx`(`telephone`) USING BTREE
);

CREATE TABLE `dian-ping`.`category`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `name` varchar(25) NOT NULL DEFAULT '',
  `icon_url` varchar(255) NOT NULL DEFAULT '',
  `sort` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_unique_idx`(`name`) USING BTREE
);

CREATE TABLE `dian-ping`.`shop`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `created_at` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_at` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `name` varchar(80) NOT NULL DEFAULT '',
  `remark_score` decimal(2, 1) NOT NULL DEFAULT 0,
  `price_per_man` int NOT NULL DEFAULT 0,
  `latitude` decimal(10, 6) NOT NULL DEFAULT 0,
  `longitude` decimal(10, 6) NOT NULL DEFAULT 0,
  `category_id` int NOT NULL DEFAULT 0,
  `tags` varchar(2000) NOT NULL DEFAULT '',
  `start_time` varchar(200) NOT NULL DEFAULT '',
  `end_time` varchar(200) NOT NULL DEFAULT '',
  `address` varchar(255) NOT NULL DEFAULT '',
  `seller_id` int NOT NULL DEFAULT 0,
  `icon_url` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
);