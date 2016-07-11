package com.psst.tool.rcp.core;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import com.psst.tool.rcp.action.OpenViewChangeFileExtAction;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

    
    private OpenViewChangeFileExtAction changeFileExtAction;
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
        changeFileExtAction = new OpenViewChangeFileExtAction(window);
        changeFileExtAction.setText("批量替换文件后缀名");
    }

    protected void fillMenuBar(IMenuManager menuBar) {
        IMenuManager  menu = new MenuManager("工具菜单");
        menu.add(changeFileExtAction);
        menuBar.add(menu);
    }
    
}
