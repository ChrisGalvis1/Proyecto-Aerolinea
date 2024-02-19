package com.front.pageObjects;

import com.front.utilidades.Utilidades;
import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import javax.lang.model.util.Elements;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class ReservaVuelosPageObject extends PageObject {

    Utilidades utilidades;
    private WebDriver driver;
    public int resultadoValorTotalReserva;

    //Objetos mapeados de la pagina Ticketes baratos
    String txtVueloOrigen = "//div[@id='myTabContent']//div[@id='flights']//form[@id='form_flights']//div[@class='row px-3 pr-md-2 pl-md-1 pt-4 c-input-box ul-transporte-motor-vuelo']//div[@id='fOrigin']//div[@class='position-relative c-field']//input[@name='origenName']";
    String lblSeleccionarCiudadOrigen = "//div[@id='myTabContent']//div[@id='flights']//form[@id='form_flights']//div[@class='row px-3 pr-md-2 pl-md-1 pt-4 c-input-box ul-transporte-motor-vuelo']//div[@id='fOrigin']//section[@id='autocomplete-ptags1_serch']//ul//li[@title='"; //Se envia por parametro la ciudad origen que viene en el DataDriven
    String txtVueloDestino = "//div[@id='myTabContent']//div[@id='flights']//form[@id='form_flights']//div[@class='row px-3 pr-md-2 pl-md-1 pt-4 c-input-box ul-transporte-motor-vuelo']//div[@id='fDestination']//div[@class='position-relative c-field']//input[@name='destinoName']";
    String lblSeleccionarCiudadDestino = "//div[@id='myTabContent']//div[@id='flights']//form[@id='form_flights']//div[@class='row px-3 pr-md-2 pl-md-1 pt-4 c-input-box ul-transporte-motor-vuelo']//div[@id='fDestination']//div[@class='position-relative c-field']//section[@id='autocomplete-ptags2_serch']//ul//li[@title='"; //Se envia por parametro la ciudad destino que viene en el DataDriven
    String btnCalendarioVuelosIda = "//div[@id='myTabContent']//div[@id='flights']//form[@id='form_flights']//div[@class='row px-3 pr-md-2 pl-md-1 pt-4 c-input-box ul-transporte-motor-vuelo']//div[@id='fGoing']//div[@class='position-relative c-field']//input[@id='from_calendar']";
    String lblMesDisponibleCalendario1 = "//section[@class='lightpick lightpick--2-columns']//div[@class='lightpick__inner']//div[@class='lightpick__months']//section[@class='lightpick__month'][1]//header[@class='lightpick__month-title-bar']//div[@class='lightpick__month-title']//select[@class='lightpick__select lightpick__select-months']//option[@selected='selected']";
    String lblMesDisponibleCalendario2 = "//section[@class='lightpick lightpick--2-columns']//div[@class='lightpick__inner']//div[@class='lightpick__months']//section[@class='lightpick__month'][2]//header[@class='lightpick__month-title-bar']//div[@class='lightpick__month-title']//select[@class='lightpick__select lightpick__select-months']//option[@selected='selected']";
    String lblMesVueloCalendario1 = "//section[@class='lightpick lightpick--2-columns']//div[@class='lightpick__inner']//div[@class='lightpick__months']//section[@class='lightpick__month'][1]//header[@class='lightpick__month-title-bar']//div[@class='lightpick__month-title']//select[@class='lightpick__select lightpick__select-months']//option[text()='"; //Se envia por parametro el mes que viene en el DataDriven
    String lblMesVueloCalendario2 = "//section[@class='lightpick lightpick--2-columns']//div[@class='lightpick__inner']//div[@class='lightpick__months']//section[@class='lightpick__month'][2]//header[@class='lightpick__month-title-bar']//div[@class='lightpick__month-title']//select[@class='lightpick__select lightpick__select-months']//option[text()='"; //Se envia por parametro el mes que viene en el DataDriven
    String btnDiaVueloCalendario1 = "//section[@class='lightpick lightpick--2-columns']//div[@class='lightpick__inner']//div[@class='lightpick__months']//section[@class='lightpick__month'][1]//div[@class='lightpick__days']//div[text()='"; //Se envia por parametro el dia que viene en el DataDriven
    String btnDiaVueloCalendario2 = "//section[@class='lightpick lightpick--2-columns']//div[@class='lightpick__inner']//div[@class='lightpick__months']//section[@class='lightpick__month'][2]//div[@class='lightpick__days']//div[text()='"; //Se envia por parametro el dia que viene en el DataDriven
    String btnPasarMesSiguiente = "//section[@class='lightpick lightpick--2-columns']//div[@class='lightpick__inner']//div[@class='lightpick__toolbar']//button[@class='lightpick__next-action']";
    String btnPasajeros = "//div[@id='myTabContent']//div[@id='flights']//form[@id='form_flights']//div[@class='row px-3 pr-md-2 pl-md-1 pt-4 c-input-box ul-transporte-motor-vuelo']//div[@class='col-12 col-lg-2-5 px-0 px-md-2 mb-4 mb-lg-0 pb-2 pb-md-0']//div[@class='position-relative']//div[@id='idPassengers']";
    String lblNumeroPasajeros = "//div[@id='myTabContent']//div[@id='flights']//form[@id='form_flights']//div[@class='row px-3 pr-md-2 pl-md-1 pt-4 c-input-box ul-transporte-motor-vuelo']//div[@class='col-12 col-lg-2-5 px-0 px-md-2 mb-4 mb-lg-0 pb-2 pb-md-0']//div[@class='position-relative']//div[@id='idPassengers']//div[@id='cPassengers-flights']/div[@class='row mb-3'][1]//div[@class='col-5 col-md-7 col-lg-5 c-icons pr-4']//div[@class='col-4 px-1 text-center adult-value']";
    String btnNumeroPasajeros = "//div[@id='myTabContent']//div[@id='flights']//form[@id='form_flights']//div[@class='row px-3 pr-md-2 pl-md-1 pt-4 c-input-box ul-transporte-motor-vuelo']//div[@class='col-12 col-lg-2-5 px-0 px-md-2 mb-4 mb-lg-0 pb-2 pb-md-0']//div[@class='position-relative']//div[@id='idPassengers']//div[@id='cPassengers-flights']/div[@class='row mb-3'][1]//div[@class='col-5 col-md-7 col-lg-5 c-icons pr-4']//div[@class='col-4 px-1 text-center btn-passengers -cp-pointer'][2]";
    String btnConfirmarNumerosPasajeros = "//div[@id='myTabContent']//div[@id='flights']//form[@id='form_flights']//div[@class='row px-3 pr-md-2 pl-md-1 pt-4 c-input-box ul-transporte-motor-vuelo']//div[@class='col-12 col-lg-2-5 px-0 px-md-2 mb-4 mb-lg-0 pb-2 pb-md-0']//div[@class='position-relative']//div[@id='idPassengers']//div[@id='cPassengers-flights']//button[text()='Listo']";
    String btnBuscarVuelos = "//div[@id='myTabContent']//div[@id='flights']//form[@id='form_flights']//div[@class='row px-3 pr-md-2 pl-md-1 pt-4 c-input-box ul-transporte-motor-vuelo']//div[@class='col-12 col-lg-1 px-0 px-md-2 pr-lg-0 pl-lg-1 c-button']//button[text()='Buscar']";
    String lblPosicionamientoVuelosIdaLatam =    "/html/body/div[2]/div[4]/div/section[3]/div[1]/div/section/div[2]/div[2]/div[7]/div/div[2]/div[1]/div/div";
    String lblPosicionamientoVuelosVueltaLatam = "/html/body/div[2]/div[4]/div/section[3]/div[1]/div/section/div[3]/div[2]/div[7]/div/div[2]/div[1]/div/div";
    String lblPosicionamientoVuelosIdaAvianca =    "/html/body/div[2]/div[4]/div/section[3]/div[3]/div/section/div[2]/div[2]/div[7]/div/div[2]/div[1]/div/div";
    String lblPosicionamientoVuelosVueltaAvianca = "/html/body/div[2]/div[4]/div/section[3]/div[3]/div/section/div[3]/div[2]/div[7]/div/div[2]/div[1]/div/div";
    String lblPrecioVueloIda = "//div[@id='app']//section[@id='cBarInfloFlights']//div[@class='pt-2 container']//div[@id='vueloIda1']//div[@class='col-10 px-0']//div[@class='position-relative']//span[@id='idaSelectedPricePerAdult']";
    String lblPrecioVueloVuelta = "//div[@id='app']//section[@id='cBarInfloFlights']//div[@class='pt-2 container']//div[@class='col-5']//div[@class='col-10 px-0']//div[@class='position-relative']//span[@id='regresoSelectedPricePerAdult']";
    String btnReservarVuelo = "//div[@id='app']//section[@id='cBarInfloFlights']//div[@class='pt-2 container']//div[@class='col-2 d-flex align-items-center justify-content-center']//button[text()='Reservar']";
    String lblPrecioFinalReservaPagina = "//form[@id='formreservar']//div[@template='home']//div[@id='cSummary']//div//div[@class='row bg-yellow-05 py-3']//div[@class='col-8 col-md-7 font-22 color-blue f-semibold text-right']//span[@data-attribute='precioTotal']";
    String txtNombre1 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//input[@id='nombreadulto1']";
    String txtNombre2 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//input[@id='nombreadulto2']";
    String txtNombre3 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//input[@id='nombreadulto3']";
    String txtNombre4 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//input[@id='nombreadulto4']";
    String txtApellido1 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//input[@id='apellidoadulto1']";
    String txtApellido2 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//input[@id='apellidoadulto2']";
    String txtApellido3 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//input[@id='apellidoadulto3']";
    String txtApellido4 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//input[@id='apellidoadulto4']";
    String checkDiaMesPasajero1 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='dianacimientoadulto1']";
    String checkDiaMesPasajero2 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='dianacimientoadulto2']";
    String checkDiaMesPasajero3 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='dianacimientoadulto3']";
    String checkDiaMesPasajero4 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='dianacimientoadulto4']";
    String checkMesPasajero1 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='mesnacimientoadulto1']";
    String checkMesPasajero2 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='mesnacimientoadulto2']";
    String checkMesPasajero3 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='mesnacimientoadulto3']";
    String checkMesPasajero4 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='mesnacimientoadulto4']";
    String checkAñoPasajero1 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='anonacimientoadulto1']";
    String checkAñoPasajero2 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='anonacimientoadulto2']";
    String checkAñoPasajero3 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='anonacimientoadulto3']";
    String checkAñoPasajero4 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='anonacimientoadulto4']";
    String txtCedulaPasajero1 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//input[@id='cedula1']";
    String txtCedulaPasajero2 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//input[@id='cedula2']";
    String txtCedulaPasajero3 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//input[@id='cedula3']";
    String txtCedulaPasajero4 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//input[@id='cedula4']";
    String txtTelefonoPasajero = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='c-forms py-3 px-4 mb-3']//div[@class='col-12 col-md-6 px-2']//input[@id='telefonomovil']";
    String txtEmail = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='c-forms py-3 px-4 mb-3']//div[@class='col-12 col-md-6 px-2']//input[@id='correo']";

    public void seleccionarLugarOrigenReserva(String reservaOrigen) {
        find(By.xpath(txtVueloOrigen)).clear();
        find(By.xpath(txtVueloOrigen)).sendKeys(reservaOrigen);
        waitFor(1).second();
        find(By.xpath(lblSeleccionarCiudadOrigen + reservaOrigen + "']")).click();
    }

    public void seleccionarLugarOrigenDestinoreservaDestino(String reservaDestino) {
        find(By.xpath(txtVueloDestino)).clear();
        find(By.xpath(txtVueloDestino)).sendKeys(reservaDestino);
        waitFor(1).second();
        find(By.xpath(lblSeleccionarCiudadDestino + reservaDestino + "']")).click();
    }

    public void seleccionarReservaIda(String mesReservaIda, String diaReservaIda) {
        find(By.xpath(btnCalendarioVuelosIda)).click();
        String mesCapturado1 = find(By.xpath(lblMesDisponibleCalendario1)).getText();
        String mesCapturado2 = find(By.xpath(lblMesDisponibleCalendario2)).getText();
        if (find(By.xpath(lblMesVueloCalendario1 + mesReservaIda + "']")).containsText(mesCapturado1)) {
            find(By.xpath(btnDiaVueloCalendario1 + diaReservaIda + "']")).click();
        } else if (find(By.xpath(lblMesVueloCalendario2 + mesReservaIda + "']")).containsText(mesCapturado2)) {
            find(By.xpath(btnDiaVueloCalendario2 + diaReservaIda + "']")).click();
        } else {
            find(By.xpath(btnPasarMesSiguiente)).click();
            seleccionarReservaIda(mesReservaIda, diaReservaIda);
        }
    }

    public void seleccionarReservaVuelta(String mesReservaVuelta, String diaReservaVuelta) {
        String mesCapturado1 = find(By.xpath(lblMesDisponibleCalendario1)).getText();
        String mesCapturado2 = find(By.xpath(lblMesDisponibleCalendario2)).getText();
        if (find(By.xpath(lblMesVueloCalendario1 + mesReservaVuelta + "']")).containsText(mesCapturado1)) {
            find(By.xpath(btnDiaVueloCalendario1 + diaReservaVuelta + "']")).click();
        } else if (find(By.xpath(lblMesVueloCalendario2 + mesReservaVuelta + "']")).containsText(mesCapturado2)) {
            find(By.xpath(btnDiaVueloCalendario2 + diaReservaVuelta + "']")).click();
        } else {
            find(By.xpath(btnPasarMesSiguiente)).click();
            seleccionarReservaVuelta(mesReservaVuelta, diaReservaVuelta);
        }
    }

    public void seleccionarNumeroPasajerosViajar(String numeroPasajerosAdultos) {
        waitFor(1).second();
        find(By.xpath(btnPasajeros)).click();
        String numerosPasajeroActual = find(By.xpath(lblNumeroPasajeros)).getTextValue();
        int pasajerosActuales = Integer.parseInt(numerosPasajeroActual);
        int pasajerosIngresar = Integer.parseInt(numeroPasajerosAdultos);
        if (pasajerosActuales < pasajerosIngresar) {
            find(By.xpath(btnNumeroPasajeros)).click();
            seleccionarNumeroPasajerosViajar(numeroPasajerosAdultos);
        } else {
            find(By.xpath(btnConfirmarNumerosPasajeros)).click();
        }
    }

    public void seleccionarBotonParaBuscarVuelosDisponiblesReserva() {
        find(By.xpath(btnBuscarVuelos)).click();
    }

    public void seleccionarVueloIda(String aerolineaA) throws InterruptedException {
        waitFor(5).seconds();
        if (aerolineaA.contains("latam")) {
            for (int i = 2; i < 10; i++) {
                String vueloAgotadoLatam1 = "/html/body/div[2]/div[4]/div/section[3]/div[1]/div/section/div[2]/div[2]/div[" + i + "]/div/div[2]/div[1]/div/div/div/div//div[text()='Agotado']";
                String primeraColumnaPreciosLatam = "/html/body/div[2]/div[4]/div/section[3]/div[1]/div/section/div[2]/div[2]/div[" + i + "]/div/div[2]/div[1]/div/div/div[2]/div/div[1]";
                if (find(By.xpath(primeraColumnaPreciosLatam)).isClickable()) {
                    utilidades.posicionarElemento(find(lblPosicionamientoVuelosIdaLatam));
                    find(By.xpath(primeraColumnaPreciosLatam)).waitUntilEnabled().click();
                    waitFor(1).second();
                    break;
                } else if (i<=9) {
                    utilidades.posicionarElemento(find(lblPosicionamientoVuelosIdaLatam));
                    utilidades.bordearElemento(find(By.xpath(vueloAgotadoLatam1)));
                } else {
                    for (int j = 2; j < 10; j++) {
                        String vueloAgotadoLatam2 = "/html/body/div[2]/div[4]/div/section[3]/div[1]/div/section/div[2]/div[2]/div[" + j + "]/div/div[2]/div[1]/div/div/div/div//div[text()='Agotado']";
                        String segundaColumnaPreciosLatam = "/html/body/div[2]/div[4]/div/section[3]/div[1]/div/section/div[2]/div[2]/div[" + j + "]/div/div[2]/div[2]/div/div/div[2]/div/div[1]";
                        if (find(By.xpath(segundaColumnaPreciosLatam)).isClickable()) {
                            utilidades.posicionarElemento(find(lblPosicionamientoVuelosIdaLatam));
                            find(By.xpath(segundaColumnaPreciosLatam)).click();
                            waitFor(1).second();
                            break;
                        } else if (j<=9) {
                            utilidades.posicionarElemento(find(lblPosicionamientoVuelosIdaLatam));
                            utilidades.bordearElemento(find(By.xpath(vueloAgotadoLatam2)));
                        } else {
                            for (int k = 2; k < 10; k++) {
                                String vueloAgotadoLatam3 = "/html/body/div[2]/div[4]/div/section[3]/div[1]/div/section/div[2]/div[2]/div[" + k + "]/div/div[2]/div[1]/div/div/div/div//div[text()='Agotado']";
                                String terceraColumnaPreciosLatam = "/html/body/div[2]/div[4]/div/section[3]/div[1]/div/section/div[2]/div[2]/div[" + k + "]/div/div[2]/div[3]/div/div/div[2]/div/div[1]";
                                if (find(By.xpath(terceraColumnaPreciosLatam)).isClickable()) {
                                    utilidades.posicionarElemento(find(lblPosicionamientoVuelosIdaLatam));
                                    find(By.xpath(terceraColumnaPreciosLatam)).click();
                                    waitFor(1).second();
                                    break;
                                } else if (k<=9) {
                                    utilidades.posicionarElemento(find(lblPosicionamientoVuelosIdaLatam));
                                    utilidades.bordearElemento(find(By.xpath(vueloAgotadoLatam3)));
                                }
                            }
                        }
                    }
                }
            }
        } else if (aerolineaA.contains("avianca")) {
            waitFor(2).seconds();
            for (int i = 2; i <= 10; i++) {
                String vueloAgotadoAvianca1 = "/html/body/div[2]/div[4]/div/section[3]/div[3]/div/section/div[2]/div[2]/div[" + i + "]/div/div[2]/div[1]/div/div/div/div//div[text()='Agotado']";
                String primeraColumnaPreciosAvianca = "/html/body/div[2]/div[4]/div/section[3]/div[3]/div/section/div[2]/div[2]/div[" + i + "]/div/div[2]/div[1]/div/div/div[2]/div/div[1]";
                if (find(By.xpath(primeraColumnaPreciosAvianca)).isClickable()) {
                    utilidades.posicionarElemento(find(By.xpath(lblPosicionamientoVuelosIdaAvianca)));
                    find(By.xpath(primeraColumnaPreciosAvianca)).click();
                    waitFor(1).second();
                    break;
                } else if (i<=9) {
                    utilidades.posicionarElemento(find(By.xpath(lblPosicionamientoVuelosIdaAvianca)));
                    utilidades.bordearElemento(find(By.xpath(vueloAgotadoAvianca1)));
                } else {
                    for (int j = 2; j < 10; j++) {
                        String vueloAgotadoAvianca2 = "/html/body/div[2]/div[4]/div/section[3]/div[3]/div/section/div[2]/div[2]/div[" + j + "]/div/div[2]/div[1]/div/div/div/div//div[text()='Agotado']";
                        String segundaColumnaPreciosAvianca = "/html/body/div[2]/div[4]/div/section[3]/div[3]/div/section/div[2]/div[2]/div[" + j + "]/div/div[2]/div[2]/div/div/div[2]/div/div[1]";
                        if (find(By.xpath(segundaColumnaPreciosAvianca)).isClickable()) {
                            utilidades.posicionarElemento(find(By.xpath(lblPosicionamientoVuelosIdaAvianca)));
                            find(By.xpath(segundaColumnaPreciosAvianca)).click();
                            waitFor(1).second();
                            break;
                        } else if (j<=9) {
                            utilidades.posicionarElemento(find(By.xpath(lblPosicionamientoVuelosIdaAvianca)));
                            utilidades.bordearElemento(find(By.xpath(vueloAgotadoAvianca2)));
                        } else {
                            for (int k = 2; k < 10; k++) {
                                String vueloAgotadoAvianca3 = "/html/body/div[2]/div[4]/div/section[3]/div[3]/div/section/div[2]/div[2]/div[" + k + "]/div/div[2]/div[1]/div/div/div/div//div[text()='Agotado']";
                                String terceraColumnaPreciosAvianca = "/html/body/div[2]/div[4]/div/section[3]/div[3]/div/section/div[2]/div[2]/div[" + k + "]/div/div[2]/div[3]/div/div/div[2]/div/div[1]";
                                if (find(By.xpath(terceraColumnaPreciosAvianca)).isClickable()) {
                                    utilidades.posicionarElemento(find(By.xpath(lblPosicionamientoVuelosIdaAvianca)));
                                    find(By.xpath(terceraColumnaPreciosAvianca)).click();
                                    waitFor(1).second();
                                    break;
                                } else if (k<=9) {
                                    utilidades.posicionarElemento(find(By.xpath(lblPosicionamientoVuelosIdaAvianca)));
                                    utilidades.bordearElemento(find(By.xpath(vueloAgotadoAvianca3)));
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void seleccionarVueloVuelta(String aerolineaB) throws InterruptedException {
        waitFor(5).seconds();
        if (aerolineaB.contains("latam")) {
            for (int i = 2; i < 10; i++) {
                String vueloAgotadoLatam1 = "/html/body/div[2]/div[4]/div/section[3]/div[1]/div/section/div[2]/div[2]/div[" + i + "]/div/div[2]/div[1]/div/div/div/div//div[text()='Agotado']";
                String primeraColumnaPreciosLatam1 = "/html/body/div[2]/div[4]/div/section[3]/div[1]/div/section/div[3]/div[2]/div[" + i + "]/div/div[2]/div[1]/div/div/div[2]/div/div[1]";
                if (find(By.xpath(primeraColumnaPreciosLatam1)).isClickable()){
                    utilidades.posicionarElemento(find(lblPosicionamientoVuelosVueltaLatam));
                    find(By.xpath(primeraColumnaPreciosLatam1)).click();
                    waitFor(1).second();
                    break;
                } else if (find(By.xpath(vueloAgotadoLatam1)).containsText("Agotado")) {
                    utilidades.posicionarElemento(find(lblPosicionamientoVuelosVueltaLatam));
                    utilidades.bordearElemento(find(By.xpath(vueloAgotadoLatam1)));
                }
            }
        } else if (aerolineaB.contains("avianca")) {
            waitFor(2).seconds();
            for (int i = 2; i < 10; i++) {
                String vueloAgotadoAvianca1 = "/html/body/div[2]/div[4]/div/section[3]/div[3]/div/section/div[2]/div[2]/div[" + i + "]/div/div[2]/div[1]/div/div/div/div//div[text()='Agotado']";
                String primeraColumnaPreciosAvianca1 = "/html/body/div[2]/div[4]/div/section[3]/div[3]/div/section/div[3]/div[2]/div[" + i + "]/div/div[2]/div[1]/div/div/div[2]/div/div[1]";
                if (find(By.xpath(primeraColumnaPreciosAvianca1)).isClickable()) {
                    utilidades.posicionarElemento(find(By.xpath(lblPosicionamientoVuelosVueltaAvianca)));
                    find(By.xpath(primeraColumnaPreciosAvianca1)).waitUntilEnabled().click();
                    waitFor(1).second();
                    break;
                } else if (find(By.xpath(vueloAgotadoAvianca1)).containsText("Agotado")) {
                    utilidades.posicionarElemento(find(By.xpath(lblPosicionamientoVuelosVueltaAvianca)));
                    utilidades.bordearElemento(find(By.xpath(vueloAgotadoAvianca1)));
                }
            }
        }
    }

    public void capturarValorTotalReserva(String cantidadPasajeros) {
        String valorReservaIda = find(By.xpath(lblPrecioVueloIda)).getText();
        String valorReservaVuelta = find(By.xpath(lblPrecioVueloVuelta)).getText();
        utilidades.bordearElemento(find(By.xpath(lblPrecioVueloIda)));
        utilidades.bordearElemento(find(By.xpath(lblPrecioVueloVuelta)));
        String valorSinCaracteresReservaIda = valorReservaIda.replaceAll("[|$.]", "");
        String valorSinCaracteresReservaVuelta = valorReservaVuelta.replaceAll("[|$.]", "");
        int valorFinalCapturadoReservaIda = Integer.parseInt(valorSinCaracteresReservaIda.trim());
        int valorFinalCapturadoReservaVuelta = Integer.parseInt(valorSinCaracteresReservaVuelta.trim());
        int cantidadPasajerosViajar = Integer.parseInt(cantidadPasajeros);
        resultadoValorTotalReserva = ((valorFinalCapturadoReservaIda*cantidadPasajerosViajar) + (valorFinalCapturadoReservaVuelta*cantidadPasajerosViajar));
    }

    public void seleccionarBotonReservar() {
        waitFor(2).seconds();
        find(By.xpath(btnReservarVuelo)).click();
    }

    public void diligenciarFormularioPasajeros(String cantidadPasajeros, String nombre1, String nombre2, String nombre3, String nombre4, String apellido1, String apellido2, String apellido3, String apellido4) {
        waitFor(3).seconds();
        int cantidadPasajerosEnviados = Integer.parseInt(cantidadPasajeros);
        for (int i = 1; i <= cantidadPasajerosEnviados; i++) {
            String numerosPasajerosDiligenciarFormulario = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='col-12 mb-2']//label[text()='Adulto  "+i+"']";
            Random rand = new Random();
            Random rand2 = new Random();
            int numeroAleatorio = rand.nextInt(9) + 1;
            int numeroAleatorio2 = rand.nextInt(90000) + 10000;
            if (i == 1) {
                find(By.xpath(txtNombre1)).sendKeys(nombre1);
                find(By.xpath(txtApellido1)).sendKeys(apellido1);
                waitFor(1).second();
                find(By.xpath(checkDiaMesPasajero1)).click();
                String numeroSeleccionado = String.valueOf(numeroAleatorio);
                String clickDiaMesPasajero1 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='dianacimientoadulto1']//option[@value='0"+numeroSeleccionado+"']";
                waitFor(1).second();
                find(By.xpath(clickDiaMesPasajero1)).click();
                find(By.xpath(checkMesPasajero1)).click();
                String clickMesPasajero1 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='mesnacimientoadulto1']//option[@value='0"+numeroSeleccionado+"']";
                waitFor(1).second();
                find(By.xpath(clickMesPasajero1)).click();
                find(By.xpath(checkAñoPasajero1)).click();
                String clickAñoPasajero1 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='anonacimientoadulto1']//option[@value='199"+numeroSeleccionado+"']";
                waitFor(1).second();
                find(By.xpath(clickAñoPasajero1)).click();
                String cedulaSeleccionado = String.valueOf(numeroAleatorio2);
                find(By.xpath(txtCedulaPasajero1)).sendKeys("11219"+cedulaSeleccionado);

            } else if (i == 2) {
                find(By.xpath(txtNombre2)).sendKeys(nombre2);
                find(By.xpath(txtApellido2)).sendKeys(apellido2);
                waitFor(1).second();
                find(By.xpath(checkDiaMesPasajero2)).click();
                String numeroSeleccionado = String.valueOf(numeroAleatorio);
                String clickDiaMesPasajero2 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='dianacimientoadulto2']//option[@value='0"+numeroSeleccionado+"']";
                waitFor(1).second();
                find(By.xpath(clickDiaMesPasajero2)).click();
                find(By.xpath(checkMesPasajero2)).click();
                String clickMesPasajero2 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='mesnacimientoadulto2']//option[@value='0"+numeroSeleccionado+"']";
                waitFor(1).second();
                find(By.xpath(clickMesPasajero2)).click();
                find(By.xpath(checkAñoPasajero2)).click();
                String clickAñoPasajero2 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='anonacimientoadulto2']//option[@value='199"+numeroSeleccionado+"']";
                waitFor(1).second();
                find(By.xpath(clickAñoPasajero2)).click();
                String cedulaSeleccionado = String.valueOf(numeroAleatorio2);
                find(By.xpath(txtCedulaPasajero2)).sendKeys("11219"+cedulaSeleccionado);

            } else if (i == 3) {
                utilidades.posicionarElemento(find(By.xpath(txtNombre3)));
                find(By.xpath(txtNombre3)).sendKeys(nombre3);
                find(By.xpath(txtApellido3)).sendKeys(apellido3);
                waitFor(1).second();
                find(By.xpath(checkDiaMesPasajero3)).click();
                String numeroSeleccionado = String.valueOf(numeroAleatorio);
                String clickDiaMesPasajero3 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='dianacimientoadulto3']//option[@value='0"+numeroSeleccionado+"']";
                waitFor(1).second();
                find(By.xpath(clickDiaMesPasajero3)).click();
                find(By.xpath(checkMesPasajero3)).click();
                String clickMesPasajero3 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='mesnacimientoadulto3']//option[@value='0"+numeroSeleccionado+"']";
                waitFor(1).second();
                find(By.xpath(clickMesPasajero3)).click();
                find(By.xpath(checkAñoPasajero3)).click();
                String clickAñoPasajero3 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='anonacimientoadulto3']//option[@value='199"+numeroSeleccionado+"']";
                waitFor(1).second();
                find(By.xpath(clickAñoPasajero3)).click();
                String cedulaSeleccionado = String.valueOf(numeroAleatorio2);
                find(By.xpath(txtCedulaPasajero3)).sendKeys("11219"+cedulaSeleccionado);

            } else if (i == 4) {
                utilidades.posicionarElemento(find(By.xpath(txtNombre4)));
                find(By.xpath(txtNombre4)).sendKeys(nombre4);
                find(By.xpath(txtApellido4)).sendKeys(apellido4);
                waitFor(1).second();
                find(By.xpath(checkDiaMesPasajero4)).click();
                String numeroSeleccionado = String.valueOf(numeroAleatorio);
                String clickDiaMesPasajero4 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='dianacimientoadulto4']//option[@value='0"+numeroSeleccionado+"']";
                waitFor(1).second();
                find(By.xpath(clickDiaMesPasajero4)).click();
                find(By.xpath(checkMesPasajero4)).click();
                String clickMesPasajero4 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='mesnacimientoadulto4']//option[@value='0"+numeroSeleccionado+"']";
                waitFor(1).second();
                find(By.xpath(clickMesPasajero4)).click();
                find(By.xpath(checkAñoPasajero4)).click();
                String clickAñoPasajero4 = "//section[@class='container c-checkout']//div[@class='col-12 col-md-7 pr-md-0 c-payments-checkout']//div[@id='cBookAndPay']//div[@class='py-3 px-4 mb-3']//div[@class='form-group position-relative']//select[@id='anonacimientoadulto4']//option[@value='199"+numeroSeleccionado+"']";
                waitFor(1).second();
                find(By.xpath(clickAñoPasajero4)).click();
                String cedulaSeleccionado = String.valueOf(numeroAleatorio2);
                find(By.xpath(txtCedulaPasajero4)).sendKeys("11219"+cedulaSeleccionado);
            }
        }
    }

    public void diligenciarCorreoTelefonoPasajero(String emailPasajero, String telefonoPasajero) {
        waitFor(1).second();
        utilidades.posicionarElemento(find(By.xpath(txtTelefonoPasajero)));
        find(By.xpath(txtTelefonoPasajero)).sendKeys(telefonoPasajero);
        find(By.xpath(txtEmail)).sendKeys(emailPasajero);
    }

    public void validarPrecioFinalReservaTicketesBaratos() {
        utilidades.posicionarElemento(find(By.xpath(lblPrecioFinalReservaPagina)));
        utilidades.bordearElemento(find(By.xpath(lblPrecioFinalReservaPagina)));
        String valorTotalReserva = find(By.xpath(lblPrecioFinalReservaPagina)).getText();
        String valorSinCaracteresReserva = valorTotalReserva.replace(".", "");
        int valorFinalCapturadoReserva = Integer.parseInt(valorSinCaracteresReserva);
        waitFor(2).seconds();
        Assert.assertTrue(resultadoValorTotalReserva == valorFinalCapturadoReserva);
    }
}
