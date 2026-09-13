# Demo Web Server

Небольшой веб-сервер на Spring Boot. Приложение предоставляет API для регистрации пользователей и просмотра списка зарегистрированных пользователей.

## Требования

- Java 17 или новее (рекомендуется Java 21)
- Maven 3.6+ или Maven Wrapper, который уже находится в проекте

## Запуск

Из корневой папки проекта выполните:

Linux/macOS:

```bash
./mvnw spring-boot:run
```

Windows:

```bat
mvnw.cmd spring-boot:run
```

Если Maven установлен глобально, можно использовать `mvn spring-boot:run`.

После успешного запуска сервер доступен по адресу [http://localhost:8687](http://localhost:8687). Порт `8687` задан в файле `src/main/resources/application.properties`.

## API

Получить список зарегистрированных пользователей:

```bash
curl http://localhost:8687/api/users
```

Зарегистрировать пользователя:

```bash
curl -X POST http://localhost:8687/api/register \
  -H "Content-Type: application/json" \
  -d '{"name":"Иван","email":"ivan@example.com","phone":"89991234567"}'
```

При успешной регистрации сервер возвращает сообщение и отформатированный номер телефона. При ошибке валидации возвращается список ошибок.

## Сборка

Собрать проект без запуска сервера:

```bash
./mvnw clean package
```

После сборки запустить полученный JAR можно так:

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

Остановить сервер можно сочетанием `Ctrl+C` в терминале, где он запущен.
