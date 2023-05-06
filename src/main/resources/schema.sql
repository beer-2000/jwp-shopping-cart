CREATE TABLE product
(
    id        BIGINT      NOT NULL AUTO_INCREMENT,
    name      VARCHAR(50) NOT NULL,
    price     BIGINT      NOT NULL,
    image_url TEXT        NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE member
(
    id        BIGINT      NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(100) NOT NULL,
    name VARCHAR(255),
    phone_number VARCHAR(50),
    PRIMARY KEY (id)
);
