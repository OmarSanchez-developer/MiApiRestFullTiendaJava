package com.methaporce.tienda.Controllers;
import com.methaporce.tienda.entidades.Cliente;
import com.methaporce.tienda.services.IClienteServices;
import jakarta.validation.Valid;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    /*
    @PostMapping("/cliente")
    //Método para insertar un nuevo cliente



    public Cliente insertarCliente(@RequestBody Cliente cliente){
        return clienteServices.insertarCliente(cliente);


    }*/
/*
    @PostMapping("/cliente")
    //Método para insertar un nuevo cliente
    public ResponseEntity<?> insertarCliente(@RequestBody @Valid Cliente  cliente, BindingResult bindResult){
        //Almacena los errores clave y valor
        Map<String,String> errores = new HashMap<>();
        if (bindResult.hasErrors()) {
            for (FieldError error : bindResult.getFieldErrors()) {
                errores.put(error.getField(),error.getDefaultMessage());

            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
        }
        Cliente clienteCreado = clienteServices.insertarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);


    }
*/
    @PostMapping("/cliente")
    //Método para insertar un nuevo cliente
    public ResponseEntity<?> insertarCliente(@RequestBody @Valid Cliente  cliente){
        //Almacena los errores clave y valor

        Cliente clienteCreado = clienteServices.insertarCliente(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);

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
