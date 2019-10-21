package principal;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;

public class Starter {	
	public static void main(String[] args) {
		Loading ll = new Loading();
		ll.setUndecorated(true);
		ll.setVisible(true);
		ll.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));
		try {
			for (int i = 0; i <= 100; i++) {
				Thread.sleep(35);
				Acesso a = new Acesso();
				if (i == 100) {
					ll.dispose();
					a.setUndecorated(true);
					a.show();
					a.setShape(new RoundRectangle2D.Double(0, 0, 928, 591, 15, 15));		
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
