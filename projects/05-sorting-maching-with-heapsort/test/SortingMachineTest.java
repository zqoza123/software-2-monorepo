import static org.junit.Assert.assertEquals;

import java.util.Comparator;

import org.junit.Test;

import components.sortingmachine.SortingMachine;

/**
 * JUnit test fixture for {@code SortingMachine<String>}'s constructor and
 * kernel methods.
 *
 * @author David P. & Ford M.
 *
 */
public abstract class SortingMachineTest {

    /**
     * Invokes the appropriate {@code SortingMachine} constructor for the
     * implementation under test and returns the result.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @return the new {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures constructorTest = (true, order, {})
     */
    protected abstract SortingMachine<String> constructorTest(
            Comparator<String> order);

    /**
     * Invokes the appropriate {@code SortingMachine} constructor for the
     * reference implementation and returns the result.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @return the new {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures constructorRef = (true, order, {})
     */
    protected abstract SortingMachine<String> constructorRef(
            Comparator<String> order);

    /**
     *
     * Creates and returns a {@code SortingMachine<String>} of the
     * implementation under test type with the given entries and mode.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @param insertionMode
     *            flag indicating the machine mode
     * @param args
     *            the entries for the {@code SortingMachine}
     * @return the constructed {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures <pre>
     * createFromArgsTest = (insertionMode, order, [multiset of entries in args])
     * </pre>
     */
    private SortingMachine<String> createFromArgsTest(Comparator<String> order,
            boolean insertionMode, String... args) {
        SortingMachine<String> sm = this.constructorTest(order);
        for (int i = 0; i < args.length; i++) {
            sm.add(args[i]);
        }
        if (!insertionMode) {
            sm.changeToExtractionMode();
        }
        return sm;
    }

    /**
     *
     * Creates and returns a {@code SortingMachine<String>} of the reference
     * implementation type with the given entries and mode.
     *
     * @param order
     *            the {@code Comparator} defining the order for {@code String}
     * @param insertionMode
     *            flag indicating the machine mode
     * @param args
     *            the entries for the {@code SortingMachine}
     * @return the constructed {@code SortingMachine}
     * @requires IS_TOTAL_PREORDER([relation computed by order.compare method])
     * @ensures <pre>
     * createFromArgsRef = (insertionMode, order, [multiset of entries in args])
     * </pre>
     */
    private SortingMachine<String> createFromArgsRef(Comparator<String> order,
            boolean insertionMode, String... args) {
        SortingMachine<String> sm = this.constructorRef(order);
        for (int i = 0; i < args.length; i++) {
            sm.add(args[i]);
        }
        if (!insertionMode) {
            sm.changeToExtractionMode();
        }
        return sm;
    }

    /**
     * Comparator<String> implementation to be used in all test cases. Compare
     * {@code String}s in lexicographic order.
     */
    private static class StringLT implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return s1.compareToIgnoreCase(s2);
        }

    }

    /**
     * Comparator instance to be used in all test cases.
     */
    private static final StringLT ORDER = new StringLT();

    /*
     * Sample test cases.
     */
    /**
     * Tests testing test constructor.
     */
    @Test
    public final void testConstructor() {
        SortingMachine<String> m = this.constructorTest(ORDER);
        SortingMachine<String> mExpected = this.constructorRef(ORDER);
        assertEquals(mExpected, m);
    }

    /**
     * Tests checking test add empty.
     */
    @Test
    public final void testAddEmpty() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "green");
        m.add("green");
        assertEquals(mExpected, m);
    }

    // TODO - add test cases for add, changeToExtractionMode, removeFirst,
    // isInInsertionMode, order, and size
    /*
     * Test cases for add
     */
    /**
     * Tests checking test add one element.
     */
    @Test
    public final void testAddOneElement() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "blue");
        m.add("blue");
        assertEquals(mExpected, m);
    }

    /**
     * Tests checking test add multiple elements.
     */
    @Test
    public final void testAddMultipleElements() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "blue", "red", "yellow");
        m.add("blue");
        m.add("red");
        m.add("yellow");
        assertEquals(mExpected, m);
    }

    /**
     * Tests checking add duplicate elements.
     */
    @Test
    public final void testAddDuplicateElements() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, true,
                "blue", "blue");
        m.add("blue");
        m.add("blue");
        assertEquals(mExpected, m);
    }

    /**
     * Tests change to extraction mode empty.
     */
    @Test
    public final void testChangeToExtractionModeEmpty() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false);
        m.changeToExtractionMode();
        assertEquals(mExpected, m);
    }

    /**
     * Tests change to extraction mode non empty.
     */
    @Test
    public final void testChangeToExtractionModeNonEmpty() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "apple",
                "banana", "cherry");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "apple", "banana", "cherry");
        m.changeToExtractionMode();
        assertEquals(mExpected, m);
    }

    /**
     * Tests change to extraction mode after add.
     */
    @Test
    public final void testChangeToExtractionModeAfterAdd() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "apple", "banana");
        m.add("apple");
        m.add("banana");
        m.changeToExtractionMode();
        assertEquals(mExpected, m);
    }

    /*
     * Test cases for removeFirst
     */
    /**
     * Tests remove first single element.
     */
    @Test
    public final void testRemoveFirstSingleElement() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false,
                "apple");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false);
        String first = m.removeFirst();
        assertEquals("apple", first);
        assertEquals(mExpected, m);
    }

    /**
     * Tests remove first multiple elements.
     */
    @Test
    public final void testRemoveFirstMultipleElements() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false,
                "apple", "banana", "cherry");
        SortingMachine<String> mExpected = this.createFromArgsRef(ORDER, false,
                "banana", "cherry");
        String first = m.removeFirst();
        assertEquals("apple", first);
        assertEquals(mExpected, m);
    }

    /*
     * Test cases for isInInsertionMode
     */
    /**
     * Tests checking is in insertion mode true.
     */
    @Test
    public final void testIsInInsertionModeTrue() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        boolean result = m.isInInsertionMode();
        assertEquals(true, result);
    }

    /**
     * Tests checking is insertion mode false.
     */
    @Test
    public final void testIsInInsertionModeFalse() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false,
                "apple");
        boolean result = m.isInInsertionMode();
        assertEquals(false, result);
    }

    /*
     * Test cases for order
     */
    /**
     * Tests checking test order.
     */
    @Test
    public final void testOrder() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        Comparator<String> order = m.order();
        assertEquals(ORDER, order);
    }

    /*
     * Test cases for size
     */

    /**
     * Tests testing size in insertion mode empty.
     */
    @Test
    public final void testSizeInInsertionModeEmpty() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        int size = m.size();
        assertEquals(0, size);
    }

    /**
     * Tests checking size in insertion mode non empty.
     */
    @Test
    public final void testSizeInInsertionModeNonEmpty() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true, "apple",
                "banana");
        int size = m.size();
        assertEquals(2, size);
    }

    /**
     * Tests size in extraction mode.
     */
    @Test
    public final void testSizeInExtractionMode() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, false,
                "apple", "banana", "cherry");
        int size = m.size();
        final int three = 3;
        assertEquals(three, size);
    }

    /**
     * Tests size in extraction mode empty.
     */
    @Test
    public final void testSizeInExtractionModeEmpty() {
        SortingMachine<String> m = this.createFromArgsTest(ORDER, true);
        m.changeToExtractionMode(); // Change an empty sorting machine to extraction mode
        int size = m.size();
        assertEquals(0, size);
    }
}
