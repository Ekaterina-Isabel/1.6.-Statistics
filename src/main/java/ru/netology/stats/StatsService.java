package ru.netology.stats;

public class StatsService {

    public long getSumOfAllSales(long[] sales) {   //Сумма всех продаж, sales - название массива
        long sum = 0;
        for (long sale : sales) {
            sum += sale;
        }
        return sum;
    }

    public double getAvgSumOfSales(long[] sales) {   //Средняя сумма продаж в месяц
        long sum = getSumOfAllSales(sales);
        int length = sales.length;
        double avgSum = sum / length;

        return avgSum;
    }

    public int maxSales(long[] sales) {   //Номер месяца, в котором был пик продаж
        int maxMonth = 0;   //номер ячейки в массиве того месяца, в котором были максимальные продажи среди всех уже просмотренных
        int month = 0;   //переменная для индекса рассматриваемого месяца в массиве
        for (long sale : sales) {
            if (sale >= sales[maxMonth]) {   //sales[maxMonth] - продажи в месяце maxMonth
                //sale - продажи в рассматриваемом месяце
                maxMonth = month;
            }
            month = month + 1;   //следующий рассматриваемый месяц имеет номер на 1 больше
        }
        return maxMonth + 1;
    }

    public int minSales(long[] sales) {   //Номер месяца, в котором был минимум продаж
        int minMonth = 0;
        int month = 0;
        for (long sale : sales) {
            if (sale <= sales[minMonth]) {
                minMonth = month;
            }
            month = month + 1;
        }
        return minMonth + 1;
    }

    public int lessAvgSales(long[] sales) {   //Кол-во месяцев, в которых продажи были ниже среднего
        int monthCount = 0;
        double avgSum = getAvgSumOfSales(sales);

        for (long sale : sales) {
            if (sale < avgSum) {
                monthCount = monthCount + 1;
            }
        }
        return monthCount;
    }

    public int moreAvgSales(long[] sales) {   //Кол-во месяцев, в которых продажи были выше среднего
        int monthCount = 0;
        double avgSum = getAvgSumOfSales(sales);

        for (long sale : sales) {
            if (sale > avgSum) {
                monthCount = monthCount + 1;
            }
        }
        return monthCount;
    }
}