CREATE TABLE `tb_produtos` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`disciplina` varchar(255) NOT NULL,
	`forum` varchar(255) NOT NULL,
	`lista_exercicios` varchar(255) NOT NULL,
	`simulado` varchar(255) NOT NULL,
	`categoria_id` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_usuario` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nome` varchar(255) NOT NULL,
	`email` varchar(255) NOT NULL,
	`senha` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tb_categoria` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`formato_conteudo` varchar(255) NOT NULL,
	`descricao_conteudo` varchar(255) NOT NULL,
	`conteudo_disponivel` BOOLEAN NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `tb_produtos` ADD CONSTRAINT `tb_produtos_fk0` FOREIGN KEY (`categoria_id`) REFERENCES `tb_categoria`(`id`);

