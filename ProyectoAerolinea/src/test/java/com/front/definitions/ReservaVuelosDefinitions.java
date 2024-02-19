package com.front.definitions;

import com.front.runners.RunnerAviancaTest;
import com.front.steps.ReservaVuelosSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ReservaVuelosDefinitions {

    @Steps
    ReservaVuelosSteps reservaVuelosSteps;

    @Given("Ingresar a la pagina de TicketesBaratos {string}")
    public void ingresar_a_la_pagina_de_ticketes_baratos(String URL) {
        reservaVuelosSteps.ingresarALaPaginaTicketesBaratos(URL);
    }

    @When("Seleccionar lugar de origen de la reserva {string}")
    public void seleccionar_lugar_de_origen_de_la_reserva(String reservaOrigen) {
        reservaVuelosSteps.seleccionarLugarOrigenReserva(reservaOrigen);
    }

    @When("Seleccionar lugar de destino de la reserva {string}")
    public void seleccionar_lugar_de_destino_de_la_reserva(String reservaDestino) {
        reservaVuelosSteps.seleccionarLugarOrigenDestinoreservaDestino(reservaDestino);
    }

    @When("Seleccionar fecha de ida de la reserva {string} {string}")
    public void seleccionar_fecha_de_ida_de_la_reserva(String mesReservaIda, String diaReservaIda) {
        reservaVuelosSteps.seleccionarReservaIda(mesReservaIda, diaReservaIda);
    }

    @When("Seleccionar fecha de vuelta de la reserva {string} {string}")
    public void seleccionar_fecha_de_vuelta_de_la_reserva(String mesReservaVuelta, String diaReservaVuelta) {
        reservaVuelosSteps.seleccionarReservaVuelta(mesReservaVuelta, diaReservaVuelta);
    }

    @When("Seleccionar el numero de pasajeros a viajar {string}")
    public void seleccionar_el_numero_de_pasajeros_a_viajar(String numeroPasajerosAdultos) {
        reservaVuelosSteps.seleccionarNumeroPasajerosViajar(numeroPasajerosAdultos);
    }

    @When("Seleccionar el boton para buscar vuelos disponibles a reservar")
    public void seleccionar_el_boton_para_buscar_vuelos_disponibles_a_reservar() {
        reservaVuelosSteps.seleccionarBotonParaBuscarVuelosDisponiblesReserva();
    }

    @When("Seleccionar vuelo de ida y vuelta {string} {string}")
    public void seleccionar_vuelo_de_ida_y_vuelta(String aerolineaA, String aerolineaB) {
        reservaVuelosSteps.seleccionarVueloIdaVuelta(aerolineaA, aerolineaB);
    }

    @When("Validar el precio total de la reserva y luego seleccionar el boton Reservar {string}")
    public void validar_el_precio_total_de_la_reserva_y_luego_seleccionar_el_boton_reservar(String cantidadPasajeros) {
        reservaVuelosSteps.validarElPrecioTotalDeLaReservaLuegoSeleccionarElBotonReservar(cantidadPasajeros);
    }

    @When("Diligenciar el formulario de los pasajeros para la reserva de vuelos {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
    public void diligenciar_el_formulario_de_los_pasajeros_para_la_reserva_de_vuelos(String cantidadPasajeros, String nombre1, String nombre2, String nombre3, String nombre4, String apellido1, String apellido2, String apellido3, String apellido4, String emailPasajero, String telefonoPasajero) {
        reservaVuelosSteps.diligenciarElFormularioDeLosPasajerosParaLaReservaDeVuelos(cantidadPasajeros, nombre1, nombre2, nombre3, nombre4, apellido1, apellido2, apellido3, apellido4, emailPasajero, telefonoPasajero);
    }

    @Then("Validar precio final de la reserva en ticketesBaratos")
    public void validar_precio_final_de_la_reserva_en_ticketes_baratos() {
        reservaVuelosSteps.validarPrecioFinalReservaTicketesBaratos();
    }
}