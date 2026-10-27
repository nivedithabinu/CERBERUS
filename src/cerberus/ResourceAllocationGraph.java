package cerberus;

import java.util.*;

public class ResourceAllocationGraph {
    private final Map<String, ProcessNode> processes = new LinkedHashMap<>();
    private final Map<String, Resource> resources = new LinkedHashMap<>();
    
    private final Map<String, String> allocation = new LinkedHashMap<>();
    private final Map<String, String> requests = new LinkedHashMap<>();
  
    public void addProcess(ProcessNode process) {
        processes.put(process.getId(), process);
    }
   
    public void addResource(Resource resource) {
        resources.put(resource.getId(), resource);
    }
   
    public void requestResource(String processId, String resourceId) {
        if (!processes.containsKey(processId)) throw new IllegalArgumentException("Unknown process: " + processId);
        if (!resources.containsKey(resourceId)) throw new IllegalArgumentException("Unknown resource: " + resourceId);
        if (allocation.containsKey(resourceId) && allocation.get(resourceId).equals(processId)) throw new IllegalStateException(processId + " already holds " + resourceId);
        
        requests.put(processId, resourceId);
    }
    
    public void allocateResource(String processId, String resourceId) {
        if (!processes.containsKey(processId)) throw new IllegalArgumentException("Unknown process: " + processId);
        if (!resources.containsKey(resourceId)) throw new IllegalArgumentException("Unknown resource: " + resourceId);
        if (allocation.containsKey(resourceId)) throw new IllegalStateException(resourceId + " is already allocated");

        allocation.put(resourceId, processId);
        requests.remove(processId, resourceId);
    }

    public void releaseResource(String processId, String resourceId) {
        if (!processId.equals(allocation.get(resourceId))) throw new IllegalStateException(processId + " does not hold " + resourceId);       
        allocation.remove(resourceId);
    }

    public void printGraph() {
        System.out.println("Resource Allocation Graph:");

        for (Map.Entry<String, String> entry : allocation.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " [ALLOCATED]");
        }

        for (Map.Entry<String, String> entry : requests.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " [REQUESTED]");
        }
    }
}
