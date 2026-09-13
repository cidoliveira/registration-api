-- -- V2: Migration to add the profession column in tb_persons --

ALTER TABLE tb_persons
    ADD COLUMN person_profession VARCHAR(255);