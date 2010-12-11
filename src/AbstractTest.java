
public abstract class AbstractTest implements Testable {
    private final String name;
    
    public AbstractTest(String name) {
        this.name = name;
    }
    
    public abstract boolean runTest(String[] params);
    
    public String getName() {
        return this.name;
    }
}
