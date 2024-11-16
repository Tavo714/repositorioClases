SELECT * 
FROM sys.key_constraints 
WHERE [parent_object_id] = OBJECT_ID('Usuarios') 
AND [type] = 'UQ';

ALTER TABLE Usuarios
DROP INDEX IX_Usuarios_Email; -- Asume que la restricción tiene este nombre en el índice

ALTER TABLE Usuarios
DROP CONSTRAINT UQ_Usuarios_Email;

ALTER TABLE Usuarios
DROP CONSTRAINT UQ_Usuarios_DNI;

SELECT 
    tc.constraint_name, 
    tc.table_name, 
    kcu.column_name
FROM 
    information_schema.table_constraints AS tc 
    JOIN information_schema.key_column_usage AS kcu
    ON tc.constraint_name = kcu.constraint_name
WHERE 
    tc.constraint_type = 'UNIQUE' 
    AND tc.table_name = 'Usuarios';

	ALTER TABLE Usuarios
DROP CONSTRAINT UQ__Usuarios__C035B8DD21EA0662;

ALTER TABLE Usuarios
DROP CONSTRAINT UQ__Usuarios__A9D10534DF87FBA2;

