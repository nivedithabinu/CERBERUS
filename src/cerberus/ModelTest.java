package cerberus;

public class ModelTest {
    public static void main(String[] args) {
        Resource printer = new Resource("R1", "Printer");
        ProcessNode p1 = new ProcessNode("P1");

        System.out.println("Resource: " + printer);
        System.out.println("Process: " + p1);
        
        if (!printer.getId().equals("R1")) {
            throw new AssertionError("Resource ID is incorrect");
        }
      
        if (!p1.getId().equals("P1")) {
            throw new AssertionError("Process ID is incorrect");
        }
      
        System.out.println("All model tests passed!");
    }
}
