
CREATE TABLE payments (
                          id BIGSERIAL PRIMARY KEY,
                          payment_id VARCHAR(100) NOT NULL UNIQUE,
                          amount NUMERIC(12, 2) NOT NULL,
                          currency VARCHAR(3) NOT NULL,
                          status VARCHAR(30) NOT NULL
);

CREATE TABLE exported_payments (
                                   id BIGSERIAL PRIMARY KEY,
                                   payment_id VARCHAR(100) NOT NULL,
                                   amount NUMERIC(12, 2) NOT NULL,
                                   currency VARCHAR(3) NOT NULL,
                                   exported_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Sample payment records for the retail scenario

INSERT INTO payments
(payment_id, amount, currency, status)
VALUES
    ('PAY1001', 120.00, 'EUR', 'ALLOCATED'),
    ('PAY1002', 45.00, 'EUR', 'PENDING'),
    ('PAY1003', 90.00, 'EUR', 'ALLOCATED'),
    ('PAY1004', 150.00, 'EUR', 'FAILED'),
    ('PAY1005', 80.00, 'EUR', 'ALLOCATED'),
    ('PAY1006', 200.00, 'EUR', 'PENDING');
