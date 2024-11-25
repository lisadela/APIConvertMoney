-- Crear tabla
CREATE TABLE exchange_rate (
    moneda_origen VARCHAR(3),
    moneda_destino VARCHAR(3),
    tipo_cambio DECIMAL(10, 2)
);

-- Insertar datos
INSERT INTO exchange_rate (moneda_origen, moneda_destino, tipo_cambio) VALUES ('USD', 'PEN', 3.7);
INSERT INTO exchange_rate (moneda_origen, moneda_destino, tipo_cambio) VALUES ('EUR', 'PEN', 4.1);
