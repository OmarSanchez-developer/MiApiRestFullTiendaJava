package com.methaporce.tienda.services;

import com.methaporce.tienda.Exceptions.ClienteNotFoundException;
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
        } else {
            throw new ClienteNotFoundException("El cliente que intenta modificar no existe");
        }

    }

    @Override
    public void eliminarCliente(Integer id) {

        Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
        if (clienteExistente != null){
            clienteRepository.deleteById(id);
        } else{
            throw new ClienteNotFoundException("El cliente que intentas eliminar no existe");
        }
    }


}

