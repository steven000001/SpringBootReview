CREATE TABLE `user`
(
    `id`    bigint(20) NOT NULL IDENTITY,
    `name`  varchar(255) NOT NULL,
    `age`   int(11) DEFAULT NULL,
    `email` varchar(255) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `name_age_index` (`name`,`age`)
);
