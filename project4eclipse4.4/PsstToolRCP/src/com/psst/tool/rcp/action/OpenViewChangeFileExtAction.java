package com.psst.tool.rcp.action;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchWindow;

import com.psst.tool.rcp.view.ChangeFileExtView;

/** 
 * @author yongsheng.shi
 * @Email  syslijian_pst@163.com
 * @version 1.0.0
 * @time 2016年7月11日 下午1:07:15 
 */
public class OpenViewChangeFileExtAction extends Action{
    
    private IWorkbenchWindow window;

    public OpenViewChangeFileExtAction(IWorkbenchWindow window) {
        super();
        this.window = window;
    }
    
    @Override
    public void run() {
        try {
            window.getActivePage().showView(ChangeFileExtView.ID);
        }catch(Exception e){
        }
        
    }
}
