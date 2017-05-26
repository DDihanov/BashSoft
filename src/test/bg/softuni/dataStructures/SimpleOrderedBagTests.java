package test.bg.softuni.dataStructures;

import main.bg.softuni.dataStructures.SimpleOrderedBag;
import main.bg.softuni.dataStructures.SimpleSortedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;

public class SimpleOrderedBagTests {

    private SimpleOrderedBag<String> names;

    @Before
    public void setUp() {

        this.names = new SimpleSortedList<>(String.class);
    }

    @Test
    public void testEmptyConstructor() {

        this.names = new SimpleSortedList<>(String.class);

        Assert.assertEquals(16, this.names.capacity());

        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testConstructorWithInitialCapacity() {

        this.names = new SimpleSortedList<>(String.class, 20);

        Assert.assertEquals(20, this.names.capacity());

        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testConstructorWithInitialComparator() {

        this.names = new SimpleSortedList<>(
                String.class,
                String.CASE_INSENSITIVE_ORDER);

        Assert.assertEquals(16, this.names.capacity());

        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void testConstructorWithAllParameters() {

        this.names = new SimpleSortedList<>(
                String.class,
                String.CASE_INSENSITIVE_ORDER,
                30);

        Assert.assertEquals(30, this.names.capacity());

        Assert.assertEquals(0, this.names.size());
    }

    @Test
    public void addShouldIncreaseSize() {

        this.names.add("Name");

        Assert.assertEquals(1, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPassedToAddShouldThrowException() {

        this.names.add(null);
    }

    @Test
    public void addedDataShouldBeSorted() {

        List<String> testNames = new ArrayList<>();
        testNames.add("Rosen");
        testNames.add("Georgi");
        testNames.add("Balkan");

        this.names.addAll(testNames);

        List<String> sortedTestNames = new ArrayList<>(testNames);
        sortedTestNames.sort(Collator.getInstance());

        List<String> namesFromBag = new ArrayList<>();
        for (String name : this.names) {

            namesFromBag.add(name);
        }

        Assert.assertArrayEquals(sortedTestNames.toArray(), namesFromBag.toArray());
    }

    @Test
    public void shouldResizeItselfWhenAddingElementsAboveInitialCapacity() {

        for (int i = 0; i < 17; i++) {

            this.names.add("Name");
        }

        Assert.assertEquals(17, this.names.size());
    }

    @Test
    public void collectionPassedToAddAllShouldIncreaseSize() {

        List<String> testNames = new ArrayList<>();
        testNames.add("Rosen");
        testNames.add("Georgi");

        this.names.addAll(testNames);

        Assert.assertEquals(2, this.names.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPassedToAddAllShouldThrowException() {

        this.names.addAll(null);
    }

    @Test
    public void removingAnElementShouldDecreaseSize() {

        this.names.add("First");
        this.names.add("Second");

        this.names.remove("First");

        Assert.assertEquals(1, this.names.size());
    }

    @Test
    public void removeShouldRemoveCorrectElement() {

        this.names.add("First");
        this.names.add("Second");

        this.names.remove("First");

        for (String name : this.names) {

            if ("First".equals(name)) {

                Assert.fail();
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPassedToRemoveShouldThrowException() {

        this.names.remove(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullPassedToJoinWithShouldThrowException() {

        this.names.joinWith(null);
    }

    @Test
    public void joinWithShouldJoinElementsCorrectly() {

        this.names.add("First");
        this.names.add("Second");
        this.names.add("Third");

        String expected = "First, Second, Third";

        Assert.assertEquals(expected, this.names.joinWith(", "));
    }
}
