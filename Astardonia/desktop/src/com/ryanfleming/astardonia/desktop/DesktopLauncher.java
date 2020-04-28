package com.ryanfleming.astardonia.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ryanfleming.astardonia.Astardonia;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	      config.title = "Astardonia";
	      config.width = 960;
	      config.height = 720;
	      config.resizable = false;
		new LwjglApplication(new Astardonia(), config);
	}
}
