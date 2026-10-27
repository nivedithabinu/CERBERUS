package cerberus;

public class ModelTest {
    public static void main(String[] args) {
        ResourceAllocationGraph graph = new ResourceAllocationGraph();

        graph.addProcess(new ProcessNode("P1"));
        graph.addProcess(new ProcessNode("P2"));

        graph.addResource(new Resource("R1", "Printer"));
        graph.addResource(new Resource("R2", "Scanner"));

        graph.allocateResource("P1", "R1");
        graph.allocateResource("P2", "R2");

        graph.requestResource("P1", "R2");
        graph.requestResource("P2", "R1");

        graph.printGraph();

        System.out.println("Graph setup test passed!");
    }
}
