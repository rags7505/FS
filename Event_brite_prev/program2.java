package Event_brite_prev;
/*
 * 2. Cached Requests
There are n services numbered from 1 to n in a system, and there are m requests to be processed. The service in which the iᵗʰ request is cached is denoted by cache[i], for all 1 ≤ i ≤ m. For any request, If the request is processed from its cached service, it takes 1 unit of time. Otherwise, it takes 2 units of time.

Different services can process different requests simultaneously, but one service can only process one request at a time. Find the minimum time to process all the requests by allocating each request to a service.

Example
It is given that n = 3, m = 5, and cache = [1, 1, 3, 1, 1].
If the 1st, 2nd, and 4th requests are assigned to the 1st service, it will take 1 unit of time each, or 3 units of time to process them in total.
Assign the 3rd request to the 2nd service and the 5th request to the 3rd service. It takes 1 and 2 units of time to complete them, respectively. Therefore, all requests are processed in 3 units of time.

Function Description
Complete the function getMinTime in the editor below.

getMinTime has the following parameters:
	int n: the number of services in the system
	int cache[m]: the service in which the request is cached (of length m)

Returns
int: the minimum time required to process all requests

Constraints
1 ≤ n, m ≤ 2 * 10⁵
1 ≤ cache[i] ≤ n

Sample Case 0
Input
n = 4  
cache = [1, 2, 3, 4]
Output
1

Explanation
Each request is cached in a different service. Process all of them at once, which takes 1 unit of time.
 */
import java.util.*;

class Result1 {
    public static int getMinTime(int n, List<Integer> cache) {
        int m = cache.size();
        
        // Create a list for each service containing indices of requests cached in it
        List<List<Integer>> serviceCachedRequests = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            serviceCachedRequests.add(new ArrayList<>());
        }
        
        // Fill the lists
        for (int i = 0; i < m; i++) {
            serviceCachedRequests.get(cache.get(i)).add(i);
        }
        
        // Priority queue to keep track of each service's completion time
        PriorityQueue<Integer> serviceCompletionTimes = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            serviceCompletionTimes.add(0);
        }
        
        // Sort requests by the number of requests cached in each service (ascending)
        // Process services with fewer cached requests first
        List<Integer> servicesSortedByLoad = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            servicesSortedByLoad.add(i);
        }
        servicesSortedByLoad.sort(Comparator.comparingInt(a -> serviceCachedRequests.get(a).size()));
        
        // Track which requests have been assigned
        boolean[] assigned = new boolean[m];
        
        // First, assign each service its own cached requests (as many as possible)
        for (int service : servicesSortedByLoad) {
            List<Integer> requests = serviceCachedRequests.get(service);
            
            // Get current completion time for this service
            int completionTime = serviceCompletionTimes.poll();
            
            for (int requestIdx : requests) {
                if (!assigned[requestIdx]) {
                    completionTime += 1; // Takes 1 unit of time for cached request
                    assigned[requestIdx] = true;
                }
            }
            
            serviceCompletionTimes.add(completionTime);
        }
        
        // Assign remaining requests to the service that will complete the earliest
        for (int i = 0; i < m; i++) {
            if (!assigned[i]) {
                int earliestCompletionTime = serviceCompletionTimes.poll();
                earliestCompletionTime += 2; // Takes 2 units of time for non-cached request
                serviceCompletionTimes.add(earliestCompletionTime);
                assigned[i] = true;
            }
        }
        
        // The answer is the maximum completion time across all services
        int maxCompletionTime = 0;
        while (!serviceCompletionTimes.isEmpty()) {
            maxCompletionTime = Math.max(maxCompletionTime, serviceCompletionTimes.poll());
        }
        
        return maxCompletionTime;
    }
}

public class program2 {
    public static void main(String[] args) {
        // Example 1
        int n1 = 3;
        List<Integer> cache1 = Arrays.asList(1, 1, 3, 1, 1);
        System.out.println(Result1.getMinTime(n1, cache1)); // Expected: 3
        
        // Example 2
        int n2 = 4;
        List<Integer> cache2 = Arrays.asList(1, 2, 3, 4);
        System.out.println(Result1.getMinTime(n2, cache2)); // Expected: 1
    }
}