package framework;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;

/**
 * TestRunner — ponto de entrada para execução dos testes Cucumber via JUnit 5.
 *
 * Configuração via @ConfigurationParameter:
 *
 *   GLUE_PATH          → pacotes onde o Cucumber procura Steps e Hooks
 *   FEATURES_PROPERTY  → caminho das features
 *   FILTER_TAGS        → filtro de tags (sobrescrito por -Dcucumber.filter.tags=@smoke)
 *   PLUGIN_PROPERTY    → formatos de relatório
 *
 * Execução por linha de comando:
 *   mvn test                                    → todos os cenários
 *   mvn test -Dcucumber.filter.tags="@smoke"    → apenas @smoke
 *   mvn test -Dbrowser=firefox -Dheadless=true  → Firefox headless
 *   mvn test -DreuseDriver=true                 → reutiliza navegador entre cenários
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameters({
    @ConfigurationParameter(
        key   = GLUE_PROPERTY_NAME,
        value = "framework.hooks,framework.steps"
    ),
    @ConfigurationParameter(
        key   = PLUGIN_PROPERTY_NAME,
        value = "pretty,"
             + "html:target/cucumber-reports/cucumber.html,"
             + "json:target/cucumber-reports/cucumber.json"
    ),
    @ConfigurationParameter(
        key   = SNIPPET_TYPE_PROPERTY_NAME,
        value = "camelcase"
    )
    // Para filtrar por tag padrão, descomente:
    // @ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@smoke")
})
public class TestRunner {
    // Classe vazia — apenas as anotações são necessárias
}
