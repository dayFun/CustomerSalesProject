package myProject;

import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.swing.locator.JMenuItemLocator;

public class TestWindowTesterTest extends UITestCaseSwing {

    /**
     * Create an Instance
     */
    public TestWindowTesterTest() {
        super(myProject.Main.class);
    }

    public void testTestWindowTester() throws Exception {
        IUIContext ui = getUI();
        ui.click(new JMenuItemLocator("File/Exit"));
    }

}
