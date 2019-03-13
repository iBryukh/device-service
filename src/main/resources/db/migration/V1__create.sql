DROP TABLE IF EXISTS device;

CREATE TABLE device (
  id   SERIAL       NOT NULL,
  name VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE device
  OWNER TO postgres;