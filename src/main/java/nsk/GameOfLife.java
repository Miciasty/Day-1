package src.main.java.nsk;

import src.main.java.nsk.Civilizations.Country;
import src.main.java.nsk.Resources.GameInstance;

import java.util.ArrayList;
import java.util.List;

public class GameOfLife {

    private final List<Country> countries = new ArrayList<>();

    public GameOfLife() {
        GameInstance.setInstance(this);

        try {
            GameInstance.getInstance().systemMessage("Starting new session...");
        } catch (Exception e) {
            this.consoleError(e);
        }
    }

    public void addCountry(Country c) {
        this.countries.add(c);
    }

    public Country getCountry(int i) {
        try {
            if (this.countries.get(i) != null) {
                return this.countries.get(i);
            } else {
                throw new IllegalArgumentException("Country not found");
            }
        } catch (Exception e) {
            this.consoleError(e);
            return null;
        }
    }

    public void removeCountry(Country c) {
        this.countries.remove(c);
    }
    public void removeCountryByName(String name) {
        try {
            for (Country c : countries) {
                if (c.getName().equals(name)) {
                    this.countries.remove(c);
                    return;
                }
            }

            throw new IllegalArgumentException("Country with name " + name + " doesn't exists.");

        } catch (Exception e) {
            this.consoleError(e);
        }
    }

    public void consoleError(Exception e) {
        System.out.println(e.getMessage());
    }

    public void systemMessage(String m) {
        System.out.println(m);
    }

}
