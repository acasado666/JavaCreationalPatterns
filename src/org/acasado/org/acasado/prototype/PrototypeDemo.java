package org.acasado.org.acasado.prototype;

public class PrototypeDemo {

	public static void main(String[] args) {
		Registry registry = new Registry();
		Movie movie = (Movie) registry.createItem("Movie");
		movie.setTitle("Creational Patterns in Java");
		
		System.out.println(movie);
		System.out.println(movie.getRuntime());
		System.out.println(movie.getTitle());
		System.out.println(movie.getUrl());
		
		Movie anotherMovie = (Movie) registry.createItem("Movie");
		anotherMovie.setTitle("Gang of Four");
		
		System.out.println(anotherMovie);
		System.out.println(anotherMovie.getRuntime());
		System.out.println(anotherMovie.getTitle());
		System.out.println(anotherMovie.getUrl());

		Book book = (Book) registry.createItem("Book");
		book.setTitle("Gang of Four");

		System.out.println(book);
		System.out.println(book.getPrice());
		System.out.println(book.getTitle());
		System.out.println(book.getNumberOfPages());
	}

}
