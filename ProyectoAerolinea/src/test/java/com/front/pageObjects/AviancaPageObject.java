package com.front.pageObjects;

import com.front.utilidades.Utilidades;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.util.Random;

public class AviancaPageObject extends PageObject {

    Utilidades utilidades;

    //Objetos mapeados de la pagina Avianca
    String btnCookiesAvianca = "//div[@id='onetrust-banner-sdk']//div[@class='ot-sdk-row']//div[@id='onetrust-button-group-parent']//div[@id='onetrust-button-group']//button[@id='onetrust-accept-btn-handler']";
    String txtLugarOrigen = "//div[@class='container-fluid']//div[@class='multiple-panel']//div[@id='multipleSearch0_tab']//div[@class='search-container_search']//div[@id='inputSearch']//div[@class='ibe-search_station-control']//div[@class='control_form']//div[@class='control_fields']//div[@id='originDiv']";
    String txtEscribirLugarOrigen = "//div[@class='container-fluid']//div[@class='multiple-panel']//div[@id='multipleSearch0_tab']//div[@class='search-container_search']//div[@id='inputSearch']//div[@class='ibe-search_station-control']//div[@class='control_form']//div[@class='control_fields']//div[@id='originDiv']//input[@class='control_field_input']";
    String txtEscribirLugarDestino = "//div[@class='container-fluid']//div[@class='multiple-panel']//div[@id='multipleSearch0_tab']//div[@class='search-container_search']//div[@id='inputSearch']//div[@class='ibe-search_station-control']//div[@class='control_form']//div[@class='control_fields']//div[@class='control_field control_field-inbound is-focused']//div[@class='control_field_inner']//input[@placeholder='Hacia']";
    String dateFechaSeleccionada = "//div[@class='container-fluid']//div[@class='multiple-panel']//div[@id='multipleSearch0_tab']//div[@class='search-container_search']//div[@id='inputSearch']//div[@class='ibe-search_date-control']//div[@class='date-control']//div[@class='control_options ng-star-inserted']//div[@class='control_options_inner']//div[@class='control_options_scroll']//div[@class='date-picker date-picker--lowest-fare']//div[@class='ngb-dp-months']//div[@class='ngb-dp-month ng-star-inserted']//div[@aria-label='"; //Se envia por parametro la fecha puesta en el DataDriven
    String btnNumeroPasajerosAdulto = "//div[@class='container-fluid']//div[@class='multiple-panel']//div[@id='multipleSearch0_tab']//div[@class='search-container_search']//div[@id='inputSearch']//div[@class='ibe-search_pax-control']//div[@class='pax-control']//div[@id='paxControlSearchId']//div[@class='control_options_inner']//div[@class='control_options_scroll']//div[@class='pax-control_selector-container']//ul[@class='pax-control_selector']//li[@class='pax-control_selector_item'][1]//div[@class='pax-control_selector_item_control']//div[@class='ui-num-ud']//button[@class='ui-num-ud_button plus']";
    String lblNumeroPasajerosActual = "//div[@class='container-fluid']//div[@class='multiple-panel']//div[@id='multipleSearch0_tab']//div[@class='search-container_search']//div[@id='inputSearch']//div[@class='ibe-search_pax-control']//div[@class='pax-control']//div[@id='paxControlSearchId']//div[@class='control_options_inner']//div[@class='control_options_scroll']//div[@class='pax-control_selector-container']//ul[@class='pax-control_selector']//li[@class='pax-control_selector_item'][1]//div[@class='pax-control_selector_item_control']//div[@class='ui-num-ud']//div[@class='ui-num-ud_input']//input[@id='inputPax_ADT']";
    String btnConfirmarNumeroPasajeros = "//div[@class='container-fluid']//div[@class='multiple-panel']//div[@id='multipleSearch0_tab']//div[@class='search-container_search']//div[@id='inputSearch']//div[@class='ibe-search_pax-control']//div[@class='pax-control']//div[@id='paxControlSearchId']//div[@class='control_options_inner']//div[@class='control_options_scroll']//div[@class='pax-control_selector-container']//div[@class='control_options_selector_action']//button";
    String btnBuscarVuelosDisponibles = "//div[@class='container-fluid']//div[@class='multiple-panel']//div[@id='multipleSearch0_tab']//div[@class='search-container_search']//div[@id='inputSearch']//div[@class='ibe-search_action']//button[@id='searchButton'][2]";
    String btnVueloDiponible = "//div[@data-testid='avail-choose-flight']//avail-list-pres[@data-testid='avail-list-pres']//div[@class='component-bound ng-star-inserted']//expander-elem[@data-testid='bound-expander-"; //Se coloca un numero aleatorio entre 0 y 10

