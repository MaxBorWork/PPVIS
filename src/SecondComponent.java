import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SecondComponent {
    public static void main(String[] args) {
        Display display = new Display();

        Shell shell = new Shell(display);

        FillLayout fillLayout = new FillLayout();
        shell.setLayout(fillLayout);
        fillLayout.type = SWT.VERTICAL;

        Text text = new Text(shell, SWT.CENTER);
        Button btn = new Button(shell, SWT.PUSH);
        Button button = new Button(shell, SWT.PUSH);
        btn.setText("Push Me");
        button.setText("Touch Me");

        btn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                button.setText(text.getText());
                button.addSelectionListener(new SelectionAdapter() {
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        String buttonText = button.getText();
                        String btnText = btn.getText();
                        btn.setText(buttonText);
                        button.setText(btnText);
                    }
                });
            }
        });
        text.pack();
        shell.open();
        while (!shell.isDisposed()){
            if (!display.readAndDispatch()){
                display.sleep();
            }
        }
        display.dispose();
    }
}
