# prueba-selenium-grid
## saucelab test
1. auth at https://saucelabs.com/
2. Automated Testing/Sauce Selenium Quickstart, choose Java
3. Paste the capabilities in setUp method. Be sure "username", "acceskey" and "build" keys matches to your saucelabs account
  ![](https://github.com/sadelax/prueba-selenium-grid/blob/main/saucelabs-screenshot.png | width=10)
5. Download the jar selenium server (grid) file in Selenium official downloads page.
6. Run ``java -jar selenium-server-<version>.jar standalone`` in the directory where jar is located.
7. Run the test (TestGridSauceLabs.java)
8. Tests results available in saucelabs dashboard.

## local test
1. RemoteWebDriver es la clase que permite interactuar con un navegador remoto en Selenium Grid. Toma una URL (en este caso, "http://localhost:4444") que apunta al hub de Selenium Grid y las opciones del navegador (chromeOptions) como argumentos. Esto establece la conexión con el nodo del Grid que cumple con las capacidades proporcionadas.
2. Run ``java -jar selenium-server-4.11.0.jar standalone`` in the directory where jar is located.
3. Run the test (TestGrid.java)

### extra
si hace falta el chromedriver y no tenemos permisos de administrador en el mac:
1. ``brew install --cask chromedriver``
2. ``xattr -cr /opt/homebrew/bin/chromedriver`` (ruta donde se haya descargado el chromedriver)
3. run standalone de nuevo
