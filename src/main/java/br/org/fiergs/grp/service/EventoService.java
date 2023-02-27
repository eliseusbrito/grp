package br.org.fiergs.grp.service;

import br.org.fiergs.grp.entity.Evento;
import br.org.fiergs.grp.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    EventoRepository repository;

    public EventoService(EventoRepository repository) {
        this.repository = repository;
    }

    public List<Evento> findAllEventos() {
        return repository.findAll();
    }

    public List<Evento> findEventosByReuniao(Long id) {
        return repository.findEventosByReuniao(id);
    }

    public List<Evento> findEventosNaoIdentificados() {
        return repository.findEventosNaoIdentificados();
    }


}
