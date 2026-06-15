# Framework Automação - Web e API
Framework de automação de testes Web e API usando as seguintes stacks:
- Cucumber (BDD)
- JUnit 5 (execução dos testes)
- Selenium (testes Web)
- Rest Assured (testes de API)

Estrutura do projeto

```
src
|--main
   |--pages
   |--config
   |--driverfactory
   |--resources
   |--requests
   |--utils
src
|--test
   |--hooks
   |--steps
   |--resources
   |--runner
```
### Detalhes de estrutura
**Pages:** Diretório contendo todos os Page Objects relacionados às páginas web que serão testadas. Por padrão, será dividida em subpastas por telas/fluxos.
O arquivo `BasePage.java`deve conter todos os métodos comuns utilizados pelos demais Page Objects
```
/main
|--pages
   |--BasePage.java
      |--Login
         |--CadastroUsuarioPage.java
         |--LoginPage.java
```

**Config:** Contem a classe `ConfigManager.java` responsável pela gestão da leitura do arquivo de configuração do framework. Essa classe deve ser usada exclusivamente na classe `DriverManager.java`, para posteriormente obter quais as propriedades principais para uso do WebBrowser.

```java
ConfigManager.java
    private  static  ConfigManager  configInstance;
    private  Properties  propriedadeAutomacao  =  new  Properties();

   private  ConfigManager()  {
       carregarArquivoPropriedades();
   }

   public  static  synchronized  ConfigManager  getInstance()  {
      if  (configInstance  ==  null)  {
         configInstance  =  ConfigManager.getInstance();
      }
      return  configInstance;
   }
```

```java
DriverFactory.java
   ConfigManager  config  =  ConfigManager.getInstance();
   String  browser  =  config.getBrowser();
   boolean  headless  =  config.getHeadless();
```

**DriverFactory:** Contém as classes para gestão do ciclo de vida da execução do WebDriver e qual navegador será usado.
Na classe `DriverFactory.java` deverá conter o acesso às configurações necessárias, como explicado acima. Com base nesses parâmetros, será escolhido o navegado do teste, como no exemplo abaixo:
```java
switch(browser)  {
case  "firefox":
driver  =  iniciarFirefox(headless);
case  "edge":
driver  =  iniciarEdge(headless);
default:
driver  =  iniciarChrome(headless);
}

configurarTempoCarregamentoPagina(driver,  config);

return  driver;
```
Na classe `DriverManager.java` constará o ciclo de vida do browser. Para sua gestão, o driver será armazenado em objeto `ThreadLocal`, isso para não ter conflito entre threads e ofertar uma possibilidade de 'reuso do driver' entre cenários caso seja necessário. Exemplo:
```java
private  static  final  ThreadLocal<WebDriver>  driverThread  =  new  ThreadLocal<WebDriver>();

private  static  void  iniciarDriver()  {
if  (driverThread.get()  ==  null)  {
driverThread.set(DriverFactory.criarDriver());
}

}
public  boolean  driverAtivo()  {
return  driver  !=  null;
}
```
**Request:** Diretório contendo todos os requests gerados para os testes de API utilizando o RestAssured

**Utils:** Pacote com classes com funcionalidades de utilidade para a manutenção e execução dos testes.
- ScenarioContext: Usada para compartilhamento de status entre steps do mesmo cenário. Deve ser usado dentro das classes de StepDefinition.
- Screenshot: Usada para obter uma captura da tela conforme necessidade do fluxo web a ser testado.

**Hooks:** Contém funções para execução anterior e posterior a cada cenário. Como o webdriver é gerido via ThreadLocal para isolar execuções em paralelo  quando necessário compartilhar status entre cenários, existe uma função para verificar se o driver será reutilizado por outro teste. Para essa função ser acessada, é necessário usar a tag @reusa-driver no arquivo feature.
**Features:** Diretório com todos os arquivos `.feature` criados para execução dos testes. Por padrão, será dividido por sub-pastas com base em telas/fluxos testados.
** StepDefinitions:** Diretório com os StepDefinitions relacionados aos arquivos de `.feature`. Quando possível, deve ser dividido em subpastas seguindo estrutura similiar ao
**Runner:** Classe para execução dos testes. Única mudança necessária nessa classe é se for necessário testar fluxos específicos, informando assim as respectivas tags do Gherkin.