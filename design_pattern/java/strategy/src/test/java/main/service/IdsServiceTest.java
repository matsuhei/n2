package main.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class IdsServiceTest {

    @Test
    public void id() {
        IdsService idsService = new IdsService();

        List<Long> numbers = Arrays.asList(1L, 2L, 3L, 4L, 5L);

        System.out.println("random result: " + idsService.getIdRandom(numbers));
        System.out.println("half result: " + idsService.getIdHalf(numbers));

        Assertions.assertEquals(idsService.getIdHalf(numbers), 3L);
    }
}
