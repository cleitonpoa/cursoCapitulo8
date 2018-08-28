package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Comentario;
import entities.Post;

public class ProgramaPost {

	public static void main(String[] args) throws ParseException {
		Date momento = new Date();
		String titulo = "Traveling to New Zeland";
		String conteudo = "i'm going to visit this wonderful country!";
		Post post1 = new Post(momento, titulo, conteudo);
		post1.setLikes(12);
		Comentario comentario1 = new Comentario("Have a nive trip");
		Comentario comentario2 = new Comentario("Wow that's awesome!");
		post1.adicionarComentario(comentario1);
		post1.adicionarComentario(comentario2);
		post1.imprimirPost();

		System.out.println();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		momento = sdf.parse("30/08/2018 16:24:01");
		titulo = "Good night guys";
		conteudo = "See you tomorrow";
		Post post2 = new Post(momento, titulo, conteudo);
		post2.setLikes(5);
		comentario1 = new Comentario("Good night");
		comentario2 = new Comentario("May the Force be with you");
		post2.adicionarComentario(comentario1);
		post2.adicionarComentario(comentario2);
		System.out.println(post2.toString());

	}

}
