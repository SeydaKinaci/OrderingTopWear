
-- Order table
CREATE TABLE "order" (
                         id BIGSERIAL PRIMARY KEY,
                         uuid UUID NOT NULL UNIQUE,
                         location VARCHAR(255) NOT NULL,
                         status VARCHAR(255) NOT NULL,
                         order_date TIMESTAMP NOT NULL
);

-- Line Item table
CREATE TABLE order_item (
                            id BIGSERIAL PRIMARY KEY,
                            order_id BIGINT NOT NULL REFERENCES "order"(id) ON DELETE CASCADE,
                            order_key INT NOT NULL,
                            sleeve_type VARCHAR(255) NOT NULL,
                            color VARCHAR(255) NOT NULL,
                            size VARCHAR(255) NOT NULL,
                            quantity INT NOT NULL

);
