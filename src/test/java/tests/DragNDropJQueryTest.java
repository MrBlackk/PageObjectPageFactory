package tests;

import core.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.JQueryDroppablePage;

/**
 * Created by chv on 09.02.2017.
 * Drag-n-drop on JQuery droppable page
 */
public class DragNDropJQueryTest extends TestBase {

    @Test(description = "Open JQuery droppable page and drag-n-drop element")
    public void dragNDropTest() {
        new JQueryDroppablePage(getDriver())
                .open(TestData.JQUERY_DROPPPABLE_URL);

        String actualDroppable = new JQueryDroppablePage(getDriver())
                .dragNDropDraggableToDroppable()
                .getDroppableText();

        Assert.assertEquals(actualDroppable, TestData.DROPPABLE_EXPECTED, "Droppable text is not correct");
    }
}
