package com.methaporce.tienda.Controllers;
import com.methaporce.tienda.entidades.Cliente;
import com.methaporce.tienda.services.IClienteServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tienda")

public class ClienteController {

    private final IClienteServices clienteServices;

    public ClienteController(IClienteServices clienteServices) {
        this.clienteServices = clienteServices;
    }

    @GetMapping("/cliente")
    public List<Cliente> obtenerListaClientes(){
        return clienteServices.listarClientes();
        //Llega peticion a controlador, controlador manda llamar al service(Logica negocio) y asu vez manda peticion repository(bd) ida y vuelta

    }

    @PostMapping("/cliente")
    //Método para insertar un nuevo cliente
    public Cliente insertarCliente(@RequestBody Cliente cliente){
        return clienteServices.insertarCliente(cliente);
    }

    @PutMapping("/cliente/{id}")
    //Método actualizar un cliente
    public Cliente actualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente){
        return clienteServices.actualizarCliente(id, cliente);
    }

    @DeleteMapping("cliente/{id}")
    //Método eliminar cliente
    public void eliminarCliente(@PathVariable Integer id){
        clienteServices.eliminarCliente(id);
    }

}
