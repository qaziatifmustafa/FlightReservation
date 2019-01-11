# FlightReservation
API in Spring Boot to search over available flights
This API is used to read two formats of json object data of flights one is cheap and the other is business flights.
Cheap flight have the following json data [{id:Long,departure:String,arrival:String,departureTime:Long,arrivalTime:Long}]
and the business flight have [{uuid:String,flight:String,departure:String,arrival:String}] 
Now for posting the data we may use "/cheapFlights" and "/businessFlights" URI and for getting the cheap and business flight data we may use following URI:
  a) "/businessFlights" (All the business Flight data which we posted in the same format)
  b) "/cheapFlights" (All the cheap Flight data which we posted in the same format)
  c) "/availableBusinessFlights" (All the upcoming filtered business Flight data which we posted in the same format)
  d) "/availableCheapFlights" (All the upcoming filtered cheap Flight data which we posted in the same format)
  e) "/aggregatedFlights" (All the filtered and sorted flight data shows in business and cheap list)
  
  output of aggregated flights are :
  {"cheapFlights": [{id:Long,departure: String,arrival:String,departureTime: Long,arrivalTime: Long}],"businessFlights":[{uuid:String,flight:String,departure:String,arrival:String}]}
  
  
