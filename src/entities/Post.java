package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {

	private static final SimpleDateFormat FORMATO_DATA = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date momento;
	private String titulo;
	private String conteudo;
	private Integer likes;
	private List<Comentario> comentarios;

	public Post(Date momento, String titulo, String conteudo) {
		this.momento = momento;
		this.titulo = titulo;
		this.conteudo = conteudo;
		comentarios = new ArrayList<>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Integer getLikes() {
		return likes;
	}

	public void setLikes(Integer likes) {
		this.likes = likes;
	}

	public Date getMomento() {
		return momento;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void adicionarComentario(Comentario comentario) {
		comentarios.add(comentario);
	}

	public void removerComentario(Comentario comentario) {
		comentarios.remove(comentario);
	}

	public void imprimirPost() {
		System.out.println(titulo);
		System.out.println(likes + " Likes - " + FORMATO_DATA.format(momento));
		System.out.println(conteudo);
		if (!comentarios.isEmpty()) {
			System.out.println("Coments:");
			for (Comentario comentario : comentarios) {
				System.out.println(comentario.getComentario());
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(titulo + "\n");
		sb.append(likes);
		sb.append(" Likes - ");
		sb.append(FORMATO_DATA.format(momento) + "\n");
		sb.append(conteudo + "\n");
		if (!comentarios.isEmpty()) {
			sb.append("Coments:\n");
			for (Comentario comentario : comentarios) {
				sb.append(comentario.getComentario() + "\n");
			}
		}
		return sb.toString();
	}
}
