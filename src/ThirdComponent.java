import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class ThirdComponent {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);

        RowLayout rowLayout = createRowLayout(shell, SWT.VERTICAL);

        Text text = new Text(shell, SWT.CENTER);

        Button button = createPushButton(shell, SWT.PUSH, "Don't push me");

        Group group = new Group(shell, SWT.NONE);
        group.setLayout(new RowLayout(SWT.HORIZONTAL));

        Button buttonFirst = createPushButton(group, SWT.RADIO, "Radio 1");

        Button buttonSecond = createPushButton(group, SWT.RADIO, "Radio 2");

        Button buttonThird = createPushButton(group, SWT.RADIO, "Radio 3");

        MessageBox messageBox = createMessageBox(shell, SWT.APPLICATION_MODAL, "No coincidence!");

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

    protected static Button createPushButton(Shell parent, int style, String buttonText) {
        Button button = new Button(parent, style);
        button.setText(buttonText);
        return button;
    }

    protected static Button createPushButton(Group parent, int style, String buttonText) {
        Button button = new Button(parent, style);
        button.setText(buttonText);
        return button;
    }

    protected static MessageBox createMessageBox (Shell parent, int style, String messageText) {
        MessageBox messageBox = new MessageBox(parent, style);
        messageBox.setMessage(messageText);
        return messageBox;
    }

    protected static RowLayout createRowLayout (Shell parent, int style) {
        RowLayout rowLayout = new RowLayout(style);
        rowLayout.marginLeft = 10;
        rowLayout.marginTop = 10;
        rowLayout.spacing = 15;
        parent.setLayout(rowLayout);
        return rowLayout;
    }
}


