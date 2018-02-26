import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

public class FirstSWTApplication {
    public static void main(String[] args) {
        Display display = new Display();

        Shell shell = new Shell(display);

        shell.setLayout(new FillLayout());
        Label label = new Label(shell, SWT.BORDER);
        Menu popup = new Menu(shell, SWT.POP_UP);
        shell.setMenuBar(popup);
        MenuItem item = new MenuItem(popup, SWT.CASCADE);
        Text text = new Text(shell, SWT.CENTER);

        //text.setText("This is the text in the text widget");

        text.pack();
        //label.pack();

        Button button = new Button(shell, SWT.PUSH);
        button.setText("Button");
        button.setSize(300,50);
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                item.setText("You've pushed!");
            }
        });
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
