import java.util.LinkedHashMap;

/**
 * Keeps all the tests stored in a map, key = test name (i.e. "example").
 * @author lightweight
 *
 */
public final class TestKeeper {
    private static TestKeeper instance;
    private final LinkedHashMap<String, Testable> tests = new LinkedHashMap<String, Testable>();
    
    private TestKeeper() {
        add(ExampleTests.example);
    }
    
    /**
     * Try running the test of the given name. Return false if test not found.
     * @param command
     * @param player
     * @param parameters
     * @return
     */
    public static boolean runTest(String testName, String[] params) {
        if (instance == null) {
            instance = new TestKeeper();
        }
    
        Testable test = instance.get(testName);
        if (test != null) {
            boolean status = test.runTest(params);

            String msgColor  = (status) ? Colors.Green : Colors.Red;    
            String msgStatus = (status) ? " returned OK" : " failed!";
            etc.getServer().messageAll(msgColor + "-- Test " + test.getName() + msgStatus);
            
            return true; 
        }
        return false;
    }
    
    
    public void add(Testable test) {
        add(test.getName(), test);
    }
    
    public void add(String name, Testable test) {
        if (name != null && test != null) {
            tests.put(name, test);
        }
    }
    
    public Testable get(String name) {
        return tests.get(name);
    }
    
    /**
     * Remove a test.
     * @param name
     */
    public void remove(String name) {
        if (name != null) {
            etc.getInstance().removeCommand(name);
            tests.remove(name);
        }
    }
}
