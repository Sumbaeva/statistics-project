package ru.netology.statistic;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StatisticsServiceTest {
    @Test
    void findMax() {
        StatisticsService service = new StatisticsService();
        long[] incomesInBillions = {12, 5, 8, 4, 5, 3, 8, 6, 11, 11, 12};
        long expected = 12;
        long actual = service.findMax(incomesInBillions);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findMaxWhenMaxIsInTheMiddle() {
        StatisticsService service = new StatisticsService();
        long[] incomes = {5, 3, 12, 8, 4};  // max=12 в середине → if сработает несколько раз
        long expected = 12;
        long actual = service.findMax(incomes);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findMaxWhenMaxIsAtTheEnd() {
        StatisticsService service = new StatisticsService();
        long[] incomes = {1, 2, 3, 15, 10};  // max=15 в конце → обновление в конце цикла
        long expected = 15;
        long actual = service.findMax(incomes);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findMaxWithSingleElement() {
        StatisticsService service = new StatisticsService();
        long[] incomes = {100};  // Только один элемент → цикл не выполнится, if не вызовется
        long expected = 100;
        long actual = service.findMax(incomes);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findMaxWithAllEqual() {
        StatisticsService service = new StatisticsService();
        long[] incomes = {7, 7, 7, 7};  // Все равны первому → if никогда не true
        long expected = 7;
        long actual = service.findMax(incomes);
        Assertions.assertEquals(expected, actual);
    }
}