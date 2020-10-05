package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Autor;
import model.Categoria;
import model.Livro;

class TestLivro {

	@Test 
	void testAdicionarLivroComISBNInvalido() {
		Autor autor = new Autor("Dan Brown", "danbrown@gmail.com");
		Categoria categoria = new Categoria("Suspense Tecnol�gico");
		
		//"978-15-93973-59-9"
        Exception exception =  assertThrows(IllegalArgumentException.class, () -> {
            Livro livro = new Livro("Fortaleza Digital",
                    "Ensei Tankado, um ex-funcionário da Agência de Segurança Nacional (NSA) que jura vingar-se dos Estados Unidos, "
            		+ "desenvolve um algoritmo de encriptação inquebrável, algo considerado impossível, "
                    + "que caso seja publicamente utilizado inutilizará o computador superpotente da NSA, TRANSLTR, na decodificação de mensagens. "
                    + "A este algoritmo dá o nome de Fortaleza Digital. Tankado conta com a ajuda de North Dakota, "
                    + "pessoa responsável por tornar o Fortaleza Digital público caso Tankado morra sem cumprir seu objetivo. "
                    + "Tankado sofre uma morte misteriosa, supostamente causada por um ataque cardíaco. "
                    + "Antes de morrer, Tankado tenta chamar a atenção das muitas pessoas que passavam ao seu redor numa praça publica da Espanha "
                    + "para o anel que trazia na sua mão esquerda, anel esse que seria a chave do Fortaleza Digital.",
                    "Esse livro não possui sumário.", 331, "111111111", autor, categoria, 1, 29.90);
        });
        
        String exceptionEsperado = "ISBN informado não é válido!";
        String exceptionObtido = exception.getMessage();
        
        assertEquals(exceptionEsperado, exceptionObtido);
	}

	@Test 
	void testAdicionarLivroComResumoMenorQue500caracteres() {
		Autor autor = new Autor("Tony Tony Chopper", "tonynhodograu@gmail.com");
		Categoria categoria = new Categoria("Aventura");
		
        Exception exception =  assertThrows(IllegalArgumentException.class, () -> {
            Livro livro = new Livro("�rvore da Cura",
                    "Imagina um resum�o aqui",
                    "Esse livro não possui sumário.", 331, "978-15-93973-59-9", autor, categoria, 1, 10);
        });
        
        String exceptionEsperado = "O resumo precisa ter pelo menos 500 caracteres!";
        String exceptionObtido = exception.getMessage();
        
        assertEquals(exceptionEsperado, exceptionObtido);
	}
}
