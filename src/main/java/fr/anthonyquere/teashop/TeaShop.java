package fr.anthonyquere.teashop;

import java.util.HashMap;
import java.util.Map;

public class TeaShop {
    private final Map<String, Tea> availableTeas = new HashMap<>();
    private int waterTemperature;

    public TeaShop(int defaultWaterTemperature) {
        this.waterTemperature = defaultWaterTemperature;
    }

    public void addTea(Tea tea) {
        availableTeas.put(tea.getName().toLowerCase(), tea);
    }

    public TeaCup prepareTea(String teaName) {
        Tea tea = availableTeas.get(teaName.toLowerCase());
        if (tea == null) {
            throw new IllegalArgumentException("Tea not available: " + teaName);
        }

        TeaCup cup = new TeaCup();
        cup.addWater(waterTemperature);
        cup.addTea(tea);
        return cup;
    }

    public void setWaterTemperature(int celsius) {
        if (celsius < 0 || celsius > 100) {
            throw new IllegalArgumentException("Water temperature must be between 0 and 100°C");
        }
        this.waterTemperature = celsius;
    }

    // Getters et Setters
    public Map<String, Tea> getAvailableTeas() {
        return new HashMap<>(availableTeas);
    }

    public int getWaterTemperature() {
        return waterTemperature;
    }

}