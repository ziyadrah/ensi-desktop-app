# ENSI Desktop application

## To run a Postgres container

`docker run --name ensi -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=dev -e POSTGRES_DB=ensidesktopapp -p 5432:5432 -d postgres`

## To run the db schema - create the tables

`docker exec -i ensi psql -U postgres -d ensidesktopapp < sql/init_db.sql`
