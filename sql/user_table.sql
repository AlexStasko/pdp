CREATE TABLE public."user" (
	id bigint NOT NULL,
	firstname varchar(256) NULL,
	lastname varchar(256) NULL,
	email varchar(256) NULL,
	"password" varchar(64) NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
);
