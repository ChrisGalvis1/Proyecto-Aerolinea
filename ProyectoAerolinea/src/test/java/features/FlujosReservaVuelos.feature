@FlujosTicketesBaratos
Feature: Realizar diferentes reservas de vuelo en la pagina de Ticketes Baratos
  Yo, como usuario de Ticketes Baratos
  al realizar diferentes acciones en la busqueda de un vuelo
  se debe poder reservar un vuelo hasta la sección de seleccionar la forma de pago

  Scenario Outline: Seleccionar reserva
    Given Ingresar a la pagina de TicketesBaratos "<URL>"
    When Seleccionar lugar de origen de la reserva "<txtOrigen>"
    And Seleccionar lugar de destino de la reserva "<txtDestino>"
    And Seleccionar fecha de ida de la reserva "<dateMesInicial>" "<dateDiaInicial>"
    And Seleccionar fecha de vuelta de la reserva "<dateMesFinal>" "<dateDiaFinal>"
    And Seleccionar el numero de pasajeros a viajar "<btnPasajeroAdulto>"
    And Seleccionar el boton para buscar vuelos disponibles a reservar
    And Seleccionar vuelo de ida y vuelta "<btnAerolineaA>" "<btnAerolineaB>"
    And Validar el precio total de la reserva y luego seleccionar el boton Reservar "<btnPasajeroAdulto>"
    And Diligenciar el formulario de los pasajeros para la reserva de vuelos "<btnPasajeroAdulto>" "<txtNombre1>" "<txtNombre2>" "<txtNombre3>" "<txtNombre4>" "<txtApellido1>" "<txtApellido2>" "<txtApellido3>" "<txtApellido4>" "<txtEmail>" "<txtTelefono>"
    Then Validar precio final de la reserva en ticketesBaratos

    Examples:
      | URL                                       | txtOrigen   | txtDestino | dateMesInicial | dateDiaInicial | dateMesFinal | dateDiaFinal | btnPasajeroAdulto | btnAerolineaA | btnAerolineaB | txtNombre1 | txtNombre2 | txtNombre3 | txtNombre4 | txtApellido1 | txtApellido2 | txtApellido3 | txtApellido4 | txtEmail                   | txtTelefono |
    ##@externaldata@C:\Users\User\Documents\JavaSelenium\DataDrivenReservasVuelos.xlsx@VuelosTicketesBaratos
|https://www.tiquetesbaratos.com/index.php|Cali|Cartagena de Indias|marzo|1|marzo|8|4|latam|latam|Carlos|Sara|Santiago|Juliana|Lopez|Pinilla|Acosta|Leon|santiago.leon951@gmail.com|3217412589|
|https://www.tiquetesbaratos.com/index.php|Bogotá|San Andrés Islas|abril|23|mayo|2|2|avianca|avianca|Christian|Paula|Felix|Polux|Galvis|Leon|Jesty|Lulo|santiago.leon951@gmail.com|3217412589|
|https://www.tiquetesbaratos.com/index.php|Cali|Cartagena de Indias|marzo|24|abril|2|2|latam|avianca|Guillermo|Joan|Juliana|Andrea|Gomez|Polo|Jota|Mandarina|santiago.leon951@gmail.com|3217412589|
