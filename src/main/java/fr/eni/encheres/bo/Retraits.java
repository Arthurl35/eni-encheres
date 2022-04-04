package fr.eni.encheres.bo;

public class Retraits {
	private ArticleVendu Article;
	private String rue;
	private String code_postal;
	private String ville;

	public Retraits(ArticleVendu article, String rue, String code_postal, String ville) {
		Article = article;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
	}

	public Retraits() {
		super();
	}

	public ArticleVendu getArticle() {
		return Article;
	}

	public void setArticle(ArticleVendu article) {
		Article = article;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Retraits [rue=" + rue + ", code_postal=" + code_postal + ", ville=" + ville + "]";
	}

}
