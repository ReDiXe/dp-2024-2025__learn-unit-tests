package fr.anthonyquere.fizzbuzz;

import fr.anthonyquere.teashop.Tea;
import fr.anthonyquere.teashop.TeaCup;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class TeaCupTest {

    //la classe Tea est composé uniquement de getter et setter donc je ne la test pas. Je vais faire des tests sur TeaCup

    //ADDWATER

    @Test
    void should_put_temperature_in_teacup() {
        TeaCup cup = new TeaCup();
        cup.addWater(20);
        //test si les temperatures est bien mise a 20
        assertThat(cup.getCurrentTemperatureCelsius()).isEqualTo(20);
    }

    @Test
    void should_not_be_empty_after_adding_water() {
        TeaCup cup = new TeaCup();
        cup.addWater(20);
        assertThat(cup.isEmpty()).isFalse();
    }

    //ADDTEA

    @Test
    void should_not_be_able_to_add_tea_to_empty_cup() {
        TeaCup cup = new TeaCup();
        cup.setEmpty(true);
        assertThrows(IllegalStateException.class, () -> cup.addTea(new Tea("menthe", 10, 10, true)));
    }

    @Test
    void should_add_tea_to_cup() {
        TeaCup cup = new TeaCup();
        cup.addWater(20);
        cup.addTea(new Tea("menthe", 10, 10, true));
        assertThat(cup.getTea()).isNotNull();
    }

    @Test
    void should_start_steeping_time_when_adding_tea() {
        TeaCup cup = new TeaCup();
        cup.addWater(20);
        cup.addTea(new Tea("menthe", 10, 10, true));
        assertThat(cup.getSteepingStartTime()).isNotNull();
    }

    //ISREADYTODRINK

    @Test
    void should_not_be_ready_to_drink_if_notea() {
        TeaCup cup = new TeaCup();
        cup.addWater(20);
        assertThat(cup.isReadyToDrink()).isFalse();
    }

    @Test
    void should_not_be_ready_to_drink_if_empty() {
        TeaCup cup = new TeaCup();
        cup.addWater(20);
        cup.addTea(new Tea("menthe", 10, 10, true));
        cup.setEmpty(true);
        assertThat(cup.isReadyToDrink()).isFalse();
    }

    @Test
    void should_not_be_ready_to_drink_if_no_steepingtime() {
        TeaCup cup = new TeaCup();
        cup.addWater(20);
        cup.addTea(new Tea("menthe", 10, 10, true));
        assertThat(cup.isReadyToDrink()).isFalse();
    }

    @Test
    void should_not_be_ready_to_drink_if_no_temperatureideal() {
        TeaCup cup = new TeaCup();
        cup.addWater(20);
        cup.addTea(new Tea("menthe", 10, 10, true));
        assertThat(cup.isReadyToDrink()).isFalse();
    }

    @Test
    void should_be_ready_to_drink_if_steepingtime_and_temperatureideal() {
        TeaCup cup = new TeaCup();
        cup.addWater(10);
        cup.addTea(new Tea("menthe", 2, 10, true));
        //on attend 10 secondes
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(cup.isReadyToDrink()).isTrue();
    }

}
