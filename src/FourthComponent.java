import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class FourthComponent {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.marginTop = 10;
        rowLayout.marginLeft = 10;
        rowLayout.spacing = 15;
        shell.setLayout(rowLayout);

        Text text = new Text(shell, SWT.CENTER);

        Button button = new Button(shell, SWT.PUSH);
        button.setText("Please, push!");

        Group group = new Group(shell, SWT.NONE);
        group.setLayout(new RowLayout(SWT.VERTICAL));

        Button checkOne = new Button(group, SWT.CHECK);
        checkOne.setText("Check 1");

        Button checkTwo = new Button(group, SWT.CHECK);
        checkTwo.setText("Check 2");

        Button checkThree = new Button(group, SWT.CHECK);
        checkThree.setText("Check 3");

        MessageBox messageBox = new MessageBox(shell, SWT.APPLICATION_MODAL);
        messageBox.setMessage("No coincidence!");

        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (checkOne.getText().equals(text.getText()) )
                    checkOne.setSelection(true);
                else if (checkTwo.getText().equals(text.getText()))
                    checkTwo.setSelection(true);
                else if (checkThree.getText().equals(text.getText()))
                    checkThree.setSelection(true);
                else messageBox.open();
            }
        });

        text.pack();
        shell.setSize(400, 200);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
