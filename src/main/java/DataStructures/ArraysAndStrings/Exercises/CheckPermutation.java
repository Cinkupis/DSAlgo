package DataStructures.ArraysAndStrings.Exercises;

public class CheckPermutation {

    private boolean checkPermutation(String one, String two) {
        one = one.toLowerCase();
        two = two.toLowerCase();
        if (one == null || one.isEmpty() || two == null || two.isEmpty()) {
            return false;
        }

        if (one.contains(two) || two.contains(one)) {
            return true;
        }

        // TODO: Implement Algorithm

        return true;
    }

    public static void main(String[] args) {
        String one = "abc";
        String two = "bdcab";
        CheckPermutation permutation = new CheckPermutation();
        System.out.println(permutation.checkPermutation(one, two));
    }
}
