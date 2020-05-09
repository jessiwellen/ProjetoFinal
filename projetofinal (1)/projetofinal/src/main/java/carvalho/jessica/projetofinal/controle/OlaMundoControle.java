package carvalho.jessica.projetofinal.controle;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class OlaMundoControle {

	@GetMapping("/")
	public String index(){
		return "Bem Vindo(a) ao Projeto Final de API com Sprig Boot";
	}

}