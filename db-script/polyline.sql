CREATE TABLE `encoded_polyline` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_time` date DEFAULT NULL,
  `encoded_loc` varchar(255) DEFAULT NULL,
  `last_updated` date DEFAULT NULL,
  `trip_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_b12cqf828opoalrp9tii5vpi` (`trip_id`),
  KEY `my_index` (`trip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;