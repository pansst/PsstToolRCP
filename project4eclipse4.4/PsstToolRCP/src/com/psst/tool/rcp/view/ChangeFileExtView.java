package com.psst.tool.rcp.view;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.part.ViewPart;

import com.psst.tool.file.FileExtChnageBanch;
import org.eclipse.swt.custom.CCombo;

/** 
 * @author yongsheng.shi
 * @Email  syslijian_pst@163.com
 * @version 1.0.0
 * @time 2016年7月11日 下午1:09:21 
 */
public class ChangeFileExtView extends ViewPart {

    public static final String ID = "com.psst.tool.rcp.view.ChangeFileExtView"; //$NON-NLS-1$

    private Text text;
    private Text text_1;
    private Text text_2;
    private CCombo combo;
    
    public ChangeFileExtView() {
    }

    /**
     * Create contents of the view part.
     * @param parent
     */
    @Override
    public void createPartControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NONE);
//        container.getShell().setMaximized(true);
        text = new Text(container, SWT.BORDER);
        text.setBounds(134, 40, 234, 23);
        text.setText("");
        IWorkbenchPage page = ChangeFileExtView.this.getViewSite()
                .getPage();
        Button btnNewButton = new Button(container, SWT.NONE);
        btnNewButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DirectoryDialog ddlg = new DirectoryDialog(container.getShell());
                String directPath = ddlg.open();
                text.setText(directPath);
            }
        });
        btnNewButton.setBounds(392, 38, 80, 27);
        btnNewButton.setText("选择文件夹");
        
        Label lblNewLabel = new Label(container, SWT.NONE);
        lblNewLabel.setBounds(44, 43, 61, 17);
        lblNewLabel.setText("文件夹路径：");
        
        Label lblNewLabel_1 = new Label(container, SWT.NONE);
        lblNewLabel_1.setBounds(44, 84, 61, 17);
        lblNewLabel_1.setText("后缀名:");
        
        text_1 = new Text(container, SWT.BORDER);
        text_1.setBounds(134, 81, 113, 23);
        
        Label lblNewLabel_2 = new Label(container, SWT.NONE);
        lblNewLabel_2.setBounds(44, 117, 61, 17);
        lblNewLabel_2.setText("新后缀名:");
        
        text_2 = new Text(container, SWT.BORDER);
        text_2.setBounds(134, 114, 113, 23);
        
        Button btnNewButton_1 = new Button(container, SWT.NONE);
        btnNewButton_1.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String direcPath  = text.getText();
                String oldExt = text_1.getText();
                String newExt = text_2.getText();
                int flagCopy = combo.getSelectionIndex();
                boolean flag =  new FileExtChnageBanch(direcPath, oldExt, newExt, 1 == flagCopy).changeExt();
                if(flag) {
                    MessageDialog.openInformation(container.getShell(), "提示", "替换完成");
                } else {
                    MessageDialog.openInformation(container.getShell(), "提示", "替换失败");
                }
            }
        });
        btnNewButton_1.setBounds(208, 213, 165, 27);
        btnNewButton_1.setText("开始替换");
        
        Label lblNewLabel_3 = new Label(container, SWT.NONE);
        lblNewLabel_3.setBounds(44, 146, 61, 17);
        lblNewLabel_3.setText("修改模式：");
        
        combo = new CCombo(container, SWT.BORDER);
        combo.setBounds(134, 146, 209, 21);
        String[] sel = {"不复制文件，仅修改后缀名","复制文件，修改后缀名"};
        combo.setItems(sel);
        combo.select(1);
        createActions();
        initializeToolBar();
        initializeMenu();
    }

    /**
     * Create the actions.
     */
    private void createActions() {
        // Create the actions
    }

    /**
     * Initialize the toolbar.
     */
    private void initializeToolBar() {
        IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
    }

    /**
     * Initialize the menu.
     */
    private void initializeMenu() {
        IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
    }

    @Override
    public void setFocus() {
    }
}
