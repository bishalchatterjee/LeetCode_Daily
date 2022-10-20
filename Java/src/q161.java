import java.util.Arrays;

public class q161 {
    //1996. The Number of Weak Characters in the Game
    //Arrays
    //Date-09/09/2022

    static int numberOfWeakCharacters(int[][] properties) {
        int max = 0;
        int count = 0;

        int len = properties.length;

        Arrays.sort(properties, (a, b) -> (b[0] == a[0]) ? (a[1] - b[1]) : (b[0] - a[0]));

        for (int i = 0; i < len; i++) {
            if (properties[i][1] < max)
                count++;

            max = Math.max(max, properties[i][1]);
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] properties = {{5,5},{6,3},{3,6}};

        System.out.println(numberOfWeakCharacters(properties));
    }
}


//T.C - O(n log n)
//S.C - O(1)