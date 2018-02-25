import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;

public class SwtTest {
    public static void main (String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        Label label = new Label(shell, SWT.NONE);
        shell.setSize(300,200);
        label.setText("Hello World");
        label.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch ()) display.sleep ();
        }
        display.dispose ();
    }
}