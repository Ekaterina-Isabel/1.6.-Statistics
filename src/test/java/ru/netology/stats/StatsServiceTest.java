package ru.netology.stats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatsServiceTest {

    @Test
    void getSumOfAllSales() {   //Сумма всех продаж
        StatsService service = new StatsService();

        long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};   //sales - название массива
        long expected = 180;

        long actual = service.getSumOfAllSales(sales);
        assertEquals(expected, actual);
    }

    @Test
    void getAvgSumOfSales() {   //Средняя сумма продаж в месяц
        StatsService service = new StatsService();

        long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
        double expected = 15;

        double actual = service.getAvgSumOfSales(sales);
        assertEquals(expected, actual);
    }

    @Test
    void maxSales() {   //Номер месяца, в котором был пик продаж
        StatsService service = new StatsService();

        long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
        long expected = 8;

        long actual = service.maxSales(sales);
        assertEquals(expected, actual);
    }

    @Test
    void minSales() {   //Номер месяца, в котором был минимум продаж
        StatsService service = new StatsService();

        long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
        long expected = 9;

        long actual = service.minSales(sales);
        assertEquals(expected, actual);
    }

    @Test
    void lessAvgSales() {   //Кол-во месяцев, в которых продажи были ниже среднего
        StatsService service = new StatsService();

        long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
        long expected = 5;

        long actual = service.lessAvgSales(sales);
        assertEquals(expected, actual);
    }

    @Test
    void moreAvgSales() {   //Кол-во месяцев, в которых продажи были выше среднего
        StatsService service = new StatsService();

        long[] sales = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
        long expected = 5;

        long actual = service.moreAvgSales(sales);
        assertEquals(expected, actual);
    }
}