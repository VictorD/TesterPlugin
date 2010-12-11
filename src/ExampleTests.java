
public final class ExampleTests {
    private static final Server server = etc.getServer();  
    
    public static final AbstractTest example = new AbstractTest("example") {
        public boolean runTest(String[] params) {
            int x, y,z;
            
            for(int i = 0; i < 100; i++) {
                x = (int) Math.floor(Math.random() * 100);
                y = (int) Math.floor(Math.random() * 100); 
                z = (int) Math.floor(Math.random() * 100); 
                
                server.setBlockAt(7, x,y,z);
                Block a = server.getBlockAt(x,y,z);

                if (a.getType() != 7)
                    return false;
            }
            
            return true;
        }
    };
}
