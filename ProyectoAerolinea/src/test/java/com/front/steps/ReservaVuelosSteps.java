package com.front.steps;

import com.front.pageObjects.AviancaPageObject;
import com.front.pageObjects.ReservaVuelosPageObject;
import com.front.runners.RunnerAviancaTest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class ReservaVuelosSteps extends ReservaVuelosPageObject {

    ReservaVuelosPageObject reservaVuelosPageObject;
    private static final Logger LOGGER = LoggerFactory.getLogger(RunnerAviancaTest.class);

    @Step
    public void ingresarALaPaginaTicketesBaratos(String url) {
        try {
            reservaVuelosPageObject.openAt(url);
        }catch (Exception e){
            LOGGER.error("Falló en el paso ingresarALaPaginaTicketesBaratos: " + e.getMessage());
            Assert.assertTrue(false);
        }
    }

    @Step
    public void seleccionarLugarOrigenReserva(String reservaOrigen) {
        try {
            reservaVuelosPageObject.seleccionarLugarOrigenReserva(reservaOrigen);
        }catch (Exception e){
            LOGGER.error("Falló en el paso seleccionarLugarOrigenReserva: " + e.getMessage());
            Assert.assertTrue(false);
        }
    }

    @Step
    public void seleccionarLugarOrigenDestinoreservaDestino(String reservaDestino) {
        try {
            reservaVuelosPageObject.seleccionarLugarOrigenDestinoreservaDestino(reservaDestino);
        }catch (Exception e){
            LOGGER.error("Falló en el paso seleccionarLugarOrigenDestinoreservaDestino: " + e.getMessage());
            Assert.assertTrue(false);
        }
    }

    @Step
    public void seleccionarReservaIda(String mesReservaIda, String diaReservaIda) {
        try {
            reservaVuelosPageObject.seleccionarReservaIda(mesReservaIda, diaReservaIda);
        }catch (Exception e){
            LOGGER.error("Falló en el paso seleccionarReservaIda: " + e.getMessage());
            Assert.assertTrue(false);
        }
    }

    @Step
    public void seleccionarReservaVuelta(String mesReservaVuelta, String diaReservaVuelta) {
        try {
            reservaVuelosPageObject.seleccionarReservaVuelta(mesReservaVuelta, diaReservaVuelta);
        }catch (Exception e){
            LOGGER.error("Falló en el paso seleccionarReservaVuelta: " + e.getMessage());
            Assert.assertTrue(false);
        }
    }

    @Step
    public void seleccionarNumeroPasajerosViajar(String numeroPasajerosAdultos) {
        try {
            reservaVuelosPageObject.seleccionarNumeroPasajerosViajar(numeroPasajerosAdultos);
        }catch (Exception e){
            LOGGER.error("Falló en el paso seleccionarNumeroPasajerosViajar: " + e.getMessage());
            Assert.assertTrue(false);
        }
    }

    @Step
    public void seleccionarBotonParaBuscarVuelosDisponiblesReserva() {
        try {
            reservaVuelosPageObject.seleccionarBotonParaBuscarVuelosDisponiblesReserva();
        }catch (Exception e){
            LOGGER.error("Falló en el paso seleccionarBotonParaBuscarVuelosDisponiblesReserva: " + e.getMessage());
            Assert.assertTrue(false);
        }
    }

    @Step
    public void seleccionarVueloIdaVuelta(String aerolineaA, String aerolineaB) {
        try {
            reservaVuelosPageObject.seleccionarVueloIda(aerolineaA);
            reservaVuelosPageObject.seleccionarVueloVuelta(aerolineaB);
        }catch (Exception e){
            LOGGER.error("Falló en el paso seleccionarVueloIdaVuelta: " + e.getMessage());
            Assert.assertTrue(false);
        }
    }

    @Step
    public void validarElPrecioTotalDeLaReservaLuegoSeleccionarElBotonReservar(String cantidadPasajeros) {
        try {
            reservaVuelosPageObject.capturarValorTotalReserva(cantidadPasajeros);
            reservaVuelosPageObject.seleccionarBotonReservar();
        }catch (Exception e){
            LOGGER.error("Falló en el paso validarElPrecioTotalDeLaReservaLuegoSeleccionarElBotonReservar: " + e.getMessage());
            Assert.assertTrue(false);
        }
    }

    @Step
    public void diligenciarElFormularioDeLosPasajerosParaLaReservaDeVuelos(String cantidadPasajeros, String nombre1, String nombre2, String nombre3, String nombre4, String apellido1, String apellido2, String apellido3, String apellido4, String emailPasajero, String telefonoPasajero) {
        try {
            reservaVuelosPageObject.diligenciarFormularioPasajeros(cantidadPasajeros, nombre1, nombre2, nombre3, nombre4, apellido1, apellido2, apellido3, apellido4);
            reservaVuelosPageObject.diligenciarCorreoTelefonoPasajero(emailPasajero, telefonoPasajero);
        }catch (Exception e){
            LOGGER.error("Falló en el paso diligenciarElFormularioDeLosPasajerosParaLaReservaDeVuelos: " + e.getMessage());
            Assert.assertTrue(false);
        }
    }

    @Step
    public void validarPrecioFinalReservaTicketesBaratos() {
        try {
            reservaVuelosPageObject.validarPrecioFinalReservaTicketesBaratos();
        }catch (Exception e){
            LOGGER.error("Falló en el paso validarPrecioFinalReservaTicketesBaratos: " + e.getMessage());
            Assert.assertTrue(false);
        }
    }
}