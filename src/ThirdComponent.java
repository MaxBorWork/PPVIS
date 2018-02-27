import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class ThirdComponent {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
        rowLayout.marginLeft = 10;
        rowLayout.marginTop = 10;
        rowLayout.spacing = 15;
        shell.setLayout(rowLayout);

        Text text = new Text(shell, SWT.CENTER);

        Button button = new Button(shell, SWT.PUSH);
        button.setText("Don't push me");

        Group group = new Group(shell, SWT.NONE);
        group.setLayout(new RowLayout(SWT.HORIZONTAL));

        Button buttonFirst = new Button(group, SWT.RADIO);
        buttonFirst.setText("Radio 1");

        Button buttonSecond = new Button(group, SWT.RADIO);
        buttonSecond.setText("Radio 2");

        Button buttonThird = new Button(group, SWT.RADIO);
        buttonThird.setText("Radio 3");

        MessageBox messageBox = new MessageBox(shell, SWT.OK | SWT.APPLICATION_MODAL);
        messageBox.setMessage("No coincidence!");

        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (buttonFirst.getText().equals(text.getText()) ) {
                    buttonFirst.setSelection(true);
                    buttonSecond.setSelection(false);
                    buttonThird.setSelection(false);
                }
                else if (buttonSecond.getText().equals(text.getText()) ) {
                    buttonSecond.setSelection(true);
                    buttonFirst.setSelection(false);
                    buttonThird.setSelection(false);
                }
                else if (buttonThird.getText().equals(text.getText()) ) {
                    buttonThird.setSelection(true);
                    buttonFirst.setSelection(false);
                    buttonSecond.setSelection(false);
                }
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
