package com.methaporce.tienda.services;

import com.methaporce.tienda.Repositories.ClienteRepository;
import com.methaporce.tienda.entidades.Cliente;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteServicesImp implements IClienteServices{

    private final ClienteRepository clienteRepository;

    public ClienteServicesImp(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();


    }

    @Override
    public Cliente insertarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente actualizarCliente(Integer id, Cliente cliente) {
        Cliente clienteActual = clienteRepository.findById(id).orElse(null);
        if(clienteActual != null){
            clienteActual.setCiudad(cliente.getCiudad());
            clienteActual.setNombre((cliente.getNombre()));
            return  clienteRepository.save(clienteActual);
        }

        return null;
    }

    @Override
    public void eliminarCliente(Integer id) {
       clienteRepository.deleteById(id);
    }


}

