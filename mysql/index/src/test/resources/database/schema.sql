CREATE TABLE IF NOT EXISTS user (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `paramA` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `paramB` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_index` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

TRUNCATE TABLE user;

CREATE TABLE IF NOT EXISTS log (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `paramA` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `paramB` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_paramA_paramB` (`paramA`,`paramB`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

TRUNCATE TABLE log;
