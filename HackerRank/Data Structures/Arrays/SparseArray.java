/*
Problem Statement:- https://www.hackerrank.com/challenges/sparse-arrays/problem

Sample input
4
aba
baba
aba
xzxb
3
aba
xzxb
ab

Sample Output
2
1
0

*/


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        Map<String, Integer> stringOccurrence = new LinkedHashMap<String, Integer>();
        int []value = new int[queries.length];
        int count = 0;

        for (String s : strings) {
            if (stringOccurrence.containsKey(s)) {
                stringOccurrence.put(s, stringOccurrence.get(s) + 1);
            } else
                stringOccurrence.put(s, 1);
        }

        for (String q : queries) {
            value[count] = stringOccurrence.containsKey(q) ? stringOccurrence.get(q) : 0;
            count++;
        }

        return value;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stringsCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] strings = new String[stringsCount];

        for (int i = 0; i < stringsCount; i++) {
            String stringsItem = scanner.nextLine();
            strings[i] = stringsItem;
        }

        int queriesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] queries = new String[queriesCount];

        for (int i = 0; i < queriesCount; i++) {
            String queriesItem = scanner.nextLine();
            queries[i] = queriesItem;
        }

        int[] res = matchingStrings(strings, queries);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}