package selenide;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

@Epic("Product Catalog Management")
@Feature("Catalog Functionality")
public class CatalogTest extends TestBase {

    @Description("Test to verify that the sorting by name is working correctly and lists are equal after sorting.")
    @Story("User should be able to sort products by their names.")
    @Test
    public void sortByNameFullComparison() {
        CatalogPage.clickLinkRubberDuckNavigationPanel();
        List<String> listBefore = CatalogPage.getListOfTitles();
        Collections.sort(listBefore);
        CatalogPage.clickSortByNameButton();
        List<String> listAfterClickSortByNameButton = CatalogPage.getListOfTitles();
        Assert.assertTrue(CatalogPage.CompareLists(listBefore, listAfterClickSortByNameButton));
    }
}
