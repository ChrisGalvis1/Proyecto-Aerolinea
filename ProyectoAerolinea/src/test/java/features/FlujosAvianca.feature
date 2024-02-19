@FlujosAvianca
Feature: Realizar diferentes reservas de vuelo en la pagina de Avianca
  Yo, como usuario de Avianca
  al realizar diferentes acciones en la busqueda de un vuelo
  se debe poder reservar un vuelo hasta la sección de seleccionar la forma de pago

  Scenario Outline: Seleccionar vuelo
    Given Ingresa a la pagina de Avianca "<URL>"
    When Seleccionar lugar de origen "<txtOrigen>"
    And Seleccionar lugar de destino "<txtDestino>"
    And Seleccionar fecha de ida y vuelta
      | Fecha Ida          | Fecha Vuelta     |
      | <dateFechaInicial> | <dateFechaFinal> |
    And Seleccionar el tipo de pasajeros a viajar "<btnPasajero>"
    And Seleccionar el boton buscar para vuelos disponibles
    And Seleccionar vuelos de ida y vuelta con su tipo de equipaje "<btnTipoEquipaje>"
    And Validar el precio final y continuar con la reserva
    And Diligenciar el formulario de los pasajeros
      | Genero       | Nombre              | Apellido1        | Apellido2        | Apellido3         | Email       | Prefijo       | Telefono      |
      | <listGenero> | <txtNombrePasajero> | <txtApellidoUno> | <txtApellidoDos> | <txtApellidoTres> | <txtCorreo> | <listPrefijo> | <txtTelefono> |
    Then Validar precio final de la reserva

    Examples:
      | URL | txtOrigen | txtDestino | dateFechaInicial | dateFechaFinal | btnPasajero | btnTipoEquipaje | listGenero | txtNombrePasajero | txtApellidoUno | txtApellidoDos | txtApellidoTres | txtCorreo | listPrefijo | txtTelefono |
    ##@externaldata@C:\Users\User\Documents\JavaSelenium\DataDrivenReservasVuelos.xlsx@VuelosMejor
|https://www.avianca.com/es/|Bogota|Barranquilla|20-2-2024|24-2-2024|2|Basic|Masculino|Testauto|ApellidoTest|TestAuto|OtroMas|prueba@gmail.com|57|3108523698|
|https://www.avianca.com/es/|Bogota|Cartagena|13-3-2024|19-3-2024|2|Basic|Femenino|Autotest|ApellidoAuto|TestApellido|MasOtro|prueba@gmail.com|57|3216549870|
