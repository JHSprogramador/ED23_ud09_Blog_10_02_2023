package tarea;

import java.util.Scanner;

public class MainBlog {

	private static Blog blog = new Blog();

	public static void main(String[] args) {
		String option = "";	

		Scanner reader = new Scanner(System.in);
		do {
			// Mostrar menú
			menu();
			option = reader.nextLine();
			stateMachine(option);
			
		} while (!option.equals("4"));	

	}
	
	
	private static void menu() {
		System.out.println("Blog");
		System.out.println("Select an option:");
		System.out.println("1. Meter un post");
		System.out.println("2. Mostrar post");
		System.out.println("3. Eliminar post");
		System.out.println("4. Mostrar 10 primeras entradas del blog");
	}
	
	private static void stateMachine(String option) {
		Scanner scan = new Scanner(System.in);
		String textoPost = "";
		
		switch (option) {
		case "1":
			System.out.println("Escribe el nuevo post: ");
			textoPost = scan.nextLine();
			Post post = new Post(textoPost); 
			blog.addPost(post); 
			break;	
		case "2":
			System.out.println("Introduce el número del post que deseas mostrar: ");
			int postNumber = scan.nextInt();
			scan.nextLine();
			Post postToShow = blog.getPost(postNumber - 1);
			if (postToShow != null) {
				postToShow.showPost();
			} else {
				System.out.println("No se ha encontrado el post con número " + postNumber);
			}
			break;				
		case "3":
			System.out.println("Introduce el número del post que deseas eliminar: ");
			int postNumberToDelete = scan.nextInt();
			scan.nextLine();
			if (blog.removePost(postNumberToDelete - 1)) {
				System.out.println("Post eliminado con éxito");
			} else {
				System.out.println("No se ha encontrado el post con número " + postNumberToDelete);
			}
			break;	
		case "4":
			ArrayList<Post> posts = blog.getPosts();
			int numberOfPosts = posts.size();
			int numberToShow = numberOfPosts < 10 ? numberOfPosts : 10;
			break;
		default:
			break;
		}
		
	}
		
}
