-- =====================================================
-- SCRIPT OF EXAMPLE DATA
-- =====================================================

-- =====================================================
-- CLEAN DATA AND RESET SEQUENCES
-- =====================================================
DELETE FROM flights;
DELETE FROM users;
DELETE FROM airlines;
DELETE FROM airports;

-- Resetear las secuencias de ID
ALTER SEQUENCE airports_id_seq RESTART WITH 1;
ALTER SEQUENCE airlines_id_seq RESTART WITH 1;
ALTER SEQUENCE users_id_seq RESTART WITH 1;
ALTER SEQUENCE flights_id_seq RESTART WITH 1;

-- =====================================================
-- INSERT AIRPORTS
-- =====================================================
INSERT INTO airports (name, code, terminals) VALUES
('John F. Kennedy International', 'JFK', 6),
('Los Angeles International', 'LAX', 5),
('Chicago O''Hare International', 'ORD', 7),
('Dallas/Fort Worth International', 'DFW', 5),
('Denver International', 'DEN', 6);

-- =====================================================
-- INSERT AIRLINES
-- =====================================================
INSERT INTO airlines (name, iata_code, region, is_international, required_document) VALUES
('American Airlines', 'AA', 'North America', true, 'Passport'),
('Delta Air Lines', 'DL', 'North America', true, 'Passport'),
('United Airlines', 'UA', 'North America', true, 'Passport'),
('Southwest Airlines', 'SW', 'North America', false, 'ID Card'),
('Frontier Airlines', 'F9', 'North America', false, 'ID Card');

-- =====================================================
-- INSERT USERS
-- =====================================================
INSERT INTO users (name, email, password, is_premium) VALUES
('Juan Pérez', 'juan@example.com', '$2a$10$I3iWEO1/kqs1w39yymfoPO3mvJk5uDaqf3sixLbKApLlxmIKXtmS2', false),
('María García', 'maria@example.com', '$2a$10$I3iWEO1/kqs1w39yymfoPO3mvJk5uDaqf3sixLbKApLlxmIKXtmS2', true),
('Carlos López', 'carlos@example.com', '$2a$10$I3iWEO1/kqs1w39yymfoPO3mvJk5uDaqf3sixLbKApLlxmIKXtmS2', false);

-- =====================================================
-- INSERT FLIGHTS
-- =====================================================
INSERT INTO flights (flight_number, origin, destination, price, duration_minutes, departure_date, arrival_date, is_available, status, airline_id) VALUES
('AA100', 'JFK', 'LAX', 599.99, 300, '2026-08-01 08:00:00', '2026-08-01 11:00:00', true, 'scheduled', 1),
('DL200', 'ORD', 'DFW', 399.99, 120, '2026-08-01 10:00:00', '2026-08-01 12:00:00', true, 'scheduled', 2),
('UA300', 'LAX', 'DEN', 349.99, 180, '2026-08-02 06:00:00', '2026-08-02 09:00:00', true, 'scheduled', 3),
('SW400', 'DFW', 'LAX', 289.99, 240, '2026-08-02 14:00:00', '2026-08-02 18:00:00', true, 'scheduled', 4),
('F9500', 'DEN', 'ORD', 199.99, 180, '2026-08-03 09:00:00', '2026-08-03 12:00:00', true, 'scheduled', 5),
('AA600', 'JFK', 'DFW', 459.99, 210, '2026-08-03 15:00:00', '2026-08-03 18:00:00', true, 'scheduled', 1),
('DL700', 'LAX', 'JFK', 579.99, 300, '2026-08-04 07:00:00', '2026-08-04 16:00:00', false, 'booked', 2);

-- =====================================================
-- VERIFY INSERTED DATA
-- =====================================================
SELECT 'Aeropuertos' as tabla, COUNT(*) as total FROM airports
UNION ALL
SELECT 'Aerolíneas', COUNT(*) FROM airlines
UNION ALL
SELECT 'Usuarios', COUNT(*) FROM users
UNION ALL
SELECT 'Vuelos', COUNT(*) FROM flights;
