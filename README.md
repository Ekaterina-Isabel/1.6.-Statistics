# Домашнее задание к занятию "Циклы, параметризованные тесты и аннотации (часть 2)"

## Задание 1. Статистика

Статистика - очень важный компонент любого бизнеса. У вас есть набор данных о продажах конкретного предприятия по месяцам: `[8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18]`.

Вам поручили написать небольшой сервис, который умеет по предоставленному ему массиву месячных продаж рассчитывать:
1. Сумму всех продаж
2. Среднюю сумму продаж в месяц
3. Номер месяца, в котором был пик продаж (осуществлены продажи на максимальную сумму)*
4. Номер месяца, в котором был минимум продаж (осуществлены продажи на минимальную сумму)*
5. Кол-во месяцев, в которых продажи были ниже среднего (см. п.2)
6. Кол-во месяцев, в которых продажи были выше среднего (см. п.2)

Примечание:* в вашем задании нужно найти последний месяц, соответствующий условиям.

Сервис должен представлять с собой один класс с шестью методами - по методу на пункт; входные данные для рассчёта сервис должен принимать в параметрах своих методов. Обратите внимание, что написанный класс должен уметь работать с любыми значениями в массиве продаж, а приведённый выше набор это лишь пример данных для ваших тестов на методы создаваемого класса.

**Вам необходимо:**
1. Создать Maven проект, в котором в package `ru.netology.stats` будет класс `StatsService` с необходимыми методами
1. Написать на каждый метод по одному автотесту, который проверяет правильность работы на тестовых данных
1. Убедитесь, что ваши автотесты работают и проходят (для этого пробуйте "ронять" каждый свой тест и удостоверяйтесь, что он действительно падает).

**Результат:** отправьте на проверку ссылку на гитхаб-репозиторий с вашим проектом.
