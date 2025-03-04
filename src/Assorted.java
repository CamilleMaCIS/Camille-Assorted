import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Assorted {

    /**
     * Challenge 1
     *
     * Takes a list of integer values represented as a mix of both
     * integer and string data types.
     * @param list a list of integer values represented as a mix of both
     *             integer and string data types. E.g. [12, "54", "78", 16]
     * @return the sum of the elements in the list as if all elements were
     *         integer data types.
     */

    //note to self, to create ArrayList with multiple data types, use <Object>

    public static int findSum(List<?> list) {
        int sum = 0;
        for (Object element : list){
            String e = element.toString();
            int e2 = Integer.parseInt(e);
            sum += e2;
        }
        return sum;
    }

    /**
     * Challenge 2
     *
     * Takes a list of integers and strings and returns a new list containing
     * the integers only (filters the strings out).
     * @param list a list of integer and string values. E.g [1, 2, "a", 5]
     * @return a list containing integers only.
     */
    public static List<Integer> filterStrings(List list) {
        List<Integer> filtered = new ArrayList<>();
        for (Object element : list){
            if (!element.getClass().getSimpleName().equals("String")){
                String element2 = element.toString();
                Integer element3 = Integer.valueOf(element2);
                filtered.add(element3);
            }
        }
        return filtered;
    }

    /**
     * Challenge 3
     *
     * Takes a list of strings and returns a new list that includes each element
     * prepended by the correct line number.
     * @param list a list of string values e.g. ["a", "b", "c"]
     * @return a list where each element is prepended by the correct line number
     *         e.g. ["1: a", "2: b", "3: c"]
     */
    public static List<String> lineNumbering(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++){
            String str = i + 1 + ": " + list.get(i);
            newList.add(str);
        }
        return newList;
    }

    /**
     * Challenge 4
     *
     * There is a bus moving in the city which takes and drops some people at each
     * bus stop.
     *
     * You are provided with a list (or array) of integer pairs. Elements of each pair
     * represent the number of people that get on the bus (the first item) and the number
     * of people that get off the bus (the second item) at a bus stop.
     *
     * Your task is to return the number of people who are still on the bus after the last
     * bus stop (after the last array). Even though it is the last bus stop, the bus might
     * not be empty and some people might still be inside the bus, they are probably
     * sleeping there :D
     *
     * @param list a list of integer pairs.
     * @return the number of people who are still on the bus after the last stop.
     */
    public static int busStop(List<Integer[]> list) {
        int stillOn = 0;
        for (Integer[] pair : list){
            Integer pairSum = pair[0] - pair[1];
            stillOn += pairSum;
        }
        return stillOn;
    }

    /**
     * Challenge 5
     *
     * Given an array of ones and zeroes, convert the equivalent binary value to an integer.
     * @param list a list of integer values. Each element is either a 0 or a 1.
     * @return the decimal value of the binary representation of the list.
     *         Eg: [0, 0, 0, 1] is treated as 0001 which is the binary representation of 1.
     */
    public static int toBinary(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(list.size() - i - 1) == 1){
                sum += 1 * Math.pow(2, i);
            }
        }
        return sum;
    }

    /**
     * Challenge 6
     *
     * Your goal is to implement a method which subtracts one list
     * from another and returns the result.
     *
     * It should remove all values from listA, which are present in listB keeping their order.
     * If a value is present in listB, all of its occurrences must be removed from listA.
     *
     * @param listA a list of integer values.
     * @param listB a list of integer values.
     * @return a list that contains the difference between listB and listA.
     *         e.g. subtractList([1,2], [1]) returns [2]
     *              subtractList([1,2,2,2,3], [2]) returns [1,3]
     */
    public static List<Integer> subtractList(List<Integer> listA, List<Integer> listB) {
        List<Integer> newList = new ArrayList<>();
        for (Integer element : listA){
            if (!listB.contains(element)){
                newList.add(element);
            }
        }
        return newList;
    }

    /**
     * Challenge 7
     *
     * Your goal is to implement a method which takes a list of integers and sorts the odd
     * numbers in ascending order while leaving the even numbers in their original positions.
     *
     * @param list a list of integers.
     * @return a list where the odd integers have been sorted in ascending order and the even
     *         integers remain in their original position.
     */

    //returns true if it ISN'T sorted by ascending order
    private static boolean notSorted(List<Integer> list){
        //make list of only the odd numbers
        List<Integer> newList = new ArrayList<>();
        for (Integer element : list){
            if (element % 2 == 1){
                newList.add(element);
            }
        }

        int count = 0;
        for (int i = 0; i < newList.size() - 1; i++){
            //next odd larger than previous odd
            if (newList.get(i) <= newList.get(i + 1)){
                count++;
            }
        }

        //if no odd numbers, it is sorted
        if (newList.size() == 0){
            return false;
        }
        //odds are sorted, therefore "not sorted" is false
        if (count == newList.size() - 1){
            return false;
        }
        //it is not sorted
        return true;
    }
    public static List<Integer> sortOdd(List<Integer> list) {
        //list of Integer pairs, index 0 = number index 1 = list index

        //repeats while odds are not sorted
        while (notSorted(list)){
            //finds first odd
            for (int i = 0; i < list.size() - 1; i++){
                if (list.get(i) % 2 == 1){
                    //finds second odd
                    for (int j = i + 1; j < list.size(); j++){
                        if (list.get(j) % 2 == 1){
                            //if both are odd and the previous odd larger than next odd, swap
                            if (list.get(i) > list.get(j)){
                                Integer temp = list.get(i);
                                list.set(i, list.get(j));
                                list.set(j, temp);
                            }
                        }
                    }
                }

            }
        }

        return list;
    }

    /**
     * Challenge 8
     *
     * Your goal is to implement a method which takes two values (a lower bound and an upper
     * bound) and returns a list of numbers that are between the lower bound and upper bound
     * (inclusive) that have a certain property.
     *
     * The property is as follows:
     *
     * The number 89 is the first integer with more than one digit whose individual digits
     * can sum to the value 89 by raising each digit to the power of the place or column of
     * which it resides. For example, 89 = 8^1 + 9^2. The next number having this property is
     * 135. 135 = 1^1 + 3^2 + 5^3.
     *
     * @param lowerBound an integer representing the lower bound.
     * @param upperBound an integer representing the upper bound.
     * @return a list containing all the numbers between lowerBound and upperBound (inclusive)
     *         that meet the property mentioned above.
     *         e.g. uniqueNumber(1,10) returns [1,2,3,4,5,6,7,8,9]
     *              uniqueNumber(1,100) returns [1,2,3,4,5,6,7,8,9,89]
     */
    public static List<Integer> uniqueNumber(int lowerBound, int upperBound) {
        List<Integer> uniques = new ArrayList<>();
        for (int n = lowerBound; n <= upperBound; n++){
            //convert n to a string, separate each digit
            String numberAsString = Integer.toString(n);
            char[] digitsAsChars = numberAsString.toCharArray();

            int sum = 0;
            for (int i = 0; i < digitsAsChars.length; i++){
                int digit = Character.getNumericValue(digitsAsChars[i]);
                double power = Math.pow(digit, i + 1);
                sum += power;
            }

            if (n == sum){
                uniques.add(n);
            }
        }
        return uniques;
    }

    /**
     * Challenge 9
     *
     * Alice and Bob were on a holiday. Both of them took many pictures of the places they've
     * been, and now they want to show Charlie their entire collection. However, Charlie doesn't
     * like these sessions, since the motif usually repeats. He isn't fond of seeing the Eiffel
     * tower 40 times.
     *
     * He tells them that he will only sit for the session if they show the same motif at most N
     * times. Luckily, Alice and Bob are able to encode the motif as a number. Can you help them
     * to remove numbers such that their list contains each number only up to N times, without
     * changing the order?
     *
     * @param list a list of motifs.
     * @param n the maximum number of occurrences of a specific motif that is allowed.
     * @return a list containing each motif at most n times.
     *         e.g. filterNTimes([1,2,3,1,2,1,2,3], 2) returns [1,2,3,1,2,3]
     *              filterNTimes([20,37,20,21], 1) returns [20,37,21]
     */
    private static boolean moreThanNTimes(List<Integer> list, int n, Integer element){
        int occurrence = Collections.frequency(list, element);
        if (occurrence > n){
            return true;
        }
        return false;
    }
    public static List<Integer> filterNTimes(List<Integer> list, int n) {
        //create a backwards list, because remove() removes first appearing duplicate objects
        List<Integer> backward = new ArrayList<>();
        for (int i = list.size() - 1; i >=0; i--){
            backward.add(list.get(i));
        }

        //unique numbers
        List<Integer> uniques = new ArrayList<>();
        for (Integer element : backward){
            if (!uniques.contains(element)){
                uniques.add(element);
            }
        }
        //unique numbers which appear more than n times
        List<Integer> uniquesWithMoreOccurrences = new ArrayList<>();
        for (Integer uniqueNum : uniques){
            int occurrence = Collections.frequency(backward, uniqueNum);
            if (occurrence > n){
                uniquesWithMoreOccurrences.add(uniqueNum);
            }
        }

        //for each element that appears more than n times, repeat removing until not more than n occurrences
        for (Integer element : uniquesWithMoreOccurrences){
            while (moreThanNTimes(backward, n, element)){
                backward.remove(element);
            }
        }

        //return reversed backward list
        List<Integer> reversedBackward = new ArrayList<>();
        for (int i = backward.size() - 1; i >=0; i--){
            reversedBackward.add(backward.get(i));
        }
        return reversedBackward;
    }

    /**
     *
     * Challenge 10
     *
     * Once upon a time, on a way through the old wild mountainous west,…
     * … a man was given directions to go from one point to another. The directions were
     * "NORTH", "SOUTH", "WEST", "EAST". Clearly "NORTH" and "SOUTH" are opposite, "WEST"
     * and "EAST" too.
     *
     * Going to one direction and coming back the opposite direction right away is a needless
     * effort. Since this is the wild west, with dreadful weather and not much water, it's
     * important to save yourself some energy, otherwise you might die of thirst!
     *
     * How I crossed a mountainous desert the smart way.
     * The directions given to the man are, for example, the following:
     *
     * ["NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"].
     *
     * You can immediately see that going "NORTH" and immediately "SOUTH" is not reasonable,
     * better stay to the same place! So the task is to give to the man a simplified version
     * of the plan. A better plan in this case is simply:
     *
     * ["WEST"]
     *
     * Your task is to write a method which will take a list of strings and returns a list
     * of strings with the needless directions removed.
     *
     * @param directions a list of directions.
     * @return a list with the needless directions removed.
     *         e.g. wildWest(["NORTH", "SOUTH", "EAST", "WEST"]) returns []
     *              wildWest(["NORTH", "EAST", "WEST", "SOUTH", "WEST", "WEST"]) returns
     *              ["WEST", "WEST"]
     */

    /**I WOULD LIKE TO STRONGLY PROTEST THAT IN AssortedTest result3, IT DOESN'T MAKE SENSE
    AFTER CANCELLING OUT EVERYTHING, IT SHOULD BE NORTH NORTH WEST
    I DON'T UNDERSTAND WHY WOULD YOU ONLY CANCEL OUT THE ADJACENT DIRECTIONS
    SHOULD CANCEL OUT ALL NEEDLESS DIRECTIONS, NOT JUST THE ADJACENT ONES
    IF YOU GO NORTH EAST EAST SOUTH, YOU END UP EAST EAST, NORTH AND SOUTH SHOULD'VE GOTTEN CANCELLED*/
    private static boolean hasNeedlessDirections(List<String> directions){
        for (int i = 0; i < directions.size() - 1; i++){
            if(directions.get(i).equals("NORTH") && directions.get(i+1).equals("SOUTH")){
                return true;
            }
            else if (directions.get(i).equals("SOUTH") && directions.get(i+1).equals("NORTH")){
                return true;
            }
            else if (directions.get(i).equals("EAST") && directions.get(i+1).equals("WEST")){
                return true;
            }
            else if (directions.get(i).equals("WEST") && directions.get(i+1).equals("EAST")){
                return true;
            }
        }
        return false;
    }
    public static List<String> wildWest(List<String> directions) {
        //repeat all of this while it still has needless directions
        do{
            //finds the indices of pairs that need to be excluded from returned list
            List<Integer> indicesToCancel = new ArrayList<>();
            for (int i = 0; i < directions.size() - 1; i++){
                if(directions.get(i).equals("NORTH") && directions.get(i+1).equals("SOUTH")){
                    indicesToCancel.add(i);
                    indicesToCancel.add(i+1);
                }
                else if (directions.get(i).equals("SOUTH") && directions.get(i+1).equals("NORTH")){
                    indicesToCancel.add(i);
                    indicesToCancel.add(i+1);
                }
                else if (directions.get(i).equals("EAST") && directions.get(i+1).equals("WEST")){
                    indicesToCancel.add(i);
                    indicesToCancel.add(i+1);
                }
                else if (directions.get(i).equals("WEST") && directions.get(i+1).equals("EAST")){
                    indicesToCancel.add(i);
                    indicesToCancel.add(i+1);
                }
            }
            //iterate through all indices in direction
            //add elements to return list whose indices ARE NOT in indicesToCancel
            List<String> newList = new ArrayList<>();
            for (int i = 0; i < directions.size(); i++){
                if (!indicesToCancel.contains(i)){
                    newList.add(directions.get(i));
                }
            }
            directions = newList;
        }while(hasNeedlessDirections(directions));

        return directions;
    }

    /**
     * Challenge 11
     *
     * There is a queue for the self-checkout tills at the supermarket. Your task is to write a
     * method to calculate the total time required for all the customers to check out!
     *
     * There is only queue serving many tills.
     * The order of the queue never changes.
     * The front person in the queue (the first element in queue) proceeds to a till as soon
     * as it becomes free.
     *
     * @param queue a list of queue times. Each element represents a customer and how long
     *                  in minutes it will take them to check out.
     * @param tillsOpen the number of tills currently available for customers to use.
     * @return an integer that represents how long it will take for all the customers to check
     *         out.
     *         e.g. queueTime([5,3,4], 1) returns 12
     *
     *              queueTime([10,2,9,3,5,2,3,4], 2) returns 20
     *              Queues:
     *              10,3,2,3
     *              2,9,5,4
     *
     *              queueTime([2,3,10], 2) returns 12
     *              Queues:
     *              2, 10
     *              3
     */
    public static int queueTime(List<Integer> queue, int tillsOpen) {
        List<Integer> queuesSum = new ArrayList<>(tillsOpen);

        for (int n = 0; n < tillsOpen; n++){
            //first numbers in queue will be first in tills
            queuesSum.add(queue.get(n));
        }
        for (int nextIndex = tillsOpen; nextIndex < queue.size(); nextIndex++){
            //for the rest of the people, go to the till with the smallest sum
            int min = Collections.min(queuesSum);
            int minIndex = queuesSum.indexOf(min);
            int newSum = queuesSum.get(minIndex) + queue.get(nextIndex);
            queuesSum.set(minIndex, newSum);
            System.out.println(Arrays.toString(queuesSum.toArray()));
        }

        //return largest sum
        return Collections.max(queuesSum);
    }
}
