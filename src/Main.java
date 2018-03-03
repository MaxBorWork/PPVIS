import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import org.eclipse.swt.widgets.Display;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        RowLayout rowLayout = createRowLayout(shell, SWT.VERTICAL);

        Text textOne = new Text(shell, SWT.CENTER);

        Button btnFirstComp = createPushButton(shell, SWT.PUSH, "button");

        Combo combo = new Combo(shell, SWT.DROP_DOWN);

        ArrayList<String> list = new ArrayList<>();

        MessageBox messBox = createMessageBox(shell, SWT.APPLICATION_MODAL);

        btnFirstComp.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                boolean textExist = false;
                for (String aList : list) {
                    if (aList.equals(textOne.getText()))
                        textExist = true;
                }
                if (!textExist) {
                    list.add(textOne.getText());
                    combo.add(textOne.getText());
                }
                else messBox.open();
            }
        });
        textOne.pack();

        Text textTwo = new Text(shell, SWT.CENTER);
        Button btnSecCompOne = createPushButton(shell, SWT.PUSH, "Kick");
        Button btnSecCompTwo = createPushButton(shell, SWT.PUSH, "Kicked");

        btnSecCompOne.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                btnSecCompTwo.setText(textTwo.getText());
                btnSecCompTwo.addSelectionListener(new SelectionAdapter() {
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        String buttonText = btnSecCompTwo.getText();
                        String btnText = btnSecCompOne.getText();
                        btnSecCompOne.setText(buttonText);
                        btnSecCompTwo.setText(btnText);
                    }
                });
            }
        });
        textTwo.pack();

        Text textThree = new Text(shell, SWT.CENTER);

        Button btnThirdComp = createPushButton(shell, SWT.PUSH, "Don't push me");

        Group groupThirdComp = new Group(shell, SWT.NONE);
        groupThirdComp.setLayout(new RowLayout(SWT.HORIZONTAL));

        Button buttonThirdCompOne = createPushButton(groupThirdComp, SWT.RADIO, "Radio 1");

        Button buttonThirdCompTwo = createPushButton(groupThirdComp, SWT.RADIO, "Radio 2");

        Button buttonThirdCompThree = createPushButton(groupThirdComp, SWT.RADIO, "Radio 3");

        //MessageBox messBoxThree = createMessageBox(shell, SWT.APPLICATION_MODAL, "No coincidence!");

        btnThirdComp.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (buttonThirdCompOne.getText().equals(textThree.getText()) ) {
                    buttonThirdCompOne.setSelection(true);
                    buttonThirdCompTwo.setSelection(false);
                    buttonThirdCompThree.setSelection(false);
                }
                else if (buttonThirdCompTwo.getText().equals(textThree.getText()) ) {
                    buttonThirdCompTwo.setSelection(true);
                    buttonThirdCompOne.setSelection(false);
                    buttonThirdCompThree.setSelection(false);
                }
                else if (buttonThirdCompThree.getText().equals(textThree.getText()) ) {
                    buttonThirdCompThree.setSelection(true);
                    buttonThirdCompOne.setSelection(false);
                    buttonThirdCompTwo.setSelection(false);
                }
                else messBox.open();
            }
        });
        textThree.pack();

        Text textFour = new Text(shell, SWT.CENTER);

        Button btnFourthComp = createPushButton(shell, SWT.PUSH, "PPush!");

        Group groupFourthComp = new Group(shell, SWT.NONE);
        groupFourthComp.setLayout(new RowLayout(SWT.VERTICAL));

        Button checkOne = new Button(groupFourthComp, SWT.CHECK);
        checkOne.setText("Check 1");

        Button checkTwo = new Button(groupFourthComp, SWT.CHECK);
        checkTwo.setText("Check 2");

        Button checkThree = new Button(groupFourthComp, SWT.CHECK);
        checkThree.setText("Check 3");

        btnFourthComp.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if (checkOne.getText().equals(textFour.getText()))
                    checkOne.setSelection(true);
                else if (checkTwo.getText().equals(textFour.getText()))
                    checkTwo.setSelection(true);
                else if (checkThree.getText().equals(textFour.getText()))
                    checkThree.setSelection(true);
                else messBox.open();
            }
        });
        textFour.pack();

        Text textFive = new Text(shell, SWT.CENTER);

        Button btnFifthCompOne = createPushButton(shell, SWT.PUSH, "Push first!");

        Button btnFifthCompTwo = createPushButton(shell, SWT.PUSH, "Push second!");

        Button btnFifthCompThree = createPushButton(shell, SWT.PUSH, "Push third!");

        Table table = createTable(shell, SWT.MULTI | SWT.BORDER);

        TableItem itemNull = new TableItem(table, SWT.NONE);

        table.getColumn(0).pack();
        table.getColumn(1).pack();

        btnFifthCompOne.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                TableItem itemNew = new TableItem(table, SWT.NONE);
                itemNew.setText(0, textFive.getText());

                btnFifthCompTwo.addSelectionListener(new SelectionAdapter() {
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        itemNew.setText(1, itemNew.getText(0));
                        itemNew.setText(0, "");

                        btnFifthCompThree.addSelectionListener(new SelectionAdapter() {
                            @Override
                            public void widgetSelected(SelectionEvent e) {
                                itemNew.setText(0, itemNew.getText(1));
                                itemNew.setText(1, "");
                            }
                        });
                    }
                });
            }
        });


        table.setSize(table.computeSize(SWT.DEFAULT, 200));
        textFive.pack();

        shell.setSize(800, 500);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    protected static RowLayout createRowLayout(Shell parent, int style) {
        RowLayout rowLayout = new RowLayout(style);
        rowLayout.marginLeft = 10;
        rowLayout.marginTop = 10;
        rowLayout.spacing = 15;
        parent.setLayout(rowLayout);
        return rowLayout;
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

    protected static MessageBox createMessageBox (Shell parent, int style) {
        MessageBox messageBox = new MessageBox(parent, style);
        messageBox.setMessage("No coincidence!");
        return messageBox;
    }

    protected static Table createTable (Shell parent, int style) {
        Table table = new Table(parent, style);
        table.setLinesVisible(true);
        table.setHeaderVisible(true);

        TableColumn columnOne = new TableColumn(table, SWT.NONE);
        columnOne.setText("First column");

        TableColumn columnTwo = new TableColumn(table, SWT.NONE);
        columnTwo.setText("Second column");
        return table;
    }
}
