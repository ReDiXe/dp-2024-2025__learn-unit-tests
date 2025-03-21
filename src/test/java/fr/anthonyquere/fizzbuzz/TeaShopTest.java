package fr.anthonyquere.fizzbuzz;

import fr.anthonyquere.teashop.Tea;
import fr.anthonyquere.teashop.TeaCup;
import fr.anthonyquere.teashop.TeaShop;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TeaShopTest {

    //ADDTEA

    @Test
    void should_add_tea_to_teashop() {
        TeaShop shop = new TeaShop(20);
        shop.addTea(new Tea("menthe", 10, 10, true));
        assertThat(shop.getAvailableTeas()).isNotEmpty();
    }

    //PREPARETEA

    @Test
    void should_prepare_tea() {
        TeaShop shop = new TeaShop(20);
        shop.addTea(new Tea("menthe", 10, 10, true));
        TeaCup cup = shop.prepareTea("menthe");
        assertThat(cup).isNotNull();
    }

    @Test
    void should_not_prepare_tea_if_not_available() {
        TeaShop shop = new TeaShop(20);
        shop.addTea(new Tea("menthe", 10, 10, true));
        assertThatThrownBy(() -> shop.prepareTea("earl grey"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    //SETWATERTEMPERATURE

    @Test
    void should_set_water_temperature() {
        TeaShop shop = new TeaShop(20);
        shop.setWaterTemperature(30);
        assertThat(shop.getWaterTemperature()).isEqualTo(30);
    }

    @Test
    void should_not_set_water_temperature_out_of_bounds() {
        TeaShop shop = new TeaShop(20);
        assertThatThrownBy(() -> shop.setWaterTemperature(-1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> shop.setWaterTemperature(101))
                .isInstanceOf(IllegalArgumentException.class);
    }
}