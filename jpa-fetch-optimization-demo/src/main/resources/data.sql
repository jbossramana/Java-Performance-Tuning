INSERT INTO customers(name) VALUES ('Venkat');
INSERT INTO customers(name) VALUES ('Ravi');
INSERT INTO customers(name) VALUES ('Kiran');

INSERT INTO orders(amount, status, customer_id)
VALUES (1000, 'PLACED', 1);

INSERT INTO orders(amount, status, customer_id)
VALUES (2500, 'SHIPPED', 1);

INSERT INTO orders(amount, status, customer_id)
VALUES (500, 'PLACED', 2);

INSERT INTO orders(amount, status, customer_id)
VALUES (900, 'DELIVERED', 3);

INSERT INTO orders(amount, status, customer_id)
VALUES (1200, 'PLACED', 3);