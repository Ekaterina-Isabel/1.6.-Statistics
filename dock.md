## Правильно настроен Maven-проект, тесты проходят
  
  Репозиторий должен быть папкой вашего мавен-проекта. Обратите внимание, что репозиторием не должна быть папка в которой лежит папка мавен-проекта, он сам должен быть папкой проекта. В нём должны быть соответствующие файлы и папки - `pom.xml`, `src` и др.
  
  Не забудьте создать .gitignore-файл в корне проекта и добавить туда в игнорирование автогенерируемую папку `target`.
  
  Общая схема вашего `pom.xml`-файла:
  
  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>ru.netology</groupId>
    <artifactId>НАЗВАНИЕ-ВАШЕГО-ПРОЕКТА-БЕЗ-ПРОБЕЛОВ</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>


    <dependencies>
        <dependency>
            ...
        </dependency>
        ...
    </dependencies>


    <build>
        <plugins>
            <plugin>
              ...
            </plugin>

            <plugin>
              ...
              <executions>
                <execution>
                  ...
                </execution>
                ...
              </executions>
            </plugin>
            ...
        </plugins>
    </build>

</project>
  ```
  
  #### JUnit
  Обратите внимание что у артефакта нет `-api` на конце. Если у вас автоматически добавилась зависимость вида `<artifactId>junit-jupiter-api</artifactId>`, то лучше поменять артефакт на тот что ниже, иначе будут сюрпризы в работе.

  ```xml
          <dependency>
              <groupId>org.junit.jupiter</groupId>
              <artifactId>junit-jupiter</artifactId>
              <version>5.7.0</version>
              <scope>test</scope>
          </dependency>
  ```

  #### Surefire
  Без этого плагина тесты могут мавеном не запускаться, хоть в идее через кнопки они и будут проходить. Чтобы лишний раз убедиться, что всё работает, нажмите `Ctrl+Ctrl` и затем `mvn clean test`.
  
  ```xml
              <plugin>
                  <groupId>org.apache.maven.plugins</groupId>
                  <artifactId>maven-surefire-plugin</artifactId>
                  <version>2.22.2</version>
                  <configuration>
                      <failIfNoTests>true</failIfNoTests>
                  </configuration>
              </plugin>
  ```
  
  ---
 
## Задание 1. Статистика

Метод ниже считает номер месяца минимальных продаж. Логика его такова: заводим переменную `minMonth` для хранения номера ячейки в массиве того месяца, в котором были минимальные продажи среди всех уже просмотренных; изначально мы никакие ещё не просмотрели, потому запишем туда номер 0. Будем циклом поочерёдно смотреть месяцы продаж: на каждой итерации у нас в `sale` будет количество продаж в рассматриваемом месяце, в `month` - номер этого рассматриваемого месяца. Если мы смотрим на месяц в котором продажи меньше чем в минимальном из просмотренных ранее (чей номер запомнен в `minMonth`), то считаем теперь этот рассматриваемый месяц минимальным (присваиваем в `minMonth` значение `month`). И так до конца массива продаж, тогда после цикла в `minMonth` у нас будет лежать номер месяца минимальных продаж. Останется только один момент: мы нумеровали месяцы с нуля (тк в массивах ячейки нумеруются с нуля), потому отдавая ответ нам надо прибавить 1.

```java
public int minSales(long[] sales) {
  int minMonth = 0;
  int month = 0; // переменная для индекса рассматриваемого месяца в массиве
  for (long sale : sales) {
    // sales[minMonth] - продажи в месяце minMonth
    // sale - продажи в рассматриваемом месяце
    if (sale <= sales[minMonth]) {
      minMonth = month;
    }
    month = month + 1; // следующий рассматриваемый месяц имеет номер на 1 больше
  }
  return minMonth + 1;
}
```
