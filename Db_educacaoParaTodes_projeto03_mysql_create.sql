CREATE TABLE `tema` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`descricao` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `postagem` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`descricao_postagem` varchar(255) NOT NULL,
	`título` varchar(255) NOT NULL,
	`texto` varchar(255) NOT NULL,
	`tema_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `usuario` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
	`senha` varchar(255) NOT NULL,
	`voluntario` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `postagem` ADD CONSTRAINT `postagem_fk0` FOREIGN KEY (`tema_id`) REFERENCES `tema`(`id`);

