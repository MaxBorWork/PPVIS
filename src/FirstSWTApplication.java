import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.widgets.Combo;

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
        //text.setSize(200, 100);
        Button button = new Button(shell, SWT.PUSH);
        Combo combo = new Combo(shell, SWT.DROP_DOWN);

        button.setText("Button");
        //button.setSize(300,50);
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                combo.add(text.getText());
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
}
