DROP TABLE IF EXISTS Item;

CREATE TABLE item
(
    item_id     IDENTITY        PRIMARY KEY,
    item_name   VARCHAR(255)    NOT NULL,
    item_price  INT             NOT NULL,
    item_amount INt				NOT NULL
);
