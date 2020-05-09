package carvalho.jessica.projetofinal.controle;

import carvalho.jessica.projetofinal.modelo.EventoEntidade;
import carvalho.jessica.projetofinal.repositorio.EventoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class  EventoControle {

	@Autowired
	private EventoRepositorio  eventoRepositorio;

	@GetMapping
	public ResponseEntity<List<EventoEntidade>> findAll (){  // get
		return new ResponseEntity<List<EventoEntidade>>(
				(List<EventoEntidade>) this.eventoRepositorio.findAll(),
				new HttpHeaders(), HttpStatus.OK);//error 404
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<EventoEntidade> findById(@PathVariable ("id") long id) {
		if(this.eventoRepositorio.findById(id).isPresent()){
			return new ResponseEntity<EventoEntidade>(
					this.eventoRepositorio.findById(id).get(),
					new HttpHeaders(),
					HttpStatus.OK);

		}
		return new ResponseEntity<EventoEntidade>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<EventoEntidade> cadastrar (@RequestBody EventoEntidade eventoEntidade) {
		return new ResponseEntity<EventoEntidade> (
				this.eventoRepositorio.save(eventoEntidade),
				new HttpHeaders(),
				HttpStatus.CREATED
		);

	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<EventoEntidade> atualizar (@PathVariable("id") long id,
														@RequestBody EventoEntidade eventoEntidade) throws Exception {

		if(id == 0 || !this.eventoRepositorio.existsById(id)){
			throw  new Exception("Código não encontrado ou inexistente!");

		}
		return new ResponseEntity<EventoEntidade>(
				this.eventoRepositorio.save(eventoEntidade),
				new HttpHeaders(),
				HttpStatus.OK);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<EventoEntidade> deletar (@PathVariable("id") long id ){
		this.eventoRepositorio.deleteById(id);
		return new ResponseEntity<EventoEntidade>(new HttpHeaders(), HttpStatus.OK);
	}

}
