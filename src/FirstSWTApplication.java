import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Combo;

import java.util.ArrayList;

public class FirstSWTApplication {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        RowLayout rowLayout = new RowLayout();
        rowLayout.center = true;
        rowLayout.marginLeft = 10;
        rowLayout.marginTop = 20;
        rowLayout.type = SWT.VERTICAL;
        rowLayout.spacing = 20;
        rowLayout.pack = true;
        rowLayout.justify = true;
        shell.setLayout(rowLayout);

        Text text = new Text(shell, SWT.CENTER);

        Button button = new Button(shell, SWT.PUSH);
        Combo combo = new Combo(shell, SWT.DROP_DOWN);

        MessageBox messageBox = createMessageBox(shell, SWT.APPLICATION_MODAL, "No coincidence!");
        button.setText("Button");

        ArrayList<String> list = new ArrayList<>();

        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                boolean textExist = false;
                for (String aList : list) {
                    if (aList.equals(text.getText()))
                        textExist = true;
                }
                if (!textExist) {
                    list.add(text.getText());
                    combo.add(text.getText());
                }
                else messageBox.open();
            }
        });
        text.pack();

        shell.setSize(400, 300);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    protected static MessageBox createMessageBox (Shell parent, int style, String messageText) {
        MessageBox messageBox = new MessageBox(parent, style);
        messageBox.setMessage(messageText);
        return messageBox;
    }
}
