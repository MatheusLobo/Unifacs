package unifacs_projetos;

public class LivroFisico extends Livro {
	String formato;
	String genero;
	
		public LivroFisico(String titulo, String autor, String editora, String ano_Publi, int numero_paginas, String formato, String genero) {
			super(titulo, autor, editora, ano_Publi, numero_paginas);
			this.formato=formato;
			this.genero=genero;
			
		}
			public String getFormato() {
		        return formato;
		    }

		    public void setFormato(String formato) {
		        this.formato = formato;
		    }

		    public String getGenero() {
		        return genero;
		    }

		    public void setGenero(String genero) {
		        this.genero = genero;
		    }
		}