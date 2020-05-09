package carvalho.jessica.projetofinal.repositorio;

import carvalho.jessica.projetofinal.modelo.EventoEntidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepositorio extends CrudRepository<EventoEntidade, Long> {

}