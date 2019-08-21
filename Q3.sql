# timestamp often called in where clause
CREATE INDEX by_order_date ON storefrontdb.order (order_date);

# quantity must be checked before any order
CREATE INDEX by_quantity ON product(quantity);

# category_name is checked whenever we required category wise data
CREATE INDEX by_category_name ON category(category_name);
