1. Используя команду cat в терминале операционной системы Linux, создать
два файла Домашние животные (заполнив файл собаками, кошками,
хомяками) и Вьючные животными заполнив файл Лошадьми, верблюдами и
ослы), а затем объединить их. Просмотреть содержимое созданного файла.
Переименовать файл, дав ему новое имя (Друзья человека).
2. Создать директорию, переместить файл туда.
3. Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.
4. Установить и удалить deb-пакет с помощью dpkg.
5. Выложить историю команд в терминале ubuntu
![Model](https://github.com/MuratovEdem/Final_Control_Geek_Brains/blob/main/CommandHistory.png)

6. Нарисовать диаграмму, в которой есть класс родительский класс, домашние
животные и вьючные животные, в составы которых в случае домашних
животных войдут классы: собаки, кошки, хомяки, а в класс вьючные животные
войдут: Лошади, верблюды и ослы)
![Model](https://github.com/MuratovEdem/Final_Control_Geek_Brains/blob/main/Diagram.png)

7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”
8. Создать таблицы с иерархией из диаграммы в БД

~~~
CREATE DATABASE human_friends;

CREATE TABLE `animals` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`type` ENUM('Pets', 'Pack'),
	PRIMARY KEY (`id`)
);

CREATE TABLE `pets` (
	`id` INT(11) NULL,
	`name_animals` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `animals` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `pack_animals` (
	`id` INT(11) NULL,
	`name_animals` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `animals` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `dogs` (
	`id` INT(11) NULL,
	`name` TEXT NULL,
	`date` DATE NULL,
	`commands` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `pets` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `cats` (
	`id` INT(11) NULL,
	`name` TEXT NULL,
	`date` DATE NULL,
	`commands` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `pets` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `hamsters` (
	`id` INT(11) NULL,
	`name` TEXT NULL,
	`date` DATE NULL,
	`commands` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `pets` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `horses` (
	`id` INT(11) NULL,
	`name` TEXT NULL,
	`date` DATE NULL,
	`commands` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `pack_animals` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `camels` (
	`id` INT(11) NULL,
	`name` TEXT NULL,
	`date` DATE NULL,
	`commands` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `pack_animals` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `donkeys` (
	`id` INT(11) NULL,
	`name` TEXT NULL,
	`date` DATE NULL,
	`commands` TEXT NULL,
	FOREIGN KEY (`id`) REFERENCES `pack_animals` (`id`) ON UPDATE CASCADE ON DELETE CASCADE
);
~~~

9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения

~~~
INSERT INTO animals (`type`) VALUES ('Pets');
INSERT INTO home_animals (`id`, `name_animals`) VALUES (LAST_INSERT_ID(), 'Dog');
INSERT INTO dogs (`id`, `name`, `date`, `commands`) VALUES (LAST_INSERT_ID(), 'Рей', '2022-06-02', 'Апорт');

INSERT INTO animals (`type`) VALUES ('Pets');
INSERT INTO home_animals (`id`, `name_animals`) VALUES (LAST_INSERT_ID(), 'Cat');
INSERT INTO cats (`id`, `name`, `date`, `commands`) VALUES (LAST_INSERT_ID(), 'Рыжик', '2020-02-12', 'Лежать');

INSERT INTO animals (`type`) VALUES ('Pets');
INSERT INTO home_animals (`id`, `name_animals`) VALUES (LAST_INSERT_ID(), 'Hamster');
INSERT INTO hamsters (`id`, `name`, `date`, `commands`) VALUES (LAST_INSERT_ID(), 'Рыжик', '2023-11-21', '');

INSERT INTO animals (`type`) VALUES ('Pack');
INSERT INTO pack_animals (`id`, `name_animals`) VALUES (LAST_INSERT_ID(), 'Horse');
INSERT INTO horses (`id`, `name`, `date`, `commands`) VALUES (LAST_INSERT_ID(), 'Плотва', '2015-01-01', 'Шевелись');

INSERT INTO animals (`type`) VALUES ('Pack');
INSERT INTO pack_animals (`id`, `name_animals`) VALUES (LAST_INSERT_ID(), 'Camel');
INSERT INTO camels (`id`, `name`, `date`, `commands`) VALUES (LAST_INSERT_ID(), 'Горбатый', '2014-12-15', 'Пей');

INSERT INTO animals (`type`) VALUES ('Pack');
INSERT INTO pack_animals (`id`, `name_animals`) VALUES (LAST_INSERT_ID(), 'Donkey');
INSERT INTO donkeys (`id`, `name`, `date`, `commands`) VALUES (LAST_INSERT_ID(), 'Мурка', '2024-02-03', 'Стой');
~~~

