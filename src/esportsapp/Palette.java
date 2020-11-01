/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esportsapp;

import java.awt.Color;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public final class Palette {
	/**
     * The list of color schemes to choose from.
     */
    public static enum SchemeEnum {
		// Don't really know what colors you actually want
		DARK(
				ColorEnum.DARK_MAIN,
				ColorEnum.DARK_MAIN_MOUSE_OVER,
				ColorEnum.DARK_MENU_BACK,
				ColorEnum.DARK_MENU_FRONT,
				ColorEnum.DARK_MENU_MOUSE_OVER_BACK,
				ColorEnum.DARK_MENU_MOUSE_OVER_FRONT,
				ColorEnum.DARK_MENU_SELECTED_BACK, 
				ColorEnum.DARK_MENU_SELECTED_FRONT,
				ColorEnum.DARK_ACTIVE,
				ColorEnum.DARK_CHECK_BACK,
				ColorEnum.DARK_PRIMARY_TEXT,
				ColorEnum.DARK_SECONDARY_TEXT,
				ColorEnum.DARK_TERTIARY_TEXT,
		
				ColorEnum.CLOSE_MOUSE_OVER,
				
				IconEnum.MINIMISE_DARK,
				IconEnum.MINIMISE_MOUSE_OVER_DARK,
				IconEnum.MAXIMISE_DARK,
				IconEnum.MAXIMISE_MOUSE_OVER_DARK,
				IconEnum.CLOSE_DARK,
				IconEnum.TOGGLE_SWITCH_DARK,
				IconEnum.SELECTED_TOGGLE_SWITCH_DARK,
				
				IconEnum.CLOSE_MOUSE_OVER
				
		),
		
		LIGHT(
				ColorEnum.LIGHT_MAIN,
				ColorEnum.LIGHT_MAIN_MOUSE_OVER,
				ColorEnum.LIGHT_MENU_BACK,
				ColorEnum.LIGHT_MENU_FRONT,
				ColorEnum.LIGHT_MENU_MOUSE_OVER_BACK,
				ColorEnum.LIGHT_MENU_MOUSE_OVER_FRONT,
				ColorEnum.LIGHT_MENU_SELECTED_BACK,
				ColorEnum.LIGHT_MENU_SELECTED_FRONT,
				ColorEnum.LIGHT_ACTIVE,
				ColorEnum.LIGHT_CHECK_BACK,
				ColorEnum.LIGHT_PRIMARY_TEXT,
				ColorEnum.LIGHT_SECONDARY_TEXT,
				ColorEnum.LIGHT_TERTIARY_TEXT,
				
				ColorEnum.CLOSE_MOUSE_OVER,
		
				IconEnum.MINIMISE_LIGHT,
				IconEnum.MINIMISE_MOUSE_OVER_LIGHT,
				IconEnum.MAXIMISE_LIGHT,
				IconEnum.MAXIMISE_MOUSE_OVER_LIGHT,
				IconEnum.CLOSE_LIGHT,
				IconEnum.TOGGLE_SWITCH_LIGHT,
				IconEnum.SELECTED_TOGGLE_SWITCH_LIGHT,
				
				IconEnum.CLOSE_MOUSE_OVER
				
		);

		// nor know how many colors make up a scheme
		public ColorEnum COLOR_MAIN;
		public ColorEnum COLOR_MAIN_MOUSE_OVER;
		public ColorEnum COLOR_MENU_BACK;
		public ColorEnum COLOR_MENU_FRONT;
		public ColorEnum COLOR_MENU_MOUSE_OVER_BACK;
		public ColorEnum COLOR_MENU_MOUSE_OVER_FRONT;
		public ColorEnum COLOR_MENU_SELECTED_BACK;
		public ColorEnum COLOR_MENU_SELECTED_FRONT;
		public ColorEnum COLOR_ACTIVE;
		public ColorEnum COLOR_CHECK_BACK;
		public ColorEnum COLOR_PRIMARY_TEXT;
		public ColorEnum COLOR_SECONDARY_TEXT;
		public ColorEnum COLOR_TERTIARY_TEXT;
		
		public ColorEnum COLOR_CLOSE_MOUSE_OVER;
		
		public IconEnum ICON_MINIMISE;
		public IconEnum ICON_MINIMISE_MOUSE_OVER;
		public IconEnum ICON_MAXIMISE;
		public IconEnum ICON_MAXIMISE_MOUSE_OVER;
		public IconEnum ICON_CLOSE;
		public IconEnum ICON_TOGGLE_SWITCH;
		public IconEnum ICON_SELECTED_TOGGLE_SWITCH;
		
		public IconEnum ICON_CLOSE_MOUSE_OVER;

		private SchemeEnum(
				ColorEnum COLOR_MAIN,
				ColorEnum COLOR_MAIN_MOUSE_OVER,
				ColorEnum COLOR_MENU_BACK,
				ColorEnum COLOR_MENU_FRONT,
				ColorEnum COLOR_MENU_MOUSE_OVER_BACK,
				ColorEnum COLOR_MENU_MOUSE_OVER_FRONT,
				ColorEnum COLOR_MENU_SELECTED_BACK,
				ColorEnum COLOR_MENU_SELECTED_FRONT,
				ColorEnum COLOR_ACTIVE,
				ColorEnum COLOR_CHECK_BACK,
				ColorEnum COLOR_PRIMARY_TEXT,
				ColorEnum COLOR_SECONDARY_TEXT,
				ColorEnum COLOR_TERTIARY_TEXT,
				
				ColorEnum COLOR_CLOSE_MOUSE_OVER,
				
				IconEnum ICON_MINIMISE,
				IconEnum ICON_MINIMISE_MOUSE_OVER,
				IconEnum ICON_MAXIMISE,
				IconEnum ICON_MAXIMISE_MOUSE_OVER,
				IconEnum ICON_CLOSE,
				IconEnum ICON_TOGGLE_SWITCH,
				IconEnum ICON_SELECTED_TOGGLE_SWITCH,
				
				IconEnum ICON_CLOSE_MOUSE_OVER
				
		) {
		    this.COLOR_MAIN = COLOR_MAIN;
			this.COLOR_MAIN_MOUSE_OVER = COLOR_MAIN_MOUSE_OVER;
		    this.COLOR_MENU_BACK = COLOR_MENU_BACK;
			this.COLOR_MENU_FRONT = COLOR_MENU_FRONT;
			this.COLOR_MENU_MOUSE_OVER_BACK = COLOR_MENU_MOUSE_OVER_BACK;
			this.COLOR_MENU_MOUSE_OVER_FRONT = COLOR_MENU_MOUSE_OVER_FRONT;
			this.COLOR_MENU_SELECTED_BACK = COLOR_MENU_SELECTED_BACK;
			this.COLOR_MENU_SELECTED_FRONT = COLOR_MENU_SELECTED_FRONT;
		    this.COLOR_ACTIVE = COLOR_ACTIVE;
			this.COLOR_CHECK_BACK = COLOR_CHECK_BACK;
			this.COLOR_PRIMARY_TEXT = COLOR_PRIMARY_TEXT;
			this.COLOR_SECONDARY_TEXT = COLOR_SECONDARY_TEXT;
			this.COLOR_TERTIARY_TEXT = COLOR_TERTIARY_TEXT;
			
			this.COLOR_CLOSE_MOUSE_OVER = COLOR_CLOSE_MOUSE_OVER;
			
			this.ICON_MINIMISE = ICON_MINIMISE;
			this.ICON_MINIMISE_MOUSE_OVER = ICON_MINIMISE_MOUSE_OVER;
			this.ICON_MAXIMISE = ICON_MAXIMISE;
			this.ICON_MAXIMISE_MOUSE_OVER = ICON_MAXIMISE_MOUSE_OVER;
			this.ICON_CLOSE = ICON_CLOSE;
			this.ICON_TOGGLE_SWITCH = ICON_TOGGLE_SWITCH;
			this.ICON_SELECTED_TOGGLE_SWITCH = ICON_SELECTED_TOGGLE_SWITCH;
			
			this.ICON_CLOSE_MOUSE_OVER = ICON_CLOSE_MOUSE_OVER;
			
		}
	}

    /**
     * The list of color descriptions to choose from.
     */
    public static enum ColorEnum {
        DARK_MAIN(32, 34, 37),													LIGHT_MAIN(227, 229, 232),
		DARK_MAIN_MOUSE_OVER(38, 41, 46),										LIGHT_MAIN_MOUSE_OVER(218, 221, 224),
		DARK_MENU_BACK(47, 49, 54),												LIGHT_MENU_BACK(242, 243, 245),
		DARK_MENU_FRONT(187, 187, 187),											LIGHT_MENU_FRONT(187, 187, 187),
		DARK_MENU_MOUSE_OVER_BACK(51, 54, 60),									LIGHT_MENU_MOUSE_OVER_BACK(232, 234, 237),
		DARK_MENU_MOUSE_OVER_FRONT(221, 221, 221),								LIGHT_MENU_MOUSE_OVER_FRONT(106, 116, 157),
		DARK_MENU_SELECTED_BACK(57, 60, 66),									LIGHT_MENU_SELECTED_BACK(212, 215, 221),
		DARK_MENU_SELECTED_FRONT(255, 255, 255),								LIGHT_MENU_SELECTED_FRONT(0, 0, 0),
		DARK_ACTIVE(54, 57, 63),												LIGHT_ACTIVE(255, 255, 255),
		DARK_CHECK_BACK(47, 50, 55),											LIGHT_CHECK_BACK(249, 249, 250),
		DARK_PRIMARY_TEXT(255, 255, 255),										LIGHT_PRIMARY_TEXT(0, 0, 0),
		DARK_SECONDARY_TEXT(205, 205, 205),									LIGHT_SECONDARY_TEXT(50, 50, 50),
		DARK_TERTIARY_TEXT(155, 155, 155),										LIGHT_TERTIARY_TEXT(100, 100, 100),
		
		CLOSE_MOUSE_OVER(240, 71, 71);
		

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
	
	public static enum IconEnum {
		MINIMISE_DARK(Palette.class.getResource("/esportsapp/images/minimisedark.png")),
		MINIMISE_MOUSE_OVER_DARK(Palette.class.getResource("/esportsapp/images/minimisemouseoverdark.png")),
		MINIMISE_LIGHT(Palette.class.getResource("/esportsapp/images/minimiselight.png")),
		MINIMISE_MOUSE_OVER_LIGHT(Palette.class.getResource("/esportsapp/images/minimisemouseoverlight.png")),
		MAXIMISE_DARK(Palette.class.getResource("/esportsapp/images/maximisedark.png")),
		MAXIMISE_MOUSE_OVER_DARK(Palette.class.getResource("/esportsapp/images/maximisemouseoverdark.png")),
		MAXIMISE_LIGHT(Palette.class.getResource("/esportsapp/images/maximiselight.png")),
		MAXIMISE_MOUSE_OVER_LIGHT(Palette.class.getResource("/esportsapp/images/maximisemouseoverlight.png")),
		CLOSE_DARK(Palette.class.getResource("/esportsapp/images/closedark.png")),
		CLOSE_LIGHT(Palette.class.getResource("/esportsapp/images/closelight.png")),
		TOGGLE_SWITCH_DARK(Palette.class.getResource("/esportsapp/images/toggleswitchdark.png")),
		TOGGLE_SWITCH_LIGHT(Palette.class.getResource("/esportsapp/images/toggleswitchlight.png")),
		SELECTED_TOGGLE_SWITCH_DARK(Palette.class.getResource("/esportsapp/images/selectedtoggleswitchdark.png")),
		SELECTED_TOGGLE_SWITCH_LIGHT(Palette.class.getResource("/esportsapp/images/selectedtoggleswitchlight.png")),
	
		CLOSE_MOUSE_OVER(Palette.class.getResource("/esportsapp/images/closemouseover.png"));
		
		private URL url;
		
		private IconEnum(URL url) {
			this.url = url;
		}
		
		public ImageIcon getIcon() {
			return new javax.swing.ImageIcon(url);
		}
		
	}

    private static SchemeEnum currentScheme = SchemeEnum.DARK;

    /**
     * Default constructor is private to prevent instantiation of this makeshift 'static' class.
     */
    private Palette() {
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
