package com.front.definitions;

import com.front.runners.RunnerAviancaTest;
import com.front.steps.AviancaSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class AviancaDefinitions {

    private static final Logger LOGGER = LoggerFactory.getLogger(RunnerAviancaTest.class);
    @Steps
    AviancaSteps aviancaSteps;

    @Given("Ingresa a la pagina de Avianca {string}")
    public void ingresa_a_la_pagina_de_avianca(String URL) {
        aviancaSteps.ingresarEnLaPaginaAvianca(URL);
    }

    @When("Seleccionar lugar de origen {string}")
    public void seleccionar_lugar_de_origen(String LugarOrigen) {
        aviancaSteps.SeleccionarLugarOrigen(LugarOrigen);
    }

    @When("Seleccionar lugar de destino {string}")
    public void seleccionar_lugar_de_destino(String LugarDestino) {
        aviancaSteps.SeleccionarLugarDestino(LugarDestino);
    }

    @When("Seleccionar fecha de ida y vuelta")
    public void seleccionar_fecha_de_ida_y_vuelta(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        for (int i = 1; i < data.size(); i++) {
            aviancaSteps.seleccionarFechaIdaYVuelta(data,i);
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                LOGGER.error("Error al seleccionar Vuelos de ida y vuelta: "+e);
                Thread.currentThread().interrupt();
            }
        }
    }

    @When("Seleccionar el tipo de pasajeros a viajar {string}")
    public void seleccionar_el_tipo_de_pasajeros_a_viajar(String Pasajero) {
        aviancaSteps.seleccionarElTipoDePasajeroViajar(Pasajero);
    }

    @When("Seleccionar el boton buscar para vuelos disponibles")
    public void seleccionar_el_boton_buscar_para_vuelos_disponibles() {
        aviancaSteps.seleccionarElBotonBuscarParaVuelosDisponibles();
    }

    @When("Seleccionar vuelos de ida y vuelta con su tipo de equipaje {string}")
    public void seleccionar_vuelos_de_ida_y_vuelta_con_su_tipo_de_equipaje(String TipoEquipaje) {
        aviancaSteps.seleccioanrVuelosIdaVueltaConSuTipoDeEquipaje(TipoEquipaje);
    }

    @When("Validar el precio final y continuar con la reserva")
    public void validar_el_precio_final_y_continuar_con_la_reserva() {
        aviancaSteps.validarElPrecioFinalContinuarConLaReservar();
    }

    @When("Diligenciar el formulario de los pasajeros")
    public void diligenciar_el_formulario_de_los_pasajeros(DataTable dataTable) {
        List<List<String>> data = dataTable.asLists(String.class);
        for (int i = 1; i < data.size(); i++) {
            aviancaSteps.diligenciarFormularioDeLosPasajeros(data,i);
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                LOGGER.error("Error Diligenciar el formulario de los pasajeros: "+e);
                Thread.currentThread().interrupt();
            }
        }
    }

    @Then("Validar precio final de la reserva")
    public void validar_precio_final_de_la_reserva() {
        aviancaSteps.validarPrecioFinalDeLaReserva();
    }
}
