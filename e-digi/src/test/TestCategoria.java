package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Categoria;

class TestCategoria {

	@Test 
	void testAdicionarCategoriaComNomeVazio() {      
        Exception exception =  assertThrows(IllegalArgumentException.class, () -> {
        	Categoria categoria1 = new Categoria("");
        });
        
        String exceptionEsperado = "Não é permitido categoria em branco, por favor digite uma categoria!";
        String exceptionObtido = exception.getMessage();
        
        assertEquals(exceptionEsperado, exceptionObtido);
	}

}
