/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esportsapp;

import java.awt.Color;

/**
 *
 * @author User
 */
public final class ColorPalette {
	/**
     * The list of color schemes to choose from.
     */
    public static enum SchemeEnum {
		// Don't really know what colors you actually want
		DARK(
				ColorEnum.DARK_MAIN,
				ColorEnum.DARK_MENU_BACK,
				ColorEnum.DARK_MENU_FRONT,
				ColorEnum.DARK_MENU_MOUSE_OVER_BACK,
				ColorEnum.DARK_MENU_MOUSE_OVER_FRONT,
				ColorEnum.DARK_MENU_SELECTED_BACK, 
				ColorEnum.DARK_MENU_SELECTED_FRONT,
				ColorEnum.DARK_ACTIVE),
		
		LIGHT(
				ColorEnum.LIGHT_MAIN,
				ColorEnum.LIGHT_MENU_BACK,
				ColorEnum.LIGHT_MENU_FRONT,
				ColorEnum.LIGHT_MENU_MOUSE_OVER_BACK,
				ColorEnum.LIGHT_MENU_MOUSE_OVER_FRONT,
				ColorEnum.LIGHT_MENU_SELECTED_BACK,
				ColorEnum.LIGHT_MENU_SELECTED_FRONT,
				ColorEnum.LIGHT_ACTIVE);

		// nor know how many colors make up a scheme
		public ColorEnum MAIN;
		public ColorEnum MENU_BACK;
		public ColorEnum MENU_FRONT;
		public ColorEnum MENU_MOUSE_OVER_BACK;
		public ColorEnum MENU_MOUSE_OVER_FRONT;
		public ColorEnum MENU_SELECTED_BACK;
		public ColorEnum MENU_SELECTED_FRONT;
		public ColorEnum ACTIVE;

		private SchemeEnum(
				ColorEnum MAIN,
				ColorEnum MENU_BACK,
				ColorEnum MENU_FRONT,
				ColorEnum MENU_MOUSE_OVER_BACK,
				ColorEnum MENU_MOUSE_OVER_FRONT,
				ColorEnum MENU_SELECTED_BACK,
				ColorEnum MENU_SELECTED_FRONT,
				ColorEnum ACTIVE
		) {
		    this.MAIN = MAIN;
		    this.MENU_BACK = MENU_BACK;
			this.MENU_FRONT = MENU_FRONT;
			this.MENU_MOUSE_OVER_BACK = MENU_MOUSE_OVER_BACK;
			this.MENU_MOUSE_OVER_FRONT = MENU_MOUSE_OVER_FRONT;
			this.MENU_SELECTED_BACK = MENU_SELECTED_BACK;
			this.MENU_SELECTED_FRONT = MENU_SELECTED_FRONT;
		    this.ACTIVE = ACTIVE;
		}
	}

    /**
     * The list of color descriptions to choose from.
     */
    public static enum ColorEnum {
        DARK_MAIN(32, 34, 37),													LIGHT_MAIN(227, 229, 232),
		DARK_MENU_BACK(47, 49, 54),												LIGHT_MENU_BACK(242, 243, 245),
		DARK_MENU_FRONT(187, 187, 187),											LIGHT_MENU_FRONT(187, 187, 187),
		DARK_MENU_MOUSE_OVER_BACK(51, 54, 60),									LIGHT_MENU_MOUSE_OVER_BACK(232, 234, 237),
		DARK_MENU_MOUSE_OVER_FRONT(221, 221, 221),								LIGHT_MENU_MOUSE_OVER_FRONT(106, 116, 157),
		DARK_MENU_SELECTED_BACK(57, 60, 66),									LIGHT_MENU_SELECTED_BACK(212, 215, 221),
		DARK_MENU_SELECTED_FRONT(255, 255, 255),								LIGHT_MENU_SELECTED_FRONT(0, 0, 0),
		DARK_ACTIVE(54, 57, 63),												LIGHT_ACTIVE(255, 255, 255);
		  

        private int red;
        private int green;
        private int blue;

        private ColorEnum(int r, int g, int b) {
            this.red = r;
            this.green = g;
            this.blue = b;
        }

        /**
         * Get the selected color object for this Enum.
         * @return The color description as a Color object.
         */
        public Color getColor() {
            // WANT TO RETURN A COLOR BASED ON currentScheme
            return new Color(red, green, blue);
        }
    }

    private static SchemeEnum currentScheme = SchemeEnum.DARK;

    /**
     * Default constructor is private to prevent instantiation of this makeshift 'static' class.
     */
    private ColorPalette() {
    }

    /**
     * Get the color scheme being used on this project.
     * @return The current color scheme in use on this project.
     */
    public static SchemeEnum getCurrentScheme() {
        return currentScheme;
    }

    /**
     * Set the overall color scheme of this project.
     * @param currentPalette The color scheme to set for use on this project.
     */
    public static void setCurrentScheme(SchemeEnum cp) {
        currentScheme = cp;
    }

    /**
     * Main method for test purposes only.  Unpredictable results.
     * @param args Command line arguments.  Should not be present.
     */
    
}
