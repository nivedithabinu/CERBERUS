package cerberus;

public class ProcessNode {
    private final String id;

    public ProcessNode(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id;
    }
}
