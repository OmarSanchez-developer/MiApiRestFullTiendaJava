package com.methaporce.tienda;

import com.methaporce.tienda.Exceptions.ClienteNotFoundException;
import com.methaporce.tienda.Repositories.ClienteRepository;
import com.methaporce.tienda.entidades.Cliente;
import com.methaporce.tienda.services.ClienteServicesImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServicesTest {
    @Mock
    private ClienteRepository clienteRepositoryMock;

    @InjectMocks
    private ClienteServicesImp clienteServicesImp;

    @Test
    public void guardarUnCliente(){
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        when(clienteRepositoryMock.save(cliente)).thenReturn(cliente);

        Cliente clienteGuardado = clienteServicesImp.insertarCliente(cliente);
        assertNotNull(clienteGuardado);
        assertEquals("Juan",clienteGuardado.getNombre());

    }
    @Test
    public void actualizarCliente(){
        Cliente clienteActual = new Cliente();
        clienteActual.setNombre("Juan");

        Cliente datosActualizados = new Cliente();
        datosActualizados.setNombre("Pedro");
        when(clienteRepositoryMock.findById(1)).thenReturn(Optional.of(clienteActual));

        when(clienteRepositoryMock.save(clienteActual)).thenReturn(clienteActual);

        Cliente clienteActualizado = clienteServicesImp.actualizarCliente(1,datosActualizados);
        assertEquals("Pedro",clienteActualizado.getNombre());

    }
    @Test
    public void actualizarClienteNotFound(){
        when(clienteRepositoryMock.findById(1)).thenReturn(Optional.empty());
        RuntimeException exception = assertThrows(ClienteNotFoundException.class, ()-> clienteServicesImp.actualizarCliente(1, new Cliente()));
        assertEquals("El cliente que intenta modificar no existe", exception.getMessage());

    }
}
