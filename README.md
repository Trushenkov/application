# Application with Spring Security and Spring Data JPA

## Реализовано:
1. Основы работы со Sprind Data JPA.
2. Вывод различной информации из таблиц log, users, roles по запросу (например, localhost:8080/user/1).
3. Используется Spring Security для аутентификации и контроля доступа.
4. Запросы localhost:8080/user/** и localhost:8080/role/** являются защищенными, для доступа к которым требуется аутентификация.
5. Права администратора для доступа к защищенному запросу предоставлены пользователю с логином и паролем, прописанными в application.properties
6. Если пользователь имеет нужные права, то по запросам  localhost:8080/user/** и localhost:8080/role/** выводится информация из базы данных.
7. В таблицу log записывается информация о пользователе, который выполнял запрос: <ul><li>login</li><li>dateLogin</li></ul>
