import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayTwelve {

	public static void main(String[] args) {

		List<String> commands = new ArrayList<>();
		int directionCount = 0;
		String currentDirection = "E";
		int coodX = 0;
		int coodY = 0;

		try {
			File file = new File("/Users/joseph.bradshaw/IdeaProjects/advent2020/src/main/resources/day12.txt");
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				commands.add(line);
				System.out.println(line);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}

		for (String command : commands) {
			String directionAction = String.valueOf(command.charAt(0));
			int valueToMove = Integer.parseInt(command.substring(1));

			if (directionAction.equals("L") || directionAction.equals("R")) {
				currentDirection = changeDirection(currentDirection, directionAction, valueToMove);

			}

			if (directionAction.equals("F")) {
				if (currentDirection.equals("E")) {
					coodX = coodX + valueToMove;
				}
				if (currentDirection.equals("S")) {
					coodY = coodY + valueToMove;
				}
				if (currentDirection.equals("W")) {
					coodX = coodX - valueToMove;
				}
				if (currentDirection.equals("N")) {
					coodY = coodY - valueToMove;
				}
			}
			if (directionAction.equals("E")) {
				coodX = coodX + valueToMove;
			}git ad
			if (directionAction.equals("S")) {
				coodY = coodY + valueToMove;
			}
			if (directionAction.equals("W")) {
				coodX = coodX - valueToMove;
			}
			if (directionAction.equals("N")) {
				coodY = coodY - valueToMove;
			}
		}

		directionCount = Math.abs(coodX) + Math.abs(coodY);
		System.out.println(directionCount);
	}

	private static String changeDirection(String currentDirection, String directionChange, int valueToMove) {
		String newDirection = null;

		int turns = valueToMove / 90;

		if (directionChange.equals("L")) {
			for (int i = 0; i < turns; i++) {
				switch (currentDirection) {
					case "N":
						newDirection = "W";
						break;
					case "S":
						newDirection = "E";
						break;
					case "E":
						newDirection = "N";
						break;
					case "W":
						newDirection = "S";
						break;
				}
				currentDirection = newDirection;
			}
		} else if (directionChange.equals("R")) {
			for (int i = 0; i < turns; i++) {
				switch (currentDirection) {
					case "N":
						newDirection = "E";
						break;
					case "S":
						newDirection = "W";
						break;
					case "E":
						newDirection = "S";
						break;
					case "W":
						newDirection = "N";
						break;
				}
				currentDirection = newDirection;
			}
		}
		return currentDirection;
	}
}
