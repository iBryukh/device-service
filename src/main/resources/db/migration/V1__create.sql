DROP TABLE IF EXISTS device;

CREATE TABLE device
(
    id   SERIAL       NOT NULL,
    name VARCHAR(255) NOT NULL,
    CONSTRAINT device_pk PRIMARY KEY (id)
);

ALTER TABLE device
    OWNER TO postgres;

-- GENERATE DATA

TRUNCATE TABLE device CASCADE;

DO $$
    DECLARE
        freeId       BIGINT       := 0;
        templateName VARCHAR(255) := 'device%s';
        devicesCount INT          := 200;
    BEGIN
        WHILE freeId < devicesCount
            LOOP
                INSERT INTO device (id, name) VALUES (freeId, (SELECT FORMAT(templateName, freeId)));
                freeId = freeId + 1;
            END LOOP;
        create sequence if not exists device_id_seq;
        alter sequence if exists device_id_seq restart with 200; -- devices count

    END $$;