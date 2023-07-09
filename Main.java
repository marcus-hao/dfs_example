import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class Main {
	public static void main(String[] args) {
		// Create the graph from text file
		Graph graph = new Graph();
		try {
			File file = new File("data.txt");
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				String[] substring = data.split(",");
				graph.addVertex(substring[0]);
				graph.addVertex(substring[1]);
				graph.addEdge(substring[0], substring[1]);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File could not be opened.");
			e.printStackTrace();
		}

		String asciiArt = "   __o            __o            __o            __o            __o\n"
				+ " _`\\<,_         _`\\<,_         _`\\<,_         _`\\<,_         _`\\<,_\n"
				+ "(_)/ (_)       (_)/ (_)       (_)/ (_)       (_)/ (_)       (_)/ (_)\n"
				+ "* * * * * * * * * * * * * Cyclist Road Network * * * * * * * * * * * * * * *";

		boolean exit = false;	// flag for end of program
		while (!exit) {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.println(asciiArt);
			System.out.println("1. View locations.");
			System.out.println("2. Find a path");
			System.out.println("99. Exit");

			Scanner scanner = new Scanner(System.in);	// Get user input
			int selection = scanner.nextInt();
			scanner.nextLine();		// Handle \n character
			switch (selection) {
				case 1:
					graph.printLocations();
					break;
				case 2:
					System.out.print("Your location: ");
					String source = scanner.nextLine();
					System.out.print("Your destination: ");
					String destination = scanner.nextLine();
					graph.findPath(source, destination);
					break;
				case 99:
					System.out.println("Exitting...");
					exit = true;
					break;
				default:
					System.out.println("Invalid option.");
					break;
			}
			if (!exit) {
				System.out.print("Press Enter to continue...");
				scanner.nextLine();
			}
		}
	}
}
