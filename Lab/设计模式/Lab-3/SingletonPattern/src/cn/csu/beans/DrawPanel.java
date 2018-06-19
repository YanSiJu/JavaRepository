package cn.csu.beans;

import java.awt.Panel;

public class DrawPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static volatile DrawPanel panel;

	private DrawPanel() {
	}

	public static DrawPanel getPanel() {
		if (panel == null) {
			synchronized (DrawPanel.class) {
				if (panel == null) {
					panel = new DrawPanel();
				}
			}
		}		
		return panel;
	}
}
