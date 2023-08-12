# prueba-selenium-grid
## saucelab test
1. auth at https://saucelabs.com/
2. Automated Testing/Sauce Selenium Quickstart, choose Java
3. Paste the capabilities in setUp method. Be sure "username", "acceskey" and "build" keys matches to your saucelabs account
4. Download the jar selenium server (grid) file in Selenium official downloads page.
5. run ``java -jar selenium-server-4.11.0.jar standalone``in the directory where jar is located.
6. run the test (TestGridSauceLabs.java)
7. tests results available in saucelabs dashboard.
