package com.methaporce.tienda.services;
import com.methaporce.tienda.entidades.Cliente;
import java.util.List;

public interface IClienteServices {

    //Service manda traer los datos del repository
    //Declarar el método de listar Clientes
    List<Cliente> listarClientes();

    //Insercion de cliente en el Metodo necesita el tipo de dato que traiga toda la info.
    Cliente insertarCliente(Cliente cliente);

    //Update de clientes
    Cliente actualizarCliente(Integer id, Cliente cliente);

    void eliminarCliente(Integer id);
}
