# car-parts-shop

## Zadania do zrealizowania
- Stworzenie szkieletu projektu (encje, kontrolery, serwisy)
- Utworzenie bazy danych zawierającej informacje o częściach samochodowych
- Uzupełnienie bazy danych przykładowymi danymi
- Dodanie ORM (Hibernate)
- Implementacja REST API (CRUD)
- Implementacja systemu logowania do aplikacji
- Stworzenie prostego UI do łatwej obsługi aplikacji
- Stworzenie ról, które mają dostęp do innych części systemu (Admin, User)
- Budowanie projektu za pomocą Dockera
- Stworzenie dokumentacji projektu

Postman:
https://go.postman.co/workspace/Studia~0620a336-7422-4c1f-92e8-3fa5ae6f4b90/collection/8221061-7eebb6d4-1400-463a-b487-d13c71aec5a5?action=share&creator=8221061

Po sklonowaniu projektu należy uruchomić komendę
mvn clean install -DskipTests

Następnie przy użyciu docker-compose build budujemy obrazy.

Komenda docker-compose up, uruchamia kontenery i aplikacja jest gotowa do użycia.
