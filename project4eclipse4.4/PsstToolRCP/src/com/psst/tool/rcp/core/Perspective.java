package com.psst.tool.rcp.core;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import com.psst.tool.rcp.view.ChangeFileExtView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
	    layout.addView(ChangeFileExtView.ID, IPageLayout.RIGHT, 0.5f, layout.getEditorArea());
	    layout.setEditorAreaVisible(false);
	}
}
