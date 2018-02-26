package com.company;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;

import org.eclipse.swt.widgets.Display;

public class Main {

    public static void main(String[] args) {
        Display display = new Display();

        Shell shell = new Shell(display);

        shell.setLayout(new FillLayout());
        shell.open();
        Button button = new Button(shell, SWT.PUSH);

        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                System.out.print("Called!");
            }
        });

        display.sleep();
        display.dispose();
    }
}