    public void SeleccionarLugarOrigen(String lugarOrigen) {
        if (find(By.xpath(btnCookiesAvianca)).isVisible()){
            find(By.xpath(btnCookiesAvianca)).click();
            find(By.xpath(txtLugarOrigen)).click();
            //utilidades.bordearElemento(find(By.xpath(txtEscribirLugarOrigen)));
            find(By.xpath(txtEscribirLugarOrigen)).sendKeys(lugarOrigen);
            find(By.xpath(txtEscribirLugarOrigen)).sendKeys(Keys.ENTER);
            waitFor(1).second();
        }else {
            //utilidades.bordearElemento(find(By.xpath(txtLugarOrigen)));
            find(By.xpath(txtLugarOrigen)).click();
            find(By.xpath(txtEscribirLugarOrigen)).sendKeys(lugarOrigen);
            find(By.xpath(txtEscribirLugarOrigen)).sendKeys(Keys.ENTER);
            waitFor(1).second();
        }
    }

    public void SeleccionarLugarDestino(String lugarDestino) {
        //utilidades.bordearElemento(find(By.xpath(txtEscribirLugarDestino)));
        find(By.xpath(txtEscribirLugarDestino)).sendKeys(lugarDestino);
        find(By.xpath(txtEscribirLugarDestino)).sendKeys(Keys.ENTER);
        waitFor(1).second();
    }

    public void seleccionarFechaIda(String fechaInicial) {
        //utilidades.bordearElemento(find(By.xpath(dateFechaSeleccionada+fechaInicial+"']")));
        find(By.xpath(dateFechaSeleccionada+fechaInicial+"']")).click();
        waitFor(1).second();
    }

    public void seleccionarFechaVuelta(String fechaFinal) {
        //utilidades.bordearElemento(find(By.xpath(dateFechaSeleccionada+fechaFinal+"']")));
        find(By.xpath(dateFechaSeleccionada+fechaFinal+"']")).click();
        waitFor(1).second();
    }

    public void seleccionarBotonConfirmarFechas() {
    }

    public void seleccionarElTipoDePasajeroViajar(String pasajero) {
        String numeroPasajero = find(By.xpath(lblNumeroPasajerosActual)).getTextValue();
        int numeroPasajerosNuevos = Integer.parseInt(numeroPasajero);
        int pasajerosSeleccionados = Integer.parseInt(pasajero);
        if (numeroPasajerosNuevos < pasajerosSeleccionados){
            //utilidades.bordearElemento(find(By.xpath(btnNumeroPasajerosAdulto)));
            find(By.xpath(btnNumeroPasajerosAdulto)).click();
            seleccionarElTipoDePasajeroViajar(pasajero);
        }else{
            seleccionarBotonConfirmarPasajeros();
        }
    }

    public void seleccionarBotonConfirmarPasajeros() {
        //utilidades.bordearElemento(find(By.xpath(btnConfirmarNumeroPasajeros)));
        find(By.xpath(btnConfirmarNumeroPasajeros)).click();
        waitFor(1).second();
    }

    public void seleccionarElBotonBuscarParaVuelosDisponibles() {
        find(By.xpath(btnBuscarVuelosDisponibles)).click();
        waitFor(1).second();
    }

    public void seleccionarVueloIda() {
        Random random = new Random();
        int numeroVuelo = random.nextInt(11);
        String vueloSeleccionado = String.valueOf(numeroVuelo);
        //utilidades.posicionarElemento(find(By.xpath(btnVueloDiponible+vueloSeleccionado+"']")));
        //utilidades.bordearElemento(find(By.xpath(btnVueloDiponible+vueloSeleccionado+"']")));
        find(By.xpath(btnVueloDiponible+vueloSeleccionado+"']")).click();
        waitFor(1).second();
    }

    public void seleccionarTipoEquipajeVueloIda(String tipoEquipaje) {
    }

    public void seleccionarVueloVuelta() {
    }

    public void seleccionarTipoEquipajeVueloVuelta(String tipoEquipaje) {
    }

    public void validarOpcionEquipajeBasic(){

    }

    public void validarPrecioTotalReserva() {
    }

    public void seleccionarBotonContinuarReserva() {
    }

    public void diligenciarGeneroPasajero(String generoPasajero) {
    }

    public void diligenciarNombrePasajero(String nombrePasajero) {
    }

    public void diligenciarApellidoUnoPasajero(String apellidoPasajero1) {
    }

    public void diligenciarApellidoDosPasajero(String apellidoPasajero2) {
    }

    public void diligenciarApellidoTresPasajero(String apellidoPasajero3) {
    }

    public void diligenciarEmailPasajero(String emailPasajero) {
    }

    public void diligenciarPrefijoTelefonicoPasajero(String prefijoTelefonoPasajero) {
    }

    public void diligenciarTelefonoPasajero(String telefonoPasajero) {
    }

    public void seleccionarBotonContinuarReservaFormulario() {
    }

    public void seleccionarBotonPagar() {
    }

    public void validarPrecioReservaFinal() {
    }

}
