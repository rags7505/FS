package day78_10_07_2025;
/*
Given a list of EventAttendance (eventId, attendeeName, durationMinutes), 
Your task is to consider only attendees who stayed ≥ 60 minutes.
For each event, display the Event ID (ascending order), List of qualified 
attendee names (alphabetically sorted) and Count of such attendees.

Example 1
---------
Sample Input:
4
E101 John 90
E101 Alice 55
E101 Zara 75
E102 Mark 120

Sample output:
E101 [John, Zara] Count=2
E102 [Mark] Count=1

Example 2
---------
Sample Input:
11
E502 Carl 90
E502 Dan 45
E501 Ana 100
E502 Evan 75
E501 Beth 61
E502 Fred 20
E301 Ron 30
E301 Tony 60
E302 Lily 75
E302 Kevin 50
E301 Maya 90

Sample Output:
E301 [Maya, Tony] Count=2
E302 [Lily] Count=1
E501 [Ana, Beth] Count=2
E502 [Carl, Evan] Count=2

*/
/*
Given a list of EventAttendance (eventId, attendeeName, durationMinutes), 
Your task is to consider only attendees who stayed ≥ 60 minutes.
For each event, display the Event ID (ascending order), List of qualified 
attendee names (alphabetically sorted) and Count of such attendees.

Example 1
---------
Sample Input:
4
E101 John 90
E101 Alice 55
E101 Zara 75
E102 Mark 120

Sample output:
E101 [John, Zara] Count=2
E102 [Mark] Count=1

Example 2
---------
Sample Input:
11
E502 Carl 90
E502 Dan 45
E501 Ana 100
E502 Evan 75
E501 Beth 61
E502 Fred 20
E301 Ron 30
E301 Tony 60
E302 Lily 75
E302 Kevin 50
E301 Maya 90

Sample Output:
E301 [Maya, Tony] Count=2
E302 [Lily] Count=1
E501 [Ana, Beth] Count=2
E502 [Carl, Evan] Count=2

*/
import java.util.*;
import java.util.stream.*;
class EventAttendance{
    private String eventId,attendeeName;
    private int durationMinutes;
    EventAttendance(String eventId,String attendeeName,int durationMinutes){
        this.eventId=eventId;
        this.attendeeName=attendeeName;
        this.durationMinutes=durationMinutes;
    }
    public String getEventId(){
        return eventId;
    }
    public String getAttendeeName(){
        return attendeeName;
    }
    public int getDurationMinutes(){
        return durationMinutes;
    }
}
class streamProgram1{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        List<EventAttendance> l=new ArrayList<>();
        for(int i=0;i<n;i++){
            String id=sc.next();
            String name=sc.next();
            int min=sc.nextInt();
            l.add(new EventAttendance(id,name,min));
        }
        sc.close();
        Map<String,List<String>> m=l.stream()
                                    .filter(e -> e.getDurationMinutes()>=60)
                                    .collect(Collectors.groupingBy(EventAttendance::getEventId,TreeMap::new,
                                    Collectors.collectingAndThen(
                                        Collectors.mapping(EventAttendance::getAttendeeName, Collectors.toList()) ,
                                            list -> {
                                            Collections.sort(list);
                                            return list;
                                        } )));
        m.forEach((id,list) -> {
            System.out.println(id+" "+list+" "+"Count="+list.size());
        });
    }
}
