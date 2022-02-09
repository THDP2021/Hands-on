-- Functions in SQL are a user-defined routines, their objective is get one or many
-- parameters as we need, perform some set of instructions and return an output

-- Procedures in SQL are also user-defined routines, but their objective is to perform
-- operations on the database, like update certain data, calculate some value, and they
-- do not return any output.

--Use this lines to delete the functions and procedures

DROP FUNCTION stock_product;
DROP FUNCTION name_product;
DROP FUNCTION price_product;
DROP PROCEDURE apply_discount;
DROP PROCEDURE increase_price;

--Use this lines to initialize the functions and procedures.

--------------------------------
CREATE FUNCTION stock_product (pid int)
returns int
begin
	return (SELECT SUM(amount)  from products where id = pid);
end;

-- Example of call from SQL command line or UI command runner
-- select stock_product(1);
------------------------------
CREATE FUNCTION name_product (pid int)
returns VARCHAR(30)
begin
	return (SELECT name from products where id = pid );
end;

-- Example of call from SQL command line or UI command runner
-- select name_product(1);
---------------------------------------
CREATE FUNCTION price_product (name_p varchar(30))
returns float
DETERMINISTIC
begin
	return (select price from products where name like name_p);
end;

-- Example of call from SQL command line or UI command runner
-- select price_product('%Sod%');
--------------------------------------
CREATE PROCEDURE apply_discount (IN discount FLOAT, IN pid INTEGER)
BEGIN
		SET @vcalc = 1 - (discount / 100);
		UPDATE products SET price = ROUND(price * @vcalc, 2) WHERE id = pid;
END;

-- Example of call from SQL command line or UI command runner
-- call apply_discount(20, 19);
----------------------------------------
CREATE PROCEDURE increase_price (IN increment FLOAT, IN pid INTEGER)
BEGIN
		SET @vcalc = 1 + (increment / 100);
		UPDATE products SET price = ROUND(price * @vcalc, 2) WHERE id = pid;
END;

-- Example of call from SQL command line or UI command runner
-- call increase_price(20, 19);