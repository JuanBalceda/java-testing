package com.balceda.testing;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple Cafe.
 */
public class CafeTest {

    @Test
    public void CanBrewEspresso() {

        // Given
        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        // When
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // Then
        // It is an espresso
        // No milk
        // We've got enough coffee
        Assert.assertEquals(CoffeeType.Espresso, coffee.getType());
        Assert.assertEquals(0, coffee.getMilk());
        Assert.assertEquals(7, coffee.getBeans());
    }

    @Test
    public void brewingEspressoConsumesBeans() {

        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        Assert.assertEquals(0, cafe.getBeansInStock());
    }

    @Test(expected = IllegalStateException.class)
    //@Test
    public void latteRequiresMilk() {

        Cafe cafe = new Cafe();
        cafe.restockBeans(7);

        cafe.brew(CoffeeType.Latte);
    }

}
