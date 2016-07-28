import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DevByTest extends TestBase{

    @Test
    public void devByMenuTest(){

        MenuPageElement.clickLentaInMenu(driver);
        assertTrue(LentaPage.isLogoPresent(driver));

        MenuPageElement.clickCompaniesInMenu(driver);
        assertTrue(CompaniesPage.isIsSoftPresent(driver));

        MenuPageElement.clickSalariesInMenu(driver);
        assertTrue(SalariesPage.isSalaryInItTextPresent(driver));

        MenuPageElement.clickVacanciesInMenu(driver);
        assertTrue(VacanciesPage.isVacanciesTextPresent(driver));

    }
}
