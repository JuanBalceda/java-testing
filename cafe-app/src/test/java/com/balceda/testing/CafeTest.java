package com.balceda.testing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


/**
 * Unit test for simple Cafe.
 */
public class CafeTest {

    private static final int ESPRESSO_BEANS = CoffeeType.Espresso.getRequiredBeans();
    private static final int NO_BEANS = 0;
    private static final int NO_MILK = 0;

    private Cafe cafe;

    @Before
    public void before(){
        cafe = new Cafe();
        withBeans();
    }

    @Test
    public void CanBrewEspresso() {

        // When
        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        // Then
        // It is an espresso
        // No milk
        // We've got enough coffee
        assertThat(coffee, hasProperty("beans",equalTo(ESPRESSO_BEANS)));
        Assert.assertEquals("Wrong coffee type", CoffeeType.Espresso, coffee.getType());
        Assert.assertEquals("Wrong amount of milk", NO_MILK, coffee.getMilk());
        Assert.assertEquals("Wrong number of beans", ESPRESSO_BEANS, coffee.getBeans());
    }

    @Test
    public void CanBrewLatte() {

        // Given
        cafe.restockMilk(227);

        // When
        Coffee coffee = cafe.brew(CoffeeType.Latte);

        // Then
        Assert.assertEquals("Wrong coffee type", CoffeeType.Latte, coffee.getType());
    }

    @Test
    public void brewingEspressoConsumesBeans() {

        Coffee coffee = cafe.brew(CoffeeType.Espresso);

        Assert.assertEquals("Wrong number of beans in stock", NO_BEANS, cafe.getBeansInStock());
    }

    @Test(expected = IllegalStateException.class)
    // @Test
    public void latteRequiresMilk() {

        cafe.brew(CoffeeType.Latte);
    }

    private void withBeans() {
        cafe.restockBeans(ESPRESSO_BEANS);
    }
}
