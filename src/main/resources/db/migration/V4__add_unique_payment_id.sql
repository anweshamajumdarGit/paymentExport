ALTER TABLE exported_payments
ADD CONSTRAINT uk_exported_payment_id
UNIQUE (payment_id);