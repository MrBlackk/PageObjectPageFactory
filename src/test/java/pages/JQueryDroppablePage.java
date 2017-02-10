package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.Log4Test;

/**
 * Created by chv on 09.02.2017.
 *
 * JQuery droppable page
 */
public class JQueryDroppablePage extends GeneralPage {

    @FindBy(id = "draggable")
    private WebElement draggable;
    @FindBy(id = "droppable")
    private WebElement droppable;
    @FindBy(className = "demo-frame")
    private WebElement frame;

    public JQueryDroppablePage(WebDriver webDriver) {
        super(webDriver);
    }

    /**
     * Drag-n-drop draggable element to droppable
     */
    public JQueryDroppablePage dragNDropDraggableToDroppable(){
        Log4Test.test("Switch to iframe and drag-n-drop draggable element to droppable");
        webDriver.switchTo().frame(frame);
        new Actions(webDriver).dragAndDrop(draggable, droppable).build().perform();
        return this;
    }

    /**
     * Get droppable element text
     */
    public String getDroppableText(){
        return droppable.getText();
    }
}
