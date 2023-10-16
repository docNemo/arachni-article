# arachni-article

## Деплой базы данных

Команда для деплоя схемы БД

```shell
mvn clean liquibase:update -Dliquibase.url=jdbc:postgresql://postgres-lab-1.neo:5432/arachni -Dliquibase.username=<Логин УЗ> -Dliquibase.password=<Пароль УЗ> -Dliquibase.verbose=true
```
