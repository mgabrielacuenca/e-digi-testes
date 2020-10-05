package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Autor;

class TestAutor {

	@Test 
	void testAdicionarAutorComNomeVazio() {      
        Exception exception =  assertThrows(IllegalArgumentException.class, () -> {
        	Autor autor1 = new Autor("", "david@localhost");
        });
        
        String exceptionEsperado = "Não é permitido nomes em branco, por favor digite um nome válido!";
        String exceptionObtido = exception.getMessage();
        
        assertEquals(exceptionEsperado, exceptionObtido);
	}
	
	@Test
	void testAdicionarAutorComEmailInvalido() {
		Exception exception =  assertThrows(IllegalArgumentException.class, () -> {
        	Autor autor2 = new Autor("David", "davidlocalhost");
        });
        
        String exceptionEsperado = "Email Inválido!";
        String exceptionObtido = exception.getMessage();
        
        assertEquals(exceptionEsperado, exceptionObtido);
	}

}
