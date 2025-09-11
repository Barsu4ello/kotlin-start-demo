package lesson10.taxiTask

/*
 * Task #1. Найти всех водителей, которые не совершили ни
 * одной поездки
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> = allDrivers - (trips.map { it.driver }.toSet())


/*
 * Task #2. Найти всех пассажиров, которые совершили заданное
 * или большее количество поездок
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> = if(minTrips == 0) allPassengers else
    trips.flatMap { it.passengers }.groupingBy { it }.eachCount().filterValues { it >= minTrips }.keys


/*
 * Task #3. Найти всех пассажиров, которых два и более раз
 * вез заданный водитель
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
    trips.filter { it.driver == driver }.flatMap { it.passengers }.groupingBy { it }.eachCount()
        .filter { it.value >= 2 }.keys

/*
 * Task #4. Найти всех пассажиров, которые большую часть своих
 * поездок ездили со скидкой (trip.discount != null)
 *
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> {
    val map = hashMapOf<Passenger, Int>()
    for (trip in trips) {
        for (passenger in trip.passengers) {
            if (map.containsKey(passenger)) {
                if (trip.discount == null)
                    map[passenger] = map[passenger]!! - 1
                else
                    map[passenger] = map[passenger]!! + 1
            } else {
                if (trip.discount == null)
                    map[passenger] = -1
                else
                    map[passenger] = 1
            }
        }
    }
    return map.filter { it.value > 0 }.keys
}
// решение со стримом от GPT
//trips
//.flatMap { trip ->
//    trip.passengers.map { passenger ->
//        passenger to if (trip.discount != null) 1 else -1
//    }
//}
//.groupingBy { it.first }        // группируем по пассажиру
//.fold(0) { acc, pair -> acc + pair.second }  // суммируем значения
//.filterValues { it > 0 }        // оставляем >0
//.keys

/*
 * Task #5.
 * Найти наиболее частое время поездки из минутных интервалов 0..9, 10..19, 20..29 и т.п.
 * Вернуть этот интервал или null
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {
    val value: Int? = trips
        .map { it.duration / 10 }
        .groupingBy { it }
        .eachCount()
        .maxByOrNull { it.value }
        ?.key?.let { it * 10 }

    return if (value == null) null else value ..value + 9
}



