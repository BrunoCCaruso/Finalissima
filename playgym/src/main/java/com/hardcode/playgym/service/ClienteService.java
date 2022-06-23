package com.hardcode.playgym.service;


import com.hardcode.playgym.entity.Asesor;
import com.hardcode.playgym.entity.Cliente;
import com.hardcode.playgym.repository.ClienteRepository;
import com.hardcode.playgym.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClienteService{

    private final ClienteRepository clienteRepository;
    private final EmailService emailService;

    @Transactional
    public void create(Cliente clienteDto) {
        if (clienteRepository.existsByEmail(clienteDto.getEmail()))
            throw new IllegalArgumentException("There is already a user associated with the email entered");

        Cliente cliente = new Cliente();

        cliente.setAlias(clienteDto.getAlias());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setAltura(clienteDto.getAltura());
        cliente.setEdad(clienteDto.getEdad());


        //asesor.setListaGrupoMuscular(); REVISAR IMPORTANTE
        cliente.setRol("CLIENTE");

        emailService.sendCliente(clienteDto.getEmail());
        clienteRepository.save(cliente);
    }
}
