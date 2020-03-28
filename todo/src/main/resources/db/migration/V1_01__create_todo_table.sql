CREATE TABLE todos (
    id uuid PRIMARY KEY,
    name text NOT NULL,
    done BOOLEAN default FALSE,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);