# Spring Boot - Liquibase

## Changelog
All liquibase changes are logged through a changelog file : `changelog-master.yaml`.

This file will list sequentially all the changes made to the database.

Here is an [example](src/main/resources/db/changelog/db.changelog-master.yaml)
```yaml
databaseChangeLog:
  - include:
      file: src/main/resources/db/changelog/0001/changelog.yaml
  - include:
      file: src/main/resources/db/changelog/0002/0002-01_create_new_table.sql
```

## Changeset
The changeset is a unit of change, a group of changeset form a changelog.

A changeset in liquibase has 2 attributes : id and author.

Here the format of a changset in `SQL`:
```sql
--liquibase formatted sql
--changeset author:id

CREATE TABLE ...

-- rollback DROP TABLE ...;
```

Here is an example:
```sql
--liquibase formatted sql
--changeset eliedaher:0001-1

CREATE TABLE test (
    id UUID PRIMARY KEY
)

-- rollback DROP TABLE test;
```

### Goals
| Goal                  | Parameters                | Description                   | 
| --------------------- | ------------------------- | ----------------------------- |
| `liquibase:update`    |                           | Migration database            |
| `liquibase:rollback`  | `liquibase.rollbackDate`  | Rollback to a specific date   |
| `liquibase:rollback`  | `liquibase.rollbackCount` | Rollback by count             |

### Use cases
#### Update database
```
mvn liquibase:update
```
#### Tag current database state
```
mvn liquibase:tag -Dliquibase.tag=10
```
#### Rollback by changeset count
```
mvn liquibase:rollback -Dliquibase.rollbackCount=2
```
#### Rollback to a specific date
```
mvn liquibase:rollback -Dliquibase.rollbackDate=2020-05-30T11:30:00
```
#### Rollback to a previous tag
```
mvn liquibase:rollback -Dliquibase.rollbackTag=9
```
