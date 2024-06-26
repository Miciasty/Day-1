package src.test.java.nsk;

import org.junit.Before;
import org.junit.Test;
import src.main.java.nsk.Civilizations.Country;
import src.main.java.nsk.CivilizationSandbox;
import src.main.java.nsk.Resources.Entities.Citizen;
import src.main.java.nsk.Resources.Entities.Knight;
import src.main.java.nsk.Resources.Entity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestCountryManagement {

    private Country V;
    private CivilizationSandbox civilizationSandbox;

    @Before
    public void init() {
        civilizationSandbox = new CivilizationSandbox();

        V = new Country("Valhalla");
        civilizationSandbox.addCountry(V);
    }


    @Test
    public void testCountryCreation() {
        assertEquals("Valhalla", civilizationSandbox.getCountry(0).getName());
    }

    @Test
    public void testCountryDeletion() {

        assertEquals("Valhalla", civilizationSandbox.getCountry(0).getName());

        civilizationSandbox.removeCountry(V);

        assertNull(civilizationSandbox.getCountry(0));
    }

    @Test
    public void testCountryDeletionByName() {

        assertEquals("Valhalla", civilizationSandbox.getCountry(0).getName());

        civilizationSandbox.removeCountry("Valhalla");

        assertNull(civilizationSandbox.getCountry(0));
    }

    @Test
    public void testNullGetEntities() {
        assertNull(V.getEntities());
    }

    @Test
    public void testAddEntities_GetEntities() {

        for (int i=0; i<6; i++) {
            V.addEntity(new Citizen());
        }
        for (int i=0; i<6; i++) {
            V.addEntity(new Knight(Knight.JobType.HORSEMAN));
        }

        List<Entity> entities = V.getAllEntitiesOfClass(Knight.class);

        for (Entity entity : entities) {
            if (entity instanceof Knight) {
                assertEquals("Knight, Health: 50, Damage: 5", entity.toString());
            }
        }

        entities = V.getAllEntitiesOfClass(Citizen.class);

        for (Entity entity : entities) {
            if (entity instanceof Citizen) {
                assertEquals("Citizen, Health: 5, Damage: 1", entity.toString());
            }
        }

    }

}
