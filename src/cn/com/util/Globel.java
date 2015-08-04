package cn.com.util;

import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.Window;

public abstract class Globel {
	public final static void setCenterByWindow(Window f) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension ds = tk.getScreenSize();
		Dimension fs = f.getSize();
		if(fs.width > ds.width) {
			fs.width = ds.width;
		}
		if(fs.height > ds.height) {
			fs.height = ds.height;
		}
		f.setLocation((ds.width-fs.width)/2, (ds.height - fs.height)/2);
	}
	
}
