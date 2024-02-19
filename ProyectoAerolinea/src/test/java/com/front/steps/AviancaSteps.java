package com.front.steps;

import com.front.runners.RunnerAviancaTest;
import com.front.pageObjects.AviancaPageObject;
import net.thucydides.core.annotations.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class AviancaSteps extends AviancaPageObject{
    AviancaPageObject aviancaPageObject;
    private static final Logger LOGGER = LoggerFactory.getLogger(RunnerAviancaTest.class);
    @Step
    public void ingresarEnLaPaginaAvianca(String url) {
        try {
            aviancaPageObject.openAt(url);
        }catch (Exception e){
            LOGGER.error("Falló en el paso ingresarEnLaPaginaAvianca: " + e.getMessage());
        }
    }

    @Step
    public void SeleccionarLugarOrigen(String lugarOrigen) {
        try {
            aviancaPageObject.SeleccionarLugarOrigen(lugarOrigen);
        }catch (Exception e){
            LOGGER.error("Falló en el paso SeleccionarLugarOrigen: " + e.getMessage());
        }
    }

    @Step
    public void SeleccionarLugarDestino(String lugarDestino) {
        try {
            aviancaPageObject.SeleccionarLugarDestino(lugarDestino);
        }catch (Exception e){
            LOGGER.error("Falló en el paso SeleccionarLugarDestino: " + e.getMessage());
        }
    }

    @Step
    public void seleccionarFechaIdaYVuelta(List<List<String>> data, int i) {
        try {
            aviancaPageObject.seleccionarFechaIda(data.get(i).get(0).trim());
            aviancaPageObject.seleccionarFechaVuelta(data.get(i).get(1).trim());
            //aviancaPageObject.seleccionarBotonConfirmarFechas();
        }catch (Exception e){
            LOGGER.error("Falló en el paso seleccionarFechaIdaYVuelta: " + e.getMessage());
        }
    }

    @Step
    public void seleccionarElTipoDePasajeroViajar(String pasajero) {
        try {
            aviancaPageObject.seleccionarElTipoDePasajeroViajar(pasajero);
            //aviancaPageObject.seleccionarBotonConfirmarPasajeros();
        }catch (Exception e){
            LOGGER.error("Falló en el paso seleccionarElTipoDePasajeroViajar: " + e.getMessage());
        }
    }

    @Step
    public void seleccionarElBotonBuscarParaVuelosDisponibles() {
        try {
            aviancaPageObject.seleccionarElBotonBuscarParaVuelosDisponibles();
        }catch (Exception e){
            LOGGER.error("Falló en el paso seleccionarElBotonBuscarParaVuelosDisponibles: " + e.getMessage());
        }
    }

    @Step
    public void seleccioanrVuelosIdaVueltaConSuTipoDeEquipaje(String tipoEquipaje) {
        try {
            aviancaPageObject.seleccionarVueloIda();
            aviancaPageObject.seleccionarTipoEquipajeVueloIda(tipoEquipaje);
            aviancaPageObject.seleccionarVueloVuelta();
            aviancaPageObject.seleccionarTipoEquipajeVueloVuelta(tipoEquipaje);
        }catch (Exception e){
            LOGGER.error("Falló en el paso seleccioanrVuelosIdaVueltaConSuTipoDeEquipaje: " + e.getMessage());
        }
    }

    @Step
    public void validarElPrecioFinalContinuarConLaReservar() {
        try {
            aviancaPageObject.validarPrecioTotalReserva();
            aviancaPageObject.seleccionarBotonContinuarReserva();
        }catch (Exception e){
            LOGGER.error("Falló en el paso validarElPrecioFinalContinuarConLaReservar: " + e.getMessage());
        }
    }

    @Step
    public void diligenciarFormularioDeLosPasajeros(List<List<String>> data, int i) {
        try {
            aviancaPageObject.diligenciarGeneroPasajero(data.get(i).get(0).trim());
            aviancaPageObject.diligenciarNombrePasajero(data.get(i).get(1).trim());
            aviancaPageObject.diligenciarApellidoUnoPasajero(data.get(i).get(2).trim());
            aviancaPageObject.diligenciarApellidoDosPasajero(data.get(i).get(3).trim());
            aviancaPageObject.diligenciarApellidoTresPasajero(data.get(i).get(4).trim());
            aviancaPageObject.diligenciarEmailPasajero(data.get(i).get(5).trim());
            aviancaPageObject.diligenciarPrefijoTelefonicoPasajero(data.get(i).get(6).trim());
            aviancaPageObject.diligenciarTelefonoPasajero(data.get(i).get(7).trim());
            aviancaPageObject.seleccionarBotonContinuarReservaFormulario();
        }catch (Exception e){
            LOGGER.error("Falló en el paso diligenciarFormularioDeLosPasajeros: " + e.getMessage());
        }
    }

    @Step
    public void validarPrecioFinalDeLaReserva() {
        try {
            aviancaPageObject.seleccionarBotonPagar();
            aviancaPageObject.validarPrecioReservaFinal();
        }catch (Exception e){
            LOGGER.error("Falló en el paso validarPrecioFinalDeLaReserva: " + e.getMessage());
        }
    }
}
