package carvalho.jessica.projetofinal.modelo;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@ToString

@Entity
@Table
public class EventoEntidade {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_evento")
	private long id;

	@Column (name = "organizador")
	private String organizador;

	@Column (name = "email")
	private String email;

	@Column (name = "contato")
	private String contato;

	@Column (name = "cidade")
	private String cidade;

	@Column (name = "estado")
	private String estado;

	@Column (name = "tipodeecento")
	private String tipodeevento;
}
