import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player playerA = new Player();
        Player playerB = new Player();
        Board board = new Board();
        Game game = new Game(playerA, playerB, board);

        String inputFilePath = args[0];
        File inputFile = new File(inputFilePath);

        try (Scanner sc = new Scanner(inputFile)) {
            while (sc.hasNextLine()) {
                String input = sc.nextLine();
                String[] tokens = input.split(" ");
                int[] inputNumbers = new int[tokens.length];
                for(int i = 0; i < tokens.length; i++)
                    inputNumbers[i] = Integer.parseInt(tokens[i]);
                game.play(inputNumbers);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please check the file and the location provided!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please check the file!");
        }
    }
}
