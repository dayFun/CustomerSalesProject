package myProject.listeners;

import java.awt.event.ItemEvent;

public interface ISalesViewListener {

    public void handleLoadOrdersClicked();

    public void handleSelectCustomerClick(ItemEvent e);

    public void handleClearButtonClick();

    public void handleExitButtonClick();

    public void handlePreferencesClicked();
}
