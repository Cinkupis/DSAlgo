package CTCIHardExercises;

public class AddWithoutPlus {

    private long add(int numberOne, int numberTwo) {
        // TODO: Implement bitwise logic gate
        return numberOne + numberTwo;
    }

    public static void main(String[] args) {
        AddWithoutPlus addWithoutPlus = new AddWithoutPlus();
        System.out.println(addWithoutPlus.add(2, 3));
        System.out.println(addWithoutPlus.add(60, 13));
        System.out.println(addWithoutPlus.add(17, 19));
    }
}
