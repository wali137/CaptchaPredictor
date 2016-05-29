/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package captcha.gui;

/**
 *
 * @author omershafiq
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class BinConverter {
    
    boolean negative;

	public BinConverter() {
		this(false);
	}

	public BinConverter(final boolean negative) {
		this.negative = negative;
	}

	public String convert(final BufferedImage image) {
		StringBuilder sb = new StringBuilder((image.getWidth() + 1) * image.getHeight());
		for (int y = 0; y < image.getHeight(); y++) {
			if (sb.length() != 0) sb.append("");
			for (int x = 0; x < image.getWidth(); x++) {
				Color pixelColor = new Color(image.getRGB(x, y));
				double gValue = (double) pixelColor.getRed() * 0.2989 + (double) pixelColor.getBlue() * 0.5870 + (double) pixelColor.getGreen() * 0.1140;
				final char s = negative ? returnStrNeg(gValue) : returnStrPos(gValue);
				sb.append(s);
			}
		}
		return sb.toString();
	}

	/**
	 * Create a new string and assign to it a string based on the grayscale value.
	 * If the grayscale value is very high, the pixel is very bright and assign characters
	 * such as . and , that do not appear very dark. If the grayscale value is very lowm the pixel is very dark,
	 * assign characters such as # and @ which appear very dark.
	 *
	 * @param g grayscale
	 * @return char
	 */
	private char returnStrPos(double g)//takes the grayscale value as parameter
	{
		final char str;

		if (g >= 230.0) {
			str = '0';
		} else if (g >= 200.0) {
			str = '1';
		} else if (g >= 180.0) {
			str = '1';
		} else if (g >= 160.0) {
			str = '1';
		} else if (g >= 130.0) {
			str = '1';
		} else if (g >= 100.0) {
			str = '1';
		} else if (g >= 70.0) {
			str = '1';
		} else if (g >= 50.0) {
			str = '1';
		} else {
			str = '1';
		}
		return str; // return the character

	}

	/**
	 * Same method as above, except it reverses the darkness of the pixel. A dark pixel is given a light character and vice versa.
	 *
	 * @param g grayscale
	 * @return char
	 */
	private char returnStrNeg(double g) {
		final char str;

		if (g >= 230.0) {
			str = '1';
		} else if (g >= 200.0) {
			str = '1';
		} else if (g >= 180.0) {
			str = '1';
		} else if (g >= 160.0) {
			str = '1';
		} else if (g >= 130.0) {
			str = '1';
		} else if (g >= 100.0) {
			str = '1';
		} else if (g >= 70.0) {
			str = '1';
		} else if (g >= 50.0) {
			str = '1';
		} else {
			str = '0';
		}
		return str;

	}

        
        public String ImageToBinMatrix(BufferedImage img)
        {
			
                try {
                        final BufferedImage image = img;
                        if (image == null) throw new IllegalArgumentException("Its is not a valid image.");
                        final String bin = new BinConverter().convert(image);
                        return bin;
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                        return null;
                }
				
        }
    
}
