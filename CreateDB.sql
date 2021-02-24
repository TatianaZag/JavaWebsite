----------------< For delete table in database >----------------
DROP TABLE Products CASCADE;
DROP TABLE Type_client CASCADE;
DROP TABLE Suppliers CASCADE;
DROP TABLE Customers CASCADE;
DROP TABLE Deliveries CASCADE;
DROP TABLE Provision CASCADE;

---------------< For create table in database >-----------------
CREATE TABLE IF NOT EXISTS Products (
	id_product        SERIAL PRIMARY KEY,
	name_product      TEXT NOT NULL,
	charact_prod      TEXT,
	count_prod        INT NOT NULL,
	date_prod         TIMESTAMPTZ NOT NULL,
	storage_location  INT NOT NULL,
	id_supplier       SERIAL NOT NULL,
	status            TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS Type_client (
	id_type   SERIAL PRIMARY KEY,
	name_type TEXT NOT NULL,
	CONSTRAINT valid_id_type CHECK (id_type = 1 OR id_type = 2),
	CONSTRAINT valid_name CHECK (name_type = 'юр.лицо' OR name_type = 'физ.лицо')
);

CREATE TABLE IF NOT EXISTS Suppliers (
	id_supplier    SERIAL PRIMARY KEY,
	name_supplier  TEXT NOT NULL,
	id_type        INT REFERENCES Type_client ON DELETE CASCADE,
	email          TEXT NOT NULL,
	number_phone   TEXT NOT NULL,
	address        TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS Customers (
	id_customer    SERIAL PRIMARY KEY,
	name_customer  TEXT NOT NULL,
	id_type        INT REFERENCES Type_client ON DELETE CASCADE,
	email          TEXT NOT NULL,
	number_phone   TEXT NOT NULL,
	address        TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS Deliveries (
	id_deliveries  SERIAL PRIMARY KEY,
	id_product     SERIAL REFERENCES Products ON DELETE CASCADE,
	id_supplier    SERIAL REFERENCES Suppliers ON DELETE CASCADE,
	count_prod     INT NOT NULL,
	date_deliver   TIMESTAMPTZ NOT NULL,
	storage_time   INT NOT NULL
);

CREATE TABLE IF NOT EXISTS Provision (
	id_provision   SERIAL PRIMARY KEY,
	id_product     SERIAL REFERENCES Products ON DELETE CASCADE,
	id_customer    SERIAL REFERENCES Customers ON DELETE CASCADE,
	count_prod     INT NOT NULL,
	date_prov      TIMESTAMPTZ NOT NULL,
	status         TEXT NOT NULL
);